package com.example.domain.formula.service;

import java.util.List;

import com.example.domain.formula.model.MFormula;
import com.example.domain.formula.model.MNewFormula;

public interface FormulaService {

	//計算式登録
	public void signupFormula(MNewFormula formula);
	
	//計算式取得
	public List<MFormula> getFormula();
	
	//計算式取得（1件）
	public MFormula getFormulaOne(int formulaId);
	
	//計算式削除
	public void deleteFormulaOne(int formulaId);
}
