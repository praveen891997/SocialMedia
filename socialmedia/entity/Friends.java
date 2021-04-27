package com.cg.socialmedia.entity;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "friendr2")
public class Friends {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long friendid;
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private Status status;
	
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER )
	@JoinColumn(name="userto")
	private Auser user;
	
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinColumn(name="userfrom")
	private Auser userid2;
	@Column(name="activeid")
	private Long activeid;
	public Long getFriendid() {
		return friendid;
	}
	public void setFriendid(Long friendid) {
		this.friendid = friendid;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Long getActiveid() {
		return activeid;
	}
	public void setActiveid(Long activeid) {
		this.activeid = activeid;
	}
	
	public Auser getUser() {
		return user;
	}
	public void setUser(Auser user) {
		this.user = user;
	}
	public Auser getUserid2() {
		return userid2;
	}
	public void setUserid2(Auser userid2) {
		this.userid2 = userid2;
	}
	public Friends() {
		super();
	}
	public Friends(Long friendid, Status status, Auser user, Auser userid2, Long activeid) {
		super();
		this.friendid = friendid;
		this.status = status;
		this.user = user;
		this.userid2 = userid2;
		this.activeid = activeid;
	}
	public Friends(Status status, Auser user, Auser userid2, Long activeid) {
		super();
		this.status = status;
		this.user = user;
		this.userid2 = userid2;
		this.activeid = activeid;
	}
	@Override
	public String toString() {
		return "Friends [friendid=" + friendid + ", status=" + status + ", user=" + user + ", userid2=" + userid2
				+ ", activeid=" + activeid + "]";
	}
	
	
	
	
	
	
}
