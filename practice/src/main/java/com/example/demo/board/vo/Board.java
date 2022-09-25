package com.example.demo.board.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 @Doc : 게시글 VO
 @Table : board
 */
@Getter
@Setter
@ToString
public class Board {
	
	private int		boardIdx;				//index
	private String	title;					//제목
	private String	content;				//글내용 content
	private String	boardTypeCode;			//게시판_종류(141) board_type_code
	private String	boardTypeCodeName;
	private String	boardCategoryCode;		//게시글_종류(142) board_category_code
	private String	boardCategoryCodeName;
	private int		readCount;				//조회수
	private int		recommendCount;			//추천수
	private int		reportCount;			//신고수
	private int		fileCount;				//파일갯수
	private String	createYmdhms;			//작성일
	private int		createUserIdx;			//작성자idx
	private String	createUserName;			//작성자명
	private String	updateYmdhms;			//수정일
	
	
	

}
