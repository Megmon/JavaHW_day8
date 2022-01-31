package com.example.domain.formula.service;

import java.util.List;

import com.example.domain.formula.model.MFormula;
import com.example.domain.formula.model.MNewFormula;
import com.example.domain.formula.model.MUpdateFormula;

public interface FormulaService {

	//計算式登録
	public void signupFormula(MNewFormula formula);
	
	//計算式取得
	public List<MFormula> getFormula();
	
	//計算式取得（1件）
	public MUpdateFormula getFormulaOne(int formulaId);
	
	//計算式更新（1件）
	public void updateFormulaOne(int formulaId,String forumulaName,int formulaYear,int formulaMonth,int formulaDay);
	
	//計算式削除
	public void deleteFormulaOne(int formulaId);
}
