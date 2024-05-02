package com.unigraneuropa.beautyseek.service;

import com.unigraneuropa.beautyseek.model.AvailableDay;
import org.junit.jupiter.api.Test;
import com.unigraneuropa.beautyseek.repository. AvailableDayRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
public class AvailableDayTest {
    @Mock
   private AvailableDayRepository  availableDayRepository;
    @InjectMocks
    private AvailableDayService  availableDayService;
    @Test
    public void testAllAvailableDay(){

    }
    @Test
    public void testAvailableDayById(){

    }
    @Test
    public void testCreateAvailableDay(){

    }
    @Test
    public void testUpdateAvailableDay(){

    }
    @Test
    public void testDeleteAvailableDay(){
    }
}
