package com.model2.mvc.service.parts.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.model2.mvc.service.domain.Parts;
import com.model2.mvc.service.parts.PartsDAO;
import com.model2.mvc.service.parts.PartsService;




@Service("partsServiceImpl")
public class PartsServiceImpl implements PartsService{

	//Field
	@Autowired
	@Qualifier("partsDaoImpl")
	private PartsDAO partsDao;

	public void setProductDao(PartsDAO partsDao) {
		this.partsDao = partsDao;
	}
	
	//Constructor
	public PartsServiceImpl() {
		System.out.println(this.getClass());
	}

	public void addParts(Parts parts) throws Exception {
		partsDao.addParts(parts);
	}	
}