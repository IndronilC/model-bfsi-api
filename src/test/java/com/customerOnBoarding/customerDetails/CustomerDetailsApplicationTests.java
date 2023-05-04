package com.customerOnBoarding.customerDetails;

import com.customerOnBoarding.customerDetails.Entity.CustomerDetails;
import com.customerOnBoarding.customerDetails.Repository.CustomerDetailsRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;





@SpringBootTest
class CustomerDetailsApplicationTests {
	@Autowired
	CustomerDetailsRepo customerDetailsRepo;

    @Test
    public void createCustomerTest() {
       CustomerDetails custDetails = new CustomerDetails();
        custDetails.setFullName("dhamu");
        custDetails.setPhoneNumber("9121696362");
        custDetails.setPanNumber("bwypc3385");
        custDetails.setAadharNumber("8374503811");
        custDetails.setAddress("hyderabad");
        custDetails.setEmail("dhamu@gmail.com");
        custDetails.setActive(1);
        customerDetailsRepo.save(custDetails);
        System.out.println(custDetails.getCustomerId());
        assertNotNull(custDetails.getCustomerId());
    }

	@Test
	public void getAllCustomers(){
		List<CustomerDetails> list = customerDetailsRepo.findAll();
		assertThat(list).size().isGreaterThan(0);

	}

    @Test
    public void getAllCustomersNegative(){
        List<CustomerDetails> list = customerDetailsRepo.findAll();
        System.out.print(list);
        assertFalse(list.size() < 0 );
    }

    @Test
    public void testCustomerById(){
        CustomerDetails customerDetails = customerDetailsRepo.findById(10002L).get();
        assertEquals("moscow",customerDetails.getFullName());
    }



    @Test
    public void testCustomerByIdNegative(){
        CustomerDetails customerDetails = customerDetailsRepo.findById(10002L).get();
        System.out.println(customerDetails.getCustomerId());
        assertFalse(customerDetails.getCustomerId() == 10003L);
    }

    @Test
    public void testCustomerDetailsUpdate(){
        CustomerDetails cDetails= customerDetailsRepo.findById(10002L).get();
        cDetails.setFullName("moscow");
        customerDetailsRepo.save(cDetails);
        assertEquals("moscow",customerDetailsRepo.findById(10002L).get().getFullName());
    }

    @Test
    public void testCustomerDetailsUpdateNegative(){
        CustomerDetails cDetails= customerDetailsRepo.findById(10002L).get();
        assertNotEquals("denver",customerDetailsRepo.findById(10002L).get().getFullName());
    }


    @Test
    public void testCustomerDelete(){
        customerDetailsRepo.deleteById(10001L);
        assertThat(customerDetailsRepo.existsById(10001L)).isTrue();
    }

    @Test
    public void testCustomerDeleteNegative(){
        customerDetailsRepo.deleteById(10000L);
        assertFalse(customerDetailsRepo.existsById(10000L));
    }




}
