package com.laptrinhjavaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.BuildingRepository;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {

	private String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	private String USER = "root";
	private String PASS = "w@2915djkq#";

	public static void joinTable(Map<String, Object> params, List<String> typeBuilding, StringBuilder query) {
		String staffId = (String) params.get("staffId");
//		if (staffId != null && !staffId.equals("")) {
//			query.append(" INNER JOIN assignmentbuilding ON assignmentbuilding.buildingid = b.id ");
//			query.append(" INNER JOIN user ON assignmentbuilding.staffid = user.id ");
//		}

		query.append(" INNER JOIN assignmentbuilding ON assignmentbuilding.buildingid = b.id ");
		query.append(" INNER JOIN user ON assignmentbuilding.staffid = user.id ");

		String rentAreaTo = (String) params.get("areaTo");
		String rentAreaFrom = (String) params.get("areaFrom");
		if (rentAreaTo != null && !rentAreaTo.equals("") || rentAreaFrom != null && !rentAreaFrom.equals("")) {
			query.append(" INNER JOIN rentarea ON rentarea.buildingid = b.id ");
		}
		if (typeBuilding != null && typeBuilding.size() != 0) {
			query.append(" INNER JOIN buildingrenttype ON buildingrenttype.buildingid = b.id ");
			query.append(" INNER JOIN renttype ON buildingrenttype.renttypeid = renttype.id ");
		}
	}

	public static boolean checkNumber(String value) {
		try {
			Long num = Long.parseLong(value);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public static void handleQuery(Map<String, Object> params, List<String> typeBuilding, StringBuilder where) {
		String staffId = (String) params.get("staffId");
		String managerName = (String) params.get("managerName");
		String managerPhoneNumber = (String) params.get("managerPhoneNumber");
		String rentAreaTo = (String) params.get("areaTo");
		String rentAreaFrom = (String) params.get("areaFrom");
		String rentPriceTo = (String) params.get("rentPriceTo");
		String rentPriceFrom = (String) params.get("rentPriceFrom");
		if (managerName != null && !managerName.equals("")) {
			where.append(" AND user.fullname like '%" + managerName + "%' ");
		}
		if (managerPhoneNumber != null && !managerPhoneNumber.equals("")) {
			where.append(" AND user.phone like '%" + managerPhoneNumber + "%' ");
		}
		if (staffId != null && !staffId.equals("")) {
			where.append(" AND assignmentbuilding.staffid = " + staffId);
		}
		if (staffId != null && !staffId.equals("")) {
			where.append(" AND assignmentbuilding.staffid = " + staffId);
		}

		if (rentAreaTo != null && !rentAreaTo.equals("") || rentAreaFrom != null && !rentAreaFrom.equals("")) {
			if (rentAreaTo != null && !rentAreaTo.equals("")) {
				where.append(" AND rentarea.value <= " + rentAreaTo);
			}
			if (rentAreaFrom != null && !rentAreaFrom.equals("")) {
				where.append(" AND rentarea.value >= " + rentAreaFrom);
			}
		}
		if (rentPriceTo != null && !rentPriceTo.equals("") || rentPriceFrom != null && !rentPriceFrom.equals("")) {
			if (rentPriceTo != null && !rentPriceTo.equals("")) {
				where.append(" AND b.rentprice >= " + rentPriceFrom);
			}
			if (rentPriceFrom != null && !rentPriceFrom.equals("")) {
				where.append(" AND b.rentprice <= " + rentPriceTo);
			}
		}
		if (typeBuilding != null && typeBuilding.size() != 0) {
			List<String> code = new ArrayList<>();
			for (String item : typeBuilding) {
				code.add("'" + item + "'");
			}
			where.append(" AND renttype.code IN (" + String.join(",", code) + ") ");
		}
		for (Map.Entry<String, Object> item : params.entrySet()) {
			if (!item.getKey().equals("staffId") && !item.getKey().equals("typeBuilding")
					&& !item.getKey().equals("managerName") && !item.getKey().equals("managerPhoneNumber")
					&& !item.getKey().startsWith("area") && !item.getKey().startsWith("rentPrice")) {
				String value = item.getValue().toString();
				if (checkNumber(value) == true) {
					where.append(" AND b." + item.getKey() + " = " + value);
				} else {
					where.append(" AND b." + item.getKey() + " like '%" + value + "%' ");
				}
			}
		}
	}

	@Override
	public List<BuildingEntity> findAll(Map<String, Object> params, List<String> typeBuilding) {
		StringBuilder query = new StringBuilder("SELECT DISTINCT  * FROM building b ");
		joinTable(params, typeBuilding, query);
		StringBuilder where = new StringBuilder(" WHERE 1=1 ");
		handleQuery(params, typeBuilding, where);
		query.append(where);
		List<BuildingEntity> results = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query.toString());) {
			while (rs.next()) {
				BuildingEntity buildingEntity = new BuildingEntity();
				buildingEntity.setName(rs.getString("name"));
				buildingEntity.setId(rs.getLong("id"));
				buildingEntity.setWard(rs.getString("ward"));
				buildingEntity.setStreet(rs.getString("street"));
				buildingEntity.setDistrictId(rs.getLong("districtId"));
				buildingEntity.setRentprice(rs.getLong("rentprice"));
				buildingEntity.setServicefee(rs.getString("servicefee"));
				buildingEntity.setBrokeragefee(rs.getLong("brokeragefee"));
				buildingEntity.setFloorArea(rs.getLong("floorarea"));
				buildingEntity.setNumberOfBasement(rs.getLong("numberofbasement"));
				buildingEntity.setManagerName(rs.getString("user.fullname"));
				buildingEntity.setManagerPhoneNumber(rs.getString("user.phone"));
				results.add(buildingEntity);
			}
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
