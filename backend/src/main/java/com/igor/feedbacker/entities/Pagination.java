package com.igor.feedbacker.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Pagination implements Serializable {

	private static final long serialVersionUID = 1L;

	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(columnDefinition = "CHAR(32)")
	@Id
	private String id;
	
	private Integer offsete;
	private Integer limite;
	private Integer total;

	@OneToOne(mappedBy = "pagination", cascade = CascadeType.ALL)
	@JsonIgnore
	private Results result;

	public Pagination(String id, Integer offset, Integer limit, Integer total) {
		super();
		this.id = id;
		this.offsete = offset;
		this.limite = limit;
		this.total = total;
	}

}
