package spring.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import spring.dto.MyCarDto;

@Repository
public class MyCarDao extends SqlSessionDaoSupport {

	public int getTotalCount() {
		System.out.println("getTotalCount() called#######");
		return getSqlSession().selectOne("car.totalCountOfCar");
	}

	public List<MyCarDto> getAllDatas() {
		System.out.println("getAllDatas() called#######");
		return getSqlSession().selectList("car.selectAllOfCar");
	}

	public void insertCar(MyCarDto dto) {
		System.out.println("insertCar() called#######");
		getSqlSession().insert("car.insertOfCar", dto);
	}

	public void updateCar(MyCarDto dto) {
		System.out.println("updateCar() called#######");
		getSqlSession().update("car.updateOfCar", dto);
	}

	public MyCarDto getData(String num) {
		System.out.println("getData() called#######");
		return getSqlSession().selectOne("car.selectOneOfCar", num);
	}

	public void deleteCar(String num) {
		System.out.println("deleteCar() called#######");
		getSqlSession().delete("car.deleteOfCar", num);
	}

}
