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
import com.example.domain.formula.model.MUpdateFormula;
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

		log.info("計算式登録画面表示");
		
		//計算式一覧を取得
		List<MFormula> formulaList=formulaService.getFormula();
		
		//Modelに登録
		model.addAttribute("formulaList", formulaList);
		log.info(model.toString());
		
		//計算式登録画面へ遷移
		return "formula/formula";
	}
	
	//計算式登録処理
	@PostMapping(value="/formula",params="regist")
	//@GetMapping("/formula/{formulaId}/regist")
	public String postFormula(Model model,Locale locale,@ModelAttribute @Validated FormulaForm form,BindingResult bindingResult) {

		log.info("登録ボタン押した");
		log.info(form.toString());
		//入力チェック結果
		if(bindingResult.hasErrors()) {			
			log.info(bindingResult.toString());			
			//エラーがある場合は登録画面に戻る
			return getFormula(model,locale,form);
		}
		
		//formをMFormulaクラスに変換
		MNewFormula formula = modelMapper.map(form,MNewFormula.class);
		
		//計算式登録
		formulaService.signupFormula(formula);
		
		//計算式画面にリダイレクト（画面更新）
		return "redirect:/formula/formula";
	}
	
	//計算式更新処理（フォームに値を渡すまで）
	@GetMapping("/formula/{formulaId}/update")
	public String updateFormula1(Model model, FormulaForm form,@PathVariable("formulaId") int formulaId) {
	
		log.info("修正ボタン押した");
		
		//更新対象の計算式を1件取得
		MUpdateFormula formula = formulaService.getFormulaOne(formulaId);

		//フォームに値を渡す
		form =modelMapper.map(formula,FormulaForm.class);
		log.info(form.toString());
		
		//Modelに登録
		model.addAttribute("formulaForm", form);
		
		//計算式一覧を取得
		List<MFormula> formulaList=formulaService.getFormula();
		
		//Modelに登録
		model.addAttribute("formulaList", formulaList);
		
		return "formula/formula";
	}

	//計算式更新処理（フォームの値を更新）
	@PostMapping(value="/formula",params="update")
	public String updateFormula2(Model model,Locale locale,@ModelAttribute @Validated FormulaForm form,BindingResult bindingResult) {

		log.info("更新ボタン押した");
		log.info(form.toString());
		//入力チェック結果
		if(bindingResult.hasErrors()) {			
			log.info(bindingResult.toString());			
			//エラーがある場合は登録画面に戻る
			return getFormula(model,locale,form);
		}
		
		//formをMFormulaクラスに変換
		MNewFormula formula = modelMapper.map(form,MNewFormula.class);
		
		//計算式更新
		formulaService.updateFormulaOne(form.getFormulaId(),form.getNewFormulaName(),form.getNewFormulaYear(),form.getNewFormulaMonth(),form.getNewFormulaDay());		
		
		//計算式画面にリダイレクト（画面更新）
		return "redirect:/formula/formula";
	}
	
	//フォームの値をクリア処理（画面更新することで初期化）
	@PostMapping(value="/formula",params="clear")
	public String clearFormula() {
		return "redirect:/formula/formula";
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
