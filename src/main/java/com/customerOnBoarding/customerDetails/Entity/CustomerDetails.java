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

    @Column(name = "dob")
    private String dateOfBirth;

    @Column(name = "email")
    private String email;


   @Column(name = "active")
    private int active;

    @Column(name = "adress_proof")
    private String addressProof;

    @Column(name = "adress_proof_type")
    private String addressProofType;

    @Column(name = "id_proof")
    private String idProof;

    @Column(name = "id_proof_type")
    private String idProofType;

  /*  @Column(name = "security_questions_id")
    private int securityQuestoinsid;
*/
    @Column(name = "security_questyion_answer")
    private String securityQuestionsAnswer;

    @Column(name = "created_by")
    private String createdBy;


    @Column(name = "created_date")
    private String createdDate;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_date")
    private String updatedDate;



    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getAddressProof() {
        return addressProof;
    }

    public void setAddressProof(String addressProof) {
        this.addressProof = addressProof;
    }

    public String getAddressProofType() {
        return addressProofType;
    }

    public void setAddressProofType(String addressProofType) {
        this.addressProofType = addressProofType;
    }

    public String getIdProof() {
        return idProof;
    }

    public void setIdProof(String idProof) {
        this.idProof = idProof;
    }

    public String getIdProofType() {
        return idProofType;
    }

    public void setIdProofType(String idProofType) {
        this.idProofType = idProofType;
    }

   /* public int getSecurityQuestoinsid() {
        return securityQuestoinsid;
    }

    public void setSecurityQuestoinsid(int securityQuestoinsid) {
        this.securityQuestoinsid = securityQuestoinsid;
    }*/

    public String getSecurityQuestionsAnswer() {
        return securityQuestionsAnswer;
    }

    public void setSecurityQuestionsAnswer(String securityQuestionsAnswer) {
        this.securityQuestionsAnswer = securityQuestionsAnswer;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }




    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void  builder() {
    }
}
