package com.fx.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fx.dao.NewsDao;

@Service("generateNews")
public class GenerateNewsImpl implements GenerateNews {

	@Autowired
	private NewsDao newsDao;

	public JSONObject genernate() {
		List<Map<String, Object>> resultList = newsDao.queryNews();
		List<Map<String, Object>> resultList2 = new ArrayList<Map<String,Object>>();
		for (Map<String, Object> map : resultList) {
			Map<String, Object> map2=new HashMap<String, Object>();
			Iterator<String> iterator = map.keySet().iterator();
			while (iterator.hasNext()) {
				String key = (String) iterator.next();
				if ("TYPE".equals(key)) {
					
					map2.put("type", map.get(key));
				}
				if ("IMG".equals(key)) {
					map2.put("img", map.get(key));
				}
				if ("NEWSTITLE".equals(key)) {
					map2.put("newsTitle", map.get(key));
				}
				if ("NEWSTIME".equals(key)) {
					map2.put("newsTime", map.get(key));
				}
				if ("NEWSSPAN".equals(key)) {
					String value=(String) map.get(key);
					value=value.split("\r\n")[0];
					System.out.println(value);
					map2.put("newsSpan", value);
				}
				
			}
			resultList2.add(map2);

		}
		JSONArray resultJsonArray = JSONArray.parseArray(JSON.toJSONString(resultList2));
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("a", resultJsonArray);
		return jsonObject;
	}
	
	public JSONObject genernateDetails() {
		List<Map<String, Object>> resultList = newsDao.queryNewsDetail();
		List<Map<String, Object>> resultList2 = new ArrayList<Map<String,Object>>();
		for (Map<String, Object> map : resultList) {
			Map<String, Object> map2=new HashMap<String, Object>();
			Iterator<String> iterator = map.keySet().iterator();
			while (iterator.hasNext()) {
				String key = (String) iterator.next();
				if ("TYPE".equals(key)) {
					System.out.println(map.get(key));
					map2.put("type", map.get(key));
				}
				if ("NEWSSPAN".equals(key)) {
					String value=(String) map.get(key);
					String line=value.substring(value.length()-2);
					if ("\r\n".equals(line)) {
						System.out.println("去掉了换行");
						value=value.substring(0, value.length()-2);
					}
					value=value.replace("\r\n", "<div class = 'changeLine' > </div>");
					System.out.println(value);
					map2.put("newsSpan", value);
				}
			}
			resultList2.add(map2);

		}
		JSONArray resultJsonArray = JSONArray.parseArray(JSON.toJSONString(resultList2));
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("a", resultJsonArray);
		return jsonObject;
	}

}
