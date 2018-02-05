package com.stylefeng.guns.modular.manage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.stylefeng.guns.common.persistence.model.Sales;


public interface SalesDao {
	/**
	 * 查询最新记录
	 * @param begin
	 * @return
	 */
	Map<String,Object> selectLastOne(@Param("begin") String begin);
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
	/**
	 * 根据销售单查询
	 * @param no
	 * @return
	 */
	Sales selectByNo(@Param("no")String no);
	/**
	 * 根据销售单查询
	 * @param no
	 * @return
	 */
	Map<String,Object> selectMapByNo(@Param("no")String no);
}
