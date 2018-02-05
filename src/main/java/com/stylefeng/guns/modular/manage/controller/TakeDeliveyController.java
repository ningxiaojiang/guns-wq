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
import com.stylefeng.guns.common.persistence.dao.TakeDeliveyMapper;
import com.stylefeng.guns.common.persistence.model.TakeDelivey;
import com.stylefeng.guns.modular.manage.dao.ProductDao;
import com.stylefeng.guns.modular.manage.dao.StaffDao;
import com.stylefeng.guns.modular.manage.dao.TakeDeliveyDao;
import com.stylefeng.guns.modular.manage.dao.TakeDeliveyInfoDao;
import com.stylefeng.guns.modular.manage.service.ITakeDeliveyService;
import com.stylefeng.guns.modular.system.dao.DictDao;

/**
 * 收货管理控制器
 *
 * @author nxj
 * @Date 2018-01-30 09:08:00
 */
@SuppressWarnings("static-access")
@Controller
@RequestMapping("/takeDelivey")
public class TakeDeliveyController extends BaseController {

    private String PREFIX = "/manage/takeDelivey/";
    
    @Resource
    private DictDao dictDao;
    
    @Resource
    private StaffDao staffDao;
    
    @Resource
    private TakeDeliveyDao tdDao;
    
    @Resource
    private TakeDeliveyInfoDao tdInfoDao;
    
    @Resource
    private ITakeDeliveyService tdSer;
    
    @Resource
    private TakeDeliveyMapper tdMapper;
    
    @Resource
    private ProductDao proDao;
    
    /**
     * 跳转到收货管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "takeDelivey.html";
    }

    /**
     * 跳转到添加收货管理
     */
    @RequestMapping("/takeDelivey_add")
    public String takeDeliveyAdd(Model model) {
    	model.addAttribute("types", dictDao.selectByName("配送方式"));
    	model.addAttribute("staffes", staffDao.selectIdAndName());
    	model.addAttribute("productes", proDao.selectAll());
        return PREFIX + "takeDelivey_add.html";
    }

    /**
     * 跳转到修改收货管理
     */
    @RequestMapping("/takeDelivey_update/{takeDeliveyId}")
    public String takeDeliveyUpdate(@PathVariable Integer takeDeliveyId, Model model) {
    	model.addAttribute("types", dictDao.selectByName("配送方式"));
    	model.addAttribute("staffes", staffDao.selectIdAndName());
    	TakeDelivey td =  tdMapper.selectById(takeDeliveyId);
    	model.addAttribute("takeDelivey",td);
    	model.addAttribute("takeDeliveyInfoes", tdInfoDao.selectByNo(td.getOtherone()));
    	model.addAttribute("productes", proDao.selectAll());
    	return PREFIX + "takeDelivey_edit.html";
    }

    /**
     * 获取收货管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return tdDao.selectAll();
    }

    /**
     * 新增收货管理
     */
	@RequestMapping(value = "/add")
    @ResponseBody
    public Object add(@Valid TakeDelivey td,BindingResult result,String productes) {
		System.err.println(productes);
    	tdSer.insert(td, productes);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除收货管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(Integer takeDeliveyId,String takeDeliveyNo) {
    	tdSer.delete(takeDeliveyId, takeDeliveyNo);
        return SUCCESS_TIP;
    }


    /**
     * 修改收货管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(@Valid TakeDelivey td,BindingResult result,String productes) {
    	System.err.println(productes);
        tdSer.update(td, productes);
    	return super.SUCCESS_TIP;
    }

    /**
     * 收货管理详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
