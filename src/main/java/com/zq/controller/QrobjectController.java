package com.zq.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.zq.pojo.Qrobject;
import com.zq.service.QrobjectService;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;

@Controller
public class QrobjectController {
	
	@Autowired QrobjectService qrobjectService;
	
	@SuppressWarnings("finally")
	@GetMapping("/qrobjects")
	@ResponseBody
    public String listQrobject() {
		List<Qrobject> qrobjects = new ArrayList<Qrobject>();
		try {
			qrobjects = qrobjectService.list();
			//System.out.println(jsons);
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
		qrobjectService.delete(id);
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
		System.out.println(q);
		for(int i = 0; (qrobjectService.update(q) == 0) && i < 5; ++i) {
			Thread.sleep(1000);
		}
		return listQrobject();
    }
	
	@GetMapping("/qrobjects/{id}")
	@ResponseBody
    public String getOne(@PathVariable("id") int id) {
		Qrobject q ;// qrobjectService.get(id);
		//if(q == null) {
			q = new Qrobject();
			q.setId(000);
			q.setName("火坑");
			q.setDescription("带着对儿时的美好记忆，让我们一起走进土家火笼屋，感受土家火塘的温暖吧！在屋子中央会看到一个三方都是用长木头或土砖围成的火塘，中间放上干柴火熊熊燃烧，上方是吊着鼎锅，铜炊壶烧水或煮或烤土豆、红薯之类的，一到冬天，一家人取暖全靠它了，一家人围坐在红红的火炉旁一脸兴奋地谈论着一年的收成，新年的愿景，张家长李家短的胡侃闲聊，全家人在一起度过了一年中最欢乐的时光。");
		//}
		JSONObject json = new JSONObject(q);
		return json.toString();
	}
	
	@RequestMapping("/")
    public String index() throws Exception {
		return "redirect:/qrobjects";
    }
}
