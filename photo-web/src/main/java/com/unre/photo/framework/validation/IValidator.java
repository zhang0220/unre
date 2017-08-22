package com.unre.photo.framework.validation;

import com.unre.photo.biz.response.ValidationH5Response;
import com.unre.photo.framework.servlet.ResettableStreamHttpServletRequest;

public interface IValidator {

	public ValidationH5Response validate(ResettableStreamHttpServletRequest request, Object handler);

}
