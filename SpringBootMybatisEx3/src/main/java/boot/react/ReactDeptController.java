package boot.react;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin // 다른 도메인과의 통신을 위해 추가 : after spring5
public class ReactDeptController {
	
	List<Dept> list = new ArrayList<Dept>();
	
	// add data
	// @RequestBody : json data 로 받을 경우.
	@PostMapping("/react/add")
	public void dataAdd(@RequestBody Dept dept) {
		System.out.println("react add success");
		System.out.println(dept); // call toString() 
		list.add(dept);
	}
	
	@GetMapping("/react/list")
	public List<Dept> list(){
		System.out.println("react list success");
		return list;
	}
}
