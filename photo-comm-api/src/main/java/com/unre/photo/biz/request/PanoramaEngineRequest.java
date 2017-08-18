package com.unre.photo.biz.request;

import com.unre.photo.biz.dto.PanoramaEngineDto;

@SuppressWarnings("serial")
public class PanoramaEngineRequest extends BaseRequest {
	
	private PanoramaEngineDto panoramaEngineDto;

	public PanoramaEngineDto getPanoramaEngineDto() {
		return panoramaEngineDto;
	}

	public void setPanoramaEngineDto(PanoramaEngineDto panoramaEngineDto) {
		this.panoramaEngineDto = panoramaEngineDto;
	}
	
	
}
