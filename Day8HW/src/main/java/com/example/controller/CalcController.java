package com.example.controller;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.calc.model.MResult;
import com.example.domain.calc.service.CalcService;
import com.example.domain.formula.model.MFormula;
import com.example.domain.formula.service.FormulaService;
import com.example.form.CalcForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/calc")
@Slf4j
public class CalcController {

	@Autowired
	private FormulaService formulaService;
	
	@Autowired
	private CalcService calcService;
	
	//計算画面を表示
	@GetMapping("/calc")
	public String getCalc(Model model,Locale locale,@ModelAttribute CalcForm form) {
		return "calc/calc";
	}
	
	//計算処理
	@PostMapping("/calc")
	public String postCalc(Model model,Locale locale,@ModelAttribute @Validated CalcForm form,BindingResult bindingResult) {

		//入力チェック結果
		if(bindingResult.hasErrors()) {
			log.info(bindingResult.toString());
			//エラーがある場合は計算画面に戻る
			return getCalc(model,locale,form);
		}
		
		//formのCalcDateを代入
		Date baseDate = form.getCalcDate();
		
		//計算式一覧を取得
		List<MFormula> formulaList=formulaService.getFormula();
		
		//計算結果一覧を取得
		List<MResult> resultList=calcService.getResult(baseDate,formulaList);
		
		//計算結果一覧をModelに登録
		model.addAttribute("resultList", resultList);
		
		return "/calc/calc";
	}
}
