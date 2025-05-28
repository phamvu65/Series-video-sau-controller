package com.laptrinhjavaweb.api;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.laptrinhjavaweb.bean.BuildingBean;

@Controller 
public class BuildingAPI {
	@RequestMapping(value = "/api/building", method = RequestMethod.GET)
	public @ResponseBody List<BuildingBean> getBuilding(@RequestParam(value = "name", required = false) String name ,
														@RequestParam(value = "numberOfBasement", required = false) Integer numberOfBasement ,
														//@RequestParam(value = "types", required = false) String[] types 
														@RequestParam(value = "types", required = false) List<String> types 													
			){
		System.out.println(name); 
		System.out.println(numberOfBasement);
		return null;
	}
	@RequestMapping(value = "/api/building/{buildingid}", method = RequestMethod.GET)
	public @ResponseBody BuildingBean getDetail(@PathVariable("buildingid") Long buildingId){
		System.out.println(buildingId);
		return null;
	}
	
	@RequestMapping(value = "/api/building", method = RequestMethod.POST)
	public @ResponseBody BuildingBean createBuilding(@RequestBody BuildingBean newBuilding){		
		return null;
	}
	
	@RequestMapping(value = "/api/building/", method = RequestMethod.PUT)
	public @ResponseBody BuildingBean updateBuilding(@RequestBody BuildingBean updateBuilding){
		System.out.println(updateBuilding);
		return null;
	}
	
	@RequestMapping(value = "/api/building", method = RequestMethod.DELETE)
//	public void deleteBuilding(@RequestBody Long[] ids ){
	public void deleteBuilding(@RequestBody BuildingBean deleteBuilding) {
		System.out.println("ok");
	}
}
