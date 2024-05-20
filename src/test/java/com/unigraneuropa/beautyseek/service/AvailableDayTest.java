package com.unigraneuropa.beautyseek.service;

import com.unigraneuropa.beautyseek.exception.RegisterNotFoundException;
import com.unigraneuropa.beautyseek.model.AvailableDay;
import com.unigraneuropa.beautyseek.repository.AvailableDayRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AvailableDayTest {
    @Autowired
    private AvailableDayService availableDayService;
    @MockBean
    private AvailableDayRepository availableDayRepository;

    @BeforeEach
    void setUp() {
        AvailableDay availableDay = new AvailableDay(true, false, true, false, true, false, true);
        when(availableDayRepository.findById(1)).thenReturn(Optional.of(availableDay));
        when(availableDayRepository.save(any(AvailableDay.class))).thenAnswer(i -> i.getArgument(0));
        when(availableDayRepository.existsById(1)).thenReturn(true);
        when(availableDayRepository.existsById(999)).thenReturn(false);
    }

    @Test
    void getAllavailableDayTest() {
        AvailableDay availableDay1 = new AvailableDay(true, false, true, false, true, false, true);
        AvailableDay availableDay2 = new AvailableDay(false, true, false, true, false, true, false);
        List<AvailableDay> availableDays = Arrays.asList(availableDay1, availableDay2);
        when(availableDayRepository.findAll()).thenReturn(availableDays);

        // Act
        List<AvailableDay> result = availableDayService.getAllAvailableDays();

        // Assert
        assertEquals(availableDays.size(), result.size());
        for (int i = 0; i < availableDays.size(); i++) {
            assertEquals(availableDays.get(i), result.get(i));
        }
    }

    @Test
    void getAvailableDayByIdFoundTest() throws RegisterNotFoundException {
        AvailableDay availableDay = availableDayService.getAvailableDayById(1);
        assertNotNull(availableDay);
        assertTrue(availableDay.isMonday());
        assertFalse(availableDay.isTuesday());
        assertTrue(availableDay.isWednesday());
    }

    @Test
    void getAvailableDayByIdNotFoundTest() {
        assertThrows(RegisterNotFoundException.class, () -> availableDayService.getAvailableDayById(999));
    }

    @Test
    void createAndUpdateAvailableDayTest() {
        AvailableDay newAvailableDay = new AvailableDay(true, true, false, true, false, true, false);
        AvailableDay savedAvailableDay = availableDayService.createAvailableDay(newAvailableDay);
        assertNotNull(savedAvailableDay);
        assertTrue(savedAvailableDay.isMonday());

        savedAvailableDay.setTuesday(false);
        try {
            AvailableDay updatedAvailableDay = availableDayService.updateAvailableDay(1, savedAvailableDay);
            assertNotNull(updatedAvailableDay);
            assertFalse(updatedAvailableDay.isTuesday());
        } catch (RegisterNotFoundException exception) {
            fail("A exceção RegisterNotFoundException foi lançada: " + exception.getMessage());
        }
    }

    @Test
    void deleteAvailableDaySuccessTest() {
        assertTrue(availableDayService.deleteAvailableDay(1));
    }

    @Test
    void deleteAvailableDayFailureTest() {
        assertFalse(availableDayService.deleteAvailableDay(999));
    }
}

