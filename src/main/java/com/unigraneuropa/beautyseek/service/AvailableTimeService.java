package com.unigraneuropa.beautyseek.service;
import com.unigraneuropa.beautyseek.exception.RegisterNotFoundException;
import com.unigraneuropa.beautyseek.model.AvailableTime;
import com.unigraneuropa.beautyseek.model.Client;
import com.unigraneuropa.beautyseek.model.User;
import com.unigraneuropa.beautyseek.repository.AvailableTimeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AvailableTimeService {
    private final AvailableTimeRepository availableTimeRepository;

    public AvailableTimeService(AvailableTimeRepository availableTimeRepository) {
        this.availableTimeRepository = availableTimeRepository;
    }

    public List <AvailableTime> getAllAvailableTimes(){
        List<AvailableTime> availableTimeList = new ArrayList();
        availableTimeList.addAll(availableTimeRepository.findAll());
        return availableTimeList;
    }

    public AvailableTime getAvailableTimeById(Integer Id) throws RegisterNotFoundException {
        Optional<AvailableTime> validAvailableTime = availableTimeRepository.findById(Id);
        if(validAvailableTime.isPresent()){
            return validAvailableTime.get();
        }else{
            throw new RegisterNotFoundException();
        }
    }
    public  AvailableTime createAvailableTime (AvailableTime availableTime ){
      return availableTimeRepository.save(availableTime);
    }

    public AvailableTime  updateAvailableTime  (Integer id,AvailableTime availableTime ) throws RegisterNotFoundException {
        if(availableTimeRepository.existsById(id)){
            availableTime.setId(id);// estamos colocando id dentro User
            return availableTimeRepository.save(availableTime);
        }else{
            throw new RegisterNotFoundException();
        }
    }

    public boolean deleteAvailableTime (Integer id){
        if(availableTimeRepository.existsById(id)){
            availableTimeRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
