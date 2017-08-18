package com.unre.photo.biz.logic.core.impl;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.unre.photo.biz.dto.PanoramaEngineDto;
import com.unre.photo.biz.logic.core.IPanoramaEngineBiz;
import com.unre.photo.comm.AppConstants;
import com.unre.photo.util.HttpClientResponse;
import com.unre.photo.util.HttpClientUtil;

@Service
public class PanoramaEngineImpl implements IPanoramaEngineBiz {

	@Override
	public PanoramaEngineDto createScan(PanoramaEngineDto panoramaEngineDto)
			throws Exception {
		
		String scanId;
		PanoramaEngineDto retPanEngineDto = new PanoramaEngineDto();
		retPanEngineDto.setFiles(panoramaEngineDto.getFiles());
		retPanEngineDto.setApiBaseUrl(panoramaEngineDto.getApiBaseUrl());
		retPanEngineDto.setApiKey(panoramaEngineDto.getApiKey());
		try{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("key", panoramaEngineDto.getApiKey());
			params.put("title", panoramaEngineDto.getTitle());
			JSONObject json =JSONObject.fromObject(params);
			String newScanUrl = panoramaEngineDto.getApiBaseUrl() + "new";
			//scanId = HttpClientUtil.doPost(newScanUrl, json);
			HttpClientResponse hcResponse = HttpClientUtil.doPost(newScanUrl, json);
			//TODO ""bf6e0901-21c4-4363-9429-de168e0d943a"" 返回对了一对括号
			scanId = hcResponse.getContext();
			if(scanId.startsWith("\"")) scanId = scanId.substring(1);
			if(scanId.endsWith("\"")) scanId = scanId.substring(0,scanId.length()-1);
			
			panoramaEngineDto.setScanId(scanId);
			retPanEngineDto.setScanId(scanId);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return retPanEngineDto;
	}

	@SuppressWarnings("unused")
	@Override
	public PanoramaEngineDto addPhotos(PanoramaEngineDto panoramaEngineDto)
			throws Exception {
		try{
			String addPhotosUrl = panoramaEngineDto.getApiBaseUrl() + "id/" + panoramaEngineDto.getScanId()+"/add-photos";
			HttpClientResponse hcResponse = HttpClientUtil.doPostMultipart(addPhotosUrl, panoramaEngineDto.getScanId(), panoramaEngineDto.getFiles());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return panoramaEngineDto;
	}

	@Override
	public boolean startProcessing(PanoramaEngineDto panoramaEngineDto)
			throws Exception {
		boolean retFlg = false;
		try{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("key", panoramaEngineDto.getApiKey());
			JSONObject json =JSONObject.fromObject(params);
			String addPhotosUrl = panoramaEngineDto.getApiBaseUrl() + "id/" + panoramaEngineDto.getScanId()+"/start-processing";
			HttpClientResponse hcResponse = HttpClientUtil.doPost(addPhotosUrl, json);
			String retCode = hcResponse.getCode();
			if(AppConstants.STATUS_SUCCESS.equals(retCode)){
				retFlg = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return retFlg;
	}

	@SuppressWarnings("unused")
	@Override
	public PanoramaEngineDto queryScanStatus(PanoramaEngineDto panoramaEngineDto)
			throws Exception {
		try{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("key", panoramaEngineDto.getApiKey());
			JSONObject json =JSONObject.fromObject(params);
			String addPhotosUrl = panoramaEngineDto.getApiBaseUrl() + "id/" + panoramaEngineDto.getScanId()+"/status";
			HttpClientResponse hcResponse = HttpClientUtil.doPost(addPhotosUrl, json);
			String retCode = hcResponse.getCode();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public PanoramaEngineDto previewScan(PanoramaEngineDto panoramaEngineDto)
			throws Exception {
		PanoramaEngineDto retPanEngineDto = new PanoramaEngineDto();
		try{
		    String previewUrl = "https://beta.benaco.com/view/" + panoramaEngineDto.getScanId();
		    retPanEngineDto.setPreviewUrl(previewUrl);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return retPanEngineDto;
	}

	

}
