package com.example.form;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class SignupForm {

	@NotBlank
	private String userId;
	@NotBlank
	private String userName;
	@NotBlank
	private String password;
}
