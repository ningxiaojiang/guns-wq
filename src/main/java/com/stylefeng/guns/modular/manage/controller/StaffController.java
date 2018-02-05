package com.stylefeng.guns.modular.manage.controller;

import java.util.List;
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
import com.stylefeng.guns.common.exception.BizExceptionEnum;
import com.stylefeng.guns.common.exception.BussinessException;
import com.stylefeng.guns.common.persistence.dao.StaffMapper;
import com.stylefeng.guns.common.persistence.model.Staff;
import com.stylefeng.guns.modular.manage.dao.StaffDao;
import com.stylefeng.guns.modular.manage.warpper.StaffWarpper;
import com.stylefeng.guns.modular.system.dao.DictDao;

/**
 * 员工管理控制器
 *
 * @author fengshuonan
 * @Date 2018-01-30 13:47:13
 */
@Controller
@RequestMapping("/staff")
@SuppressWarnings("static-access")
public class StaffController extends BaseController {

    private String PREFIX = "/manage/staff/";
    
    @Resource
    private StaffDao staffDao;
    
    @Resource
    private StaffMapper staffMapper;
    
    @Resource
    private DictDao dictDao;
    
    /**
     * 跳转到员工管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "staff.html";
    }

    /**
     * 跳转到添加员工管理
     */
    @RequestMapping("/staff_add")
    public String staffAdd(Model model) {
    	model.addAttribute("sexs", dictDao.selectByName("性别"));
    	model.addAttribute("status", dictDao.selectByName("在职状态"));
        return PREFIX + "staff_add.html";
    }

    /**
     * 跳转到修改员工管理
     */
    @RequestMapping("/staff_update/{staffId}")
    public String staffUpdate(@PathVariable Integer staffId, Model model) {
    	model.addAttribute("sexs", dictDao.selectByName("性别"));
    	model.addAttribute("status", dictDao.selectByName("在职状态"));
    	model.addAttribute("staff", staffMapper.selectById(staffId));
        return PREFIX + "staff_edit.html";
    }

    /**
     * 获取员工管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
    	List<Map<String,Object>> ls = staffDao.selectAll();
        return new StaffWarpper(ls).warp();
    }

    /**
     * 新增员工管理
     */
	@RequestMapping(value = "/add")
    @ResponseBody
    public Object add(@Valid Staff staff,BindingResult result) {
		if (result.hasErrors()) {
            //throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
		staff.setDelFlag(1);
    	staffMapper.insert(staff);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除员工管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(Integer staffId) {
    	staffDao.deleteStaff(staffId);
        return SUCCESS_TIP;
    }


    /**
     * 修改员工管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(@Valid Staff staff,BindingResult result) {
    	staff.setDelFlag(1);
    	staffMapper.updateById(staff);
        return super.SUCCESS_TIP;
    }

    /**
     * 员工管理详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail(Integer id,Model model) {
    	model.addAttribute("staff", staffMapper.selectById(id));
        return null;
    }
}
