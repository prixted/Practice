package com.example.demo.util;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

// 자주 사용하는 기능들
public class UtilService {
	
    /**
     @Method : empty
     @Desc : 빈 값일 경우 체크
     @Date : 2022. 9. 23.
     @Author : PrixTeD
     @param object
     @return
    
     @Change : 
    
     */
    public Boolean empty(Object object) {
        if (object instanceof String) return object == null || object == "" || "0".equals(object.toString().trim()) || "".equals(object.toString().trim()) || "null".equals(object.toString().trim()) || "undefined".equals(object.toString().trim());
        else if (object instanceof Integer) return object == null || (int)object == 0;
        else if (object instanceof Long) return object == null || (long)object == 0;
        else if (object instanceof List) return object == null || ((List<?>) object).isEmpty();
        else if (object instanceof Map) return object == null || ((Map<?, ?>) object).isEmpty();
        else if (object instanceof Object[]) return object == null || Array.getLength(object) == 0;
        else return object == null;
    }
 
    /**
     @Method : notEmpty
     @Desc : 빈 값이 아닐 경우 체크
     @Date : 2022. 9. 23.
     @Author : PrixTeD
     @param object
     @return
    
     @Change : 
    
     */
    public Boolean notEmpty(Object object) {
        return !empty(object);
    }

    /**
     @Method : getCurDate
     @Desc : 형식에 따라서 오늘 날짜, 시분초 값을 반환해준다.
     @Date : 2022. 9. 23.
     @Author : PrixTeD
     @param type
     @return
    
     @Change : 
    
     */
    public String getCurDate(String type) {
  	  	if (empty(type)) {
  	  		return null;
  	  	}    	
  	  	
        Date today = new Date();
    	String strDate = "";
    	try {
	            
	        if("YEAR".equals(type)) { //연도
		        SimpleDateFormat year = new SimpleDateFormat("yyyy");		
	        	strDate = year.format(today);
	        } else if("YM".equals(type)) { //연월
		        SimpleDateFormat yearMonth = new SimpleDateFormat("yyyyMM");
	        	strDate = yearMonth.format(today);
	        } else if("DAY".equals(type)) { //연월일
	        	SimpleDateFormat day = new SimpleDateFormat("yyyyMMdd");
	        	strDate = day.format(today);
	        } else if("YMDHM".equals(type)) { //연월일시분
		        	SimpleDateFormat date = new SimpleDateFormat("yyyyMMddHHmm");
		        	strDate = date.format(today);
	        } else if("HM".equals(type)) { //시분
		        SimpleDateFormat noSSTime = new SimpleDateFormat("HHmm");
	        	strDate = noSSTime.format(today);	
	        } else if("HMS".equals(type)) { //시분초
		        SimpleDateFormat onlyTime = new SimpleDateFormat("HHmmss");
	        	strDate = onlyTime.format(today);	
	        } else if("RDTM".equals(type)) {	
		        SimpleDateFormat rtime = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
	        	strDate = rtime.format(today);	
	        } else if("RDAY".equals(type)) {	
		        SimpleDateFormat rday = new SimpleDateFormat("yyyy.MM.dd");
	        	strDate = rday.format(today);	
	        } else {
		        SimpleDateFormat time = new SimpleDateFormat("yyyyMMddHHmmss");
	        	strDate = time.format(today);
	        }
		} catch (Exception e) {
			strDate = null;
		}
		return strDate;
        
    }
    
    
    /**
     @Method : getNextMonth
     @Desc : 해당 연월의, 다음 월 조회
     @Date : 2022. 9. 23.
     @Author : PrixTeD
     @param theYm
     @return
     @throws ParseException
    
     @Change : 
    
     */
    public String getNextMonth(String theYm) throws ParseException {
    	if (empty(theYm)) {
    		return null;
    	}    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    	Calendar c = Calendar.getInstance();
    	String thisYm = theYm;
    	if (thisYm.length() == 6) {
    		thisYm = theYm.concat("01");
    	}
    	Date d = sdf.parse(thisYm);
    	
    	c.setTime(d);
    	c.add(Calendar.MONTH,1);
    	String date = sdf.format(c.getTime());
    	
    	return date.substring(0, 6);
    }

    /**
     @Method : getPrevMonth
     @Desc : 해당 연월의, 이전 월 조회
     @Date : 2022. 9. 23.
     @Author : PrixTeD
     @param theYm
     @return
     @throws ParseException
    
     @Change : 
    
     */
    public String getPrevMonth(String theYm) throws ParseException {
  	  	if (empty(theYm)) {
  	  		return null;
  	  	}    	
  	  	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
  	  	Calendar c = Calendar.getInstance();
  	  	String thisYm = theYm;
	  	if (thisYm.length() == 6) {
	  		thisYm = theYm.concat("01");
	  	}
	  	Date d = sdf.parse(thisYm);
  	  
  	  	c.setTime(d);
  	  	c.add(Calendar.MONTH,-1);
  	  	String date = sdf.format(c.getTime());
  	  
  	  	return date.substring(0, 6);
 	 }
    
    
}
