package com.example.domain.formula.model;

import lombok.Data;

@Data
public class MUpdateFormula {

	private int formulaId;
	private String newFormulaName;
	private int newFormulaYear;
	private int newFormulaMonth;
	private int newFormulaDay;
}
