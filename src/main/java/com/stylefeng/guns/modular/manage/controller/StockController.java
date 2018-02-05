package com.stylefeng.guns.modular.manage.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stylefeng.guns.common.controller.BaseController;
import com.stylefeng.guns.common.persistence.dao.StockMapper;
import com.stylefeng.guns.common.persistence.model.Stock;
import com.stylefeng.guns.modular.manage.dao.ProductDao;
import com.stylefeng.guns.modular.manage.dao.StockDao;

/**
 * 库存管理控制器
 *
 * @author nxj
 * @Date 2018-01-30 09:00:21
 */
@Controller
@RequestMapping("/stock")
@SuppressWarnings("static-access")
public class StockController extends BaseController {

    private String PREFIX = "/manage/stock/";
    
    @Resource
    private ProductDao proDao;
    
    @Resource
    private StockDao stockDao;
    
    @Resource
    private StockMapper stockMapper;
    
    /**
     * 跳转到库存管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "stock.html";
    }

    /**
     * 跳转到添加库存管理
     */
    @RequestMapping("/stock_add")
    public String stockAdd(Model model) {
    	model.addAttribute("productes", proDao.selectIdAndName());
        return PREFIX + "stock_add.html";
    }

    /**
     * 跳转到修改库存管理
     */
    @RequestMapping("/stock_update/{stockId}")
    public String stockUpdate(@PathVariable Integer stockId, Model model) {
    	model.addAttribute("productes", proDao.selectIdAndName());
    	model.addAttribute("stock", stockMapper.selectById(stockId));
        return PREFIX + "stock_edit.html";
    }

    /**
     * 获取库存管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return stockDao.selectAll();
    }

    /**
     * 新增库存管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(@Valid Stock stock,BindingResult result) {
    	stock.setDelflag(1);
    	stockMapper.insert(stock);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除库存管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(Integer stockId) {
    	stockDao.delete(stockId);
        return SUCCESS_TIP;
    }


    /**
     * 修改库存管理
     */
	@RequestMapping(value = "/update")
    @ResponseBody
    public Object update(@Valid Stock stock,BindingResult result) {
		stock.setDelflag(1);
    	stockMapper.updateById(stock);
        return super.SUCCESS_TIP;
    }

    /**
     * 库存管理详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
