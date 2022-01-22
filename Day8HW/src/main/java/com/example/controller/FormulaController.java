package com.example.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.SignupFormulaForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/formula")
@Slf4j
public class FormulaController {

//	@Autowired
//	private FormulaService formulaService;
	
//	@Autowired
//	private ModelMapper modelMapper;
	
	
	//計算式登録画面を表示
	@GetMapping("/formula")
	public String getFormula(Model model,Locale locale,@ModelAttribute SignupFormulaForm form) {
		
		//計算式登録画面へ遷移
		return "formula/formula";
	}
	
	//計算式登録処理
	@PostMapping("/formula")
	public String postFormula(Model model,Locale locale,@ModelAttribute @Validated SignupFormulaForm form,BindingResult bindingResult) {
		
		//入力チェック結果
		if(bindingResult.hasErrors()) {			
			log.info(bindingResult.toString());			
			//エラーがある場合は登録画面に戻る
			return getFormula(model,locale,form);
		}
		
		log.info(form.toString());
		
		//formをMFormulaクラスに変換
//		MFormula formula = modelMapper.map(form,MFormula.class);
		
		//計算式登録
//		formulaService.signupFormula(formula);
		
		//計算式画面にリダイレクト（画面更新）
		return "redirect:/formula/formula";
	}
}
