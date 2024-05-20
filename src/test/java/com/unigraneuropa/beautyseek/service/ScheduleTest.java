package com.unigraneuropa.beautyseek.service;

import com.unigraneuropa.beautyseek.exception.RegisterNotFoundException;
import com.unigraneuropa.beautyseek.model.Schedule;
import com.unigraneuropa.beautyseek.repository.ScheduleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Time;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ScheduleTest {

    @Autowired
    private ScheduleService scheduleService;

    @MockBean
    private ScheduleRepository scheduleRepository;

    @BeforeEach
    void setUp() {
        Date date = new Date();
        long timeInMillis = date.getTime();
        Time time = new Time(timeInMillis);
        Schedule schedule1 = new Schedule(date, time);
        Schedule schedule2 = new Schedule(date, time);
        List<Schedule> schedules = Arrays.asList(schedule1, schedule2);

        when(scheduleRepository.findAll()).thenReturn(schedules);
        when(scheduleRepository.findById(1)).thenReturn(Optional.of(schedule1));
        when(scheduleRepository.save(any(Schedule.class))).thenAnswer(i -> i.getArgument(0));
        when(scheduleRepository.existsById(1)).thenReturn(true);
        when(scheduleRepository.existsById(999)).thenReturn(false);
    }

    @Test
    void getAllSchedulesTest() {
        List<Schedule> schedules = scheduleService.getAllSchedules();
        assertNotNull(schedules);
        assertEquals(2, schedules.size());
    }

    @Test
    void getScheduleByIdFoundTest() throws RegisterNotFoundException {
        int id = 1;
        Schedule schedule = scheduleService.getScheduleById(id);
        assertNotNull(schedule);
        // Adicione mais asserções conforme necessário
    }

    @Test
    void getScheduleByIdNotFoundTest() {
        assertThrows(RegisterNotFoundException.class, () -> scheduleService.getScheduleById(999));
    }

    @Test
    void createAndUpdateScheduleTest() {
        Date date = new Date();
        long timeInMillis = date.getTime();
        Time time = new Time(timeInMillis);
        Schedule newSchedule = new Schedule(date, time);
        Schedule savedSchedule = scheduleService.createSchedule(newSchedule);
        assertNotNull(savedSchedule);
        // Adicione mais asserções conforme necessário

        // Testing update
        Time newTime = new Time(timeInMillis + 60);
        savedSchedule.setTime(newTime);
        try {
            Schedule updatedSchedule = scheduleService.updateSchedule(3, savedSchedule);
            assertNotNull(updatedSchedule);
            // Adicione mais asserções conforme necessário
        } catch (RegisterNotFoundException exception) {
            fail("o registro nao existe" + exception.getMessage());
        }
    }

    @Test
    void deleteScheduleSuccessTest() {
        int id = 1;
        assertTrue(scheduleService.deleteSchedule(id));
    }

    @Test
    void deleteScheduleFailureTest() {
        assertFalse(scheduleService.deleteSchedule(999));
    }
}
