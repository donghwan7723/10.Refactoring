package com.model2.mvc.web.product;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model2.mvc.common.Page;
import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;

@RestController
@RequestMapping("/product/*")
public class ProductRestController {

	///Field
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;
	
	public ProductRestController() {
		System.out.println(this.getClass());
	}
	
	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
	@Value("#{commonProperties['pageSize']}")
	int pageSize;
	
	@RequestMapping(value="json/addProduct", method=RequestMethod.POST)
	public Map addProduct(@RequestBody Product product) throws Exception {
		
		
		System.out.println("여기는 addProduct의 POST");
		productService.addProduct(product);
		
		String methodComplited = "addProduct Complited";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("complited", methodComplited);	
		
		return map;
	}
	
	@RequestMapping(value="json/getProduct/{prodNo}", method=RequestMethod.GET)
	public Product getProduct(@PathVariable int prodNo) throws Exception {
		
		System.out.println("getProduct");
		
		return productService.getProduct(prodNo);
	}	
	
	@RequestMapping(value="json/updateProduct", method=RequestMethod.POST)
	public void updateProduct(@RequestBody Product product) throws Exception{
	
		System.out.println("updateProduct Post");
		
	
		System.out.println(product);
		
		productService.updateProduct(product);
		
	}
	
	@RequestMapping(value="json/updateProduct/{prodNo}", method=RequestMethod.GET)
	public void updateProduct(@PathVariable int prodNo) {
		
		System.out.println("updateProduct Get");
		
		
	}
//	@RequestMapping(value="json/listProduct")
//	public Model listProduct(@RequestBody Search search, Model model) throws Exception{
//		
//		System.out.println("여기는 listProduct 메서드");
//		
//		if(search.getCurrentPage()==0) {
//			search.setCurrentPage(1);
//		}
//		search.setPageSize(pageSize);
//
//		
//		Map<String, Object> map = productService.getProductList(search);
//		
//		Page resultPage = new Page(search.getCurrentPage(),((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize); 
//		System.out.println(resultPage);
//		
//		model.addAttribute("list", map.get("list"));
//		model.addAttribute("resultPage", resultPage);
//		model.addAttribute("search", search);
//		
//		return model;
//	}
}
