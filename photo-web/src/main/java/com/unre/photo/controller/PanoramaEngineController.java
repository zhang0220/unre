package com.unre.photo.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import com.unre.photo.biz.response.PhotoMemberResponse;
import com.unre.photo.biz.response.PhotoScanItemResponse;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("/engine")
public class PanoramaEngineController extends BaseController<PanoramaEngineController> {

	@Autowired
	private IPanoramaEngineFacade panoramaEngineFacade;

	@ApiOperation(value = "创建scanID", httpMethod = "POST", response = PhotoScanItemResponse.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "panoramaEngineDto.title", value = "scan名称", required = false, dataType = "string"), })
	@RequestMapping(value = "/createScan.do", method = RequestMethod.POST)
	public @ResponseBody PanoramaEngineResponse createScan(@RequestBody PanoramaEngineRequest request,
			HttpServletRequest servletRequest) throws Exception {
		request.getPanoramaEngineDto().setApiKey("3c7c6941-2204-4ee7-a4b5-0981e0e6e09c");
		request.getPanoramaEngineDto().setApiBaseUrl("https://beta.benaco.com/api/beta/scans/");
		return panoramaEngineFacade.createScan(request);
	}

	@ApiImplicitParams({
	    @ApiImplicitParam(name = "panoramaEngineDto.apiBaseUrl", value = "apiBaseUrl", required = true, dataType = "string"),
		@ApiImplicitParam(name = "panoramaEngineDto.apiKey", value = "apikey", required = true, dataType = "string"),
		@ApiImplicitParam(name = "panoramaEngineDto.benacoScanId", value = "scanid名称", required = true, dataType = "string"), 
		@ApiImplicitParam(name = "panoramaEngineDto.files", value = "files", required = true, dataType = "List<File>"),})
	@RequestMapping(value = "/addPhotos.do", method = RequestMethod.POST)
	public @ResponseBody PanoramaEngineResponse addPhotos(@RequestBody PanoramaEngineRequest request,
			HttpServletRequest servletRequest) throws Exception {
		request.getPanoramaEngineDto().setApiKey("3c7c6941-2204-4ee7-a4b5-0981e0e6e09c");
		request.getPanoramaEngineDto().setApiBaseUrl("https://beta.benaco.com/api/beta/scans/");
		List<File> files = request.getPanoramaEngineDto().getFiles();//
		
		
		/*MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) servletRequest;
		Map<String, List<MultipartFile>> map = multiRequest.getMultiFileMap();
		List<File> listFile = new ArrayList<File>();
		// 这个map获取的就是所有的file对象集合，通过循环可以获取到所有的file
		map.forEach((ent, ent2) -> {
			System.out.println(ent);
			ent2.forEach((ent3) -> {
				System.out.println(ent3.getName());
				File saveFile = new File(ent3.getOriginalFilename());
				try {
					ent3.transferTo(saveFile);
					listFile.add(saveFile);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		});*/
		request.getPanoramaEngineDto().setFiles(files);
		return panoramaEngineFacade.addPhotos(request);
	}

	@ResponseBody
	@RequestMapping(value = "/startProcessing.do", method = RequestMethod.POST)
	public PanoramaEngineResponse startProcessing(@RequestBody PanoramaEngineRequest request,
			HttpServletRequest servletRequest) throws Exception {
		return panoramaEngineFacade.startProcessing(request);
	}
	
	@ResponseBody
	@RequestMapping(value = "/queryScanStatus.do", method = RequestMethod.POST)
	public PanoramaEngineResponse queryScanStatus(@RequestBody PanoramaEngineRequest request,
			HttpServletRequest servletRequest) throws Exception {
		return panoramaEngineFacade.queryScanStatus(request);
	}
}
