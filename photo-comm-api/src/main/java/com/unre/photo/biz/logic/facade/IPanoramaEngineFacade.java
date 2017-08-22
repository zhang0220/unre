package com.unre.photo.biz.logic.facade;

import com.unre.photo.biz.request.PanoramaEngineRequest;
import com.unre.photo.biz.response.PanoramaEngineResponse;

public interface IPanoramaEngineFacade {

	/**
	 * 新增benaco scan
	 * 
	 * @param photoMemberDto 
	 *  
	 * @return PanoramaEngineResponse.scanId
	 * @throws Exception
	 */
	PanoramaEngineResponse generateScan(PanoramaEngineRequest request) throws Exception;

	/**
	 * 上传benaco scan
	 * 
	 * @param photoMemberDto 
	 *  
	 * @return PanoramaEngineResponse.scanId
	 * @throws Exception
	 */
	PanoramaEngineResponse queryScanStatus(PanoramaEngineRequest request) throws Exception;

}
