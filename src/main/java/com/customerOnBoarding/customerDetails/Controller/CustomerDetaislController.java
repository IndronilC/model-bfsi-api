package com.customerOnBoarding.customerDetails.Controller;


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
public class CustomerDetaislController {

    @Autowired
     CustomerDetailsService customerDetailsService;

    @RequestMapping( value = {"/createCustomer"} ,method=RequestMethod.POST)
    public Status viewCustomer(@RequestBody CustomerDetails customerDetails){
       return customerDetailsService.customerOnBoarding(customerDetails);


    }


    @RequestMapping(value = {"/id"},method = RequestMethod.GET)
    public Optional<CustomerDetails> getById(@RequestBody CustomerDetails customerDetails){
        return customerDetailsService.getCustomerByCustomerId(customerDetails.getCustomerId());

    }

    @RequestMapping(value = {"/allCustomerDetails"},method = RequestMethod.GET)
    public List<CustomerDetails> getAllCustomerDetails(){
        return customerDetailsService.getAllCustomerDetails();
    }

    @RequestMapping(value = {"/deleteCustomerBy/{id}"}, method=RequestMethod.DELETE)
    public Status deleteCustomerById(@PathVariable("id") Long customerId){

        return customerDetailsService.deleteCustomerById(customerId);
    }

    @RequestMapping(value = {"/customerDetails/{id}"})
    public CustomerDetails updateCustomerDetailsById( @RequestBody  CustomerDetails customerDetails,
                                                      @PathVariable("id") Long customerId){
        return customerDetailsService.updateCustomerDetails(customerDetails,customerId);//.getBody();
    }


}
