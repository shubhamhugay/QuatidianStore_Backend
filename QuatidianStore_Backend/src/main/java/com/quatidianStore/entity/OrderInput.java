package com.quatidianStore.entity;

import java.util.List;

public class OrderInput {

	private String fullName;
	private String fullAddress;
	private String contactNumber;
	private String alternateContactNumber;
	
    private List<OrderProductQuantity> orderProductQuantityList;
    
    

	

	public OrderInput() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderInput(String fullName, String fullAddress, String contactNumber, String alternateContactNumber,
			List<OrderProductQuantity> orderProductQuantityList) {
		super();
		this.fullName = fullName;
		this.fullAddress = fullAddress;
		this.contactNumber = contactNumber;
		this.alternateContactNumber = alternateContactNumber;
		this.orderProductQuantityList = orderProductQuantityList;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAlternateContactNumber() {
		return alternateContactNumber;
	}

	public void setAlternateContactNumber(String alternateContactNumber) {
		this.alternateContactNumber = alternateContactNumber;
	}

	public List<OrderProductQuantity> getOrderProductQuantityList() {
		return this.orderProductQuantityList;
	}

	public void setOrderProductQuantityList(List<OrderProductQuantity> orderProductQuantityList) {
		this.orderProductQuantityList = orderProductQuantityList;
	}

    
    
	

	
	
}
