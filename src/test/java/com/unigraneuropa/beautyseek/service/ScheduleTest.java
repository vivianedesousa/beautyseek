package com.unigraneuropa.beautyseek.service;

import com.unigraneuropa.beautyseek.model.Schedule;
import com.unigraneuropa.beautyseek.repository.ScheduleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ScheduleTest {
    @Mock
    private ScheduleRepository scheduleRepository;
    @InjectMocks
    private ScheduleService  scheduleService ;
    @Test
    public void testAllSchedule(){

    }
    @Test
    public void testScheduleById(){

    }
    @Test
    public void testCreateScheduleOffered(){

    }
    @Test
    public void testUpdateSchedule(){

    }
    @Test
    public void testDeleteSchedule(){
    }
}
