package com.ncs.empconsole.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empconsole/emp")
public class EmployeeRestController {

	public EmployeeRestController() {
		System.out.println("Employee Controller constructor called");
	}
}