package com.example.domain.calc.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.domain.calc.model.MResult;
import com.example.domain.calc.service.CalcService;
import com.example.domain.formula.model.MFormula;

@Service
public class CalcServiceImpl implements CalcService{
	
	//計算処理
	@Override	
	public List<MResult> getResult(Date baseDate,List<MFormula> formulaList){
		
		//計算結果格納用のresults作成
		List<Date> results= new ArrayList<Date>();
		
		//resultsに計算結果格納
		for (int i=0; i<formulaList.size();i++) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(baseDate);
			calendar.add(Calendar.YEAR, formulaList.get(i).getFormulaYear());
			calendar.add(Calendar.MONTH, formulaList.get(i).getFormulaMonth());
			calendar.add(Calendar.DAY_OF_MONTH, formulaList.get(i).getFormulaDay());
			Date resultDate = calendar.getTime();
			results.add(i, resultDate);
		}

		//formulaListとresultsを合わせたresultList作成
		List<MResult> resultList= new ArrayList<MResult>();
		for (int i=0; i<formulaList.size();i++) {
			//MResultに引数を渡しインスタンス化（引数はコンストラクタで初期値に設定）し、resultListに追加する
			resultList.add(new MResult(formulaList.get(i).getFormulaName(),formulaList.get(i).getFormulaYear(), formulaList.get(i).getFormulaMonth(), formulaList.get(i).getFormulaDay(), results.get(i)));	
		}
		
		return resultList;
	};		
}
