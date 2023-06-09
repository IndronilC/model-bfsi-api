package com.customerOnBoarding.customerDetails.Repository;

import com.customerOnBoarding.customerDetails.Entity.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerDetailsRepo extends JpaRepository<CustomerDetails,Long> {


}
