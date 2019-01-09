package org.world.origin.mapper.demo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.world.origin.domain.PageData;

/**
 * <pre>
 * *********************************************
 * Copyright .
 * All rights reserved.
 * Description:
 * HISTORY
 * *********************************************
 *  ID     REASON        PERSON          DATE
 *  1      Create   	 darwin du       2017年11月22日
 * *********************************************
 * </pre>
 */
@Mapper
public interface DemoMapper {

	@Select("select * from demo where id = ${id}")
	List<PageData> find(@Param("id") String id);
}
