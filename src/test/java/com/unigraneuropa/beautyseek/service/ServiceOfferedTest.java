package com.unigraneuropa.beautyseek.service;
import com.unigraneuropa.beautyseek.model. ServiceOffered;
import com.unigraneuropa.beautyseek.repository.ServiceOfferedRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
public class ServiceOfferedTest {
    @Mock
    private ServiceOfferedRepository serviceOfferedRepository;
    @InjectMocks
    private ServiceOfferedService  serviceOfferedService ;
    @Test
    public void testAllServiceOffered(){

    }
    @Test
    public void testServiceOfferedById(){

    }
    @Test
    public void testCreateServiceOffered(){

    }
    @Test
    public void testUpdateServiceOffered(){

    }
    @Test
    public void testDeleteServiceOffered(){
    }
}
