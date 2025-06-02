package com.laptrinhjavaweb.entity;

public class BuildingEntity {
	private Long id;
	private String name;
	private Integer floorArea;
	private Long[] buildingIds;
	private String street;
	private String ward;
	private Long districtId;
	private Integer numberOfBasement;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public Long getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getFloorArea() {
		return floorArea;
	}
	public void setFloorArea(Integer floorArea) {
		this.floorArea = floorArea;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long[] getBuildingIds() {
		return buildingIds;
	}
	public void setBuildingIds(Long[] buildingIds) {
		this.buildingIds = buildingIds;
	}
	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}
	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}
	

}
