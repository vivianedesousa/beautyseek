package com.unigraneuropa.beautyseek.service;
import com.unigraneuropa.beautyseek.exception.RegisterNotFoundException;
import com.unigraneuropa.beautyseek.model.ServiceOffered;
import com.unigraneuropa.beautyseek.repository.ServiceOfferedRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;
import java.util.List;
@Service
public class ServiceOfferedService {
    private final ServiceOfferedRepository serviceOfferedRepository;
    // construtor
    public ServiceOfferedService(ServiceOfferedRepository serviceOfferedRepository) {
        this.serviceOfferedRepository = serviceOfferedRepository;
    }

    public List<ServiceOffered> getAllServiceOffered(){//
        List<ServiceOffered> serviceOfferedList = new ArrayList();
        serviceOfferedList.addAll(serviceOfferedRepository.findAll());
        return  serviceOfferedList;
    }

    public ServiceOffered getServiceOfferedById(Integer id) throws RegisterNotFoundException {
        Optional< ServiceOffered> validServiceOffered = serviceOfferedRepository.findById(id);
        if(validServiceOffered.isPresent()){
            return validServiceOffered.get();
        }else{
            throw new RegisterNotFoundException();
        }
    }

    public ServiceOffered  createServiceOffered(ServiceOffered  serviceOffered ){
        return serviceOfferedRepository.save(serviceOffered);
    }

    public ServiceOffered updateServiceOffered(Integer id,ServiceOffered serviceOffered)
        throws RegisterNotFoundException {
        if(serviceOfferedRepository.existsById(id)){
            serviceOffered.setId(id);
            return serviceOfferedRepository.save(serviceOffered);
        }else{
            throw new RegisterNotFoundException();
        }
    }
    public boolean deleteServiceOffered (Integer id){
        if(serviceOfferedRepository.existsById(id)){
            serviceOfferedRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
