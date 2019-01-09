package org.world.origin.demo;

import java.io.Serializable;

/**
 * <pre>
 * *********************************************
 * Copyright .
 * All rights reserved.
 * Description:
 * HISTORY
 * *********************************************
 *  ID     REASON        PERSON          DATE
 *  1      Create   	 darwin du       2017年9月30日
 * *********************************************
 * </pre>
 */
public class Demo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String sex;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Demo [name=" + name + ", sex=" + sex + "]";
	}
	
}
