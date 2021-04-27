package com.cg.socialmedia.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

@Entity
@Table(name="UserProfile_details")
public class UserProfile {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long userprofile_id;
	@NotNull
	private String about;
	
	private String gender;
	

	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull()
	private LocalDate createdOn;
	
	
	private String profilePicUrl;
	
	private String languages;

	public UserProfile() {
		super();
	}

	public UserProfile(Long userprofile_id, String about, String gender, LocalDate createdOn, String profilePicUrl,
			String languages) {
		super();
		this.userprofile_id = userprofile_id;
		this.about = about;
		this.gender = gender;
		this.createdOn = createdOn;
		this.profilePicUrl = profilePicUrl;
		this.languages = languages;
	}

	public Long getUserprofile_id() {
		return userprofile_id;
	}

	public void setUserprofile_id(Long userprofile_id) {
		this.userprofile_id = userprofile_id;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String isGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public String getProfilePicUrl() {
		return profilePicUrl;
	}

	public void setProfilePicUrl(String profilePicUrl) {
		this.profilePicUrl = profilePicUrl;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	@Override
	public String toString() {
		return "UserProfile [userprofile_id=" + userprofile_id + ", about=" + about + ", gender=" + gender
				+ ", createdOn=" + createdOn + ", profilePicUrl=" + profilePicUrl + ", languages=" + languages + "]";
	}
	
	

}
