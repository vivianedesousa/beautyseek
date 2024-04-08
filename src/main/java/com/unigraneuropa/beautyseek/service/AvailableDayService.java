package com.unigraneuropa.beautyseek.service;
import com.unigraneuropa.beautyseek.exception.RegisterNotFoundException;
import com.unigraneuropa.beautyseek.model.AvailableDay;
import com.unigraneuropa.beautyseek.model.User;
import com.unigraneuropa.beautyseek.repository.AvailableDayRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java .util.Optional;
import java.util.List;
@Service
public class AvailableDayService {
    private final AvailableDayRepository availableDayRepository;

    public AvailableDayService(AvailableDayRepository availableDayRepository) {
        this.availableDayRepository = availableDayRepository;
    }
    public List<AvailableDay> getAllAvailableDays(){
        List<AvailableDay> availableDayList = new ArrayList();
        availableDayList.addAll(availableDayRepository.findAll());// adcionando dentro da lista
        return availableDayList;

    }
    public AvailableDay getAvailableDayById(Integer Id) throws RegisterNotFoundException {
        Optional<AvailableDay> validavailableDay = availableDayRepository.findById(Id);
        if(validavailableDay.isPresent()){//se exite or  nao
            return validavailableDay.get();
        }else{
            throw new RegisterNotFoundException();
        }
    }
    public   AvailableDay createAvailableDay( AvailableDay availableDay){
        return availableDayRepository.save(availableDay);
    }

    public  AvailableDay updateAvailableDay(Integer id, AvailableDay availableDay) throws RegisterNotFoundException {
        if(availableDayRepository.existsById(id)){
            availableDay.setId(id);
            return availableDayRepository.save(availableDay);
        }else{
         throw new RegisterNotFoundException();
        }
    }

    public boolean deleteAvailableDay(Integer id){
        if(availableDayRepository.existsById(id)){
            availableDayRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
