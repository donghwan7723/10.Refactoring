package com.model2.mvc.web.parts;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model2.mvc.service.domain.Parts;
import com.model2.mvc.service.parts.PartsService;


@RestController
@RequestMapping("/parts/*")
public class PartsRestController {

	///Field
	@Autowired
	@Qualifier("partsServiceImpl")
	private PartsService partsService;
	
	public PartsRestController() {
		System.out.println(this.getClass());
	}
	
	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
	@Value("#{commonProperties['pageSize']}")
	int pageSize;
	
	@RequestMapping(value="json/addParts", method=RequestMethod.POST)
	public void addParts(@RequestBody Parts parts) throws Exception {
		
		partsService.addParts(parts);
	

	}

}
