package com.aits.controller;

import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.aits.constant.AppConstant;
import com.aits.dto.EndUserDetailsDto;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class UserLoginController implements AppConstant {
	
	@RequestMapping(value=USER_LOGIN, method = RequestMethod.POST)
	public String userLogin(@ModelAttribute("endUserDetailsDto") EndUserDetailsDto endUserDetailsDto,ModelMap model) throws IOException {

		
		RestTemplate restTemplate = new RestTemplate();
        /*EndUserDetailsDto endUserDetailsDtoResponse = restTemplate.postForObject(URI+USER_LOGIN, endUserDetailsDto, EndUserDetailsDto.class);
		System.out.println("response"+endUserDetailsDtoResponse.getEndUserId());
		model.addAttribute("endUserDetailsDtoResponse",endUserDetailsDtoResponse);
		return "index";*/		
		
		//For Post Type
		String endUserDetailsDtoResponse = restTemplate.postForObject(URI+USER_LOGIN, endUserDetailsDto, String.class);
		ObjectMapper mapper = new ObjectMapper();
		EndUserDetailsDto dto = mapper.readValue(endUserDetailsDtoResponse, EndUserDetailsDto.class);
		System.out.println("hello Dto" +dto.getEndUserId() );
		model.addAttribute("endUserDetailsDtoResponse",dto);
		return "index";
	}
	
	@RequestMapping(value=USER_REGISTRATION, method = RequestMethod.GET)
	public String adminLogin(ModelMap model) {
		model.addAttribute("step1",true);
		return "user/userRegistration";
	}
	
	@RequestMapping(value =USER_PARTIALREGISTRATION, method = RequestMethod.POST)
	public String partialRegistration(@ModelAttribute("endUserDetailsDto") EndUserDetailsDto endUserDetailsDto,ModelMap model) throws JsonParseException, JsonMappingException, IOException {
		
		System.out.println("registration begin2");
		
		String endUserDetailsDtoResponse = new RestTemplate().postForObject(URI+USER_PARTIALREGISTRATION, endUserDetailsDto, String.class);
		EndUserDetailsDto dto = new ObjectMapper().readValue(endUserDetailsDtoResponse, EndUserDetailsDto.class);
		System.out.println("hello Dto" +dto.getEndUserId()+"----"+dto.getOneTimePassword());
	    model.addAttribute("step2",true);
	    model.addAttribute("EndUserId",dto.getEndUserId());
	    model.addAttribute("OneTimePassword",dto.getOneTimePassword());
		
		return "user/userRegistration";
	}
	
	@RequestMapping(value =USER_CENTRALREGISTRATION, method = RequestMethod.POST)
	public String centralRegistration(@ModelAttribute("endUserDetailsDto") EndUserDetailsDto endUserDetailsDto,ModelMap model,@RequestParam("ROneTimePassword") int ROneTimePassword) throws JsonParseException, JsonMappingException, IOException {
	   
		System.out.println("registration begin3"+endUserDetailsDto.getEndUserId());
		if(endUserDetailsDto.getOneTimePassword()==ROneTimePassword){
			
			String endUserDetailsDtoResponse = new RestTemplate().postForObject(URI+USER_CENTRALREGISTRATION, endUserDetailsDto, String.class);
			EndUserDetailsDto dto = new ObjectMapper().readValue(endUserDetailsDtoResponse, EndUserDetailsDto.class);
			System.out.println("-----" +dto.getEndUserId()+"=="+endUserDetailsDto.getEndUserId()+"----"+dto.getOneTimePassword()+"=="+endUserDetailsDto.getOneTimePassword());
			model.addAttribute("step3",true);		
		}else{
			model.addAttribute("EndUserId",endUserDetailsDto.getEndUserId());
		    model.addAttribute("OneTimePassword",ROneTimePassword);
			model.addAttribute("step2",true);
			model.addAttribute("errormsg","Invalid OTP, Enter Valid OTP");
		}	
	    	
		return "user/userRegistration";
	}
	
	@RequestMapping(value=USER_FINALREGISTRATION, method = RequestMethod.POST)
	public String finalRegistration(@ModelAttribute("endUserDetailsDto") EndUserDetailsDto endUserDetailsDto,ModelMap model) throws JsonParseException, JsonMappingException, IOException {
	   
		    System.out.println("registration end"+endUserDetailsDto.getEndUserId());	
			//String endUserDetailsDtoResponse = new RestTemplate().postForObject(URI+USER_FINALREGISTRATION, endUserDetailsDto, String.class);
			//EndUserDetailsDto dto = new ObjectMapper().readValue(endUserDetailsDtoResponse, EndUserDetailsDto.class);
				
		return "index";
	}

}
