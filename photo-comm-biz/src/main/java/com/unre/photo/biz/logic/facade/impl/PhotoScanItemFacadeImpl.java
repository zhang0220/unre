package com.unre.photo.biz.logic.facade.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.unre.photo.biz.dto.PhotoScanItemDto;
import com.unre.photo.biz.logic.core.IPhotoScanItemBiz;
import com.unre.photo.biz.logic.facade.IPhotoScanItemFacade;
import com.unre.photo.biz.request.PhotoScanItemRequest;
import com.unre.photo.biz.response.PhotoScanItemResponse;

@Service("photoScanItemFacade")
public class PhotoScanItemFacadeImpl implements IPhotoScanItemFacade{

	private IPhotoScanItemBiz photoScanItemImpl;
	@Override
	public PhotoScanItemResponse queryPhotoScanItem(PhotoScanItemRequest request) throws Exception {
		List<PhotoScanItemDto> PhotoScanItemList = photoScanItemImpl.queryPhotoScanItem(request.getPhotoScanItemDto());
		PhotoScanItemResponse response = new PhotoScanItemResponse();
        response.setPhotoScanItemDtoList(PhotoScanItemList);;
		return response;
	}

	@Override
	public PhotoScanItemResponse findPhotoScanItemById(PhotoScanItemRequest request) throws Exception {
		PhotoScanItemResponse response = new PhotoScanItemResponse();
		PhotoScanItemDto photoScanItemParm = request.getPhotoScanItemDto();
		if (photoScanItemParm != null) {
			PhotoScanItemDto photoScanItemDto = photoScanItemImpl.findPhotoScanItemById(photoScanItemParm.getId());
			response.setPhotoScanItemDto(photoScanItemDto);
		}
		return response;
	}


	@Override
	public void deletePhotoScanItem(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
