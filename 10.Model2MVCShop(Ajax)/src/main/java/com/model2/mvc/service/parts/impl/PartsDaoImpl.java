package com.model2.mvc.service.parts.impl;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


import com.model2.mvc.service.domain.Parts;
import com.model2.mvc.service.parts.PartsDAO;


@Repository("partsDaoImpl")
public class PartsDaoImpl implements PartsDAO{

	//Field
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}
	
	///Constructor
	public PartsDaoImpl() {
		System.out.println(this.getClass());
	}

	
	public void addParts(Parts parts) throws Exception {
		sqlSession.insert("PartsMapper.addParts", parts);
	}

	public Parts getParts(Parts parts) throws Exception {
		return sqlSession.selectOne("PartsMapper.getParts", parts);
	}



}