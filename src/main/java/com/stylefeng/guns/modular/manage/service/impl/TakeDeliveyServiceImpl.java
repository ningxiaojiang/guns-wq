package com.stylefeng.guns.modular.manage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stylefeng.guns.common.exception.BizExceptionEnum;
import com.stylefeng.guns.common.exception.BussinessException;
import com.stylefeng.guns.common.persistence.dao.StockMapper;
import com.stylefeng.guns.common.persistence.dao.TakeDeliveyInfoMapper;
import com.stylefeng.guns.common.persistence.dao.TakeDeliveyMapper;
import com.stylefeng.guns.common.persistence.model.Stock;
import com.stylefeng.guns.common.persistence.model.TakeDelivey;
import com.stylefeng.guns.common.persistence.model.TakeDeliveyInfo;
import com.stylefeng.guns.modular.manage.dao.StockDao;
import com.stylefeng.guns.modular.manage.dao.TakeDeliveyDao;
import com.stylefeng.guns.modular.manage.dao.TakeDeliveyInfoDao;
import com.stylefeng.guns.modular.manage.service.IStockService;
import com.stylefeng.guns.modular.manage.service.ITakeDeliveyService;

/**
 * 收货管理Dao
 *
 * @author fengshuonan
 * @Date 2018-01-30 09:08:00
 */
@Service
@Transactional
public class TakeDeliveyServiceImpl implements ITakeDeliveyService {
	
	@Resource
	private TakeDeliveyDao tdDao;
	
	@Resource
	private TakeDeliveyInfoDao tdInfoDao;
	
	@Resource
	private TakeDeliveyMapper tdMapper;
	
	@Resource
	private TakeDeliveyInfoMapper tdInfoMapper;
	
	@Resource
	private StockMapper stockMapper;
	
	@Resource
	private StockDao stockDao;
	
	@Resource
	private IStockService stockSer;
	
	@Override
	public void insert(TakeDelivey takeDelivey, String productes) {
		takeDelivey.setDelflag(1);
		tdMapper.insert(takeDelivey);
		if(productes != "" && productes != null){
			String[] str = productes.split(";");
			for(String st : str){
				String[] pro = st.split(":");
				Integer number = Integer.parseInt(pro[2]);
				Integer productid = Integer.parseInt(pro[1]);
				TakeDeliveyInfo td = new TakeDeliveyInfo();
				td.setDelflag(1);
				td.setProductId(productid);
				td.setNumber(number);
				td.setTakeDeliveyNo(takeDelivey.getOtherone());
				if(pro.length > 3){
					td.setRemarks(pro[3]);
				}
				tdInfoMapper.insert(td);
				//添加库存
				Stock stock = new Stock();
				stock.setDelflag(1);
				stock.setNumber(number);
				stock.setProductid(productid);
				if(pro.length > 3){
					stock.setOtherone(pro[3]);;
				}
				stockSer.update(stock,1);
			}
		}
	}

	@Override
	public void update(TakeDelivey takeDelivey, String productes) {
		takeDelivey.setDelflag(1);
		tdMapper.updateById(takeDelivey);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("takedeliveyno", takeDelivey.getOtherone());
//		Map<String,Object> maps = new HashMap<String,Object>();
//		maps.put("takeid", takeDelivey.getOtherone());
		tdInfoMapper.deleteByMap(map);//删除原有清单
		//stockMapper.deleteByMap(maps);//删除原有库存
		if(productes != "" && productes != null){
			String[] str = productes.split(";");
			for(String st : str){
				String[] pro = st.split(":");
				Integer id = Integer.parseInt(pro[0]);
				Integer number = Integer.parseInt(pro[2]);
				Integer productid = Integer.parseInt(pro[1]);
				TakeDeliveyInfo td = new TakeDeliveyInfo();
				td.setId(id);
				td.setDelflag(1);
				td.setProductId(productid);
				td.setNumber(number);
				td.setTakeDeliveyNo(takeDelivey.getOtherone());
				if(pro.length > 3){
					td.setRemarks(pro[3]);
				}
				tdInfoMapper.insert(td);
				//添加库存
				Stock stock = new Stock();
				stock.setDelflag(1);
				stock.setNumber(number-Integer.parseInt(pro[4]));
				stock.setProductid(productid);
				stock.setTakeid(id+"");
				if(pro.length > 4){
					stock.setOtherone(pro[3]);
				}
				stockSer.update(stock,1);
			}
		}
	}

	@Override
	public void delete(Integer takeDeliveyId, String takeDeliveyNo) {
		tdDao.delete(takeDeliveyId);
		tdInfoDao.delete(takeDeliveyNo);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("takedeliveyno", takeDeliveyNo);
		List<TakeDeliveyInfo> ls = tdInfoMapper.selectByMap(map);
		for(TakeDeliveyInfo tdInfo : ls){
			Integer id = tdInfo.getId();
			map.clear();
			map.put("takeid", id);
			Stock stock= stockMapper.selectByMap(map).get(0);
			if(tdInfo.getNumber() != stock.getNumber()){
				throw new BussinessException(BizExceptionEnum.STOCK_ERROR);
			}else{
				//stockDao.delete(id+"");
			}
		}
	}
}
