package com.example.domain.formula.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.formula.model.MFormula;
import com.example.domain.formula.model.MNewFormula;
import com.example.domain.formula.model.MUpdateFormula;
import com.example.domain.formula.service.FormulaService;
import com.example.repository.FormulaMapper;

@Service
public class FormuraServiceImpl implements FormulaService {

	@Autowired
	private FormulaMapper mapper;
	
	//計算式登録
	@Override
	public void signupFormula(MNewFormula formula) {
		
		mapper.insertOne(formula);
	}
	
	//計算式取得
	@Override
	public List<MFormula> getFormula(){
		
		return mapper.findMany();
	}
	
	//計算式取得（1件）
	@Override
	public MUpdateFormula getFormulaOne(int formulaId){
		return mapper.findOneFormula(formulaId);
	}
	
	//計算式削除
	@Override
	public void deleteFormulaOne(int formulaId) {
		
		int count = mapper.deleteOne(formulaId);
	}
}
