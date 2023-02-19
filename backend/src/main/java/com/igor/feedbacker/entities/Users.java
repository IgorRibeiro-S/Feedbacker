package com.igor.feedbacker.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

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
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	private String name;
	private String email;
	private String password;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID apiKey;
	
	private LocalDateTime createdAt;

	public Users(String name, String email, String password) {

		this.name = name;
		this.email = email;
		this.password = password;
		this.createdAt = LocalDateTime.now();
	}
	
	
	
}
