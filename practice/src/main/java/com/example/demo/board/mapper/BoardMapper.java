package com.example.demo.board.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.board.vo.Board;
import com.example.demo.common.vo.Criteria;

@Mapper
@Repository("com.example.demo.board.mapper.BoardMapper")
public interface BoardMapper {

	List<Map<String, Object>> selectCity() throws Exception;

	List<Board> fildAll() throws Exception;

	void saveBoard(Board board) throws Exception;

	List<Board> selectBoardList(Criteria cri) throws Exception;

	int selectBoardListCount(Criteria cri) throws Exception;

	int insertBoard(Board board) throws Exception;

	Board selectBoardFromBoardIdx(Map<String, Object> paramMap) throws Exception;

	void updateBoardReadCount(long parseLong) throws Exception;

	String testQuery() throws Exception;

}
