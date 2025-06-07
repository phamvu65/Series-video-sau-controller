package com.laptrinhjavaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.repository.RentAreaRepository;

@Repository
public class RentAreaImpl implements RentAreaRepository {


	private String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	private String USER = "root";
	private String PASS = "w@2915djkq#";
	
	@Override
	public List<RentAreaEntity> findById(BuildingEntity buildingEntity) {
		
		StringBuilder query = new StringBuilder("select * FROM rentarea where rentarea.buildingid =  "+ buildingEntity.getId());
		List<RentAreaEntity> result = new ArrayList<>() ;
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query.toString());) {
			while (rs.next()) {
				RentAreaEntity rentAreaEntity = new RentAreaEntity();
				rentAreaEntity.setValue(rs.getLong("value"));
				result.add(rentAreaEntity);
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
