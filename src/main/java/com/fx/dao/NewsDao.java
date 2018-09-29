package com.fx.dao;

import java.util.List;
import java.util.Map;

public interface NewsDao {
	List<Map<String, Object>> queryNews();
	List<Map<String, Object>> queryNewsDetail();
}
