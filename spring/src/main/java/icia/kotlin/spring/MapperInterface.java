package icia.kotlin.spring;

import org.apache.ibatis.annotations.Select;

import icia.kotlin.beans.member;

public interface MapperInterface {
	
	public int isMember(member m);
	public int isAccess(member m);
	public member memberInfo(member m);
}