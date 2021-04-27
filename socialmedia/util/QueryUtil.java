package com.cg.socialmedia.util;

public class QueryUtil {
	private QueryUtil() {
		
	}
	public static final String ACCEPT_FRIEND="update friendr2  set status ='APPROVED' ,activeid= ?2 where userto=?1 and userfrom=?2";
    public static final String FRIEND_LIST="select * from friendr2 where (userto=?1 or userfrom =?1) and status = 'APPROVED' ";
    public static final String FIND_USERID="select * from friendr2 where userto=?1 and userfrom=?2";
    public static final String REQUEST_LIST=" select * from friendr2 where (userto = ?1 or userfrom=?1)and status='REQUEST' and activeid <> ?1 ";
}
