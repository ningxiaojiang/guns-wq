package com.stylefeng.guns.modular.manage.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stylefeng.guns.common.controller.BaseController;
import com.stylefeng.guns.common.persistence.dao.SalesInfoMapper;
import com.stylefeng.guns.common.persistence.dao.SalesMapper;
import com.stylefeng.guns.common.persistence.model.Sales;
import com.stylefeng.guns.modular.manage.dao.ClientDao;
import com.stylefeng.guns.modular.manage.dao.ProductDao;
import com.stylefeng.guns.modular.manage.dao.SalesDao;
import com.stylefeng.guns.modular.manage.dao.SalesInfoDao;
import com.stylefeng.guns.modular.manage.dao.StaffDao;
import com.stylefeng.guns.modular.manage.factory.NoFactory;
import com.stylefeng.guns.modular.manage.service.ISalesService;
import com.stylefeng.guns.modular.system.dao.DictDao;

/**
 * 銷售管理
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("static-access")
@Controller
@RequestMapping("/sales")
public class SalesController extends BaseController {
	@Autowired
	SalesDao salesDao;
	
	@Autowired
	SalesInfoDao salesInfoDao;
	
	@Resource
	private SalesMapper salesMapper;
	
	@Resource
	private SalesInfoMapper salesInfoMapper;
	
	@Resource
    private DictDao dictDao;
	
	@Resource
	private ClientDao clientDao;
	
	@Resource
	private ProductDao proDao;
	
	@Autowired
	private StaffDao staffDao;
	
	@Resource
	private ISalesService salesSer;
	
	private static String PREFIX = "/manage/sales/";
	/**
     * 跳转到销售管理首页
     */
	@RequestMapping("")
	public String index(Model model){
		List<Map<String,Object>> staffList = staffDao.selectIdAndName();
		model.addAttribute("staffes", staffList);
		return PREFIX+"sales.html";
	}
	/**
     * 获取销售管理列表
     */
	@RequestMapping("list")
	@ResponseBody
	public List<Map<String,Object>> list(){
		return salesDao.selectAll();
	}
	/**
     * 跳转到添加销售管理
     */
    @RequestMapping("/sales_add")
    public String salesAdd(Model model) {
    	model.addAttribute("no", NoFactory.getIndicatorNo("XS", salesDao.selectLastOne("XS"), "salesno"));
    	model.addAttribute("clients", clientDao.selectIdAndName());
    	model.addAttribute("types", dictDao.selectByName("配送方式"));
    	model.addAttribute("fps", dictDao.selectByName("开票"));
    	model.addAttribute("staffes", staffDao.selectIdAndName());
    	model.addAttribute("statues", dictDao.selectByName("销售状态"));
    	model.addAttribute("productes", proDao.selectIdAndName());
        return PREFIX + "sales_add.html";
    }

    /**
     * 跳转到修改销售管理
     */
    @RequestMapping("/sales_update/{salesId}")
    public String salesUpdate(@PathVariable Integer salesId, Model model) {
    	model.addAttribute("no", NoFactory.getIndicatorNo("XS", salesDao.selectLastOne("XS"), "salesno"));
    	model.addAttribute("clients", clientDao.selectIdAndName());
    	model.addAttribute("types", dictDao.selectByName("配送方式"));
    	model.addAttribute("fps", dictDao.selectByName("开票"));
    	model.addAttribute("staffes", staffDao.selectIdAndName());
    	model.addAttribute("statues", dictDao.selectByName("销售状态"));
    	model.addAttribute("productes", proDao.selectIdAndName());
    	Sales sales = salesMapper.selectById(salesId);
    	model.addAttribute("sales",sales);
    	model.addAttribute("salesInfoes",salesInfoDao.selectByNo(sales.getSalesno()));
        return PREFIX + "sales_edit.html";
    }


    /**
     * 新增销售管理
     */
    
	@RequestMapping(value = "/add")
    @ResponseBody
    public Object add(@Valid Sales sales,BindingResult result,String productes) {
    	salesSer.insert(sales, productes);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除销售管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(Integer salesId,String salesno) {
    	salesSer.delete(salesId, salesno);
        return SUCCESS_TIP;
    }


    /**
     * 修改销售管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(@Valid Sales sales,BindingResult result,String productes) {
    	salesSer.update(sales, productes);
        return super.SUCCESS_TIP;
    }

    /**
     * 销售管理详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
	
}
