package com.teljdbc.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.teljdbc.dao.TelDao;
import com.teljdbc.po.Telephone;

/**
 * @Description: 业务类：负责业务处理
 * @author chaoling
 * @date 2018年7月29日下午1:38:29
 */
public class TelService {

	TelDao dao = new TelDao();
	List<Telephone> tels = new ArrayList<>();
	/**
	 * @Description: 添加业务处理
	 * @param telephone
	 * @return boolean    
	 */
	public boolean addTel(Telephone telephone) {
		return dao.insert(telephone);
	}

	/**
	 * 
	 * @Description: 删除业务处理
	 * @param name
	 * @return int    
	 * @throws
	 */
	public int deleteTelByName(String name) {
		
		Telephone telephone = dao.select(name);
		if(telephone == null)
			return -1;
		
		return dao.delete(name)?1:0;
	}

	/**
	 * @Description: 根据姓名更新
	 * @param telephone
	 * @param name
	 * @return     
	 * @throws
	 */
	public boolean updateTel(Telephone telephone, String name) {
		return dao.update(telephone,name);
	}

	/**
	 * @Description: 查询所有
	 * @return tels  
	 * @throws
	 */
	public List<Telephone> selectAllTel() {
		return dao.select();
	}

	/**
	 * @Description: 根据姓名查询
	 * @param name
	 * @return     
	 * @throws
	 */
	public Telephone selectTelByName(String name) {
				return dao.select(name);
	}
}
