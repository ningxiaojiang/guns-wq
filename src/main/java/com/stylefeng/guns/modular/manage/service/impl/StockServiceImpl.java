package com.stylefeng.guns.modular.manage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.stylefeng.guns.common.persistence.dao.StockMapper;
import com.stylefeng.guns.common.persistence.model.Stock;
import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.modular.manage.dao.StockDao;
import com.stylefeng.guns.modular.manage.service.IStockService;

/**
 * 库存管理Dao
 *
 * @author fengshuonan
 * @Date 2018-01-30 09:00:21
 */
@Service
public class StockServiceImpl implements IStockService {
	
	@Resource
	private StockDao stockDao;
	
	@Resource
	private StockMapper stockMapper;
	
	@Override
	public void update(Stock stock,Integer type) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("productid", stock.getProductid());
		Stock stocks = null;
		List<Stock> ls = stockMapper.selectByMap(map);
		if(ls != null && ls.size() > 0){
			stocks = stockMapper.selectByMap(map).get(0);
		}else{
			stock.setCreatetime(DateUtil.getTime());
			stockMapper.insert(stock);
			return;
		}
		if(type == 1){
			stocks.setNumber(stock.getNumber()+stocks.getNumber());
		}else if(type == 2){
			stocks.setNumber(stocks.getNumber()-stock.getNumber());
		}else{
			stocks.setNumber(stock.getNumber());
		}
		stocks.setUpdatetime(DateUtil.getTime());
		stocks.setOtherone(stock.getOtherone());
		stockMapper.updateById(stocks);
	}

}
