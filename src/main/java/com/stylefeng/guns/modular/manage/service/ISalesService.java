package com.stylefeng.guns.modular.manage.service;

import com.stylefeng.guns.common.persistence.model.Sales;

public interface ISalesService {
	/**
	 * 添加销售
	 * @param sales 销售记录
	 * @param product 产品清单
	 */
	void insert(Sales sales,String product);
	/**
	 * 修改销售
	 * @param sales 销售记录
	 * @param product 产品清单
	 */
	void update(Sales sales,String product);
	/**
	 * 删除销售
	 * @param salesId
	 */
	void delete(Integer salesId,String salesno);
}
