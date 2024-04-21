package com.service.postman.service;

import java.util.List;

import com.service.postman.pojo.Demo;

public interface IDemoService {

	List<Demo> getAllDemos();

	Demo getDemo(Integer id);

	Demo saveDemo(Demo demo);

	Demo updateDemo(Demo demo);

	String deleteDemo(Integer id);

	Demo patchDemo(Demo demo);

}
