package com.cg.oam.entities;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class MedicineSpecifications {

	@Id
	private Integer specId;

	private String specName;

	private String specValue;

	@ManyToOne()
	@JoinColumn(name = "medicine_id", referencedColumnName = "medicine_id")
	private Medicine medicine;
}
