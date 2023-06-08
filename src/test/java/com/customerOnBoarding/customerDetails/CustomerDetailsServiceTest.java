package com.customerOnBoarding.customerDetails;

import com.customerOnBoarding.customerDetails.Entity.CustomerDetails;
import com.customerOnBoarding.customerDetails.Repository.CustomerDetailsRepo;
import com.customerOnBoarding.customerDetails.Service.CustomerDetailsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerDetailsServiceTest {

    @Mock
    private CustomerDetailsRepo customerDetailsRepo;

    @InjectMocks
    private CustomerDetailsService customerDetailsService;

    private CustomerDetails buildTestingCustomer() {
        CustomerDetails customerDetails = CustomerDetails.builder()
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
        return customerDetails;
    }


    @Test
    public void getAllCustomersDetailsTest(){
        CustomerDetails customerDetails = this.buildTestingCustomer();

        //when calling the mocked repository method
        when(customerDetailsRepo.findAll()).thenReturn(List.of(customerDetails));
        List<CustomerDetails> getCustomerDetails = this.customerDetailsService.getAllCustomerDetails();

        //Then
        assertEquals(List.of(customerDetails),getCustomerDetails);
        verify(this.customerDetailsRepo).findAll();
    }

        @Test
        public void getCusomerDetailsByIdTest(){
            CustomerDetails customerDetails = this.buildTestingCustomer();

            //when
            when(customerDetailsRepo.findById(1L)).thenReturn(Optional.of(customerDetails));
             Optional<CustomerDetails> returnedEmployee = customerDetailsService.getCustomerByCustomerId(1L);

            //Then
           assertEquals(customerDetails.getCustomerId(),returnedEmployee.get().getCustomerId());
            verify(this.customerDetailsRepo).findById(1L);
        }

    @Test
    public void createCustomerTest(){
        CustomerDetails customerDetails = this.buildTestingCustomer();

        this.customerDetailsService.customerOnBoarding(customerDetails);

        verify(this.customerDetailsRepo).save(customerDetails);
    }

    @Test
    public void deleteById(){
        this.customerDetailsService.deleteCustomerById(1L);
    }
}
