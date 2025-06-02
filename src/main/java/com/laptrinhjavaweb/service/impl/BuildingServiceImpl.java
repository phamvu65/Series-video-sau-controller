package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.model.response.BuildingSearchResponse;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.service.BuildingService;



@Service
public class BuildingServiceImpl implements BuildingService{
	
	@Autowired
	private BuildingRepository buildingRepository;

	@Override
	public List<BuildingSearchResponse> findAll() {
		List<BuildingSearchResponse> results = new ArrayList<>();
		List<BuildingEntity> buildingEntities = buildingRepository.findAll();
		for(BuildingEntity item : buildingEntities) {
			BuildingSearchResponse buildingSearchResponse = new BuildingSearchResponse();
			buildingSearchResponse.setName(item.getName());
			buildingSearchResponse.setAddress(item.getStreet()+"-"+item.getWard());
			buildingSearchResponse.setFloorArea(item.getFloorArea());
			buildingSearchResponse.setNumberOfBasement(item.getNumberOfBasement());
			results.add(buildingSearchResponse);
		}
		return results;
	}


}
