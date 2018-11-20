package com.model2.mvc.web.parts;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;

import com.model2.mvc.service.domain.Parts;
import com.model2.mvc.service.parts.PartsService;



@Controller
@RequestMapping("/parts/*")
public class PartsController{
	
	//Field
	@Autowired
	@Qualifier("partsServiceImpl")
	private PartsService partsService;
	
	public PartsController() {
		System.out.println(this.getClass());
	}
	
	@Value("#{commonProperties['pageUnit']}")
		int pageUnit;	
	
	@Value("#{commonProperties['pageSize']}")
		int pageSize;
	
	@RequestMapping(value = "addParts", method=RequestMethod.POST)
	public ModelAndView addParts (@ModelAttribute("parts") Parts parts) throws Exception {
	
		//Business Logic
		partsService.addParts(parts);
		
		String viewName = "/parts/addParts.jsp";
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(viewName);
		modelAndView.addObject("parts", parts);
	//	model.addAttribute("parts", parts);		

		return modelAndView;
		//"forward:/parts/addParts.jsp"
	}


}
