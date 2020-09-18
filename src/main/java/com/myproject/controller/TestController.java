/**
 * 
 */
package com.myproject.controller;

import java.util.List;

import com.myproject.dto.MedicineDto;
import com.myproject.dto.ResponseDto;
import com.myproject.dto.TestDto;
import com.myproject.service.MedicineService;
import com.myproject.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kamlesh.Choubey
 *
 */

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	TestService testService;

	@GetMapping("/testList")
	public List<TestDto> getAllTestList() {
		return testService.getAllTests();
	}

	@PostMapping("/test")
	public ResponseDto addNewTest(@RequestBody TestDto testDto){
		return testService.addTest(testDto);
	}

}
