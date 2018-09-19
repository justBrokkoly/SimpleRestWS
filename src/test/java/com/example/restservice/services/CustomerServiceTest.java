package com.example.restservice.services;

import com.example.restservice.api.v1.model.CustomerDTO;
import com.example.restservice.api.v1.model.api.v1.mapper.CustomerMapper;
import com.example.restservice.domain.Customer;
import com.example.restservice.repositories.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CustomerServiceTest {

    CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;

    @Before
    public void setUp() throws Exception{

        MockitoAnnotations.initMocks(this);
        customerService = new CustomerServiceImpl(CustomerMapper.INSTANCE, customerRepository);

    }

    @Test
    public void getAllCustomersTest() throws Exception{

        List<Customer> customers = Arrays.asList(new Customer(),new Customer());

        when(customerRepository.findAll()).thenReturn(customers);

        List<CustomerDTO> customerDTOS = customerService.getAllCustomers();

        assertEquals(2,customerDTOS.size());

    }

    @Test
    public void getCustomerByIdTest(){

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setLastName("Pff");

        when(customerRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(customer));

        CustomerDTO customerDTO = customerService.getCustomerById(1L);

        assertEquals("Pff",customerDTO.getLastName());


    }

    @Test
    public void createNewCustomer() throws Exception{

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName("Jim");

        Customer savedCustomer = new Customer();
        savedCustomer.setFirstName(customerDTO.getFirstName());
        savedCustomer.setLastName(customerDTO.getLastName());
        savedCustomer.setId(1L);

        when(customerRepository.save(any(Customer.class))).thenReturn(savedCustomer);

        CustomerDTO savedDTO = customerService.createNewCustomer(customerDTO);

        assertEquals(customerDTO.getFirstName(), savedDTO.getFirstName());
        assertEquals("/api/v1/customer/1", savedDTO.getCustomerUrl());

    }

    @Test
    public void saveCustomerById() throws Exception{

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName("Jim");

        Customer savedCustomer = new Customer();
        savedCustomer.setFirstName(customerDTO.getFirstName());
        savedCustomer.setLastName(customerDTO.getLastName());
        savedCustomer.setId(1L);

        when(customerRepository.save(any(Customer.class))).thenReturn(savedCustomer);

        CustomerDTO savedDTO = customerService.saveCustomerById(1L,customerDTO);
        assertEquals(customerDTO.getFirstName(), savedDTO.getFirstName());
        assertEquals("/api/v1/customer/1", savedDTO.getCustomerUrl());
    }

    @Test
    public void deleteCustomerById(){
        Long id = 1L;

        customerRepository.deleteById(id);

        verify(customerRepository, times(1)).deleteById(anyLong());
    }



}
