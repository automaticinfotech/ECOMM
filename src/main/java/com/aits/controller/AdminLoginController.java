package com.aits.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

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
public class AdminLoginController implements AppConstant{
	
	
	@RequestMapping(value=ADMIN_LOGIN_AUTHENTICATION, method = RequestMethod.POST)
	public String adminLoginAuthentication(@ModelAttribute("endUserDetailsDto") EndUserDetailsDto endUserDetailsDto,
			ModelMap model,HttpServletRequest request) throws IOException {

		RestTemplate restTemplate = new RestTemplate();
		String endUserDetailsDtoResponse = restTemplate.postForObject(URI+USER_LOGIN, endUserDetailsDto, String.class);
		ObjectMapper mapper = new ObjectMapper();
		EndUserDetailsDto dto = mapper.readValue(endUserDetailsDtoResponse, EndUserDetailsDto.class);
		
		
		if(dto.getEndUserId()==0)
		{
			model.addAttribute("authenticatinFailed","authentication failed...!");
			return "admin/adminLogin";
		}
		else
		{
			request.getSession().setAttribute("LOGGEDIN_USER", dto);
			model.addAttribute("endUserDetailsDtoResponse",dto);
			return "admin/adminDashboard";
		}
		
	}
	
	
	@RequestMapping(value=ADMIN_SIGN_OUT, method = RequestMethod.GET)
	public String adminSignOut(HttpServletRequest request) throws IOException {

		  request.getSession().invalidate();
		  return "admin/adminLogin";
		
	}
	
	
	
}
