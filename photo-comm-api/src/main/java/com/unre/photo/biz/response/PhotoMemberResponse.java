package com.unre.photo.biz.response;

import java.util.List;

import com.unre.photo.biz.dto.PhotoMemberDto;

@SuppressWarnings("serial")
public class PhotoMemberResponse extends BaseResponse {
	
    private PhotoMemberDto photoMemberDto;
	
	private List<PhotoMemberDto> photoMemberDtoList;

	public PhotoMemberDto getPhotoMemberDto() {
		return photoMemberDto;
	}

	public void setPhotoMemberDto(PhotoMemberDto photoMemberDto) {
		this.photoMemberDto = photoMemberDto;
	}

	public List<PhotoMemberDto> getPhotoMemberDtoList() {
		return photoMemberDtoList;
	}

	public void setPhotoMemberDtoList(List<PhotoMemberDto> photoMemberDtoList) {
		this.photoMemberDtoList = photoMemberDtoList;
	}

}
