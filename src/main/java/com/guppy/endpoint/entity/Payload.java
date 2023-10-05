package com.guppy.endpoint.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payload")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payload {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "payload", nullable = false, columnDefinition = "TEXT")
	String payload;
	
	public Payload(String payload) {
		this.payload=payload;
	}

}
