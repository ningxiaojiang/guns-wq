package com.stylefeng.guns.modular.manage.controller;

import com.stylefeng.guns.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 销售管理控制器
 *
 * @author fengshuonan
 * @Date 2018-01-29 16:42:42
 */
@Controller
@RequestMapping("/sales")
public class SalesController extends BaseController {

    private String PREFIX = "/manage/sales/";

    /**
     * 跳转到销售管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "sales.html";
    }

    /**
     * 跳转到添加销售管理
     */
    @RequestMapping("/sales_add")
    public String salesAdd() {
        return PREFIX + "sales_add.html";
    }

    /**
     * 跳转到修改销售管理
     */
    @RequestMapping("/sales_update/{salesId}")
    public String salesUpdate(@PathVariable Integer salesId, Model model) {
        return PREFIX + "sales_edit.html";
    }

    /**
     * 获取销售管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return null;
    }

    /**
     * 新增销售管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add() {
        return super.SUCCESS_TIP;
    }

    /**
     * 删除销售管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete() {
        return SUCCESS_TIP;
    }


    /**
     * 修改销售管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update() {
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
