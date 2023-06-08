package com.customerOnBoarding.customerDetails.Repository;

import com.customerOnBoarding.customerDetails.Entity.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerDetailsRepo extends JpaRepository<CustomerDetails,Long> {


    CustomerDetails findUserByPanNumber(String panNumber);

    //Optional<CustomerDetails> findByCustomerId(Long customerId);
}
