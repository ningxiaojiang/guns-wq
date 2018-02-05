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
import com.stylefeng.guns.common.persistence.dao.ProductTypeMapper;
import com.stylefeng.guns.common.persistence.model.ProductType;
import com.stylefeng.guns.modular.manage.dao.ProductTypeDao;

/**
 * 产品类型管理控制器
 *
 * @author nxj
 * @Date 2018-01-30 09:02:35
 */
@SuppressWarnings("static-access")
@Controller
@RequestMapping("/productType")
public class ProductTypeController extends BaseController {

    private String PREFIX = "/manage/productType/";
    
    @Resource
    private ProductTypeDao typeDao;
    
    @Resource
    private ProductTypeMapper typeMapper;
    
    /**
     * 跳转到产品类型管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "productType.html";
    }

    /**
     * 跳转到添加产品类型管理
     */
    @RequestMapping("/productType_add")
    public String productTypeAdd() {
        return PREFIX + "productType_add.html";
    }

    /**
     * 跳转到修改产品类型管理
     */
    @RequestMapping("/productType_update/{productTypeId}")
    public String productTypeUpdate(@PathVariable Integer productTypeId, Model model) {
    	model.addAttribute("productType", typeMapper.selectById(productTypeId));
        return PREFIX + "productType_edit.html";
    }

    /**
     * 获取产品类型管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return typeDao.selectAll();
    }

    /**
     * 新增产品类型管理
     */
    
	@RequestMapping(value = "/add")
    @ResponseBody
    public Object add(@Valid ProductType pro, BindingResult result) {
    	pro.setDelflag(1);
		typeMapper.insert(pro);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除产品类型管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(Integer productTypeId) {
    	typeDao.delete(productTypeId);
        return SUCCESS_TIP;
    }


    /**
     * 修改产品类型管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(@Valid ProductType pro, BindingResult result) {
    	pro.setDelflag(1);
    	typeMapper.updateById(pro);
        return super.SUCCESS_TIP;
    }

    /**
     * 产品类型管理详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
