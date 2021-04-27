package com.cg.socialmedia.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

@Entity
@Table(name="post_details")
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long post_id;
	
	@NotNull
	private String post_content;
	
	private int post_likes;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull()
	private LocalDate postedOn;
	
	private String title;
	
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "userprofile_id", nullable = false)
	private UserProfile userProfile;

	public Post() {
		super();
	}

	public Post(long post_id, String post_content, int post_likes, LocalDate postedOn, String title,
			UserProfile userProfile) {
		super();
		this.post_id = post_id;
		this.post_content = post_content;
		this.post_likes = post_likes;
		this.postedOn = postedOn;
		this.title = title;
		this.userProfile = userProfile;
	}

	public long getPost_id() {
		return post_id;
	}

	public void setPost_id(long post_id) {
		this.post_id = post_id;
	}

	public String getPost_content() {
		return post_content;
	}

	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}

	public int getPost_likes() {
		return post_likes;
	}

	public void setPost_likes(int post_likes) {
		this.post_likes = post_likes;
	}

	public LocalDate getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(LocalDate postedOn) {
		this.postedOn = postedOn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	@Override
	public String toString() {
		return "Post [post_id=" + post_id + ", post_content=" + post_content + ", post_likes=" + post_likes
				+ ", postedOn=" + postedOn + ", title=" + title + ", userProfile=" + userProfile + "]";
	}

	

}
