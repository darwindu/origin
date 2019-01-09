package org.world.origin.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;

/**
 * <pre>
 * *********************************************
 * Copyright .
 * All rights reserved.
 * Description:
 * HISTORY
 * *********************************************
 *  ID     REASON        PERSON          DATE
 *  1      Create   	 darwin du       2017年11月22日
 * *********************************************
 * </pre>
 */
@RestController
public class HelloWorldController {

	
	@RequestMapping("hi")
	@ResponseBody
	public String hi() {
		return "hello world !";
	}
	
	@RequestMapping("helloworld")
	public String helloworld() {
		return "helloworld";
	}
	
	@RequestMapping("index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("helloworldTh")  
    public String helloHtml(@RequestBody Map<String,Object> map){  
  
       map.put("hello","from TemplateController.helloHtml");  
       return "helloworld";  
    } 
	
	@PostMapping(value = "json")  
    public JsonObject json(@RequestBody JsonObject json){
       return json;  
    }
	
	
}
