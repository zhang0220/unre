package com.unre.photo.biz.logic.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unre.photo.biz.logic.facade.ILoginUserFacade;
import com.unre.photo.biz.request.LoginUserRequest;
import com.unre.photo.biz.response.Error;
import com.unre.photo.biz.response.LoginUserResponse;
import com.unre.photo.biz.exception.BusinessException;
import com.unre.photo.biz.logic.core.ILoginUserBiz;

/**
 * @author TDH
 *
 */
@Service("loginUserFacade")
public class LoginUserFacadeImpl implements ILoginUserFacade {

	@Autowired
	private ILoginUserBiz loginUserBiz;

	@Override
	public LoginUserResponse queryLoginUser(LoginUserRequest loginUserRequest) throws BusinessException {
		LoginUserResponse queryLoginUsers = loginUserBiz.queryLoginUsers(loginUserRequest.getLoginUserDto());
		boolean loginFlag = queryLoginUsers.isLoginFlag();
		LoginUserResponse response = new LoginUserResponse();
		response.setLoginFlag(loginFlag);
		if (!loginFlag) {
			Error error = new Error(loginUserRequest.getLoginUserDto().getSubjectId(), "用户未登录");
			response.setError(error);
		}
		return response;
	}
}
