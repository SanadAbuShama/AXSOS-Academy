package com.sanad.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@RequestMapping("/")
	public String home(@RequestParam(value = "name", required = false) String searchParam,
			@RequestParam(value = "last_name", required = false) String searchParam2,
			@RequestParam(value = "times", required = false) String searchParam3) {
		if (searchParam == null) {
			return "Hello Human";
		} else if (searchParam2 == null) {
			return "Hello " + searchParam;
		} else if (searchParam3 == null) {
			return ("Hello " + searchParam + " " + searchParam2);
		}

		String res = "";
		for (int i = 0; i < Integer.parseInt(searchParam3); i++) {
			res += "Hello " + searchParam + " " + searchParam2;
		}
		return res;
	}
}
