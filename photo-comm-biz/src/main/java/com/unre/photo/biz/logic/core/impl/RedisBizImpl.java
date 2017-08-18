package com.unre.photo.biz.logic.core.impl;


public class RedisBizImpl extends ABaseRedis<String, Object> {

	@Override
	protected boolean add(String k, Object v) {
		return super.add(k, v);
	}

	@Override
	protected Object get(String k) {
		return super.get(k);
	}
     
	
}
