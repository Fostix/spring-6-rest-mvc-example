package learn.springframework.spring6restmvc.services;

import learn.springframework.spring6restmvc.model.CustomerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
    Optional<CustomerDTO> getCustomerById(UUID customerId);
    CustomerDTO saveNewCustomer(CustomerDTO customer);
    Optional<CustomerDTO> updateCustomerById(UUID customerId, CustomerDTO customer);
    Boolean deleteCustomerById(UUID customerId);
    Optional<CustomerDTO> patchCustomerById(UUID customerId, CustomerDTO customer);

}
