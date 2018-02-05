package com.stylefeng.guns.modular.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.stylefeng.guns.common.persistence.model.SalesInfo;

public interface SalesInfoDao {
	/**
	 * 逻辑删除销售清单
	 * @param salesid
	 */
	void delete(@Param("salesid")String salesid);
	/**
	 * 根据销售单查询产品清单
	 * @param salesid
	 * @return
	 */
	List<SalesInfo> selectByNo(@Param("salesid")String salesid);
}
