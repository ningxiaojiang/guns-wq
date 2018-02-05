package com.stylefeng.guns.modular.manage.factory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class NoFactory {
	//update by zhangjun 20170809 增加同步关键字，避免并发访问
	/**
	 * 生成系统单号
	 * @param type 类型--"XS"--销售
	 * @param map 验证已有单号的map
	 * @param no 单号字段名
	 * @return
	 */
	public synchronized static String getIndicatorNo(String type,Map<String,Object> map,String no) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd-");
		String begin = type+format.format(date);
		if(map==null){
			return begin+"0001";
		}
		String lastIndicatorId = map.get(no).toString();
		String lastEnd = lastIndicatorId.substring(11);
		if(lastIndicatorId.startsWith(begin)){
			int intEnd = Integer.parseInt(lastEnd);
			String newEnd = String.format("%04d", intEnd += 1);
			return begin+newEnd;
		}else{
			return begin+"0001";
		}
	}
}
