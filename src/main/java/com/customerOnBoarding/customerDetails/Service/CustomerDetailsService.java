package com.customerOnBoarding.customerDetails.Service;

import com.customerOnBoarding.customerDetails.Entity.CustomerDetailsDto;
import com.customerOnBoarding.customerDetails.Entity.Status;
import com.customerOnBoarding.customerDetails.Entity.CustomerDetails;
import com.customerOnBoarding.customerDetails.Repository.CustomerDetailsRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerDetailsService {

    @Autowired
    CustomerDetailsRepo customerDetailsRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    Status accountStatus;

    //method to create onboard a customer with details
    public CustomerDetails customerOnBoarding(CustomerDetails customerDetails) {
        //Optional<CustomerDetails> getPanByCustomerId = Optional.ofNullable(customerDetailsRepo.findUserByPanNumber(customerDetails.getPanNumber()));

        try {

            customerDetailsRepo.save(customerDetails);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return customerDetails;
    }

    //modelMapper for postMethod for customerOnBoarding
    public CustomerDetails customerDetailsDtoToCustomerDetails(CustomerDetailsDto customerDetailsDto) {
        CustomerDetails customerDetails = this.modelMapper.map(customerDetailsDto, CustomerDetails.class);
        return customerDetails;

    }

    //method to get customerDetails by customerId
    public Optional<CustomerDetails> getCustomerByCustomerId(Long customerId) {
        return customerDetailsRepo.findById(customerId);
    }


    //method to get all customerDetails
    public List<CustomerDetails> getAllCustomerDetails() {
        return customerDetailsRepo.findAll();
    }

    //method to delete customer by customerId
    public void deleteCustomerById(Long customerId) {

        customerDetailsRepo.deleteById(customerId);

    }

    //method to update a customerDetails by customerId
    public CustomerDetails updateCustomerDetails(CustomerDetails customerDetails, Long customerId) {

        CustomerDetails existingCustomer = customerDetailsRepo.findById(customerId).orElse(null);

        existingCustomer.setFullName(customerDetails.getFullName());
        existingCustomer.setPanNumber(customerDetails.getPanNumber());
        existingCustomer.setPhoneNumber(customerDetails.getPhoneNumber());
        existingCustomer.setAadharNumber(customerDetails.getAadharNumber());
        existingCustomer.setAddress(customerDetails.getAddress());
        existingCustomer.setEmail(customerDetails.getEmail());


        customerDetailsRepo.save(existingCustomer);
        return existingCustomer;

    }




}
