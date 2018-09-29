package com.fx.services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSONObject;

public class Main {

	public static void main(String[] args) throws Exception {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		GenerateNews generateNews= (GenerateNews) context.getBean("generateNews");
		JSONObject jsonObject=generateNews.genernateDetails();
		FileOutputStream fos=new FileOutputStream("newsDetails.json");
		fos.write(jsonObject.toJSONString().getBytes());
		
		jsonObject=generateNews.genernate();
		fos=new FileOutputStream("news.json");
		fos.write(jsonObject.toJSONString().getBytes());
		fos.close();
	}

}
