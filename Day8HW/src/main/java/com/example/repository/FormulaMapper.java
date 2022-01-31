package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.domain.formula.model.MFormula;
import com.example.domain.formula.model.MNewFormula;
import com.example.domain.formula.model.MUpdateFormula;

@Mapper
public interface FormulaMapper {

	//計算式登録
	public int insertOne(MNewFormula formula);
	
	//計算式取得（全件）
	public List<MFormula> findMany();
	
	//計算式取得（1件）
	public MUpdateFormula findOneFormula(int formulaId);
	
	//計算式更新（1件）
	public void updateOneFormula(@Param("formulaId") int formulaId,@Param("formulaName") String formulaName,@Param("formulaYear") int formulaYear,@Param("formulaMonth") int formulaMonth,@Param("formulaDay") int formulaDay);
	
	//計算式削除
	public int deleteOne(@Param("formulaId") int formulaId);
}
