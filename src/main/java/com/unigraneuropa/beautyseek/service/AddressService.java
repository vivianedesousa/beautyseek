package com.unigraneuropa.beautyseek.service;
import com.unigraneuropa.beautyseek.exception.RegisterNotFoundException;
import com.unigraneuropa.beautyseek.model.Address;
import com.unigraneuropa.beautyseek.model.User;
import com.unigraneuropa.beautyseek.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
    public List<Address> getAllAddresses(){
        List<Address> addressList = new ArrayList();
        addressList.addAll(addressRepository.findAll());
        return addressList;
    }

    public Address getAddressById(Integer Id) throws RegisterNotFoundException {
        Optional<Address> validAddress= addressRepository.findById(Id);
        if(validAddress.isPresent()){
            return validAddress.get();
        }else{
            throw new RegisterNotFoundException();
        }
    }

    public Address createAddress (Address address){
        return addressRepository.save(address);
    }
    public Address updateAddress (Integer id,Address address) throws RegisterNotFoundException {
        if(addressRepository.existsById(id)){
            address.setId(id);// estamos colocando id dentro User
            return addressRepository.save(address);
        }else{
            throw new RegisterNotFoundException();
        }
    }

    public boolean deleteAddress (Integer id){
        if(addressRepository.existsById(id)){
            addressRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
