package com.aits.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.aits.constant.AppConstant;
import com.aits.dto.EndUserDetailsDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class UserLoginController implements AppConstant {
	
	@RequestMapping(value=USER_LOGIN, method = RequestMethod.POST)
	public String userLogin(@ModelAttribute("endUserDetailsDto") EndUserDetailsDto endUserDetailsDto,ModelMap model) throws IOException {

		
		RestTemplate restTemplate = new RestTemplate();
/*		EndUserDetailsDto endUserDetailsDtoResponse = restTemplate.postForObject(URI+USER_LOGIN, endUserDetailsDto, EndUserDetailsDto.class);
		System.out.println("response"+endUserDetailsDtoResponse.getEndUserId());
		model.addAttribute("endUserDetailsDtoResponse",endUserDetailsDtoResponse);
		return "index";
*/		
		
		
		//For Post Type
		String endUserDetailsDtoResponse = restTemplate.postForObject(URI+USER_LOGIN, endUserDetailsDto, String.class);
		ObjectMapper mapper = new ObjectMapper();
		EndUserDetailsDto dto = mapper.readValue(endUserDetailsDtoResponse, EndUserDetailsDto.class);
		System.out.println("hello Dto" +dto.getEndUserId() );
		model.addAttribute("endUserDetailsDtoResponse",dto);
		return "index";
	}

}
