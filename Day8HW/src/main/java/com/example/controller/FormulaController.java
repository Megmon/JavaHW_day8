package com.example.controller;

import java.util.List;
import java.util.Locale;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.formula.model.MFormula;
import com.example.domain.formula.model.MNewFormula;
import com.example.domain.formula.service.FormulaService;
import com.example.form.FormulaForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/formula")
@Slf4j
public class FormulaController {

	@Autowired
	private FormulaService formulaService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	//計算式登録画面を表示
	@GetMapping("/formula")
	public String getFormula(Model model,Locale locale,@ModelAttribute FormulaForm form) {
	
		//計算式一覧を取得
		List<MFormula> formulaList=formulaService.getFormula();
		log.info("計算式登録画面表示");
		
		//Modelに登録
		model.addAttribute("formulaList", formulaList);
		log.info(model.toString());
		
		//計算式登録画面へ遷移
		return "formula/formula";
	}
	
	//計算式登録処理
	@PostMapping(value="/formula",params="regist")
	public String postFormula(Model model,Locale locale,@ModelAttribute @Validated FormulaForm form,BindingResult bindingResult) {
		
		//入力チェック結果
		if(bindingResult.hasErrors()) {			
			log.info(bindingResult.toString());			
			//エラーがある場合は登録画面に戻る
			return getFormula(model,locale,form);
		}
		
		log.info(form.toString());
		
		//formをMFormulaクラスに変換
		MNewFormula formula = modelMapper.map(form,MNewFormula.class);
		
		//計算式登録
		formulaService.signupFormula(formula);
		
		//計算式画面にリダイレクト（画面更新）
		return "redirect:/formula/formula";
	}
	
	//計算式更新処理（フォームに値を渡すまで）
	@GetMapping("/formula/{formulaId}/update")
	public void updateFormula(Model model, FormulaForm form,@PathVariable("formulaId") int formulaId) {
	
		log.info("更新ボタン押した");
		//更新対象の計算式を1件取得
		MFormula formula = formulaService.getFormulaOne(formulaId);

		//フォームに値を渡す
		form =modelMapper.map(formula,FormulaForm.class);
	}
	
	//計算式削除処理
	@GetMapping("/formula/{formulaId}/delete")
	public String deleteFormula(@PathVariable("formulaId") int formulaId) {
		
		log.info("削除ボタン押した");
	
		//計算式を削除
		formulaService.deleteFormulaOne(formulaId);
		
		//計算式画面にリダイレクト（画面更新）
		return "redirect:/formula/formula";
	}
}
