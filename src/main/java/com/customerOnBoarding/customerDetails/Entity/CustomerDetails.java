package com.customerOnBoarding.customerDetails.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "customer_details", schema = "userdetails")
public class CustomerDetails {

    @Id
    @GeneratedValue(generator = "mySeqGen", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "mySeqGen", sequenceName = "mySeq", initialValue = 10001, allocationSize = 1)
    @Column(name = "customer_id")
    private long customerId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "pan_number")
    private String panNumber;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "aadhar_number")
    private String aadharNumber;

    @Column(name = "address")
    private String address;


    @Column(name = "email")
    private String email;

    @Column(name = "active")
    private int active;

    @Column(name = "address_proof")
    private String addressProof;

    @Column(name = "address_proof_type")
    private String addressProofType;

    @Column(name = "id_proof")
    private String idProof;

    @Column(name = "id_proof_type")
    private String idProofType;

    @Column(name = "security_question_answer")
    private String securityQuestionsAnswer;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private String createdDate;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_date")
    private String updatedDate;

}