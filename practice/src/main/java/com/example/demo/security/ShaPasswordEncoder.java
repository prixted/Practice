package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class ShaPasswordEncoder /* implements PasswordEncoder */{

	/**
	 * String to sha256 비밀번호 등록 시 sha256 값으로 변환하여 저장한다
	 */
//	@Override
//	public String encode(CharSequence inputPassword) {
//		return Crypto.sha256(inputPassword.toString());
//	}

	/**
	 * check inputPassword and encodePassword
	 * 입력된 password 와 DB에 등록되어 있는 sha256 패스워드 값이 맞는지 비교 후 boolean 값으로 true, false 반환
	 */
//	@Override
//	public boolean matches(CharSequence inputPassword, String encodedPassword) {
//		return Crypto.sha256(inputPassword.toString()).equals(encodedPassword);
//	}
	
	
}
