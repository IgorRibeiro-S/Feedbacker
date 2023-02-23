package com.igor.feedbacker.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

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
@Table(name = "feedbacks")
public class Feedbacks implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(columnDefinition = "CHAR(32)")
	@Id
	private String id;
	private String type;
	private String text;
	private String fingerprint;
	private String apiKey;
	private String device;
	private String page;
	
	public Feedbacks(String type, String text, String fingerprint, String apiKey, String device, String page) {
		this.type = type;
		this.text = text;
		this.fingerprint = fingerprint;
		this.apiKey = apiKey;
		this.device = device;
		this.page = page;
	}

	
}
