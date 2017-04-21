package com.aits.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.aits.constant.AppConstant;
import com.aits.dto.CategoryMasterDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class AdminProductMgmtController implements AppConstant{
	
	@RequestMapping(value=GET_CATEGORY_MASTER_LIST, method = RequestMethod.GET)
	public String getCategoryMasterList(ModelMap model,HttpServletRequest request) throws IOException {

		RestTemplate restTemplate = new RestTemplate();
		String categoryMasterDtoResponse = restTemplate.getForObject(URI+GET_CATEGORY_MASTER_LIST, String.class);
		ObjectMapper mapper = new ObjectMapper();
		CategoryMasterDto dto = mapper.readValue(categoryMasterDtoResponse, CategoryMasterDto.class);
		model.addAttribute("categoryMasterDtoResponse",dto);
		return "admin/addCategory";
	}
	
	
	@RequestMapping(value=INSERT_CATEGORY_MASTER, method = RequestMethod.POST)
	public String insertCategoryMaster(@ModelAttribute("categoryMasterDto") CategoryMasterDto categoryMasterDto,
			ModelMap model,HttpServletRequest request) throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		String categoryMasterDtoResponse = restTemplate.postForObject(URI+INSERT_CATEGORY_MASTER, categoryMasterDto,String.class);
		ObjectMapper mapper = new ObjectMapper();
		CategoryMasterDto dto = mapper.readValue(categoryMasterDtoResponse, CategoryMasterDto.class);
		model.addAttribute("categoryMasterDtoResponse",dto);
		return "admin/addCategory";
	}
	
	
	@RequestMapping(value=GET_CATEGORY_MASTER_INFORMATION_BY_ID, method = RequestMethod.GET)
	public String getCategoryMasterInformationById(@PathVariable("categoryMasterId") int categoryMasterId,
			ModelMap model,HttpServletRequest request) throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		String categoryMasterDtoResponse = restTemplate.getForObject(URI+GET_CATEGORY_MASTER_INFORMATION_BY_CATEGORY_ID+categoryMasterId,String.class);
		ObjectMapper mapper = new ObjectMapper();
		CategoryMasterDto dto = mapper.readValue(categoryMasterDtoResponse, CategoryMasterDto.class);
		model.addAttribute("categoryMasterDtoResponse",dto);
		return "admin/addCategory";
	}
	
	@RequestMapping(value=UPDATE_CATEGORY_MASTER, method = RequestMethod.POST)
	public String updateCategoryMaster(@ModelAttribute("categoryMasterDto") CategoryMasterDto categoryMasterDto,
			ModelMap model,HttpServletRequest request) throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		String categoryMasterDtoResponse = restTemplate.postForObject(URI+UPDATE_CATEGORY_MASTER, categoryMasterDto,String.class);
		ObjectMapper mapper = new ObjectMapper();
		CategoryMasterDto dto = mapper.readValue(categoryMasterDtoResponse, CategoryMasterDto.class);
		model.addAttribute("categoryMasterDtoResponse",dto);
		return "admin/addCategory";
	}
	
	//AJAX CALL FOR UPDATE CATEGORY STATUS
	@RequestMapping(value=UPDATE_CATEGORY_STATUS, method = RequestMethod.POST,consumes= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody  String updateCategoryStatus(@RequestBody CategoryMasterDto categoryMasterDto) throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("in controller method");
		String categoryMasterDtoResponse = restTemplate.postForObject(URI+UPDATE_CATEGORY_MASTER, categoryMasterDto,String.class);
		return "admin/addCategory";
	}
	
	

}
