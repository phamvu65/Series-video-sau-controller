package com.laptrinhjavaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.DistrictEntity;
import com.laptrinhjavaweb.repository.DistrictRepository;

@Repository
public class DistrictRepositoryImpl implements DistrictRepository {

	private String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	private String USER = "root";
	private String PASS = "w@2915djkq#";

	@Override
	public DistrictEntity findById(BuildingEntity buildingEntity) {
		StringBuilder query = new StringBuilder("SELECT district.name FROM building b inner join district on b.districtid = district.id ");
		query.append(" WHERE district.id = " + buildingEntity.getDistrictId());
		DistrictEntity districtEntity = new DistrictEntity();
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query.toString());) {
			while (rs.next()) {
				districtEntity.setName(rs.getString("district.name"));
			}
			return districtEntity;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
