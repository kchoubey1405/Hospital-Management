/**
 * 
 */
package com.myproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kamlesh.Choubey
 *
 */

@RestController
@RequestMapping("/testController")
public class TestController {
	
	@GetMapping
	public String test(){ 
		return "success";
	}

}
