package com.aits.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.aits.constant.AppConstant;
import com.aits.dto.DiscountMasterDto;
import com.aits.dto.SubProductMasterDiscountMapperDto;
import com.aits.dto.SubProductMasterDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class AdminSubProductDiscountMapperController implements AppConstant {
	@RequestMapping(value=GET_DISCOUNT_MAPPER_LIST, method = RequestMethod.GET)
	public String getDiscount(Model model)throws Exception {
        
		model.addAttribute("subProductMasterDiscountMapperDto",new SubProductMasterDiscountMapperDto());
		RestTemplate restTemplate=new RestTemplate();
		String discountMapperListResponse=restTemplate.getForObject(URI+GET_DISCOUNT_MAPPER_LIST, String.class);
		SubProductMasterDiscountMapperDto subProductMasterDiscountMapperDto=new ObjectMapper().readValue(discountMapperListResponse, SubProductMasterDiscountMapperDto.class);
		
		String discountListResponse=restTemplate.getForObject(URI+GET_DISCOUNT_LIST, String.class);
		DiscountMasterDto discountMasterDto=new ObjectMapper().readValue(discountListResponse, DiscountMasterDto.class);
		
		String subProductListResponse=restTemplate.getForObject(URI+GET_SUB_PRODUCT_LIST, String.class);
		SubProductMasterDto subProductMasterDto=new ObjectMapper().readValue(subProductListResponse, SubProductMasterDto.class);
		
		model.addAttribute("subProductMasterList",subProductMasterDto.getSubProductMasterList());
		model.addAttribute("discountMasterList",discountMasterDto.getDiscountMasterList());
		model.addAttribute("subProductMasterDiscountMapperList",subProductMasterDiscountMapperDto.getSubProductMasterDiscountMapperList());

		return "admin/mapDiscount";
	}
	
	@RequestMapping(value=ADD_DISCOUNT_MAPPER_INFO,method=RequestMethod.POST)
	public String addDiscount(@ModelAttribute("subProductMasterDiscountMapperDto") SubProductMasterDiscountMapperDto subProductMasterDiscountMapperDto,Model model){
		System.out.println("Inside Add Discount Mappper Information");
		System.out.println("From Date"+subProductMasterDiscountMapperDto.getSubProductMasterDiscountMapperFromDate());
		System.out.println("To Date"+subProductMasterDiscountMapperDto.getSubProductMasterDiscountMapperToDate());
		System.out.println("SubProduct Name="+subProductMasterDiscountMapperDto.getSubProductMaster().getSubProductName());
		System.out.println("Discount Name="+subProductMasterDiscountMapperDto.getDiscountMaster().getDicountMasterName());
		
		return "admin/mapDiscount";
	}
}
