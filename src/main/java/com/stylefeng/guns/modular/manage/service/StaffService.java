package com.stylefeng.guns.modular.manage.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stylefeng.guns.common.persistence.model.Staff;

public interface StaffService {
	List<Map<String,Object>> selectAll(); 
}
