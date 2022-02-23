package com.example.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.user.model.MUser;

@Mapper
public interface UserMapper {

	//ログインユーザー取得
	public MUser findLoginUser(String userId);
	
	//ユーザー登録
	public int insertOneUser(MUser user);
}
