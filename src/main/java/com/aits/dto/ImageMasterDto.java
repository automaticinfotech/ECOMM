package com.aits.dto;

import java.util.List;
import com.aits.model.ImageMaster;
import com.aits.model.SubProductMaster;

public class ImageMasterDto {
	private int imageMasterId;
	private String imagePath;
	private String isActive;
	private SubProductMaster subProductMaster;
	private List<ImageMaster> imageMasterList;
	public int getImageMasterId() {
		return imageMasterId;
	}
	public void setImageMasterId(int imageMasterId) {
		this.imageMasterId = imageMasterId;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public SubProductMaster getSubProductMaster() {
		return subProductMaster;
	}
	public void setSubProductMaster(SubProductMaster subProductMaster) {
		this.subProductMaster = subProductMaster;
	}
	public List<ImageMaster> getImageMasterList() {
		return imageMasterList;
	}
	public void setImageMasterList(List<ImageMaster> imageMasterList) {
		this.imageMasterList = imageMasterList;
	}
	
}
