package com.example.demo.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.vo.Board;
import com.example.demo.common.mapper.CommonMapper;
import com.example.demo.common.vo.CommonDetailCode;
import com.example.demo.common.vo.Criteria;
import com.example.demo.common.vo.Pagination;
import com.example.demo.util.UtilService;

@Controller
public class BoardController {
	
	@Resource(name="com.example.demo.board.mapper.BoardMapper")
	BoardMapper mBoardMapper;
	
	@Resource(name="com.example.demo.common.mapper.CommonMapper")
	CommonMapper mCommonMapper;
	
	UtilService util = new UtilService();
	
	@GetMapping("/")
	public String home(Model model) {
		
		try {
			
			model.addAttribute("greetingMessage", "Hello World!!");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "home";
	}
	
	
	/**
	 @Method : selectBoard
	 @Desc : 게시글 기본 조회하는 API 입니다
	 @Date : 2022. 9. 23.
	 @Author : PrixTeD
	 @param model
	 @param pagination
	 @return
	 @throws Exception
	
	 @Change :	

	 */
	@GetMapping("/board/board-list")
	public String selectBoard(Model model, Criteria cri) throws Exception{
		
		try {
			Map<String, Object> paramMap = new HashMap<>();
			
			
			int totalCount = 0;

			if(util.notEmpty(cri.getSearchWord())) {
				cri.setSearchWord(cri.getSearchWord().trim());
			}

			totalCount = mBoardMapper.selectBoardListCount(cri);
			
			model.addAttribute("totalCount", totalCount);
			
			System.out.println("cri : " + cri);
			
			List<Board> boardList = mBoardMapper.selectBoardList(cri);
			
			if(util.notEmpty(boardList)) {
				model.addAttribute("boardList", boardList);
			}
			
			Pagination pagination = new Pagination(totalCount, cri.getPageNum());
			pagination.setCri(cri);
			model.addAttribute("pagination", pagination);
			
			
			// 공통코드 조회
			paramMap.put("groupCode", "141");
			List<CommonDetailCode> codes141 = mCommonMapper.selectCommonDetailCode(paramMap);
			
			if(util.notEmpty(codes141)) {
				model.addAttribute("codes141", codes141);
			}
			
			paramMap.put("groupCode", "142");
			List<CommonDetailCode> codes142 = mCommonMapper.selectCommonDetailCode(paramMap);
			
			if(util.notEmpty(codes142)) {
				model.addAttribute("codes142", codes142);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "board/board-list";
	}
	
	
	/**
	 @Method : selectBoard
	 @Desc : 게시글 1개 조회
	 @Date : 2022. 9. 27.
	 @Author : PrixTeD
	 @param model
	 @param boardIdx
	 @return
	 @throws Exception
	
	 @Change : 
	
	 */
	@GetMapping("/board/board")
	public String selectBoard(Model model, @RequestParam(required = false) String boardIdx) throws Exception {
		
		
		try {
			
			if(util.notEmpty(boardIdx)) {
				
				Map<String, Object> paramMap = new HashMap<>();
				paramMap.put("boardIdx", Long.parseLong(boardIdx));
				
				Board board = mBoardMapper.selectBoardFromBoardIdx(paramMap);
				
				if(util.notEmpty(board)) {
					model.addAttribute("board", board);	
					
					// 추가로, comment, file체크까지 확인
					
				} else {
					model.addAttribute("board", new Board());
				}

			} else {
				model.addAttribute("board", new Board());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "board/board";
				
	}
	
	


}
