package com.example.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SignupFormulaForm {
	
	@NotBlank
	private String formulaName;
	
	@NotNull
	private int formulaYear;
	
	@NotNull
	private int formulaMonth;
	
	@NotNull
	private int formulaDay;
	
}
