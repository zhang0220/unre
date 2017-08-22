package com.unre.photo.biz.logic.core.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.unre.photo.biz.dto.PhotoMemberDto;
import com.unre.photo.biz.exception.BusinessException;
import com.unre.photo.biz.logic.core.IPhotoMemberBiz;
import com.unre.photo.comm.dal.model.PhotoMember;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.unre.photo.comm.AppConstants;
import com.unre.photo.comm.dal.dao.PhotoMemberMapper;
import com.unre.photo.util.ModelUtil;
import org.apache.commons.collections.CollectionUtils;

@Service
public class PhotoMemberImpl implements IPhotoMemberBiz {

	@Autowired
	private PhotoMemberMapper photoMemberMapper;

	private static final Log LOGGER = LogFactory.getLog(PhotoMemberImpl.class);

	@Override
	public PhotoMemberDto findPhotoMemberById(Long photoMemberId) throws BusinessException {
		PhotoMemberDto photoMemberDto = null;

		try {
			PhotoMember photoMember = photoMemberMapper.selectByPrimaryKey(photoMemberId);
			photoMemberDto = ModelUtil.modelToDto(photoMember, PhotoMemberDto.class);
		} catch (Exception e) {
			LOGGER.error("err", e);
			throw new BusinessException("err", "err");
		}
		return photoMemberDto;
	}

	@Override
	public List<PhotoMemberDto> queryPhotoMember(PhotoMemberDto photoMemberDto) throws BusinessException {
		List<PhotoMemberDto> photoMemberDtoList = new ArrayList<PhotoMemberDto>();
		try {
			PhotoMember photoMember = ModelUtil.dtoToModel(photoMemberDto, PhotoMember.class);
			List<PhotoMember> photoMemberList = photoMemberMapper.selectBySelective(photoMember);
			if (!CollectionUtils.isEmpty(photoMemberList)) {
				for (PhotoMember p : photoMemberList) {
					photoMemberDtoList.add(ModelUtil.modelToDto(p, PhotoMemberDto.class));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

			/*	 LOGGER.error(AppConstants.QUERY_FAIL_PLAN_ERROR_MESSAGE, e);
				 throw new
				 BusinessException(AppConstants.QUERY_FAIL_PLAN_ERROR_CODE,
				 AppConstants.QUERY_FAIL_PLAN_ERROR_MESSAGE);*/

		}
		return photoMemberDtoList;
	}

	// 注册
	@Override
	public PhotoMemberDto addPhotoMember(PhotoMemberDto photoMemberDto) throws BusinessException {
		PhotoMemberDto photoRes = null;
		try {
			PhotoMember photomember = ModelUtil.dtoToModel(photoMemberDto, PhotoMember.class);
			photoMemberMapper.insertSelective(photomember);
			Long id = photomember.getId();
			photoRes = findPhotoMemberById(id);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("err", e);
			throw new BusinessException("err", "err");
		}
		return photoRes;

	}

	// 登录
	@Override
	public PhotoMemberDto queryLoginUsers(PhotoMemberDto photoMemberDto) throws BusinessException {
		PhotoMember photomember;
		try {
			PhotoMember photoMembers = ModelUtil.dtoToModel(photoMemberDto, PhotoMember.class);
			photomember = photoMemberMapper.queryLoginUsers(photoMembers);
			photoMemberDto = ModelUtil.modelToDto(photomember, PhotoMemberDto.class);
		} catch (Exception e) {
			LOGGER.error("err", e);
			throw new BusinessException("err", "err");
		}

		return photoMemberDto;
	}

	@Override
	public void updatePhotoMember(PhotoMemberDto photoMemberDto) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePhotoMember(Long id) throws BusinessException {
		// TODO Auto-generated method stub

	}

}
