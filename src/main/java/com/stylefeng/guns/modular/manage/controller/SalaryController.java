package com.stylefeng.guns.modular.manage.controller;

import com.stylefeng.guns.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 工资管理控制器
 *
 * @author fengshuonan
 * @Date 2018-01-30 09:06:11
 */
@Controller
@RequestMapping("/salary")
public class SalaryController extends BaseController {

    private String PREFIX = "/manage/salary/";

    /**
     * 跳转到工资管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "salary.html";
    }

    /**
     * 跳转到添加工资管理
     */
    @RequestMapping("/salary_add")
    public String salaryAdd() {
        return PREFIX + "salary_add.html";
    }

    /**
     * 跳转到修改工资管理
     */
    @RequestMapping("/salary_update/{salaryId}")
    public String salaryUpdate(@PathVariable Integer salaryId, Model model) {
        return PREFIX + "salary_edit.html";
    }

    /**
     * 获取工资管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return null;
    }

    /**
     * 新增工资管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add() {
        return super.SUCCESS_TIP;
    }

    /**
     * 删除工资管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete() {
        return SUCCESS_TIP;
    }


    /**
     * 修改工资管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update() {
        return super.SUCCESS_TIP;
    }

    /**
     * 工资管理详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
