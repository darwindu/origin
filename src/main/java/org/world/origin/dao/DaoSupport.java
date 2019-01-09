package org.world.origin.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.world.origin.exception.DaoException;

@Repository
public class DaoSupport implements IDao {

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 保存对象
	 * 
	 * @param str
	 * @param obj
	 * @return 返回为int
	 * @throws Exception
	 */
	public Integer save(String str, Object obj) {
		try {
			return sqlSessionTemplate.insert(str, obj);
		} catch (Exception e) {
			throw new DaoException("添加数据异常", e);
		}
	}

	/**
	 * 批量添加
	 * 
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public Integer batchSave(String str, List objs) {
		try {
			for (Object obj : objs) {
				sqlSessionTemplate.insert(str, obj);
			}
			return objs.size();
		} catch (Exception e) {
			throw new DaoException("批量添加数据异常", e);
		}
	}

	/**
	 * 修改对象
	 * 
	 * @param str
	 * @param obj
	 * @return 返回为int
	 * @throws Exception
	 */
	public Integer update(String str, Object obj) {
		try {
			return sqlSessionTemplate.update(str, obj);
		} catch (Exception e) {
			throw new DaoException("更新数据异常", e);
		}
	}

	/**
	 * 批量更新
	 * 
	 * @param str
	 * @param obj
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public void batchUpdate(String str, List objs) {
		SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();
		// 批量执行器
		SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
		try {
			if (objs != null) {
				for (int i = 0, size = objs.size(); i < size; i++) {
					sqlSession.update(str, objs.get(i));
				}
				sqlSession.flushStatements();
				sqlSession.commit();
				sqlSession.clearCache();
			}
		} catch (Exception e) {
			throw new DaoException("批量更新数据异常", e);
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * 批量删除
	 * 
	 * @param str
	 * @param obj
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public void batchDelete(String str, List objs) {

		SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();
		// 批量执行器
		SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);

		try {
			if (objs != null) {
				for (int i = 0, size = objs.size(); i < size; i++) {
					sqlSession.delete(str, objs.get(i));
				}
				sqlSession.flushStatements();
				sqlSession.commit();
				sqlSession.clearCache();
			}
		} catch (Exception e) {
			throw new DaoException("批量删除数据异常", e);
		}
	}

	/**
	 * 删除对象
	 * 
	 * @param str
	 * @param obj
	 * @return 返回为int
	 * @throws Exception
	 */
	public Integer delete(String str, Object obj) {
		try {
			return sqlSessionTemplate.delete(str, obj);
		} catch (Exception e) {
			throw new DaoException("删除数据异常", e);
		}
	}

	/**
	 * 查找对象
	 * 
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object findForObject(String str, Object obj) {
		try {
			return sqlSessionTemplate.selectOne(str, obj);
		} catch (Exception e) {
			throw new DaoException("查询单条数据异常", e);
		}
	}

	/**
	 * 查找对象list
	 * 
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object findForList(String str, Object obj) {
		try {
			return sqlSessionTemplate.selectList(str, obj);
		} catch (Exception e) {
			throw new DaoException("查询数据异常", e);
		}
	}

	/**
	 * 查找对象Map
	 * 
	 * @date 2017年9月13日
	 * @author darwin du
	 * @param str
	 * @param obj
	 * @param key
	 * @param value
	 * @return
	 */
	public Object findForMap(String str, Object obj, String key, String value) {
		try {
			return sqlSessionTemplate.selectMap(str, obj, key);
		} catch (Exception e) {
			throw new DaoException("查询Map类型数据异常", e);
		}
	}

}
