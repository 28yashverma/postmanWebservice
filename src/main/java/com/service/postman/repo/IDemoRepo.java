package com.service.postman.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.postman.pojo.Demo;

@Repository
public interface IDemoRepo extends JpaRepository<Demo, Integer> {

}
