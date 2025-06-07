package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.DistrictEntity;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.model.response.BuildingSearchResponse;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.DistrictRepository;
import com.laptrinhjavaweb.repository.RentAreaRepository;
import com.laptrinhjavaweb.service.BuildingService;



@Service
public class BuildingServiceImpl implements BuildingService{
	
	@Autowired
	private BuildingRepository buildingRepository;

	@Autowired
	private DistrictRepository districtRepository;
	
	@Autowired
	private RentAreaRepository rentAreaRepository;
	@Override
	public List<BuildingSearchResponse> findAll(Map<String, Object>  params , List<String> typeBuilding) {
		List<BuildingSearchResponse> results = new ArrayList<>();
		DistrictEntity districtEntity = new DistrictEntity();
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(params,typeBuilding);
		for(BuildingEntity item : buildingEntities) {
			BuildingSearchResponse buildingSearchResponse = new BuildingSearchResponse();
			buildingSearchResponse.setName(item.getName());
			districtEntity = districtRepository.findById(item);
			buildingSearchResponse.setAddress(item.getStreet()+"-"+item.getWard()+"-"+districtEntity.getName());
			buildingSearchResponse.setFloorArea(item.getFloorArea());
			buildingSearchResponse.setRentPrice(item.getRentprice());
			buildingSearchResponse.setServiceFee(item.getServicefee());
			buildingSearchResponse.setBrokerageFee(item.getBrokeragefee());
			buildingSearchResponse.setNumberOfBasement(item.getNumberOfBasement());
			List<RentAreaEntity> rentAreaEntities= rentAreaRepository.findById(item);
			String resultArea = rentAreaEntities.stream().map(it -> it.getValue().toString()).collect(Collectors.joining(","));
			buildingSearchResponse.setRentArea(resultArea);
			buildingSearchResponse.setManagerName(item.getManagerName());
			buildingSearchResponse.setManagerPhone(item.getManagerPhoneNumber());
			results.add(buildingSearchResponse);
		}
		return results;
	}


}
