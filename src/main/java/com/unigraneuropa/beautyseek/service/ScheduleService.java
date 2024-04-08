package com.unigraneuropa.beautyseek.service;
import com.unigraneuropa.beautyseek.exception.RegisterNotFoundException;
import com.unigraneuropa.beautyseek.model.Schedule;
import com.unigraneuropa.beautyseek.model.User;
import com.unigraneuropa.beautyseek.repository.ScheduleRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository; // atributo final em uma classe

    public ScheduleService(ScheduleRepository scheduleRepository) {
       this. scheduleRepository = scheduleRepository;
    }
    // os metodos do CRUD

    public List<Schedule> getAllSchedules(){
        List<Schedule> scheduleList = new ArrayList();
        scheduleList.addAll(scheduleRepository.findAll());// adcionando dentro da lista
        return scheduleList;

    }

    public Schedule getScheduleById(Integer id) throws RegisterNotFoundException {
        Optional<Schedule> validSchedule =  scheduleRepository.findById(id);
        if(validSchedule.isPresent()){
            return validSchedule.get();
        }else{
            throw new RegisterNotFoundException();
        }
    }
    public Schedule createSchedule(Schedule schedule){
        return scheduleRepository.save(schedule);
    }

    public  Schedule updateSchedule (Integer id,Schedule schedule) throws RegisterNotFoundException {
        if(scheduleRepository.existsById(id)){
            schedule.setId(id);// estamos colocando id dentro User
            return scheduleRepository.save(schedule);
        }else{
            throw new RegisterNotFoundException();
        }
    }
    public boolean deleteSchedule (Integer id){
        if(scheduleRepository.existsById(id)){
            scheduleRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }


}
