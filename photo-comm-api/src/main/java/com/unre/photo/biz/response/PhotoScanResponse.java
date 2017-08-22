package com.unre.photo.biz.response;

import java.util.List;

import com.unre.photo.biz.dto.PhotoScanDto;

@SuppressWarnings("serial")
public class PhotoScanResponse extends BaseResponse {

	private PhotoScanDto photoScanDto;

	private List<PhotoScanDto> photoScanDtoList;

	public PhotoScanDto getPhotoScanDto() {
		return photoScanDto;
	}

	public void setPhotoScanDto(PhotoScanDto photoScanDto) {
		this.photoScanDto = photoScanDto;
	}

	public List<PhotoScanDto> getPhotoScanDtoList() {
		return photoScanDtoList;
	}

	public void setPhotoScanDtoList(List<PhotoScanDto> photoScanDtoList) {
		this.photoScanDtoList = photoScanDtoList;
	}

}
