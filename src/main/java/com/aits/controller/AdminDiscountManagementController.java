package com.aits.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.aits.constant.AppConstant;
import com.aits.dto.CategoryMasterDto;
import com.aits.dto.DiscountMasterDto;
import com.aits.dto.StateMasterDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class AdminDiscountManagementController implements AppConstant {

	@RequestMapping(value=GET_DISCOUNT_LIST, method = RequestMethod.GET)
	public String getDiscount(Model model)throws Exception {
        
		model.addAttribute("discountMasterDto",new DiscountMasterDto());
		RestTemplate restTemplate=new RestTemplate();
		String discountListResponse=restTemplate.getForObject(URI+GET_DISCOUNT_LIST, String.class);
		DiscountMasterDto discountMasterDto=new ObjectMapper().readValue(discountListResponse, DiscountMasterDto.class);
		model.addAttribute("discountMasterList",discountMasterDto.getDiscountMasterList());

		return "admin/addDiscount";
	}
	
	@RequestMapping(value=ADD_DISCOUNT, method = RequestMethod.POST)
	public String addDiscount(@ModelAttribute("discountMasterDto")DiscountMasterDto discountMasterDto ,Model model)throws Exception {


		RestTemplate restTemplate = new RestTemplate();

		String discountMasterResponse=restTemplate.postForObject(URI+ADD_DISCOUNT,discountMasterDto,String.class);
		DiscountMasterDto diMasterDto=new ObjectMapper().readValue(discountMasterResponse,DiscountMasterDto.class);
		model.addAttribute("discountMasterList",diMasterDto.getDiscountMasterList());
		model.addAttribute("discountMasterDto",discountMasterDto);
		model.addAttribute("msg","Discount Saved Successfully!!");

		return "admin/addDiscount";

	}

	@RequestMapping(value=GET_DISCOUNT_INFO_BY_ID+"{discountMasterId}", method = RequestMethod.GET)
	public String getDiscountMasterInformationById(@PathVariable("discountMasterId") int discountMasterId,Model model)throws Exception {
        System.out.println("Inside Get Discount Master By Id"+discountMasterId);
		RestTemplate restTemplate=new RestTemplate();
		String discountListResponse=restTemplate.getForObject(URI+GET_DISCOUNT_INFO_BY_ID+discountMasterId, String.class);
		DiscountMasterDto discountMasterDto=new ObjectMapper().readValue(discountListResponse, DiscountMasterDto.class);
		model.addAttribute("discountMasterList",discountMasterDto.getDiscountMasterList());
        model.addAttribute("discountMasterDto", discountMasterDto);
		return "admin/addDiscount";
	}
	
	@RequestMapping(value=UPDATE_DISCOUNT, method = RequestMethod.POST)
	public String updateDiscountMasterInformation(@ModelAttribute("discountMasterDto")DiscountMasterDto discountMasterDto ,Model model)throws Exception{
		RestTemplate restTemplate = new RestTemplate();
		String discountMasterDtoResponse = restTemplate.postForObject(URI+UPDATE_DISCOUNT, discountMasterDto,String.class);
		ObjectMapper mapper = new ObjectMapper();
		DiscountMasterDto dto = mapper.readValue(discountMasterDtoResponse, DiscountMasterDto.class);
		model.addAttribute("discountMasterDto",dto);
		model.addAttribute("discountMasterList", dto.getDiscountMasterList());
		return "admin/addDiscount";
	}
	
	
}
