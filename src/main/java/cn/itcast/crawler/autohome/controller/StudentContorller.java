package cn.itcast.crawler.autohome.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stu")
public class StudentContorller {

	@RequestMapping("list")
	public String list(Map<String,Object> data){
		data.put("loginName", "gyf");
		data.put("age", 32);
		return "stu";
	}
}
