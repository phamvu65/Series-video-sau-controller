package com.laptrinhjavaweb.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.deser.BuilderBasedDeserializer;
import com.laptrinhjavaweb.bean.BuildingBean;

//@Controller
@RestController
public class BuildingAPI {

	@GetMapping("/api/building")
	public List<BuildingBean> getBuilding(@RequestParam(value = "name", required = false) String name ,
														@RequestParam(value = "street", required = false) String street ,
														@RequestParam(value = "numberOfBasement", required = false) Integer numberOfBasement ,
														//@RequestParam(value = "types", required = false) String[] types 
														@RequestParam(value = "types", required = false) List<String> types 													
			){
		List<BuildingBean> results = new ArrayList<>();
		return results;
	}

	@PostMapping("/api/building")
	public BuildingBean createBuilding(@RequestBody BuildingBean newBuilding){		
		return null;
	}
	
	@PutMapping("/api/building")
	public BuildingBean updateBuilding(@RequestBody BuildingBean updateBuilding){
		System.out.println(updateBuilding);
		return null;
	}
	
	@DeleteMapping("/api/building")
	public void deleteBuilding(@RequestBody Long[] ids ){
		System.out.println("ok");
	}
}
