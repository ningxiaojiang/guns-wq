package com.stylefeng.guns.modular.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.stylefeng.guns.common.persistence.model.TakeDeliveyInfo;

public interface TakeDeliveyInfoDao {
	/**
	 * 根据货单号查询
	 * @param tdNo
	 * @return
	 */
	List<TakeDeliveyInfo> selectByNo(@Param("tdNo")String tdNo);
	/**
	 * 根据货单号删除
	 * @param tdNo
	 */
	void delete(@Param("tdNo")String tdNo);
}
