package com.unre.photo.biz.logic.core.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unre.photo.biz.dto.PhotoMemberDto;
import com.unre.photo.biz.dto.PhotoScanDto;
import com.unre.photo.biz.exception.BusinessException;
import com.unre.photo.biz.logic.core.IPhotoScanBiz;
import com.unre.photo.comm.dal.dao.PhotoScanMapper;
import com.unre.photo.comm.dal.model.PhotoMember;
import com.unre.photo.comm.dal.model.PhotoScan;
import com.unre.photo.util.ModelUtil;

@Service
public class PhotoScanImpl implements IPhotoScanBiz {

	@Autowired
	private PhotoScanMapper photoScanMapper;

	private static final Log LOGGER = LogFactory.getLog(PhotoScanImpl.class);

	@Override
	public PhotoScanDto findPhotoScanById(Long photoScanId) throws BusinessException {
		PhotoScanDto photoScanDto = null;

		try {
			PhotoScan photoScan = photoScanMapper.selectByPrimaryKey(photoScanId);
			photoScanDto = ModelUtil.modelToDto(photoScan, PhotoScanDto.class);
		} catch (Exception e) {
			LOGGER.error("err", e);
			throw new BusinessException("err", "err");
		}
		return photoScanDto;
	}

	@Override
	public List<PhotoScanDto> queryPhotoScan(PhotoScanDto photoScanDto) throws BusinessException {
		List<PhotoScanDto> photoScanoList = new ArrayList<PhotoScanDto>();
		try {
			/*PhotoScan photoScan = ModelUtil.dtoToModel(photoScanDto,
					PhotoScan.class);
			List<PhotoScan> photoScanList = photoScanMapper.selectBySelective(photoScan);
			if (!CollectionUtils.isEmpty(photoScanList)) {
				for (PhotoScan p : photoScanList) {
					photoScanoList.add(ModelUtil.modelToDto(p,
							PhotoScanDto.class));
				}
			}*/
		} catch (Exception e) {
			e.printStackTrace();

			/*	 LOGGER.error(AppConstants.QUERY_FAIL_PLAN_ERROR_MESSAGE, e);
				 throw new
				 BusinessException(AppConstants.QUERY_FAIL_PLAN_ERROR_CODE,
				 AppConstants.QUERY_FAIL_PLAN_ERROR_MESSAGE);*/

		}
		return photoScanoList;
	}

	@Override
	public PhotoScanDto addPhotoScan(PhotoScanDto photoScanDto) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePhotoScan(PhotoScanDto photoScanDto) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePhotoScan(Long id) throws BusinessException {
		// TODO Auto-generated method stub

	}
}
