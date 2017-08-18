package com.unre.photo.biz.logic.core.impl;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.unre.photo.biz.dto.LoginUserDto;
import com.unre.photo.biz.exception.BusinessException;
import com.unre.photo.biz.logic.core.ILoginUserBiz;
import com.unre.photo.biz.response.LoginUserResponse;

/**
 * @author TDH
 *
 */
@Service
public class LoginUserBizImpl implements ILoginUserBiz {

	private static final Log LOGGER = LogFactory.getLog(LoginUserBizImpl.class);

	@Value("${tms.url:}")
	private String tmsUrl;
	
	@Value("${tms.login.confirm:}")
	private String tmsLoginConfirm;

	@Override
	public LoginUserResponse queryLoginUsers(LoginUserDto loginUserDto)
			throws BusinessException {
		LOGGER.debug("------queryLoginUsers---------start");
		LoginUserResponse loginUserResponse = new LoginUserResponse();
		loginUserResponse.setLoginFlag(false);
		try {
			/*LoginConfirmMsg loginConfirmMsg = new LoginConfirmMsg();
			loginConfirmMsg.setAccountNo(loginUserDto.getCompanyNo());
			loginConfirmMsg.setSubjectId(loginUserDto.getSubjectId());
			
			WebApiRequest<LoginConfirmMsg> queryRequest = new WebApiRequest<LoginConfirmMsg>();
			queryRequest.setBody(loginConfirmMsg);
			Response tmsResponse = ClientBuilder.newClient().target(tmsUrl + tmsLoginConfirm).request()
					.post(Entity.json(queryRequest));
			if (tmsResponse.getStatus() == 200) {
				@SuppressWarnings("unchecked")
				WebApiResponse<String> waybillResponse = tmsResponse
						.readEntity(WebApiResponse.class);
				if (waybillResponse.getMeta() != null && waybillResponse.getMeta().getSucc() == 1) {
					loginUserResponse.setLoginFlag(true);
				}
			}*/
		}catch (Exception e) {
			/*Error error = new Error(AppConstants.QUERY_LOGIN_USER_ERROR_CODE, e.getMessage());
			loginUserResponse.setError(error);
			LOGGER.error(AppConstants.QUERY_LOGIN_USER_ERROR_CODE, e);*/
		}
		LOGGER.debug("------queryLoginUsers---------end:flag="+loginUserResponse.isLoginFlag());
		return loginUserResponse;
	}

}
