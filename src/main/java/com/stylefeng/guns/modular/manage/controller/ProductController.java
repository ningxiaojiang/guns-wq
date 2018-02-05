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
import com.stylefeng.guns.common.persistence.dao.ProductMapper;
import com.stylefeng.guns.common.persistence.model.Product;
import com.stylefeng.guns.modular.manage.dao.ProductDao;
import com.stylefeng.guns.modular.manage.dao.ProductTypeDao;
import com.stylefeng.guns.modular.system.dao.DictDao;

/**
 * 产品管理控制器
 *
 * @author fengshuonan
 * @Date 2018-01-30 09:02:19
 */
@Controller
@RequestMapping("/product")
@SuppressWarnings("static-access")
public class ProductController extends BaseController {

    private String PREFIX = "/manage/product/";
    
    @Resource
    private ProductDao proDao;
    
    @Resource
    private ProductTypeDao protypeDao;
    
    @Resource
    private ProductMapper proMapper;
    
    @Resource
    private DictDao dictDao;
    
    /**
     * 跳转到产品管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "product.html";
    }

    /**
     * 跳转到添加产品管理
     */
    @RequestMapping("/product_add")
    public String productAdd(Model model) {
    	model.addAttribute("types", protypeDao.selectIdAndName());
    	model.addAttribute("ptypes", dictDao.selectByName("包装方式"));
        return PREFIX + "product_add.html";
    }

    /**
     * 跳转到修改产品管理
     */
    @RequestMapping("/product_update/{productId}")
    public String productUpdate(@PathVariable Integer productId, Model model) {
    	model.addAttribute("product", proMapper.selectById(productId));
    	model.addAttribute("types", protypeDao.selectIdAndName());
    	model.addAttribute("ptypes", dictDao.selectByName("包装方式"));
        return PREFIX + "product_edit.html";
    }

    /**
     * 获取产品管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return proDao.selectAll();
    }

    /**
     * 新增产品管理
     */
	@RequestMapping(value = "/add")
    @ResponseBody
    public Object add(@Valid Product pro,BindingResult result) {
		pro.setDelflag(1);
		proMapper.insert(pro);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除产品管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(Integer productId) {
    	proDao.delete(productId);
        return SUCCESS_TIP;
    }


    /**
     * 修改产品管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(@Valid Product pro,BindingResult result) {
    	pro.setDelflag(1);
    	proMapper.updateById(pro);
        return super.SUCCESS_TIP;
    }

    /**
     * 产品管理详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
