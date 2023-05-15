package com.customerOnBoarding.customerDetails.Service;

import com.customerOnBoarding.customerDetails.Entity.Status;
import com.customerOnBoarding.customerDetails.Entity.CustomerDetails;
import com.customerOnBoarding.customerDetails.Repository.CustomerDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerDetailsService {

    @Autowired
    CustomerDetailsRepo customerDetailsRepo;

    @Autowired
    Status accountStatus;

    //method to create onboard a customer with details
    public Status customerOnBoarding(CustomerDetails customerDetailsInput) {
        Optional<CustomerDetails> getPanByCustomerId = Optional.ofNullable(customerDetailsRepo.findUserByPanNumber(customerDetailsInput.getPanNumber()));


        try {
            if (!getPanByCustomerId.isPresent()) {

                CustomerDetails customerDetails = new CustomerDetails();

                customerDetails.setFullName(customerDetailsInput.getFullName());
                customerDetails.setPhoneNumber(customerDetailsInput.getPhoneNumber());
                customerDetails.setPanNumber(customerDetailsInput.getPanNumber());
                customerDetails.setAadharNumber(customerDetailsInput.getAadharNumber());
                customerDetails.setAddress(customerDetailsInput.getAddress());
                customerDetails.setEmail(customerDetailsInput.getEmail());
                customerDetails.setActive(customerDetailsInput.getActive());
                customerDetails.setAddressProof(customerDetailsInput.getAddressProof());
                customerDetails.setAddressProofType(customerDetailsInput.getAddressProofType());
                customerDetails.setIdProof(customerDetailsInput.getIdProof());
                customerDetails.setIdProofType(customerDetailsInput.getIdProofType());
                customerDetails.setCreatedBy(customerDetailsInput.getCreatedBy());
                customerDetails.setCreatedDate(customerDetailsInput.getCreatedDate());
                customerDetails.setUpdatedBy(customerDetailsInput.getUpdatedBy());
                customerDetails.setUpdatedDate(customerDetailsInput.getUpdatedDate());

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
        if (isAccountExsist(customerId)) {
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
        CustomerDetails exsistingCustomer = customerDetailsRepo.findById(customerId).orElse(null);

        exsistingCustomer.setFullName(customerDetails.getFullName());
        exsistingCustomer.setPanNumber(customerDetails.getPanNumber());
        exsistingCustomer.setPhoneNumber(customerDetails.getPhoneNumber());
        exsistingCustomer.setAadharNumber(customerDetails.getAadharNumber());
        exsistingCustomer.setAddress(customerDetails.getAddress());
        exsistingCustomer.setDateOfBirth(customerDetails.getDateOfBirth());
        exsistingCustomer.setEmail(customerDetails.getEmail());
        customerDetailsRepo.save(exsistingCustomer);
        return exsistingCustomer;


    }

    public boolean isAccountExsist(Long customerId) {
        boolean isExsist = false;
        CustomerDetails customerDetails;
        try {
            customerDetails = customerDetailsRepo.findByCustomerId(customerId).orElse(null);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (customerDetails != null) {
            isExsist = true;
        }
        return isExsist;
    }


}
