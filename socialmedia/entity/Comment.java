package com.cg.socialmedia.entity;

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

import com.sun.istack.NotNull;

@Entity
@Table(name="comment_details")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long comment_id;
	
	private String comment_content;
	
	private int comment_likes;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(style = "yyyy-MM-dd")
	@NotNull()
	private Date commentedOn;
	
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "post_id", nullable = false)
	private Post post;
	
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "userprofile_id", nullable = false)
	private UserProfile userProfile;

	public Comment() {
		super();
	}

	public Comment(long comment_id, String comment_content, int comment_likes, Date commentedOn, Post post,
			UserProfile userProfile) {
		super();
		this.comment_id = comment_id;
		this.comment_content = comment_content;
		this.comment_likes = comment_likes;
		this.commentedOn = commentedOn;
		this.post = post;
		this.userProfile = userProfile;
	}

	public long getComment_id() {
		return comment_id;
	}

	public void setComment_id(long comment_id) {
		this.comment_id = comment_id;
	}

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}

	public int getComment_likes() {
		return comment_likes;
	}

	public void setComment_likes(int comment_likes) {
		this.comment_likes = comment_likes;
	}

	public Date getCommentedOn() {
		return commentedOn;
	}

	public void setCommentedOn(Date commentedOn) {
		this.commentedOn = commentedOn;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	@Override
	public String toString() {
		return "Comment [comment_id=" + comment_id + ", comment_content=" + comment_content + ", comment_likes="
				+ comment_likes + ", commentedOn=" + commentedOn + ", post=" + post + ", userProfile=" + userProfile
				+ "]";
	}

	
	

}
