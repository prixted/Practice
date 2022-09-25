package com.example.demo.common.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.common.vo.CommonDetailCode;

@Mapper
@Repository("com.example.demo.common.mapper.CommonMapper")
public interface CommonMapper {

	List<CommonDetailCode> selectCommonDetailCode(Map<String, Object> paramMap) throws Exception;

}
