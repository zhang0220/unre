package com.unre.photo.biz.logic.core;

import java.util.List;

import com.unre.photo.biz.dto.PhotoMemberDto;
import com.unre.photo.biz.exception.BusinessException;

/**
 * 登录用户信息查询、校验
 * @author TDH
 */
public interface IPhotoMemberBiz {

	/**
	 * 通过ID查询photoMemberId
	 * 
	 * @param photoMemberId  --id
	 * @return PhotoMemberDto --Dto
	 * 
	 * @throws BusinessException
	 */
	public PhotoMemberDto findPhotoMemberById(Long photoMemberId) throws BusinessException;

	/**
	 * 查询满足条件的PhotoMember
	 * 
	 * @param photoMemberDto --Dto
	 * @return List
	 * 
	 * @throws BusinessException
	 */
	public List<PhotoMemberDto> queryPhotoMember(PhotoMemberDto photoMemberDto) throws BusinessException;

	/**
	 * 新增PhotoMember
	 * 
	 * @param photoMemberDto  
	 * @return PhotoMemberDto
	 * @throws BusinessException
	 */
	public PhotoMemberDto addPhotoMember(PhotoMemberDto photoMemberDto) throws BusinessException;

	/**
	 * 更新PhotoMember
	 * 
	 * @param photoMemberDto --要更新的photoMemberDto
	 * 
	 * @return boolean
	 * @throws BusinessException
	 */
	public void updatePhotoMember(PhotoMemberDto photoMemberDto) throws BusinessException;

	/**
	 * 删除PhotoMember
	 * 
	 * @param id --要删除的PhotoMember ID
	 * 
	 * @return boolean 
	 * @throws BusinessException
	 */
	public void deletePhotoMember(Long id) throws BusinessException;

	/**
	 * 通过member_name和password登录
	 * 
	 * @param member_name   --member_name
	 * @param password     --password
	 * @return photoMemberDto -Dto
	 * @throws BusinessException
	 */
	public PhotoMemberDto queryLoginUsers(PhotoMemberDto photoMemberDto) throws BusinessException;

}
