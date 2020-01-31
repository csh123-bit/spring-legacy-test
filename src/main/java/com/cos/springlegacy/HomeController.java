package com.cos.springlegacy;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cos.springlegacy.dto.RequestInfoDto;

//http://localhost:8080/springlegacy/
//Controller 어노테이션은 페이지를 리턴하는 어노테이션이다.
@Controller
public class HomeController {
	
//	1. 데이터 전달-쿼리스트링, Form데이터, Json
//	2. 데이터 받기-쿼리스트링, Form, Json
//	3. Pathvariable 사용해보기
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		// Controller 어노테이션이 있는 클래스에서 함수가 return하는 순간
		// ViewResolve가 관여하여 prefix와 suffix를 만들어서
		// 페이지를 return해준다.//리퀘스트 디스패쳐는 컨트롤러 아니면 레스트만 찾는다.
		// 
		// request에 담기=>modelandview=>model에서 다음페이지까지 끌고간다.
		// 톰캣이 제공하는 모든객체를 매개변수에 적기만하면 DI된다
		
		String username="ssar";
		model.addAttribute("username", "ssar");//Object타입
		
		return "home";
	}
	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public String hello(String id, String pw, Model model) {
		
		System.out.println("id:"+id);
		System.out.println("pw:"+pw);
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "hello";
		//QueryString, x-www-formurlencoded/form에 name값
	}
	@RequestMapping(value = "/goodbye", method = RequestMethod.GET)
	public String goodbye(RequestInfoDto requestInfoDto) {
		
		System.out.println("addr:"+requestInfoDto.getAddr());
		System.out.println("addr:"+requestInfoDto.getHobby());
		return "goodbye";
	}
	
}
