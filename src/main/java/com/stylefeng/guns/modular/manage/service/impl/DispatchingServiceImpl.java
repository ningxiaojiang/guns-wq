package com.stylefeng.guns.modular.manage.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.stylefeng.guns.common.persistence.dao.DispatchingMapper;
import com.stylefeng.guns.common.persistence.model.Dispatching;
import com.stylefeng.guns.common.persistence.model.Sales;
import com.stylefeng.guns.modular.manage.dao.SalesDao;
import com.stylefeng.guns.modular.manage.service.IDispatchingService;
import com.stylefeng.guns.modular.manage.transfer.DispDto;

/**
 * 配送管理Dao
 *
 * @author nxj
 * @Date 2018-01-30 09:04:41
 */
@Service
public class DispatchingServiceImpl implements IDispatchingService {
	
	@Resource
	private DispatchingMapper dispMapper;
	
	@Resource
	private SalesDao salesDao;
	
	@Override
	public void add(DispDto dispDto) {
		Sales sales = salesDao.selectByNo(dispDto.getSalesNo());
		System.err.println(sales);
		Dispatching disp = new Dispatching();
	}


}
