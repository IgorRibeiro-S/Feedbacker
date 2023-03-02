package com.igor.feedbacker.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.igor.feedbacker.utils.RandomString;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ToString
@NoArgsConstructor
@Setter
@EqualsAndHashCode
@Getter
@Entity
@Table(name="users")
public class Users implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(columnDefinition = "CHAR(32)")
	@Id
	private String id;
	
	private String name;
	private String email;
	private String password;
	
	@Column(name = "u_roles")
	private String roles;
	private String apiKey;
	
	private LocalDateTime createdAt;

	public Users(String name, String email, String password, String roles) {

		this.name = name;
		this.email = email;
		this.password = password;
		this.createdAt = LocalDateTime.now();
		this.apiKey = RandomString.getAlphaNumericString(30);
		this.roles = roles; 
	}
	
	
	
}
