package org.world.origin.dao;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;
import org.world.origin.domain.PageData;
import org.world.origin.enums.ResultEnum;
import org.world.origin.util.ConstDb;
import org.world.origin.util.ConstLogWarning;
import org.world.origin.util.ConstResult;
import org.world.origin.util.JavaLongUtil;
import org.world.origin.util.Log;
import org.world.origin.util.ResultUtil;


/**
 * 封装daosuport类
 * 正在模拟封装....
 * @author darwin du
 *
 */
@Repository
public class BizDaoSupport extends DaoSupport {
	
	private static final Logger log = Log.get();
	
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	/**
	 * 获取操作错误码
	 * @date 2017年9月13日
	 * @author darwin du
	 * @param handler 操作
	 * @return
	 */
	private Integer getErrorCode(String handler) {
		
		switch(handler) {
    	case ConstDb.SAVE:
    		return ResultEnum.ERROR_SAVE.getCode();
    	case ConstDb.UPDATE:
    		return ResultEnum.ERROR_UPDATE.getCode();
    	case ConstDb.DELETE:
    		return ResultEnum.ERROR_DELETE.getCode();
    	default:
    		break;
    	}
		return -1;
	}
	/**
	 * 获取操作错误码
	 * @date 2017年9月13日
	 * @author darwin du
	 * @param handler 操作
	 * @return
	 */
	private Integer getErrorZeroCode(String handler) {
		
		switch(handler) {
    	case ConstDb.SAVE:
    		return ResultEnum.ERROR_SAVE_ZERO.getCode();
    	case ConstDb.UPDATE:
    		return ResultEnum.ERROR_UPDATE_ZERO.getCode();
    	case ConstDb.DELETE:
    		return ResultEnum.ERROR_DELETE_ZERO.getCode();
    	default:
    		break;
    	}
		return -1;
	}
	
	/**
	 * 默认前缀：【ats.】
	 * @date 2017年9月20日
	 * @author darwin du
	 * @param str
	 * @param obj
	 * @param handler
	 * @param dbHandler
	 * @param mapIndex
	 * @param isProcessIndex
	 * @return
	 */
	public Object execute(String str, Object obj, String handler, IDbHandler dbHandler, Map<String, Object> mapIndex, Boolean isProcessIndex){
		return this.execute(ConstDb.NAMESPACE_PRE, str, obj, handler, dbHandler, mapIndex, isProcessIndex);
	}
	
	/**
	 * 执行db操作
	 * @date 2017年9月13日
	 * @author darwin du
	 * @param namespacePre 命名空间前缀
	 * @param str
	 * @param obj
	 * @param handler
	 * @param dbHandler
	 * @return
	 */
	public Object execute(String namespacePre, String str, Object obj, String handler, IDbHandler dbHandler, Map<String, Object> mapIndex, Boolean isProcessIndex){
		
		int index = 0;
		PageData pdResult = new PageData();
		try {
			if(dbHandler != null) {
				if(StringUtils.isNotBlank(namespacePre)) {
					//命名空间拼接
					str = namespacePre + str;
				}
				index = dbHandler.executeSql(str, obj);
			}
			pdResult = ResultUtil.success();
		} catch (Exception e) {
			
			index = 0;
			pdResult = ResultUtil.error(ResultEnum.getValue(this.getErrorCode(handler)), this.getErrorCode(handler));
			
			//保存时，唯一索引校验，异常处理
			if(dbHandler != null && mapIndex != null && !mapIndex.isEmpty() && isProcessIndex != null && isProcessIndex) {
				for(Map.Entry<String, Object> map : mapIndex.entrySet()) {
					
					String[] ss = (String[]) map.getValue();
					if(ss != null && ss.length > 0) {
						if(e.getCause().getMessage().indexOf(map.getKey()) > 0) {
							pdResult = ResultUtil.error(ss[1], JavaLongUtil.strToInt(ss[0]));
							break;
						}
					}
				}
			}
			//增加关键字告警
			log.error(Log.TEMPLATE_PRE, pdResult.getString(ConstResult.RESULT_CODE) , pdResult.getString(ConstResult.RESULT_MSG), ConstLogWarning.ON_CRITICAL_TEMPLATE, e);
		} 
		if(index < 1) {
			Integer resultcode = (Integer) pdResult.get(ConstResult.RESULT_CODE);
			//如果code=0，则执行sql成功了，但是影响行数=0
			if(ResultEnum.SUCCESS.getCode().equals(resultcode)) {
				pdResult = ResultUtil.error(ResultEnum.getValue(this.getErrorZeroCode(handler)), this.getErrorZeroCode(handler));
				//无需告警
				log.warn(Log.TEMPLATE_PRE, pdResult.getString(ConstResult.RESULT_CODE), pdResult.getString(ConstResult.RESULT_MSG), "");
			}
		}
		pdResult.put("index", index);
    	return pdResult;
	}
	
