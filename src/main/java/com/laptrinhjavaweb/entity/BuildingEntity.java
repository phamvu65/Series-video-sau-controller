package com.laptrinhjavaweb.entity;

public class BuildingEntity {
	private String name;
    private String managerName;
    private String managerPhoneNumber;
    private String ward;
    private String street;
    private Long numberOfBasement;
    private Long id;
    private String direction;
    private Long districtId;
    private String type;
    private Long floorArea;
    private Long rentprice;
    private Long brokeragefee;
    private String servicefee;
    private String note;
    private Long structure;
    private String motoFee;
    private String carFee;
    private String level;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public Long getNumberOfBasement() {
		return numberOfBasement;
	}
	public void setNumberOfBasement(Long numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getFloorArea() {
		return floorArea;
	}
	public void setFloorArea(Long floorArea) {
		this.floorArea = floorArea;
	}
	public Long getRentprice() {
		return rentprice;
	}
	public void setRentprice(Long rentprice) {
		this.rentprice = rentprice;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Long getStructure() {
		return structure;
	}
	public void setStructure(Long structure) {
		this.structure = structure;
	}
	public String getMotoFee() {
		return motoFee;
	}
	public void setMotoFee(String motoFee) {
		this.motoFee = motoFee;
	}
	public String getCarFee() {
		return carFee;
	}
	public void setCarFee(String carFee) {
		this.carFee = carFee;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerPhoneNumber() {
		return managerPhoneNumber;
	}
	public void setManagerPhoneNumber(String managerPhoneNumber) {
		this.managerPhoneNumber = managerPhoneNumber;
	}
	public Long getBrokeragefee() {
		return brokeragefee;
	}
	public void setBrokeragefee(Long brokeragefee) {
		this.brokeragefee = brokeragefee;
	}
	public String getServicefee() {
		return servicefee;
	}
	public void setServicefee(String servicefee) {
		this.servicefee = servicefee;
	}

}
