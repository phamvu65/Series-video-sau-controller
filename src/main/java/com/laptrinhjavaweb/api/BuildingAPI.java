package com.laptrinhjavaweb.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.customexception.FieldRequiredException;
import com.laptrinhjavaweb.model.BuildingDTO;
import com.laptrinhjavaweb.model.response.BuildingSearchResponse;
import com.laptrinhjavaweb.service.BuildingService;


//@Controller
@RestController
@RequestMapping("/api/building")
public class BuildingAPI {
	
	@Autowired
	private BuildingService buildingService;

	@GetMapping
	public List<BuildingSearchResponse> getBuilding(@RequestParam Map<String, Object> params,
			@RequestParam(value = "typeBuilding", required = false) List<String> typeBuilding) {
		List<BuildingSearchResponse> results= buildingService.findAll(params,typeBuilding);	
		return results;
	}
	@PostMapping
	public BuildingDTO createBuilding(@RequestBody BuildingDTO newBuilding) {
		validateData(newBuilding);
		return newBuilding;
	}

	private void validateData(BuildingDTO newBuilding) {
		if (newBuilding.getName() == null || newBuilding.getName().equals("")
				|| newBuilding.getNumberOfBasement() == null) {
			throw new FieldRequiredException("name or numberofbasement is required ");

		}
	}

	@PutMapping
	public BuildingDTO updateBuilding(@RequestBody BuildingDTO updateBuilding) {
		return updateBuilding;
	}

	@DeleteMapping
	public void deleteBuilding(@RequestBody Long[] ids) {
		System.out.println("ok");
	}


}
