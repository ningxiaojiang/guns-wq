package com.stylefeng.guns.modular.manage.warpper;

import com.stylefeng.guns.common.constant.factory.ConstantFactory;
import com.stylefeng.guns.common.warpper.BaseControllerWarpper;

import java.util.Map;

/**
 * 结算列表的包装
 *
 * @author nxj
 * @date 2017年4月25日 18:10:31
 */
public class StaffWarpper extends BaseControllerWarpper {

    public StaffWarpper(Object list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
    	map.put("sexName", ConstantFactory.me().getSexName((Integer) map.get("sex")));
    }

}
