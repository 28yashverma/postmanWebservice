package com.service.postman.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.postman.pojo.Demo;
import com.service.postman.repo.IDemoRepo;

@Service
public class DemoService implements IDemoService {

	@Autowired
	public IDemoRepo demoRepo;

	@Override
	public List<Demo> getAllDemos() {
		if (demoRepo == null) {
			throw new NullPointerException("Demo repo is null initialised");
		}
		return demoRepo.findAll();
	}

	@Override
	public Demo getDemo(Integer id) {
		if (id == null) {
			throw new IllegalArgumentException("Id is null ");
		}
		return demoRepo.findById(id).get();
	}

	@Override
	public Demo saveDemo(Demo demo) {
		if (demo == null) {
			throw new IllegalArgumentException("demo object is null ");
		}
		return demoRepo.saveAndFlush(demo);
	}

	@Override
	public Demo updateDemo(Demo d) {
		if (d == null) {
			throw new IllegalArgumentException("Demo object is null ");
		}

		Integer id = d.getId();

		Demo demo = demoRepo.findById(id).get();

		if (demo == null) {
			throw new IllegalArgumentException("Cannot update");
		}

		Demo newObj = new Demo(d.getId(), d.getName(), d.getDesc());

		return demoRepo.saveAndFlush(newObj);
	}

	@Override
	public String deleteDemo(Integer id) {

		if (id == null) {
			throw new IllegalArgumentException("Id is null ");
		}

		Demo demo = demoRepo.findById(id).get();

		if (demo == null) {
			throw new IllegalArgumentException("Cannot delete:: No such object present");
		}

		demoRepo.delete(demo);

		return "Deleted successfully";
	}

	@Override
	public Demo patchDemo(Demo demo) {
		// TODO Auto-generated method stub
		return null;
	}

}
