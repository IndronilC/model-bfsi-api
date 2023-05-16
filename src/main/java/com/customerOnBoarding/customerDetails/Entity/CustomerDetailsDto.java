package com.customerOnBoarding.customerDetails.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDetailsDto {

    private long customerId;

    private String fullName;

    private String panNumber;

    private String phoneNumber;

    private String aadharNumber;

    private String address;


    private String email;

    private int active;


}
