package com.kpit.kmsdemo.OndutyService.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Onduty Service details", description = "Operations pertaining to declare onduty details")
public class OndutyServiceController {

	@Value("${test.message:hello default}")
	private String message;

	@RequestMapping(value = "/hellodefault", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Hello default message display AP Operation", response = String.class)
	public String getMessage() {
		return this.message;
	}
}
