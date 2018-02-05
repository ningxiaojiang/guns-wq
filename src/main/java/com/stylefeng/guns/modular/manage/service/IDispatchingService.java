package com.stylefeng.guns.modular.manage.service;

import com.stylefeng.guns.modular.manage.transfer.DispDto;

/**
 * 配送管理Service
 *
 * @author nxj
 * @Date 2018-01-30 09:04:41
 */
public interface IDispatchingService {
	/**
	 * 添加配送
	 * @param dispDto
	 */
	void add(DispDto dispDto);
}
