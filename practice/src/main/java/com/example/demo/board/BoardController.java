package com.example.demo.board;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.board.mapper.BoardMapper;

@Controller
public class BoardController {
	
	@Resource(name="com.example.demo.board.mapper.BoardMapper")
	BoardMapper mBoardMapper;
	
	@GetMapping("/")
	public String home(Model model) {
		
		try {
			
			model.addAttribute("greetingMessage", "Hello World!!");
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "home";
	}
	

}
