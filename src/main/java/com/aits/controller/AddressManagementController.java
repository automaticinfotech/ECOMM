package com.aits.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.aits.constant.AppConstant;
import com.aits.dto.AddressMasterDto;
import com.aits.dto.CityMasterDto;
import com.aits.dto.PincodeMasterDto;
import com.aits.dto.StateMasterDto;
import com.aits.model.StateMaster;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class AddressManagementController implements AppConstant {

	@RequestMapping(value="/adminDashboard", method = RequestMethod.GET)
	public String adminDashboard() {

		return "admin/adminDashboard";
	}



	/*****************************State Operations****************************************/

	@RequestMapping(value=AdminStates, method = RequestMethod.GET)
	public String addState(Model model)throws Exception {

		model.addAttribute("stateMasterDto",new StateMasterDto());
		RestTemplate restTemplate=new RestTemplate();
		String stateListResponce=restTemplate.postForObject(URI+AdminStates,StateMasterDto.class, String.class);
		StateMasterDto stateList=new ObjectMapper().readValue(stateListResponce, StateMasterDto.class);
		model.addAttribute("stateList",stateList.getStateMasterList());
		model.addAttribute("operation","Add State");

		return "admin/addState";
	}

	@RequestMapping(value=SAVE_STATE, method = RequestMethod.POST)
	public String saveState(@ModelAttribute("stateMasterDto")StateMasterDto stateMasterDto ,Model model)throws Exception {


		RestTemplate restTemplate = new RestTemplate();

		String stateMasterDtoResponce=restTemplate.postForObject(URI+SAVE_STATE,stateMasterDto,String.class);
		StateMasterDto stDto=new ObjectMapper().readValue(stateMasterDtoResponce,StateMasterDto.class);
		model.addAttribute("stateList",stDto.getStateMasterList());
		model.addAttribute("stateMasterDto",stateMasterDto);
		model.addAttribute("operation","Add State");
		model.addAttribute("msg","State Save Successfull!!");

		return "admin/addState";

	}

	@RequestMapping(value=ADMIN_EDIT_STATE, method = RequestMethod.GET)
	public String editState(@RequestParam("stateId")int stateId,Model model)throws Exception {

		RestTemplate restTemplate = new RestTemplate();
		StateMasterDto dto=new StateMasterDto();
		dto.setStateId(stateId);
		String stateMasterDtoResponce=restTemplate.postForObject(URI+ADMIN_EDIT_STATE,dto,String.class);
		StateMasterDto stDto=new ObjectMapper().readValue(stateMasterDtoResponce,StateMasterDto.class);
		model.addAttribute("stateList",stDto.getStateMasterList());
		model.addAttribute("operation","Update State");
		model.addAttribute("stateMasterDto",stDto);
		return "admin/addState";

	}



	@RequestMapping(value=ADMIN_UPDATE_STATE_STATUS,method=RequestMethod.POST)
	public @ResponseBody String updateStateStatus(@RequestBody StateMasterDto stateMasterDto,Model model)throws Exception{

		RestTemplate restTemplate=new RestTemplate();
		String stateListResponce=restTemplate.postForObject(URI+ADMIN_UPDATE_STATE_STATUS,stateMasterDto, String.class);
		StateMasterDto stateList=new ObjectMapper().readValue(stateListResponce, StateMasterDto.class);

		return"admin/addState";	
	}




	/*****************************city Operations****************************************/





	@RequestMapping(value="/adminAddCity", method = RequestMethod.GET)
	public String addcity(Model model) throws Exception{

		RestTemplate restTemplate=new RestTemplate();
		String stateListResponce=restTemplate.postForObject(URI+AdminStates,StateMasterDto.class, String.class);
		StateMasterDto stateList=new ObjectMapper().readValue(stateListResponce, StateMasterDto.class);

		model.addAttribute("stateList",stateList.getStateMasterList());

		String cityListResponce=restTemplate.postForObject(URI+ADMIN_CITYS,CityMasterDto.class, String.class);
		CityMasterDto cityListDto=new ObjectMapper().readValue(cityListResponce, CityMasterDto.class);
		model.addAttribute("cityList",cityListDto.getCityMasterList());

		model.addAttribute("cityMasterDto",new CityMasterDto());

		return "admin/addCity";

	}



	@RequestMapping(value=SAVE_CITY, method = RequestMethod.POST)
	public String saveCity(@ModelAttribute("cityMasterDto")CityMasterDto cityMasterDto,Model model)throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(URI+SAVE_CITY,cityMasterDto,String.class);

		String stateListResponce=restTemplate.postForObject(URI+AdminStates,StateMasterDto.class, String.class);
		StateMasterDto stateListDto=new ObjectMapper().readValue(stateListResponce, StateMasterDto.class);
		model.addAttribute("stateList",stateListDto.getStateMasterList());

		String cityListResponce=restTemplate.postForObject(URI+ADMIN_CITYS,CityMasterDto.class, String.class);
		CityMasterDto cityListDto=new ObjectMapper().readValue(cityListResponce, CityMasterDto.class);
		model.addAttribute("cityList",cityListDto.getCityMasterList());
		model.addAttribute("cityMasterDto",new CityMasterDto());
		model.addAttribute("msg","City Save Successfull!!");

		return "admin/addCity";

	}



	@RequestMapping(value=ADMIN_EDIT_CITY, method = RequestMethod.GET)
	public String editCity(@RequestParam("cityId")int cityId,Model model)throws Exception {


		RestTemplate restTemplate = new RestTemplate();
		CityMasterDto dto=new CityMasterDto();
		dto.setCityId(cityId);

		String cityMasterDtoResponce=restTemplate.postForObject(URI+ADMIN_EDIT_CITY,dto,String.class);
		CityMasterDto ctDto=new ObjectMapper().readValue(cityMasterDtoResponce,CityMasterDto.class);
		model.addAttribute("cityMasterDto",ctDto);
		
		String stateListResponce=restTemplate.postForObject(URI+AdminStates,StateMasterDto.class, String.class);
		StateMasterDto stateListDto=new ObjectMapper().readValue(stateListResponce, StateMasterDto.class);
		model.addAttribute("stateList",stateListDto.getStateMasterList());

		String cityListResponce=restTemplate.postForObject(URI+ADMIN_CITYS,CityMasterDto.class, String.class);
		CityMasterDto cityListDto=new ObjectMapper().readValue(cityListResponce, CityMasterDto.class);
		model.addAttribute("cityList",cityListDto.getCityMasterList());
		
		
		model.addAttribute("operation","Update City");
		

		return "admin/addCity";

	}

	@RequestMapping(value=ADMIN_UPDATE_CITY_STATUS,method=RequestMethod.POST)
	public @ResponseBody String updateCityStatus(@RequestBody CityMasterDto cityMasterDto,Model model)throws Exception{

		RestTemplate restTemplate=new RestTemplate();
		String stateListResponce=restTemplate.postForObject(URI+ADMIN_UPDATE_CITY_STATUS,cityMasterDto, String.class);
		return"admin/addCity";	
	}









	@RequestMapping(value="/adminAddPincode", method = RequestMethod.GET)
	public String addPincode(Model model) {
		model.addAttribute("pincodeMasterDto",new PincodeMasterDto());


		return "admin/addPincode";

	}
	@RequestMapping(value="/adminAddAddress", method = RequestMethod.GET)
	public String addAddressLine(Model model) {
		model.addAttribute("addressMasterDto",new AddressMasterDto());


		return "admin/addAddress";

	}

}
