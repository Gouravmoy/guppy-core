package com.guppy.endpoint.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "metadata")
@Data
@NoArgsConstructor
public class Metadata {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "metadata", columnDefinition = "TEXT")
	String metadata;

	public Metadata(String metadata) {
		this.metadata = metadata;
	}

}
