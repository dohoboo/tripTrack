package com.springboot.tripTrack.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.tripTrack.dto.LocationDto;
import com.springboot.tripTrack.dto.TagDto;
import com.springboot.tripTrack.service.MainService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MainController {
	private final MainService mainService;
	
	@GetMapping(path="/") // 메인페이지 이동
	public String home() {
		return "index";
	}
	
//	@GetMapping(path="/domestic")
//	public ModelAndView getDomesticList() {
//		ModelAndView mav = new ModelAndView("domestic");
//		
//		return mav;
//	}
//	
//	@GetMapping(path="/overseas")
//	public ModelAndView getOverseasList() {
//		ModelAndView mav = new ModelAndView("overseas");
//		
//		return mav;
//	}
//	
//	@GetMapping(path="/city")
//	public ModelAndView getCityList() {
//		ModelAndView mav = new ModelAndView("city");
//		
//		return mav;
//	}
	
	@GetMapping(path="/place")
	public ModelAndView getPlaceList() {
		List<TagDto> tagList = mainService.getAllTag();
		List<LocationDto> locationList = mainService.getAllLocation();
		ModelAndView mav = new ModelAndView("place");
		mav.addObject("tagList",tagList);
		mav.addObject("locationList",locationList);
		return mav;
	}
	
	@GetMapping(path="/acc")
	public ModelAndView getAccList() {
		ModelAndView mav = new ModelAndView("acc");
		
		return mav;
	}
	
	@GetMapping(path="/rest")
	public ModelAndView getRestList() {
		ModelAndView mav = new ModelAndView("rest");
		
		return mav;
	}
}
