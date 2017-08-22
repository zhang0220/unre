package com.unre.photo.biz.logic.facade;

import com.unre.photo.biz.request.PhotoMemberRequest;
import com.unre.photo.biz.response.PhotoMemberResponse;

public interface IPhotoMemberFacade {

	/**
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public PhotoMemberResponse queryPhotoMember(PhotoMemberRequest request) throws Exception;

	/**
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public PhotoMemberResponse findPhotoMemberById(PhotoMemberRequest request) throws Exception;

	/**
	 * @param id
	 * @throws Exception
	 */
	public void deletePhotoMember(Long id) throws Exception;

	/**
	 * 更新PhotoMember
	 * 
	 * @param request
	 * 
	 * @return void
	 * @throws BusinessException
	 */
	public void updatePhotoMember(PhotoMemberRequest request) throws Exception;

	/**
	 * 登录
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public PhotoMemberResponse login(PhotoMemberRequest request) throws Exception;

	/**
	 * 注册
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public PhotoMemberResponse register(PhotoMemberRequest request) throws Exception;

}
