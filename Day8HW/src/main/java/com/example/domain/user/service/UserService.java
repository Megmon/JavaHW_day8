package com.example.domain.user.service;

import com.example.domain.user.model.MUser;

public interface UserService {

	//ログインユーザー情報取得
	public MUser getLoginUser(String userId);
}
