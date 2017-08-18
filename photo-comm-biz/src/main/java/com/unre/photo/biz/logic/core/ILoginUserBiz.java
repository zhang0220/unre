package com.unre.photo.biz.logic.core;

import com.unre.photo.biz.dto.LoginUserDto;
import com.unre.photo.biz.response.LoginUserResponse;
import com.unre.photo.biz.exception.BusinessException;

/**
 * 登录用户信息查询、校验
 * @author TDH
 */
public interface ILoginUserBiz {

	LoginUserResponse queryLoginUsers(LoginUserDto loginUserDto) throws BusinessException;
}
