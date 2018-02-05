package com.stylefeng.guns.modular.manage.service;

import com.stylefeng.guns.common.persistence.model.Stock;

/**
 * 库存管理Service
 *
 * @author fengshuonan
 * @Date 2018-01-30 09:00:21
 */
public interface IStockService {
	/**
	 * 更新库存,若产品已存在,则更新数量,没有则新增
	 * @param stock
	 * @param type 1为增加数量-2为减少数量-3为修改数量
	 */
	void update(Stock stock,Integer type);
}
