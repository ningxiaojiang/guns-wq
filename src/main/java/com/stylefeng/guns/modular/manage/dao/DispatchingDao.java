package com.stylefeng.guns.modular.manage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 配送管理Dao
 *
 * @author fengshuonan
 * @Date 2018-01-30 09:04:41
 */
public interface DispatchingDao {
	/**
	 * 查询全部
	 * @return
	 */
	List<Map<String,Object>> selectAll();
	
	/**
	 * 查询最新记录
	 * @param begin
	 * @return
	 */
	Map<String,Object> selectLastOne(@Param("begin") String begin);
}
