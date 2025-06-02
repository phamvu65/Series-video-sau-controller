package com.laptrinhjavaweb.model.response;

public class BuildingSearchResponse {

	  private String name;
	    private Integer floorArea;
	    private String address;
	    private Long numberOfBasement;
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


		public Long getNumberOfBasement() {
			return numberOfBasement;
		}
		public void setNumberOfBasement(Long numberOfBasement) {
			this.numberOfBasement = numberOfBasement;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}

}
