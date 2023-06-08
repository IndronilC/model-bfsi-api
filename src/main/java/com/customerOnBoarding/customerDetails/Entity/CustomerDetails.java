package com.customerOnBoarding.customerDetails.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "customer_details", schema = "userdetails")
public class CustomerDetails {

    @Id
    @GeneratedValue(generator = "mySeqGen", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "mySeqGen", sequenceName = "mySeq", initialValue = 10001, allocationSize = 1)
    @Column(name = "customer_id")
    private long customerId;

    @Column(name = "full_name",nullable = false)
    private String fullName;

    @Column(name = "pan_number",nullable = false)
    private String panNumber;

    @Column(name = "phone_number",nullable = false)
    private String phoneNumber;

    @Column(name = "aadhar_number",nullable = false)
    private String aadharNumber;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(name = "dob",nullable = false)
    private String dateOfBirth;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "active",nullable = false)
    private int active;

    @Column(name = "created_by",nullable = false)
    private String createdBy;

    @Column(name = "created_date",nullable = false)
    private String createdDate;

    @Column(name = "updated_by",nullable = false)
    private String updatedBy;

    @Column(name = "updated_date",nullable = false)
    private String updatedDate;

}