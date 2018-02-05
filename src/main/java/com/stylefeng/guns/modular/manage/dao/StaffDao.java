package com.stylefeng.guns.modular.manage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 员工管理Dao
 *
 * @author fengshuonan
 * @Date 2018-01-30 13:47:13
 */
public interface StaffDao {
	/**
	 * 查询员工id和name
	 * @return
	 */
	List<Map<String,Object>> selectIdAndName();
	/**
	 * 查询全部信息
	 * @return
	 */
	List<Map<String,Object>> selectAll();
	/**
	 * 逻辑删除
	 * @param id
	 */
	void deleteStaff(@Param("id")int id);
}
