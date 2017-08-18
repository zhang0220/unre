package com.unre.photo.util;

import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.unre.photo.framework.servlet.ResettableStreamHttpServletRequest;

public class RequestUtil {

	private static final Log LOGGER = LogFactory.getLog(RequestUtil.class);

	public static String getRequestJsonDto(ResettableStreamHttpServletRequest request) {
		String strDto = null;
		try {
			InputStream iStream = request.getInputStream();
			strDto = JsonUtil.inputStreamToString(iStream);
			strDto.trim();
			request.resetInputStream();
		} catch (Exception e) {
			LOGGER.error("getRequestJsonDto error!", e);
		}

		strDto = strDto == null ? "{}" : strDto;
		return strDto;
	}
}
