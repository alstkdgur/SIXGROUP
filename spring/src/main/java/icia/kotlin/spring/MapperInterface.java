package icia.kotlin.spring;


import icia.kotlin.beans.member;

public interface MapperInterface {
	public int idCheck(member m);	
	public int accessInfoCheck(member m);
	public member showMember(member m);
}
