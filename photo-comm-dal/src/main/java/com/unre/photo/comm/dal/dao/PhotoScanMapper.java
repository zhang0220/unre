package com.unre.photo.comm.dal.dao;

import com.unre.photo.comm.dal.model.PhotoScan;

public interface PhotoScanMapper {
	int deleteByPrimaryKey(Long id);

	int insert(PhotoScan record);

	int insertSelective(PhotoScan record);

	PhotoScan selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(PhotoScan record);

	int updateByPrimaryKey(PhotoScan record);
}