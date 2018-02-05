package com.stylefeng.guns.modular.manage.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stylefeng.guns.common.controller.BaseController;
import com.stylefeng.guns.common.persistence.dao.SalesMapper;
import com.stylefeng.guns.common.persistence.dao.StaffMapper;
import com.stylefeng.guns.modular.manage.dao.DispatchingDao;
import com.stylefeng.guns.modular.manage.dao.ProductDao;
import com.stylefeng.guns.modular.manage.dao.SalesDao;
import com.stylefeng.guns.modular.manage.dao.SalesInfoDao;
import com.stylefeng.guns.modular.manage.dao.StaffDao;
import com.stylefeng.guns.modular.manage.factory.NoFactory;
import com.stylefeng.guns.modular.manage.transfer.DispDto;

/**
 * 配送管理控制器
 *
 * @author fengshuonan
 * @Date 2018-01-30 09:04:41
 */
@Controller
@RequestMapping("/dispatching")
@SuppressWarnings("static-access")
public class DispatchingController extends BaseController {

    private String PREFIX = "/manage/dispatching/";

    @Resource
    private DispatchingDao dpDao;
    
    @Resource
    private ProductDao proDao;
    
    @Resource
    private StaffDao staffDao;
    
    @Resource
    private SalesInfoDao salesInfoDao;
    
    @Resource
    private SalesDao salesDao;
    
    @Resource
    private SalesMapper salesMapper;
    
    @Resource
    private StaffMapper staffMapper;
    
    /**
     * 跳转到配送管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "dispatching.html";
    }

    /**
     * 跳转到添加配送管理
     */
    @RequestMapping("/dispatching_add/{salesno}")
    public String dispatchingAdd(@PathVariable String salesno, Model model) {
    	model.addAttribute("productes", proDao.selectIdAndName());
    	model.addAttribute("staffes", staffDao.selectIdAndName());
    	model.addAttribute("salesInfoes", salesInfoDao.selectByNo(salesno));
    	String disoatchingNo = NoFactory.getIndicatorNo("PS", dpDao.selectLastOne("PS"), "otherone");
        Map<String,Object> map = salesDao.selectMapByNo(salesno);
        map.put("disoatchingNo", disoatchingNo);
        model.addAttribute("disp", map);
    	return PREFIX + "dispatching_add.html";
    }

    /**
     * 跳转到修改配送管理
     */
    @RequestMapping("/dispatching_update/{dispatchingId}")
    public String dispatchingUpdate(@PathVariable Integer dispatchingId, Model model) {
        return PREFIX + "dispatching_edit.html";
    }

    /**
     * 获取配送管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return dpDao.selectAll();
    }

    /**
     * 新增配送管理
     */
	@RequestMapping(value = "/add")
    @ResponseBody
    public Object add(@Valid DispDto dispDto,BindingResult result) {
    	System.out.println(dispDto);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除配送管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete() {
        return SUCCESS_TIP;
    }


    /**
     * 修改配送管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update() {
        return super.SUCCESS_TIP;
    }

    /**
     * 配送管理详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
