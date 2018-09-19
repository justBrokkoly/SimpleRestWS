package com.example.restservice.services;

import com.example.restservice.api.v1.model.api.v1.mapper.CustomerMapper;
import com.example.restservice.bootstrap.Bootstrap;
import com.example.restservice.repositories.CategoryRepository;
import com.example.restservice.repositories.CustomerRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerServiceIT {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CategoryRepository categoryRepository;

    CustomerService customerService;

    @Before
    public void setUp() throws  Exception{

        System.out.println("Loading data");
        System.out.println(customerRepository.findAll().size());

        Bootstrap bootstrap = new Bootstrap(categoryRepository,customerRepository);
        bootstrap.run();

        customerService= new CustomerServiceImpl(CustomerMapper.INSTANCE,customerRepository);

    }


}
