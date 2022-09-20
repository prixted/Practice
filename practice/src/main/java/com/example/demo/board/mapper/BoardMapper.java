package com.example.demo.board.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("com.example.demo.board.mapper.BoardMapper")
public interface BoardMapper {

	List<Map<String, Object>> selectCity() throws Exception;

}