	/**
	 * 保存对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object bizSave(String str, Object obj) {
		
		return this.execute(str, obj, ConstDb.SAVE, new DbHandler() {
			
			@Override
			public int executeSql(String str, Object obj) {
				// TODO Auto-generated method stub
				return sqlSessionTemplate.insert(str, obj);
			}
		}, null, null);
	}
	
	
	/**
	 * 保存对象
	 * @date 2017年9月15日
	 * @author darwin du
	 * @param str
	 * @param obj 索引存储map对象
	 * @param isProcessIndex 是否校验唯一索引
	 * @return
	 */
	public Object bizSave(String str, Object obj, Map<String, Object> mapIndex, Boolean isProcessIndex) {
		
		return this.execute(str, obj, ConstDb.SAVE, new DbHandler() {
			
			@Override
			public int executeSql(String str, Object obj) {
				// TODO Auto-generated method stub
				return sqlSessionTemplate.insert(str, obj);
			}
		}, mapIndex, isProcessIndex);
	}
	
	/**
	 * 修改对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object bizUpdate(String str, Object obj)  {
		
		return this.execute(str, obj, ConstDb.UPDATE, new DbHandler() {
			
			@Override
			public int executeSql(String str, Object obj) {
				// TODO Auto-generated method stub
				return sqlSessionTemplate.update(str, obj);
			}
		}, null, null);
	}

	/**
	 * 删除对象 
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object bizDelete(String str, Object obj)  {
		
		return this.execute(str, obj, ConstDb.DELETE, new DbHandler() {
			
			@Override
			public int executeSql(String str, Object obj) {
				// TODO Auto-generated method stub
				return sqlSessionTemplate.delete(str, obj);
			}
		}, null, null);
	}
	
	/**
	 * 查找对象:指定前缀【origin.】
	 * @date 2017年9月20日
	 * @author darwin du
	 * @param str
	 * @param obj
	 * @return
	 */
	public Object bizFindForObject(String str, Object obj) {
		return this.bizFindForObject(ConstDb.NAMESPACE_PRE, str, obj);
	}
	 
	/**
	 * 查找对象
	 * @param namespacePre 命名空间前缀
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object bizFindForObject(String namespacePre, String str, Object obj) {
		
		Object result = null;
		try {
			if(StringUtils.isNotBlank(namespacePre)) {
				str = namespacePre + str;
			}
			result = sqlSessionTemplate.selectOne(str, obj);
		} catch (Exception e) {
			log.error(Log.TEMPLATE_PRE, ResultEnum.ERROR_QUERY_SINGLE.getMsg(), ResultEnum.ERROR_QUERY_SINGLE.getCode(), ConstLogWarning.ON_CRITICAL_TEMPLATE, e);
		}
		return result;
	}
	
	/**
	 * 查找对象list:指定前缀【ats.】
	 * @date 2017年9月20日
	 * @author darwin du
	 * @param str
	 * @param obj
	 * @return
	 */
	public Object bizFindForList(String str, Object obj)  {
		return this.bizFindForList(ConstDb.NAMESPACE_PRE, str, obj);
	}

	/**
	 * 查找对象list
	 * @param namespacePre 命名空间前缀
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object bizFindForList(String namespacePre, String str, Object obj)  {
		
		Object result = null;
		try {
			if(StringUtils.isNotBlank(namespacePre)) {
				str = namespacePre + str;
			}
			result = sqlSessionTemplate.selectList(str, obj);
		} catch (Exception e) {
			log.error(Log.TEMPLATE_PRE, ResultEnum.ERROR_QUERY_LIST.getMsg(), ResultEnum.ERROR_QUERY_LIST.getCode(), ConstLogWarning.ON_CRITICAL_TEMPLATE, e);
		}
		return result;
	}
}




