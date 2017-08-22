package com.unre.photo.controller;

import org.junit.Assert;
import org.junit.Test;

import com.unre.photo.biz.response.BaseResponse;
import com.unre.photo.biz.response.PhotoMemberResponse;
import com.unre.photo.util.JsonUtil;

@SuppressWarnings("static-access")
public class PhotoMemberControllerTest extends BaseTest {

	//@Test
	public void testFindPhotoMemberById() throws Exception {
		String urlSuffix = "member/findPhotoMemberById.do";
		Long id = 1L;
		String json = "{\"photoMemberDto\": {\"id\": \"" + id + "\"}}";
		String result = this.postRequest(urlSuffix, json);
		Assert.assertNotNull(result);
		BaseResponse res = (BaseResponse) JsonUtil.toObject(result, PhotoMemberResponse.class);
		Assert.assertNull(res.getError());
	}

	@Test
	public void testQueryPhotoMember() throws Exception {
		String urlSuffix = "member/queryPhotoMember.do";
		String memberNo = "001";
		String json = "{\"photoMemberDto\": {\"memberNo\": \"" + memberNo + "\"}}";
		String result = this.postRequest(urlSuffix, json);
		Assert.assertNotNull(result);
		BaseResponse res = (BaseResponse) JsonUtil.toObject(result, PhotoMemberResponse.class);
		Assert.assertNull(res.getError());

	}

}
