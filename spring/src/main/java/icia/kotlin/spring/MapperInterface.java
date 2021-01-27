package icia.kotlin.spring;

import org.apache.ibatis.annotations.Select;
 
//mapper인터페이스 선
public interface MapperInterface {		
	@Select("SELECT SYSDATE FROM DUAL")
	public String getDate();
	public String getDate2();
	
	
}
