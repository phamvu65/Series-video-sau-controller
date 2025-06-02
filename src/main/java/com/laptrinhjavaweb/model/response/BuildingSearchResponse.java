package com.laptrinhjavaweb.model.response;

public class BuildingSearchResponse {

	  private String name;
	    private Integer floorArea;
	    private String address;
	    private Integer numberOfBasement;
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


		public Integer getNumberOfBasement() {
			return numberOfBasement;
		}
		public void setNumberOfBasement(Integer numberOfBasement) {
			this.numberOfBasement = numberOfBasement;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}

}
