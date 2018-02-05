package com.stylefeng.guns.modular.manage.service;

import com.stylefeng.guns.common.persistence.model.TakeDelivey;

/**
 * 收货管理Service
 *
 * @author fengshuonan
 * @Date 2018-01-30 09:08:00
 */
public interface ITakeDeliveyService {
	/**
	 * 添加
	 * @param takeDelivey
	 * @param productes
	 */
	void insert(TakeDelivey takeDelivey,String productes);
	/**
	 * 修改
	 * @param takeDelivey
	 * @param productes
	 */
	void update(TakeDelivey takeDelivey,String productes);
	/**
	 * 逻辑删除
	 * @param takeDeliveyId
	 * @param takeDeliveyNo
	 */
	void delete(Integer takeDeliveyId,String takeDeliveyNo);
}
