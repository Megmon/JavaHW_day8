package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController{
	
	//ログイン画面を表示
	@GetMapping("/login")
	public String getLogin() {
		return "login/login";
	}
	
	//計算画面にリダイレクト
	@PostMapping("/login")
	public String postLogin() {
		return "redirect:/calc/calc";
	}
}