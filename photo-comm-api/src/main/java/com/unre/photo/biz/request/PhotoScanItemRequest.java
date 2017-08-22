package com.unre.photo.biz.request;

import com.unre.photo.biz.dto.PhotoScanItemDto;

@SuppressWarnings("serial")
public class PhotoScanItemRequest extends BaseRequest{
	private PhotoScanItemDto photoScanItemDto;

	public PhotoScanItemDto getPhotoScanItemDto() {
		return photoScanItemDto;
	}

	public void setPhotoScanItemDto(PhotoScanItemDto photoScanItemDto) {
		this.photoScanItemDto = photoScanItemDto;
	}


	
	
	

}
