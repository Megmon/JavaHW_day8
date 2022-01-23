package com.example.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SignupFormulaForm {
	
	@NotBlank
	private String newFormulaName;
	
	@NotNull
	private int newFormulaYear;
	
	@NotNull
	private int newFormulaMonth;
	
	@NotNull
	private int newFormulaDay;
	
}
