package com.stylefeng.guns.modular.manage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 收货管理Dao
 *
 * @author fengshuonan
 * @Date 2018-01-30 09:08:00
 */
public interface TakeDeliveyDao {
	/**
	 * 查询全部
	 * @return
	 */
	List<Map<String,Object>> selectAll();
	/**
	 * 逻辑删除
	 * @param id
	 */
	void delete(@Param("id")Integer id);
}
