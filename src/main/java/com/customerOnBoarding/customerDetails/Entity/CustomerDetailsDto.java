package com.customerOnBoarding.customerDetails.Entity;

import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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

    private Date dateOfBirth;

    private String email;

    private int active;

    private String addressProof;

    private String addressProofType;

    private String idProof;

    private String idProofType;

    private String createdBy;

    private Date createdDate;

    private String updatedBy;

    private Date updatedDate;


}
