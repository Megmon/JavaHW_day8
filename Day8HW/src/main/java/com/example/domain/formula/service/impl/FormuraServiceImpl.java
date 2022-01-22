package com.example.domain.formula.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.formula.model.MFormula;
import com.example.domain.formula.service.FormulaService;
import com.example.repository.FormulaMapper;

@Service
public class FormuraServiceImpl implements FormulaService {

	@Autowired
	private FormulaMapper mapper;
	
	//計算式登録
	@Override
	public void signupFormula(MFormula formula) {
		
		mapper.insertOne(formula);
	}
}
