package com.unre.photo.biz.response;

import com.unre.photo.biz.dto.PanoramaEngineDto;

@SuppressWarnings("serial")
public class PanoramaEngineResponse extends BaseResponse {

	private PanoramaEngineDto panoramaEngineDto;

	public PanoramaEngineDto getPanoramaEngineDto() {
		return panoramaEngineDto;
	}

	public void setPanoramaEngineDto(PanoramaEngineDto panoramaEngineDto) {
		this.panoramaEngineDto = panoramaEngineDto;
	}

}
