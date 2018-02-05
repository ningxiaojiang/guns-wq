package com.stylefeng.guns.modular.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.stylefeng.guns.common.persistence.model.Stock;

/**
 * 库存管理Dao
 *
 * @author fengshuonan
 * @Date 2018-01-30 09:00:21
 */
public interface StockDao {
	/**
	 * 根据货单号查询
	 * @param tdNo
	 * @return
	 */
	List<Stock> selectByNo(@Param("tdNo")String tdNo);
	/**
	 * 查询全部
	 * @param tdNo
	 * @return
	 */
	List<Stock> selectAll();
	/**
	 * 根据货单号删除
	 * @param tdNo
	 */
	void delete(@Param("id")Integer id);

}
