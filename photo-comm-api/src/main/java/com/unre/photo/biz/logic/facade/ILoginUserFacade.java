package com.unre.photo.biz.logic.facade;

import com.unre.photo.biz.request.LoginUserRequest;
import com.unre.photo.biz.response.LoginUserResponse;

public interface ILoginUserFacade {

	/**
	 * 查询、校验登录用户信息
	 * @param loginUserRequest
	 * @return
	 */
	public LoginUserResponse queryLoginUser(LoginUserRequest loginUserRequest) throws Exception;

}
