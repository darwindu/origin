package org.world.origin.enums;

/**
 * <pre>
 * *********************************************
 * Copyright .
 * All rights reserved.
 * Description: 【注意：错误描述长度不要超过255】
 * HISTORY
 * *********************************************
 *  ID     REASON        PERSON          DATE
 *  1      Create   	 darwin du       2017年7月17日
 * *********************************************
 * </pre>
 */
public enum ResultEnum {
	
	
	/*********************************结果集-返回-异常**/
	/**结果集-返回-code:0，成功**/
	SUCCESS(0, "success || 成功"),
	
	/**结果集-返回-code:800000，已受理成功**/
	SUCCESS_DONE(800000, "success || 已受理成功"),
	
	/**结果集-返回-code:800101，未知**/
	ERROR_UNKOWN(800101, "unkown || 未知"),
	
	/**结果集-返回-code:800102，已受理未知**/
	ERROR_UNKOWN_DONE(800102, "unkown || 已受理未知"),
	
	/**结果集-返回-code:800103，处理中**/
	DOING(800103, "it is doing || 处理中"),
	
	/**结果集-返回-code:800104，失败**/
	FAIL(800104, "fail || 失败"),
	
	
	/*********************************结果集-数据库-异常**/
	/**结果集-数据库-code:800201，保存数据异常**/
	ERROR_SAVE(800201, "save is fail || 添加数据异常"),
	
	/**结果集-数据库-code:800202，保存操作成功，但影响0行**/
	ERROR_SAVE_ZERO(800202, "save is ok, but 0 rows affected || 添加操作成功，但影响0行"),
	
	/**结果集-数据库-code:800203，更新数据异常**/
	ERROR_UPDATE(800203, "update is fail || 更新数据异常"),
	
	/**结果集-数据库-code:800204，更新操作成功，但影响0行**/
	ERROR_UPDATE_ZERO(800204, "update is ok, but 0 rows affected || 更新操作成功，但影响0行"),
	
	/**结果集-数据库-code:800205，删除数据异常**/
	ERROR_DELETE(800205, "delete is fail || 删除数据异常"),
	
	/**结果集-数据库-code:800206，删除操作成功，但影响0行**/
	ERROR_DELETE_ZERO(800206, "delete is ok, but 0 rows affected || 删除操作成功，但影响0行"),
	
	/**结果集-数据库-code:800207，查询单条数据异常**/
	ERROR_QUERY_SINGLE(800207, "query single is fail || 查询单条数据异常"),
	
	/**结果集-数据库-code:800207，查询列表数据异常**/
	ERROR_QUERY_LIST(800207, "query list is fail || 查询列表数据异常"),
	
	/*********************************结果集-业务处理-异常**/
	/**结果集-业务处理-code:800301，非法参数**/
	ERROR_ILLEGAL_PARAM(800301, "illegal param || 非法参数"),
	
	/**结果集-业务处理-code:800302，请求接口已经被关闭**/
	ERROR_INTERFACE_CLOASED(800302, "the interface haved bean closed || 请求接口已经被关闭"),
	
	
	/**code:800401，支付失败通知重发访问前置超时**/
	ERROR_TIMEOUT_RESEND(800401, "access timeout || 访问超时"),
	
	/**code:8004012，IO异常**/
	ERROR_IO(800402, "IOException || IO异常"),
    ;

	private Integer code;
    private String msg;
    
    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    
    /**
     * 根据code查询msg
     * @date 2017年9月13日
     * @author darwin du
     * @param code
     * @return
     */
    public static String getValue(Integer code){  
    	
        for(ResultEnum resultEnum : ResultEnum.values()) {  
            if(resultEnum.getCode().equals(code)){  
                return resultEnum.msg;  
            }  
        }  
        return null;  
    } 
    
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
