package com.example.domain.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.domain.user.model.MUser;
import com.example.domain.user.service.UserService;
import com.example.repository.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper mapper;
	
	@Autowired
	private PasswordEncoder encoder;
	
	//ログインユーザー情報取得
	@Override
	public MUser getLoginUser(String userId) {
		
		return mapper.findLoginUser(userId); 
	}
	
	//ユーザー登録処理
	@Override
	public void signup(MUser user) {

		user.setRole("ROLE_GENERAL");
		
		//パスワード暗号化
		String rawPassword = user.getPassword();
		user.setPassword(encoder.encode(rawPassword));

		mapper.insertOneUser(user);

	}

}
