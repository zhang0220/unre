package com.unre.photo.biz.request;

import com.unre.photo.biz.dto.PhotoScanDto;

@SuppressWarnings("serial")
public class PhotoScanRequest extends BaseRequest {

	private PhotoScanDto photoScanDto;

	public PhotoScanDto getPhotoScanDto() {
		return photoScanDto;
	}

	public void setPhotoScanDto(PhotoScanDto photoScanDto) {
		this.photoScanDto = photoScanDto;
	}

}
