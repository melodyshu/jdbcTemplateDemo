package com.fx.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class NewsDaoImpl implements NewsDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Map<String, Object>> queryNews() {
		String sql="select type,img,newsTitle,newsTime,newsSpan from news order by type";
		
		return jdbcTemplate.queryForList(sql);
	}

	public List<Map<String, Object>> queryNewsDetail() {
		String sql="select type,newsSpan from news order by type";
		
		return jdbcTemplate.queryForList(sql);
	}

}
