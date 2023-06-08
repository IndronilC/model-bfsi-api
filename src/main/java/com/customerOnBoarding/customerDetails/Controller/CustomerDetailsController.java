package com.customerOnBoarding.customerDetails.Controller;


import com.customerOnBoarding.customerDetails.Entity.CustomerDetailsDto;
import com.customerOnBoarding.customerDetails.Entity.Status;
import com.customerOnBoarding.customerDetails.Entity.CustomerDetails;
import com.customerOnBoarding.customerDetails.Service.CustomerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/customer")
public class CustomerDetailsController {

    @Autowired
    CustomerDetailsService customerDetailsService;

    @PostMapping(value = {"/createCustomer"} /*,method=RequestMethod.POST*/)
    public CustomerDetails viewCustomer(@RequestBody CustomerDetails customerDetails) {
        return customerDetailsService.customerOnBoarding(customerDetails);

    }

    @GetMapping(value = {"/id"}/*,method = RequestMethod.GET*/)
    public Optional<CustomerDetails> getById(@PathVariable Long customerId) {
        return customerDetailsService.getCustomerByCustomerId(customerId);

    }

    @GetMapping(value = {"/allCustomerDetails"}/*,method = RequestMethod.GET*/)
    public List<CustomerDetails> getAllCustomerDetails() {
        return customerDetailsService.getAllCustomerDetails();
    }

    @DeleteMapping(value = {"/deleteCustomerBy/{id}"}/*, method=RequestMethod.DELETE*/)
    public void deleteCustomerById(@PathVariable Long customerId) {

        customerDetailsService.deleteCustomerById(customerId);
    }

    @PutMapping(value = {"/customerDetails/{id}"})
    public CustomerDetails updateCustomerDetailsById(@RequestBody CustomerDetails customerDetails,
                                                     @PathVariable("id") Long customerId) {
        return customerDetailsService.updateCustomerDetails(customerDetails, customerId);//.getBody();
    }


}
