package com.springbootCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootCrud.model.Kisi;

public interface KisiRepository extends JpaRepository<Kisi, Integer> {//bu extend sayesinde butun jpa nin metodlarini kullanabilirim
	//delete vs
	

}
