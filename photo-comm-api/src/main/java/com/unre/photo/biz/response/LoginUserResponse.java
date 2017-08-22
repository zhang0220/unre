package com.unre.photo.biz.response;

import java.util.List;

import com.unre.photo.biz.dto.LoginUserDto;

/**
 * 调用TMS用户查询接口响应对象
 * @author TDH
 *
 */
@SuppressWarnings("serial")
public class LoginUserResponse extends BaseResponse {

	private LoginUserDto loginUserDto;

	private List<LoginUserDto> loginUserDtoList;

	private boolean loginFlag;

	public LoginUserDto getFirst() {
		if (null != loginUserDtoList && loginUserDtoList.size() > 0) {
			return loginUserDtoList.get(1);
		}
		return null;
	}

	public boolean isLoginFlag() {
		return loginFlag;
	}

	public void setLoginFlag(boolean loginFlag) {
		this.loginFlag = loginFlag;
	}

	public LoginUserDto getLoginUserDto() {
		return loginUserDto;
	}

	public void setLoginUserDto(LoginUserDto loginUserDto) {
		this.loginUserDto = loginUserDto;
	}

	public List<LoginUserDto> getLoginUserDtoList() {
		return loginUserDtoList;
	}

	public void setLoginUserDtoList(List<LoginUserDto> loginUserDtoList) {
		this.loginUserDtoList = loginUserDtoList;
	}

}
