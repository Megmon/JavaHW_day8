package com.example.rest;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.user.model.MUser;
import com.example.domain.user.service.UserService;
import com.example.form.SignupForm;

@RestController
@RequestMapping("/user")
public class RestSignupController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private MessageSource messageSource;
	
	//ユーザーを登録
	@PostMapping("/signup/rest")
	public RestResult postSignup(@Validated SignupForm form,BindingResult bindingResult,Locale locale) {
		
		//入力チェック結果
		if(bindingResult.hasErrors()) {
			//エラーありの場合、エラーメッセージを取得して結果を返却
			Map<String,String> errors = new HashMap<>();
			for(FieldError error:bindingResult.getFieldErrors()) {
				String message=messageSource.getMessage(error,locale);
				errors.put(error.getField(), message);
			}
			return new RestResult(90,errors);
		}
		
		//formをMUserクラスに変換
		MUser user =modelMapper.map(form, MUser.class);
		
		//ユーザー登録
		userService.signup(user);
		
		//結果の返却
		return new RestResult(0,null);
	}
}
