package com.dnb.jdbcdemo.demo.dto;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.Length;

import com.dnb.jdbcdemo.demo.utils.CustomAccountIdGenerator;
import com.dnb.jdbcdemo.demo.utils.CustomCustomerIdGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Customer {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
//creates instance of generator and calls generator
//@GenericGenerator(name = "customer_seq" , strategy= "com.dnb.jdbcdemo.demo.utils.CustomCustomerIdGenerator", 
//	parameters = {@Parameter(name=CustomCustomerIdGenerator.INCREMENT_PARAM,value="5"),
//			@Parameter(name= CustomCustomerIdGenerator.VALUE_PREFIX_PARAMETER, value="cust_"), 
//			@Parameter(name=CustomCustomerIdGenerator.NUMBER_FORMAT_PARAMETER, value="%05d")} )
@Column private int customerId;
@NotBlank(message = "account holder name should not be blank")
@Column private String customerName;
@Length(min=10,max=10)
@Column private String customerContactNumber;
@Column private String customeraddress;
@NotNull
@Column private String customerPAN;
@Column private String customerUUID;

}
