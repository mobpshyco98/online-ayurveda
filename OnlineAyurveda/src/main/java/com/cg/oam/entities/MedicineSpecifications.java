package com.cg.oam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="cg_med_spec")
public class MedicineSpecifications {

	@Id
	@Column(name="spec_id")
	@SequenceGenerator(name = "seq1", sequenceName = "cart_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq1")
	private Integer specId;

	@Column(name="spec_name", length=25)
	private String specName;

	@Column(name="spec_value")
	private String specValue;

	@ManyToOne
	@JoinColumn(name = "medicine_id", referencedColumnName = "medicine_id")
	private Medicine medicine;

	public MedicineSpecifications(String specName, String specValue) {
		super();
		this.specName = specName;
		this.specValue = specValue;
	}

	public MedicineSpecifications(String specName, String specValue, Medicine medicine) {
		super();
		this.specName = specName;
		this.specValue = specValue;
		this.medicine = medicine;
	}

	
	public MedicineSpecifications(Integer specId, String specName, String specValue) {
		super();
		this.specId = specId;
		this.specName = specName;
		this.specValue = specValue;
	}

	public Integer getSpecId() {
		return specId;
	}

	public MedicineSpecifications() {
		super();
	}

	public void setSpecId(Integer specId) {
		this.specId = specId;
	}

	public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
	}

	public String getSpecValue() {
		return specValue;
	}

	public void setSpecValue(String specValue) {
		this.specValue = specValue;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}
	
	
}
