package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/update")
public class MongoUpdateController {
	
	@Autowired
	private MongoUpdate mongoUpdate;
	
	@RequestMapping("/updateOne")
	public String updateOne()
	{
		return mongoUpdate.updateOne();
	}
	
	

}
