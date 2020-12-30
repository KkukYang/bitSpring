package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
//@Table(name="mycar")
@Table(name="mycar2") //실행하면 자동으로 테이블 생성.(없을경우) - 있다면 업데이트.
@Data
public class MyCarDto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long num;
//	private String num;
	
	@Column(name = "carname")
	private String carname;
	
	@Column(name = "carprice")
	private int carprice;
	
	@Column(name = "carcolor")
	private String carcolor;
	
	@Column(name = "carguip")
	private String carguip;
}
