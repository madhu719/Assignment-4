package com.terra.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonBackReference;

//@Entity
//@Table(name = "address")
public class Address {
	
	@Id
	//@Column(name="store_id",insertable = true, updatable = false)
    @GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "store"))
	private int storeId;
	private String state;
	private String country;
	private String pinCode;

	
	@OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
//	@MapsId
	//@JoinColumn(name = "store_id")
	//@JsonBackReference
	private Store store;
	
	public Address() {}
	
	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "Address [storeId=" + storeId + ", state=" + state + ", country=" + country + ", pinCode=" + pinCode
				+ ", store=" + store + "]";
	}

	
	
}