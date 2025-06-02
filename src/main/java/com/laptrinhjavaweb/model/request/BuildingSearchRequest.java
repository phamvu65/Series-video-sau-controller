package com.laptrinhjavaweb.model.request;

public class BuildingSearchRequest {

	 private String name;
	    private Long floorArea;
	    private String district;
	    private String ward;
	    private String street;
	    private Long numberOfBasement;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Long getFloorArea() {
			return floorArea;
		}
		public void setFloorArea(Long floorArea) {
			this.floorArea = floorArea;
		}
		public String getDistrict() {
			return district;
		}
		public void setDistrict(String district) {
			this.district = district;
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
		public Long getNumberOfBasement() {
			return numberOfBasement;
		}
		public void setNumberOfBasement(Long numberOfBasement) {
			this.numberOfBasement = numberOfBasement;
		}


}
