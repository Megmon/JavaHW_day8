package com.example.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.formula.model.MFormula;

@Mapper
public interface FormulaMapper {

	//計算式登録
	public int insertOne(MFormula formula);
}
