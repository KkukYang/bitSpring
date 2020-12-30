package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MycarDao {

	@Autowired
	MycarDaoInter daoInter;
	
	public void insertCar(MyCarDto dto) {
		daoInter.save(dto);
	}
	
//	public Iterable<MyCarDto> getAllDatas(){
	public List<MyCarDto> getAllDatas(){
		return daoInter.findAll();
	}
	
	public void updateCar(MyCarDto dto) {
		daoInter.save(dto);
	}
	
	public void deleteCar(Long id) {
		daoInter.deleteById(id);
	}
	
	public MyCarDto getData(Long id) {
		return daoInter.getOne(id);
	}
}
