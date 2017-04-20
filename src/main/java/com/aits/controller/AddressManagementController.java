package com.aits.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

		return "admin/addState";
	}

	@RequestMapping(value=SAVE_STATE, method = RequestMethod.POST)
	public String saveState(@ModelAttribute("stateMasterDto")StateMasterDto stateMasterDto ,Model model)throws Exception {


		RestTemplate restTemplate = new RestTemplate();

		String stateMasterDtoResponce=restTemplate.postForObject(URI+SAVE_STATE,stateMasterDto,String.class);
		StateMasterDto stDto=new ObjectMapper().readValue(stateMasterDtoResponce,StateMasterDto.class);
		model.addAttribute("stateList",stDto.getStateMasterList());
		model.addAttribute("stateMasterDto",stateMasterDto);
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


		model.addAttribute("stateMasterDto",stDto);

		return "admin/addState";

	}



	@RequestMapping(value=ADMIN_INACTIVE_STATE,method=RequestMethod.GET)
	public String inactiveState(@RequestParam("stateId")int stateId,Model model)throws Exception{

		RestTemplate restTemplate=new RestTemplate();
		StateMasterDto dto=new StateMasterDto();
		dto.setStateId(stateId);

		String stateListResponce=restTemplate.postForObject(URI+ADMIN_INACTIVE_STATE,dto, String.class);
		StateMasterDto stateList=new ObjectMapper().readValue(stateListResponce, StateMasterDto.class);
		model.addAttribute("stateList",stateList.getStateMasterList());
		model.addAttribute("stateMasterDto",new StateMasterDto());
		model.addAttribute("msg","State inactive successfull!!");
		return"admin/addState";	
	}

	@RequestMapping(value=ADMIN_ACTIVE_STATE,method=RequestMethod.GET)
	public String activeState(@RequestParam("stateId")int stateId,Model model)throws Exception{

		RestTemplate restTemplate=new RestTemplate();
		StateMasterDto dto=new StateMasterDto();
		dto.setStateId(stateId);

		String stateListResponce=restTemplate.postForObject(URI+ADMIN_ACTIVE_STATE,dto, String.class);
		StateMasterDto stateList=new ObjectMapper().readValue(stateListResponce, StateMasterDto.class);
		model.addAttribute("stateList",stateList.getStateMasterList());
		model.addAttribute("stateMasterDto",new StateMasterDto());
		model.addAttribute("msg","State Active successfull!!");
		return"admin/addState";	
	}
	


	/*****************************city Operations****************************************/





	@RequestMapping(value="/adminAddCity", method = RequestMethod.GET)
	public String addcity(Model model) throws Exception{

		RestTemplate restTemplate=new RestTemplate();
		String stateListResponce=restTemplate.postForObject(URI+AdminStates,StateMasterDto.class, String.class);
		StateMasterDto stateList=new ObjectMapper().readValue(stateListResponce, StateMasterDto.class);
		model.addAttribute("stateList",stateList.getStateMasterList());

		model.addAttribute("cityMasterDto",new CityMasterDto());

		return "admin/addCity";

	}



	@RequestMapping(value=SAVE_CITY, method = RequestMethod.POST)
	public String saveCity(@ModelAttribute("cityMasterDto")CityMasterDto cityMasterDto,@RequestParam("stateId")int stateId ,Model model)throws Exception {
		StateMaster stateMaster=new StateMaster();
		stateMaster.setStateId(stateId);
     	cityMasterDto.setStateMaster(stateMaster);

		RestTemplate restTemplate = new RestTemplate();

		String cityMasterDtoResponce=restTemplate.postForObject(URI+SAVE_CITY,cityMasterDto,String.class);

		CityMasterDto stDto=new ObjectMapper().readValue(cityMasterDtoResponce,CityMasterDto.class);
		model.addAttribute("stateList",stDto.getStateMaster().getStateMasterList());
		model.addAttribute("cityList",stDto.getCityMasterList());
		model.addAttribute("cityMasterDto",new CityMasterDto());
		model.addAttribute("msg","City Save Successfull!!");

		return "admin/addCity";

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
