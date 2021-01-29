package icia.kotlin.spring;

import org.apache.ibatis.annotations.Select;

public interface MapperInterface {

	@Select("SELECT * FROM ST WHERE ST_ID")
	public int isMember();
	public int isAccess();

}