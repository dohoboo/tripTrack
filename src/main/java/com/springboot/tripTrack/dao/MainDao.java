package com.springboot.tripTrack.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;

import com.springboot.tripTrack.dto.LocationDto;
import com.springboot.tripTrack.dto.TagDto;

@Mapper
public interface MainDao {
	@Select("select * from tbl_tag")
	public List<TagDto> selectAllTag() throws DataAccessException;
	
	@Select("select * from tbl_location")
	public List<LocationDto> selectAllLocation() throws DataAccessException;
}
