package com.unre.photo.biz.request;

import com.unre.photo.biz.dto.PhotoMemberDto;


@SuppressWarnings("serial")
public class PhotoMemberRequest extends BaseRequest {

	private PhotoMemberDto photoMemberDto;

	public PhotoMemberDto getPhotoMemberDto() {
		return photoMemberDto;
	}

	public void setPhotoMemberDto(PhotoMemberDto photoMemberDto) {
		this.photoMemberDto = photoMemberDto;
	}

}
