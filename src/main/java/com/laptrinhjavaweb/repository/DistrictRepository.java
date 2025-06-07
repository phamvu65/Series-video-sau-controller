package com.laptrinhjavaweb.repository;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.DistrictEntity;


public interface DistrictRepository {
	DistrictEntity findById(BuildingEntity buildingEntity);
}
