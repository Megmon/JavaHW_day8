package com.example.domain.calc.model;

import java.util.Date;

import lombok.Data;

@Data
public class MResult {
	
	private String formulaName;
	private int formulaYear;
	private int formulaMonth;
	private int formulaDay;
	private Date resultDate;
	
	//コンストラクタ（引数で受け取った値を初期値に設定）
	public MResult(String formulaName, int formulaYear, int formulaMonth,int formulaDay,Date resultDate) {
	
		this.formulaName = formulaName;
		this.formulaYear = formulaYear;
		this.formulaMonth = formulaMonth;
		this.formulaDay = formulaDay;
		this.resultDate = resultDate;
	
	}

}
