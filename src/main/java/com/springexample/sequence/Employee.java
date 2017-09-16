package com.springexample.sequence;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Employee {
	private String firstName;
	private String lastName;
	
	@Autowired
	@Qualifier("addrr1")
	private Address addr;
	
	public Employee() {
	}
	
	
	public Employee(String firstName, String lastName, Address addr) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.addr = addr;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Address getAddr() {
		return addr;
	}
/*	@Autowired
	public void setAddr(Address addr) {
		this.addr = addr;
	}*/
	
/*	@Resource(name = "addr")
	public void setAddr(Address addr) {
		this.addr = addr;
	}*/
	
	public void setAddr(Address addr) {
		this.addr = addr;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addr == null) ? 0 : addr.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (addr == null) {
			if (other.addr != null)
				return false;
		} else if (!addr.equals(other.addr))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	
	
	
	
}
