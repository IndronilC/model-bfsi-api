package com.customerOnBoarding.customerDetails;

import com.customerOnBoarding.customerDetails.Entity.CustomerDetails;
import com.customerOnBoarding.customerDetails.Repository.CustomerDetailsRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;


@DataJpaTest
public class CustomerDetailsRespositoryTest {
    @Autowired
    private   CustomerDetailsRepo customerDetailsRepo;

    private CustomerDetails customerDetails;

    @BeforeEach
    public void setup(){
        customerDetails = CustomerDetails.builder()
                .customerId(1L)
                .fullName("damodharReddy")
                .panNumber("BWYPC3344A")
                .phoneNumber("9121696362")
                .aadharNumber("123412341234")
                .address("chennai")
                .dateOfBirth("08-09-2000")
                .email("damodharreddychintu15@gmail.com")
                .active(1)
                .createdBy("damodhar")
                .createdDate("01-06-2023")
                .updatedBy("damodhar")
                .updatedDate("07-06-2023")
                .build();

    }


    @Test
    public void customerOnboarding_test(){
        CustomerDetails customerDetails1 = CustomerDetails.builder()
                .customerId(2L)
                .fullName("shambhavi")
                .panNumber("BWYPC3344B")
                .phoneNumber("9121696363")
                .aadharNumber("123412341235")
                .address("mysore")
                .dateOfBirth("08-09-2001")
                .email("shambu@gmail.com")
                .active(1)
                .createdBy("shambu")
                .createdDate("01-05-2023")
                .updatedBy("shambu")
                .updatedDate("07-06-2023")
                .build();

        //operation we are going to test
        CustomerDetails savedCustomer=customerDetailsRepo.save(customerDetails1);

        //then verifying the output
        assertThat(savedCustomer).isNotNull();
        assertThat(savedCustomer.getCustomerId()).isGreaterThan(0);


    }

    @Test
    public void getAllCustomersTest(){
        CustomerDetails customerDetails1 = CustomerDetails.builder()
                .customerId(2L)
                .fullName("shambhavi")
                .panNumber("BWYPC3344B")
                .phoneNumber("9121696363")
                .aadharNumber("123412341235")
                .address("mysore")
                .dateOfBirth("08-09-2001")
                .email("shambu@gmail.com")
                .active(1)
                .createdBy("shambu")
                .createdDate("01-05-2023")
                .updatedBy("shambu")
                .updatedDate("07-06-2023")
                .build();
        //customerDetailsRepo.save(customerDetails);
        customerDetailsRepo.save(customerDetails1);

        List<CustomerDetails> customerDetailsList = customerDetailsRepo.findAll();
        assertThat(customerDetailsList).isNotNull();
        assertThat(customerDetailsList.size()).isEqualTo(1);
    }
}
