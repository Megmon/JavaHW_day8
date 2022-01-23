package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.formula.model.MFormula;
import com.example.domain.formula.model.MNewFormula;

@Mapper
public interface FormulaMapper {

	//計算式登録
	public int insertOne(MNewFormula formula);
	
	//計算式取得
	public List<MFormula> findMany();
}
