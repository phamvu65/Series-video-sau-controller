package com.laptrinhjavaweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.bean.AssignmentBuildingBean;
import com.laptrinhjavaweb.bean.BuildingBean;
import com.laptrinhjavaweb.customexception.FieldRequiredException;
import com.laptrinhjavaweb.model.response.BuildingSearchResponse;
import com.laptrinhjavaweb.service.BuildingService;


//@Controller
@RestController
@RequestMapping("/api/building")
public class BuildingAPI {
	
	@Autowired
	private BuildingService buildingService;

	@GetMapping
	public List<BuildingSearchResponse> getBuilding(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "street", required = false) String street,
			@RequestParam(value = "numberOfBasement", required = false) Integer numberOfBasement,
			@RequestParam(value = "types", required = false) List<String> types) {
//		List<BuildingSearchResponse> results = new ArrayList<>();
//		List<BuildingFilter>  buildingFilters= buildingService.findAll();	
//		for(BuildingFilter item:buildingFilters) {
//			BuildingSearchResponse buildingSearchResponse = new BuildingSearchResponse();
//			buildingSearchResponse.setName(item.getName());
//			buildingSearchResponse.setAddress(item.getAddress());
//			results.add(buildingSearchResponse);
//		}
		List<BuildingSearchResponse> results= buildingService.findAll();	
		return results;
	}
	@PostMapping
	public BuildingBean createBuilding(@RequestBody BuildingBean newBuilding) {
		validateData(newBuilding);
		return newBuilding;
	}

	private void validateData(BuildingBean newBuilding) {
		if (newBuilding.getName() == null || newBuilding.getName().equals("")
				|| newBuilding.getNumberOfBasement() == null) {
			throw new FieldRequiredException("name or numberofbasement is required ");

		}
	}

	@PutMapping
	public BuildingBean updateBuilding(@RequestBody BuildingBean updateBuilding) {
		return updateBuilding;
	}

	@DeleteMapping
	public void deleteBuilding(@RequestBody Long[] ids) {
		System.out.println("ok");
	}

	@PostMapping("/assignment")
	public void assignmentBuilding(@RequestBody AssignmentBuildingBean assignmentBuildingBean) {
		System.out.println("ok");
	}

}
