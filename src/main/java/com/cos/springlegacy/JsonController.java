package com.cos.springlegacy;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.springlegacy.dto.RequestJsonDto;

@Controller
public class JsonController {

	// 스프링은 form에 name값과 혹은 쿼리스트링만 오브젝트로 자동 반환!! 
	@RequestMapping(value="/jsonTest",method=RequestMethod.POST)
	public @ResponseBody RequestJsonDto jsonTest(@RequestBody RequestJsonDto requestJsonDto ) {
		
		System.out.println(requestJsonDto.getId());
		
		return requestJsonDto;
	}
	//http://localhost:8080/springlegacy/jsonHome/변수<<페이징할때 많이 쓴다
	@RequestMapping(value="/jsonHome/(num)",method=RequestMethod.GET) public String JsonHome(@PathVariable int num) {
		
		System.out.println("num:"+num);
		return "jsonHome";
	}
}
