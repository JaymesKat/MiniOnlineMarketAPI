package edu.miu.cs545.group1.MiniOnlineMarket.service;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.Address;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.Product;

import java.util.List;

public interface AddressService {
    public List<Address> findAll();
    Address findById(Long id);
    void updateAddress(Long id, Address address);
    void deleteAddress(Long id);
}
