package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.domain.formula.model.MFormula;
import com.example.domain.formula.model.MNewFormula;

@Mapper
public interface FormulaMapper {

	//計算式登録
	public int insertOne(MNewFormula formula);
	
	//計算式取得（全件）
	public List<MFormula> findMany();
	
	//計算式取得（1件）
	public MFormula findOneFormula(int formulaId);
	
	//計算式削除
	public int deleteOne(@Param("formulaId") int formulaId);
}
