package com.zq.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zq.interceptor.WebInterceptor;
import com.zq.pojo.Qrobject;
import com.zq.service.QrobjectService;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;

@Controller
public class QrobjectController {
	
	@Autowired QrobjectService qrobjectService;
	
	Logger logger = Logger.getLogger(WebInterceptor.class);
	
	@SuppressWarnings("finally")
	@GetMapping("/qrobjects")
	@ResponseBody
    public String listQrobject() {
		List<Qrobject> qrobjects = new ArrayList<Qrobject>();
		try {
			qrobjects = qrobjectService.list();
			//throw new Exception();
		}catch(Exception e) {
			//e.printStackTrace();
			Qrobject qrobject = new Qrobject();
			qrobject.setId(000);
			qrobject.setName("未找到");
			qrobject.setDescription("内容未找到");
			qrobjects.add(qrobject);
		}finally {
			JSONArray jsons = new JSONArray(qrobjects);
			return jsons.toString();
		}
    }
	
	@DeleteMapping("/qrobjects/{id}")
	@ResponseBody
    public String deleteQrobject(@PathVariable("id") int id) throws Exception {
//		for(int i = 0; (qrobjectService.delete(id) == 0) && i < 5; ++i) {
//			Thread.sleep(1000);
//		}
		return "delete完成";
    }
	
	@PostMapping("/qrobjects")
	@ResponseBody
    public String addQrobject(Qrobject q) throws Exception {
		try {
			qrobjectService.add(q);
		}catch(Exception e) {
			return "add失败";
		}
		return "add完成";
    }
	
	@PutMapping("/qrobjects/{id}")
	@ResponseBody
    public String updateQrobject(@RequestBody Qrobject q) throws Exception {
		logger.info(q);
		for(int i = 0; (qrobjectService.update(q) == 0) && i < 5; ++i) {
			Thread.sleep(1000);
		}
		return listQrobject();
    }
	
	@GetMapping("/qrobjects/{id}")
	@ResponseBody
    public String getOne(@PathVariable("id") int id) {
		Qrobject q = qrobjectService.get(id);
		if(q == null) {
			q = new Qrobject();
			q.setId(000);
			q.setName("未找到");
			q.setDescription("无描述");
		}
		JSONObject json = new JSONObject(q);
		return json.toString();
	}
	
	@RequestMapping("/")
    public String index() throws Exception {
		return "redirect:/qrobjects";
    }
}
