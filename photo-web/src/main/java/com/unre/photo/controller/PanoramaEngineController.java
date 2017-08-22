package com.unre.photo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unre.photo.biz.logic.facade.IPanoramaEngineFacade;
import com.unre.photo.biz.request.PanoramaEngineRequest;
import com.unre.photo.biz.response.PanoramaEngineResponse;

@Controller
@RequestMapping("/engine")
public class PanoramaEngineController extends BaseController<PanoramaEngineController> {

	@Autowired
	private IPanoramaEngineFacade panoramaEngineFacade;

	@ResponseBody
	@RequestMapping(value = "/queryPhotoMember.do", method = RequestMethod.POST)
	public PanoramaEngineResponse createScan(@RequestBody PanoramaEngineRequest request,
			HttpServletRequest servletRequest) throws Exception {
		return panoramaEngineFacade.generateScan(request);
	}
}
