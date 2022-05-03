package com.model2.mvc.web.product;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	
	
	
	@RequestMapping( value="json/getProduct/{prodNo}", method=RequestMethod.GET)
	public Product getProduct( @PathVariable int prodNo ) throws Exception{
	
		
	return productService.getProduct(prodNo);
	
	}
	
	
	@RequestMapping( value="json/addProduct/{product}", method=RequestMethod.POST)
	//RequestBody:��û ����body�� ����ִ� �����͸� httpMessageConverter�� ���� ��ȯ�� ��ü�� �޾ƿü��մ�.
	public Product addProduct(@RequestBody Product product, HttpSession session) throws Exception{
		productService.addProduct(product);
		return product;
	}

}
