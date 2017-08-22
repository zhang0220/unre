package com.unre.photo.comm.dal.dao;

import com.unre.photo.comm.dal.model.PhotoScanItem;

public interface PhotoScanItemMapper {
	int deleteByPrimaryKey(Long id);

	int insert(PhotoScanItem record);

	int insertSelective(PhotoScanItem record);

	PhotoScanItem selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(PhotoScanItem record);

	int updateByPrimaryKey(PhotoScanItem record);
}