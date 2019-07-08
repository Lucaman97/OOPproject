package com.esame.progetto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class simpleRestController {
	@GetMapping("/hello")
	public HelloWorldClass method(@RequestParam(name="param1", defaultValue="World") String param1) {
 		 return new HelloWorldClass("Leo", "Forcini");
	}
}

