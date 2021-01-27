package icia.kotlin.sixgroup;

import org.apache.ibatis.annotations.Select;

public interface MapperInterface {//파라미터가 없는경우에 주로사용
	@Select("SELECT SYSDATE FROM DUAL") 
	public String getDate();
	public String getDate2();
}
