package com.customerOnBoarding.customerDetails;

import com.customerOnBoarding.customerDetails.Entity.CustomerDetails;
import com.customerOnBoarding.customerDetails.Repository.CustomerDetailsRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerDetailsRespositoryTest {
    @Autowired
    private   CustomerDetailsRepo customerDetailsRepo;

    private CustomerDetails customerDetails;

    @BeforeEach
    public void setup(){
        // delete the data from customr details table before each test run
        customerDetailsRepo.deleteAll();
        customerDetails = CustomerDetails.builder()
               // .customerId(1L)
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
        //operation we are going to test
        CustomerDetails savedCustomer=customerDetailsRepo.save(customerDetails);

        //then verifying the output
        assertThat(savedCustomer).isNotNull();
        assertThat(savedCustomer.getCustomerId()).isGreaterThan(0);


    }

    @Test
    public void getAllCustomersTest(){
        customerDetailsRepo.save(customerDetails);

        List<CustomerDetails> customerDetailsList = customerDetailsRepo.findAll();
        assertThat(customerDetailsList).isNotNull();
        assertThat(customerDetailsList.size()).isEqualTo(1);
    }
}
