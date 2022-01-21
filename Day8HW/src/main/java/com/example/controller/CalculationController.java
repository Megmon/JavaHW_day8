package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calc")
public class CalculationController {

	//計算画面を表示
	@GetMapping("/calc")
	public String getCalc() {
		return "calc/calc";
	}
	
}
