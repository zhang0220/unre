package com.unre.photo.biz.dto;

import java.util.Date;

public class PhotoScanDto {

	private Long id;
	private Long member_id;
	private Long btch_no;
	private String title;
	private String desc;
	private String image_path;
	private String thumb_image_path;
	private String status;
	private Integer createBy;
	private Date createTime;
	private Integer updateBy;
	private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMember_id() {
		return member_id;
	}

	public void setMember_id(Long member_id) {
		this.member_id = member_id;
	}

	public Long getBtch_no() {
		return btch_no;
	}

	public void setBtch_no(Long btch_no) {
		this.btch_no = btch_no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public String getThumb_image_path() {
		return thumb_image_path;
	}

	public void setThumb_image_path(String thumb_image_path) {
		this.thumb_image_path = thumb_image_path;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
