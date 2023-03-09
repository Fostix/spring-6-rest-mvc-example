package learn.springframework.spring6restmvc.services;

import learn.springframework.spring6restmvc.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerById(UUID customerId);
    Customer saveNewCustomer(Customer customer);
    void updateCustomerById(UUID customerId, Customer customer);
    void deleteCustomerById(UUID customerId);
    void patchCustomerById(UUID customerId, Customer customer);

}
