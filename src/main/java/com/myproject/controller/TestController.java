/**
 * 
 */
package com.myproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.dto.TestDto;
import com.myproject.service.TestService;

/**
 * @author Kamlesh.Choubey
 *
 */

@RestController
@RequestMapping("/test")
public class TestController {
  
	@Autowired
	TestService testService;

//	@Autowired
//	BillingDao billingDao;

	@GetMapping("/testList")
	public List<TestDto> getAllTestList() {
		return testService.getAllTests();
	}
//
//	@PostMapping("/test")
//	public String generateBill(@RequestBody BillMap billEntity){
//		return billingDao.generateBill(billEntity);
//	}

}
