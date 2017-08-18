package com.unre.photo.biz.dto;

public class LoginUserDto extends BaseDto{
	
	private static final long serialVersionUID = 1L;
	
    /**
     * 当前分支
     */
    private String currentBranch;
    /**
     * 用户编号
     */
    private String subjectId;
    
	
	public String getCurrentBranch() {
		return currentBranch;
	}
	public void setCurrentBranch(String currentBranch) {
		this.currentBranch = currentBranch;
	}
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	
	public LoginUserDto(String currentBranch, String subjectId) {
		super();
		this.currentBranch = currentBranch;
		this.subjectId = subjectId;
	}
    
}