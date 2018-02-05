package com.stylefeng.guns.modular.manage.controller;

import com.stylefeng.guns.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 库存管理控制器
 *
 * @author fengshuonan
 * @Date 2018-01-30 08:58:34
 */
@Controller
@RequestMapping("/wq_stock")
public class Wq_stockController extends BaseController {

    private String PREFIX = "/manage/wq_stock/";

    /**
     * 跳转到库存管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "wq_stock.html";
    }

    /**
     * 跳转到添加库存管理
     */
    @RequestMapping("/wq_stock_add")
    public String wq_stockAdd() {
        return PREFIX + "wq_stock_add.html";
    }

    /**
     * 跳转到修改库存管理
     */
    @RequestMapping("/wq_stock_update/{wq_stockId}")
    public String wq_stockUpdate(@PathVariable Integer wq_stockId, Model model) {
        return PREFIX + "wq_stock_edit.html";
    }

    /**
     * 获取库存管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return null;
    }

    /**
     * 新增库存管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add() {
        return super.SUCCESS_TIP;
    }

    /**
     * 删除库存管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete() {
        return SUCCESS_TIP;
    }


    /**
     * 修改库存管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update() {
        return super.SUCCESS_TIP;
    }

    /**
     * 库存管理详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
