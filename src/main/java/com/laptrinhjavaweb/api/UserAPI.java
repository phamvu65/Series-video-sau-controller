package com.laptrinhjavaweb.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.bean.UserBean;

@RestController
public class UserAPI {
//	@GetMapping("/api/staffs")
//	public List<UserBean> getStaffs(@RequestParam(value = "buildingid", required = false) Long buildingId ){
//		List<UserBean> results = new ArrayList<>();
//		return results;
//	}
	@GetMapping("/api/users")
	public List<UserBean> getStaffs(@RequestParam(value = "buildingid", required = false) Long buildingId,
									@RequestParam(value = "role", required = false) String roleCode ){
		List<UserBean> results = new ArrayList<>();
		return results;
	}

}
