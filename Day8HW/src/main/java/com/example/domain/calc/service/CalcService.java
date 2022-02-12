package com.example.domain.calc.service;

import java.util.Date;
import java.util.List;

import com.example.domain.calc.model.MResult;
import com.example.domain.formula.model.MFormula;

public interface CalcService {

	//計算式取得
	public List<MResult> getResult(Date baseDate,List<MFormula> formulaList);	
}
