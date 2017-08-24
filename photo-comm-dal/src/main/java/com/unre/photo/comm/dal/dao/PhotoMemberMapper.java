package com.unre.photo.comm.dal.dao;

import java.util.List;

import com.unre.photo.comm.dal.model.PhotoMember;

public interface PhotoMemberMapper {
	int deleteByPrimaryKey(Long id);

	int insert(PhotoMember record);

	int insertSelective(PhotoMember record);

	PhotoMember selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(PhotoMember record);

	int updateByPrimaryKey(PhotoMember record);

	// --------------------------------
	List<PhotoMember> selectBySelective(PhotoMember record);

	// 登录
	PhotoMember queryLoginUsers(PhotoMember photoMember);
	
	List<PhotoMember> selectByTelOrMail(PhotoMember record);


}