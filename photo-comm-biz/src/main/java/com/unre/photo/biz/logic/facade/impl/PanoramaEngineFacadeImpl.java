package com.unre.photo.biz.logic.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unre.photo.biz.dto.PanoramaEngineDto;
import com.unre.photo.biz.logic.core.IPanoramaEngineBiz;
import com.unre.photo.biz.logic.facade.IPanoramaEngineFacade;
import com.unre.photo.biz.request.PanoramaEngineRequest;
import com.unre.photo.biz.response.Error;
import com.unre.photo.biz.response.PanoramaEngineResponse;
import com.unre.photo.comm.AppConstants;

@Service
public class PanoramaEngineFacadeImpl implements IPanoramaEngineFacade {

	@Autowired
	private IPanoramaEngineBiz panoramaEngineBiz;

	@SuppressWarnings("unused")
	@Override
	public PanoramaEngineResponse generateScan(PanoramaEngineRequest request)
			throws Exception {
		PanoramaEngineResponse response = new PanoramaEngineResponse();
		try {
			// 1.创建scan id
			PanoramaEngineDto panoramaEngineDto = panoramaEngineBiz.createScan(request.getPanoramaEngineDto());
			String scanId = panoramaEngineDto.getScanId();
			// 2.上传照片
			panoramaEngineBiz.addPhotos(panoramaEngineDto);
			// 3.开始处理
			boolean retFlg = panoramaEngineBiz.startProcessing(panoramaEngineDto);
			if(retFlg){
				response.setCode(AppConstants.STATUS_SUCCESS);
			} else {
				response.setCode(AppConstants.STATUS_FAIL);
			}
		} catch (Exception e) {
			response.setCode(AppConstants.STATUS_FAIL);
			Error error = new Error();
			error.setCode("001");
			error.setMessage("系统异常");
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public PanoramaEngineResponse queryScanStatus(PanoramaEngineRequest request)
			throws Exception {
		PanoramaEngineResponse retResponse = new PanoramaEngineResponse();
		PanoramaEngineDto panoramaEngineDto = panoramaEngineBiz.queryScanStatus(request.getPanoramaEngineDto());
		retResponse.setPanoramaEngineDto(panoramaEngineDto);
		return retResponse;
	}

}
