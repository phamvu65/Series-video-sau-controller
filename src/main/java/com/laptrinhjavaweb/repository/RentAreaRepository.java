package com.laptrinhjavaweb.repository;

import java.util.List;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentAreaEntity;

public interface RentAreaRepository {
	List<RentAreaEntity>  findById(BuildingEntity buildingEntity);
}
