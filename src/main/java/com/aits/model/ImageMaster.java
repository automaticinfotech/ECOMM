package com.aits.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Image_Master")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="imageMasterId",scope = ImageMaster.class)
public class ImageMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Image_Master_Id")
	private int imageMasterId;

	@Column(name = "Image_Master_Path", length = 100)
	private String imagePath;

	@Column(name = "Is_Active", length = 2)
	private String isActive;

	@JsonBackReference
	@ManyToOne(targetEntity = SubProductMaster.class, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH, CascadeType.REMOVE })
	@JoinColumn(name = "Fk_SubProductId")
	private SubProductMaster subProductMaster;

	@Transient
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
