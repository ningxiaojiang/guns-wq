package com.stylefeng.guns.modular.manage.controller;

import com.stylefeng.guns.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 报销管理控制器
 *
 * @author fengshuonan
 * @Date 2018-01-30 09:07:34
 */
@Controller
@RequestMapping("/wipeout")
public class WipeoutController extends BaseController {

    private String PREFIX = "/manage/wipeout/";

    /**
     * 跳转到报销管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "wipeout.html";
    }

    /**
     * 跳转到添加报销管理
     */
    @RequestMapping("/wipeout_add")
    public String wipeoutAdd() {
        return PREFIX + "wipeout_add.html";
    }

    /**
     * 跳转到修改报销管理
     */
    @RequestMapping("/wipeout_update/{wipeoutId}")
    public String wipeoutUpdate(@PathVariable Integer wipeoutId, Model model) {
        return PREFIX + "wipeout_edit.html";
    }

    /**
     * 获取报销管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return null;
    }

    /**
     * 新增报销管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add() {
        return super.SUCCESS_TIP;
    }

    /**
     * 删除报销管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete() {
        return SUCCESS_TIP;
    }


    /**
     * 修改报销管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update() {
        return super.SUCCESS_TIP;
    }

    /**
     * 报销管理详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
