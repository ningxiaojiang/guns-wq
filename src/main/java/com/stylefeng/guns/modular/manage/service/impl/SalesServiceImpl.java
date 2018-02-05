package com.stylefeng.guns.modular.manage.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stylefeng.guns.common.persistence.dao.SalesInfoMapper;
import com.stylefeng.guns.common.persistence.dao.SalesMapper;
import com.stylefeng.guns.common.persistence.model.Sales;
import com.stylefeng.guns.common.persistence.model.SalesInfo;
import com.stylefeng.guns.modular.manage.dao.SalesDao;
import com.stylefeng.guns.modular.manage.dao.SalesInfoDao;
import com.stylefeng.guns.modular.manage.service.ISalesService;
@Service
@Transactional
public class SalesServiceImpl implements ISalesService {
	
	@Resource
	private SalesMapper salesMapper;
	
	@Resource
	private SalesInfoMapper salesInfoMapper;
	
	@Resource
	private SalesDao salesDao;
	
	@Resource
	private SalesInfoDao salesInfoDao;
	
	@Override
	public void insert(Sales sales, String product) {
		sales.setDelflag(1);
		salesMapper.insert(sales);
		String[] str = product.split(";");
		if(product != "" && product != null){
			for(String st :str){
				SalesInfo sa = new SalesInfo();
				sa.setSalesid(sales.getSalesno());
				String[] productInfo = st.split(":");
				sa.setProductid(Integer.parseInt(productInfo[0]));
				sa.setPrice(productInfo[1]);
				sa.setCounts(Integer.parseInt(productInfo[2]));
				sa.setRemarks(productInfo[3]);
				sa.setDelflag(1);
				salesInfoMapper.insert(sa);
			}
		}
	}
	@Override
	public void update(Sales sales, String product) {
		sales.setDelflag(1);
		salesMapper.updateById(sales);
		System.err.println(sales);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("salesid", sales.getSalesno());
		salesInfoMapper.deleteByMap(map);
		String[] str = product.split(";");
		if(product != "" && product != null){
			for(String st :str){
				SalesInfo sa = new SalesInfo();
				sa.setSalesid(sales.getSalesno());
				String[] productInfo = st.split(":");
				sa.setProductid(Integer.parseInt(productInfo[0]));
				sa.setPrice(productInfo[1]);
				sa.setCounts(Integer.parseInt(productInfo[2]));
				sa.setRemarks(productInfo[3]);
				sa.setDelflag(1);
				salesInfoMapper.insert(sa);
			}
		}
	}
	@Override
	public void delete(Integer salesId,String salesno) {
		System.err.println(salesId+":"+salesno);
		salesDao.delete(salesId);
		salesInfoDao.delete(salesno);
	}

}
