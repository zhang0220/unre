package com.unre.photo.biz.request;

import com.unre.photo.biz.dto.LoginUserDto;

/**
 * 调用TMS用户查询接口对象
 * @author TDH
 *
 */
@SuppressWarnings("serial")
public class LoginUserRequest extends BaseRequest {

	private LoginUserDto loginUserDto;

	public LoginUserDto getLoginUserDto() {
		return loginUserDto;
	}

	public void setLoginUserDto(LoginUserDto loginUserDto) {
		this.loginUserDto = loginUserDto;
	}

}
