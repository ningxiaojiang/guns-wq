package com.stylefeng.guns.modular.manage.controller;

import com.stylefeng.guns.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 结算管理控制器
 *
 * @author fengshuonan
 * @Date 2018-01-30 09:03:46
 */
@Controller
@RequestMapping("/accounts")
public class AccountsController extends BaseController {

    private String PREFIX = "/manage/accounts/";

    /**
     * 跳转到结算管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "accounts.html";
    }

    /**
     * 跳转到添加结算管理
     */
    @RequestMapping("/accounts_add")
    public String accountsAdd() {
        return PREFIX + "accounts_add.html";
    }

    /**
     * 跳转到修改结算管理
     */
    @RequestMapping("/accounts_update/{accountsId}")
    public String accountsUpdate(@PathVariable Integer accountsId, Model model) {
        return PREFIX + "accounts_edit.html";
    }

    /**
     * 获取结算管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return null;
    }

    /**
     * 新增结算管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add() {
        return super.SUCCESS_TIP;
    }

    /**
     * 删除结算管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete() {
        return SUCCESS_TIP;
    }


    /**
     * 修改结算管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update() {
        return super.SUCCESS_TIP;
    }

    /**
     * 结算管理详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
