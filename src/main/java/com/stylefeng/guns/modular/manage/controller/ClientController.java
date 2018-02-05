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

import com.stylefeng.guns.common.constant.factory.ConstantFactory;
import com.stylefeng.guns.common.controller.BaseController;
import com.stylefeng.guns.common.persistence.dao.ClientMapper;
import com.stylefeng.guns.common.persistence.model.Client;
import com.stylefeng.guns.modular.manage.dao.ClientDao;
import com.stylefeng.guns.modular.system.dao.DictDao;

/**
 * 客户管理控制器
 *
 * @author fengshuonan
 * @Date 2018-01-30 09:03:04
 */
@SuppressWarnings("static-access")
@Controller
@RequestMapping("/client")
public class ClientController extends BaseController {

    private String PREFIX = "/manage/client/";
    
    @Resource
    private ClientDao clientDao;
    
    @Resource
    private DictDao dictDao;
    
    @Resource
    private ClientMapper clientMapper;
    
    /**
     * 跳转到客户管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "client.html";
    }

    /**
     * 跳转到添加客户管理
     */
    @RequestMapping("/client_add")
    public String clientAdd(Model model) {
    	model.addAttribute("sexs", dictDao.selectByName("性别"));
        return PREFIX + "client_add.html";
    }

    /**
     * 跳转到修改客户管理
     */
    @RequestMapping("/client_update/{clientId}")
    public String clientUpdate(@PathVariable Integer clientId, Model model) {
    	model.addAttribute("client", clientMapper.selectById(clientId));
        return PREFIX + "client_edit.html";
    }

    /**
     * 获取客户管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
    	List<Map<String,Object>> ls = clientDao.selectAll();
    	//本项目本来有wapper可以给map额外添加属性,我懒得写!但是最好是用wapper--nxj
    	for (int i = 0; i < ls.size(); i++) {
			ls.get(i).put("sexName", ConstantFactory.me().getSexName((Integer) ls.get(i).get("sex")));
		}
        return ls;
    }

    /**
     * 新增客户管理
     */
	@RequestMapping(value = "/add")
    @ResponseBody
    public Object add(@Valid Client client,BindingResult result) {
    	client.setDelflag(1);//因为model中不是用的Integer而是int,所以需要手动确认正常,本项目model使用工具生成,我懒得改!但是以后其他项目不允许这样!model里必须用包装类--nxj
    	clientMapper.insert(client);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除客户管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@PathVariable Integer clientId) {
    	clientDao.delete(clientId);
        return SUCCESS_TIP;
    }


    /**
     * 修改客户管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(@Valid Client client,BindingResult result) {
    	client.setDelflag(1);
    	clientMapper.updateById(client);
        return super.SUCCESS_TIP;
    }

    /**
     * 客户管理详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
