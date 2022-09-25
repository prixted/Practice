package com.example.demo.common.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Doc 검색용 VO객체
 */
@Getter
@Setter
@ToString
public class Criteria {
	private int pageNum;	// 현재 페이지 번호
	private int amount;		// 한 페이지에 표시할 컨텐츠 갯수
	private int startIndex;	// 디비에서 시작 Index
	
	private String typeCode;	// 조건 검색시 조건
	private String searchWord;	// 입력한 검색어 문자열
	private String startYmd;	// 검색시 시작일
	private String endYmd;		// 검색시 종료일
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.startIndex = (pageNum-1) * amount;
	}
	public Criteria() {
		this(1,10);
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
		this.startIndex = (pageNum-1) * this.amount;
	}

}
