package rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import boot.data.TestDto;

@RestController
public class RestTestController {

	@GetMapping("/json3")
	public List<TestDto> getJson3(){
		List<TestDto> list = new ArrayList<>();
		TestDto dto = new TestDto();
		dto.setSang("오렌지");
		dto.setSu(5);
		dto.setDan(1200);
		
		TestDto dto2 = new TestDto();
		dto2.setSang("오렌지2");
		dto2.setSu(53);
		dto2.setDan(120023);
		
		list.add(dto);
		list.add(dto2);
		return list;
	}
}
