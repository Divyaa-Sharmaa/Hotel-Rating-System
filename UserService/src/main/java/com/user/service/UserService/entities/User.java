package com.user.service.UserService.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "User")
public class User {
	
	@Id
	private String id;
	
	@Column(name="phone")
	private String mobile;
	
	@Column(name = "username")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Transient
   private List<Rating> ratings = new ArrayList<>();
	

}
