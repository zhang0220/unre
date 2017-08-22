package com.unre.photo.biz.logic.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unre.photo.biz.dto.PhotoScanDto;
import com.unre.photo.biz.logic.core.IPhotoScanBiz;
import com.unre.photo.biz.logic.facade.IPhotoScanFacade;
import com.unre.photo.biz.request.PhotoScanRequest;
import com.unre.photo.biz.response.PhotoScanResponse;

/**
 * @author TDH
 *
 */
@Service
public class PhotoScanFacadeImpl implements IPhotoScanFacade {

	@Autowired
	private IPhotoScanBiz photoScanBiz;

	@Override
	public PhotoScanResponse queryPhotoScan(PhotoScanRequest request) throws Exception {
		List<PhotoScanDto> photoScanDtoList = photoScanBiz.queryPhotoScan(request.getPhotoScanDto());
		PhotoScanResponse response = new PhotoScanResponse();
		response.setPhotoScanDtoList(photoScanDtoList);
		return response;
	}

	@Override
	public PhotoScanResponse findPhotoScanById(PhotoScanRequest request) throws Exception {
		PhotoScanResponse response = new PhotoScanResponse();
		PhotoScanDto photoScanParm = request.getPhotoScanDto();
		if (photoScanParm != null) {
			PhotoScanDto photoScanDto = photoScanBiz.findPhotoScanById(photoScanParm.getId());
			response.setPhotoScanDto(photoScanDto);
		}
		return response;
	}

	@Override
	public void deletePhotoScan(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePhotoScan(PhotoScanRequest request) throws Exception {
		PhotoScanDto photoScanDto = request.getPhotoScanDto();
		photoScanBiz.updatePhotoScan(photoScanDto);
	}

}
