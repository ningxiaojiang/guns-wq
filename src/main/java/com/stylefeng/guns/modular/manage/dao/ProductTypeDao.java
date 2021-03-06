package com.stylefeng.guns.modular.manage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 产品类型管理Dao
 *
 * @author fengshuonan
 * @Date 2018-01-30 09:02:36
 */
public interface ProductTypeDao {
	/**
	 * 查询id和name
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
	void delete(@Param("id")int id);

}
