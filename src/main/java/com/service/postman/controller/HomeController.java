package com.service.postman.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.postman.pojo.Demo;
import com.service.postman.service.IDemoService;

@RestController
@RequestMapping("/v1")
public class HomeController {

	@Autowired
	public IDemoService demoService;

	@GetMapping("/hello")
	public String hello() {
		return "Greetings from controller";
	}

	@GetMapping("/demos")
	public List<Demo> getAllDemos() {
		if (demoService == null) {
			throw new NullPointerException("Demo Service is null initialised");
		}
		return demoService.getAllDemos();
	}

	@GetMapping("/demo/{id}")
	public Demo getDemo(@PathVariable(value = "id") Integer id) {
		return demoService.getDemo(id);
	}

	@PostMapping("/demo/save")
	public Demo saveDemo(@RequestBody Demo demo) {
		return demoService.saveDemo(demo);
	}

	@PutMapping("/demo/update")
	public Demo updateDemo(@RequestBody Demo demo) {
		return demoService.updateDemo(demo);
	}

	@DeleteMapping("/demo/delete/{id}")
	public String deleteDemo(@PathVariable(value = "id") Integer id) {
		return demoService.deleteDemo(id);
	}

}
