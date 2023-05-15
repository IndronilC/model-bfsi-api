package com.customerOnBoarding.customerDetails.Service;

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
    public Status customerOnBoarding(CustomerDetails customerDetailsDto) {
        Optional<CustomerDetails> getPanByCustomerId = Optional.ofNullable(customerDetailsRepo.findUserByPanNumber(customerDetailsDto.getPanNumber()));


        try {
            if (getPanByCustomerId.isEmpty()) {

                CustomerDetails customerDetails = this.customerDetailsDtoToCustomerDetails(customerDetailsDto);

                customerDetailsRepo.save(customerDetails);

                accountStatus.setStatus("Success");
                accountStatus.setStatusMessage("Account created successfully");
            } else {
                accountStatus.setStatus("failure");
                accountStatus.setStatusMessage("Aadhaar number ia already exist");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return accountStatus;
    }

    //modelMapper for postMethod for customerOnBoarding
    public CustomerDetails customerDetailsDtoToCustomerDetails(CustomerDetails customerDetailsDto) {
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
    public Status deleteCustomerById(Long customerId) {
        if (isAccountExist(customerId)) {
            customerDetailsRepo.deleteById(customerId);

            accountStatus.setStatus("Success");
            accountStatus.setStatusMessage("Account with customerId:" + customerId + " " + "is deleted");
        } else {
            accountStatus.setStatus("failure");
            accountStatus.setStatusMessage("Account with customerId:" + customerId + " " + "doesn't exist");
        }


        return accountStatus;
    }

    //method to update a customerDetails by customerId
    public CustomerDetails updateCustomerDetails(CustomerDetails customerDetails, Long customerId) {

        CustomerDetails existingCustomer = customerDetailsRepo.findById(customerId).orElse(null);


        existingCustomer.setFullName(customerDetails.getFullName());
        existingCustomer.setPanNumber(customerDetails.getPanNumber());
        existingCustomer.setPhoneNumber(customerDetails.getPhoneNumber());
        existingCustomer.setAadharNumber(customerDetails.getAadharNumber());
        existingCustomer.setAddress(customerDetails.getAddress());
        /* existingCustomer.setDateOfBirth(customerDetails.getDateOfBirth());*/
        existingCustomer.setEmail(customerDetails.getEmail());


        customerDetailsRepo.save(existingCustomer);
        return existingCustomer;

    }

    public boolean isAccountExist(Long customerId) {
        boolean isExist = false;
        CustomerDetails customerDetails;
        try {
            customerDetails = customerDetailsRepo.findByCustomerId(customerId).orElse(null);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (customerDetails != null) {
            isExist = true;
        }
        return isExist;
    }


}
