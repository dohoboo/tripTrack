package com.springboot.tripTrack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.tripTrack.dao.MainDao;
import com.springboot.tripTrack.dto.LocationDto;
import com.springboot.tripTrack.dto.TagDto;

@Service
public class MainService {
	private final MainDao mainDao;

	@Autowired
	public MainService(MainDao mainDao) {
		this.mainDao = mainDao;
	}

	public List<TagDto> getAllTag() {
		List<TagDto> tagList = mainDao.selectAllTag();

		return tagList;
	}

	public List<LocationDto> getAllLocation() {
		List<LocationDto> locationList = mainDao.selectAllLocation();

		return locationList;
	}

}
