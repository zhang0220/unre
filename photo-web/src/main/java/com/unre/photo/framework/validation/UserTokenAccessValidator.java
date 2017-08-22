package com.unre.photo.framework.validation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.unre.photo.biz.logic.facade.IPhotoMemberFacade;
import com.unre.photo.biz.response.ValidationH5Response;
import com.unre.photo.framework.servlet.ResettableStreamHttpServletRequest;

public class UserTokenAccessValidator implements IValidator {

	@SuppressWarnings("unused")
	private static final Log LOGGER = LogFactory.getLog(UserTokenAccessValidator.class);

	@Autowired
	private IPhotoMemberFacade photoMemberFacade;

	@Override
	public ValidationH5Response validate(ResettableStreamHttpServletRequest request, Object handler) {
		ValidationH5Response vH5Response = new ValidationH5Response();
		//TODO 
		return vH5Response;
	}

	public IPhotoMemberFacade getPhotoMemberFacade() {
		return photoMemberFacade;
	}

	public void setPhotoMemberFacade(IPhotoMemberFacade photoMemberFacade) {
		this.photoMemberFacade = photoMemberFacade;
	}

}
