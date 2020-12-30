package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MycarDaoInter extends JpaRepository<MyCarDto, Long> {

	
}
