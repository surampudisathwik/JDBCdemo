package com.dnb.jdbcdemo.demo.dto;

import java.time.LocalDate;
import java.util.regex.Pattern;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.Length;

import com.dnb.jdbcdemo.demo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.demo.exceptions.InvalidAccTypeException;
import com.dnb.jdbcdemo.demo.exceptions.InvalidContactException;
import com.dnb.jdbcdemo.demo.exceptions.InvalidNameException;
import com.dnb.jdbcdemo.demo.utils.CustomAccountIdGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@ToString(exclude = "customer")
@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//creates instance of generator and calls generator
	@GenericGenerator(name = "account_seq" , strategy= "com.dnb.jdbcdemo.demo.utils.CustomAccountIdGenerator", 
		parameters = {@Parameter(name=CustomAccountIdGenerator.INCREMENT_PARAM,value="50"),
				@Parameter(name= CustomAccountIdGenerator.VALUE_PREFIX_PARAMETER, value="A_"), 
				@Parameter(name=CustomAccountIdGenerator.NUMBER_FORMAT_PARAMETER, value="%05d")} )
	@Column private int accountId;
	@NotBlank(message = "account holder name should not be blank")
	@Column(nullable=false) private String accountHolderName;
	@Column private String accountType;
	@Min(value=0,message= "Value should not be negative")
	@Column private float balance;
	
//	public Account(@NotBlank(message = "account holder name should not be blank") String accountHolderName,
//			String accountType, @Min(value = 0, message = "Value should not be negative") float balance,
//			String contactNumber, String address, LocalDate accountCreatedDate, LocalDate dob, boolean accountStatus) {
//		super();
//		this.accountHolderName = accountHolderName;
//		this.accountType = accountType;
//		this.balance = balance;
//		this.contactNumber = contactNumber;
//		this.address = address;
//		this.accountCreatedDate = accountCreatedDate;
//		this.dob = dob;
//		this.accountStatus = accountStatus;
//	}
	@Column 
	@Length(min=10,max=10) 
	//@jakarta.validation.constraints.Pattern(regexp = "[0-9]{10}$")
	private String contactNumber;
	@Column private String address;
	@Column private LocalDate accountCreatedDate=LocalDate.now();
	@NotNull
//	@jakarta.validation.constraints.Pattern(regexp = "^(\\d{4})-(\\d{2})-(\\d{2})$")
	@Column  private LocalDate dob;
    @Transient
    private boolean accountStatus;
    @Column private int customerId;
  //  private Customer customer;
}
