package com.unigraneuropa.beautyseek.service;

import com.unigraneuropa.beautyseek.exception.RegisterNotFoundException;
import com.unigraneuropa.beautyseek.model.ServiceOffered;
import com.unigraneuropa.beautyseek.repository.ServiceOfferedRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ServiceOfferedTest {

    @Mock
    private ServiceOfferedRepository serviceOfferedRepository;

    @InjectMocks
    private ServiceOfferedService serviceOfferedService;

    @BeforeEach
    void setUp() {
        ServiceOffered service1 = new ServiceOffered("Corte de Cabelo");
        ServiceOffered service2 = new ServiceOffered("Manicure");
        ArrayList<ServiceOffered> services = new ArrayList<>();
        services.add(service1);
        services.add(service2);

        when(serviceOfferedRepository.findAll()).thenReturn(services);
        when(serviceOfferedRepository.findById(1)).thenReturn(Optional.of(service1));
        when(serviceOfferedRepository.save(any(ServiceOffered.class))).thenAnswer(i -> i.getArgument(0));
        when(serviceOfferedRepository.existsById(1)).thenReturn(true);
        when(serviceOfferedRepository.existsById(999)).thenReturn(false);
    }

    @Test
    void getAllServicesTest() {
        List<ServiceOffered> services = serviceOfferedService.getAllServiceOffered();
        assertNotNull(services);
        assertEquals(2, services.size());
    }

    @Test
    void getServiceByIdFoundTest() throws RegisterNotFoundException {
        ServiceOffered service = serviceOfferedService.getServiceOfferedById(1);
        assertNotNull(service);
        assertEquals("Corte de Cabelo", service.getType());
    }

    @Test
    void getServiceByIdNotFoundTest() {
        assertThrows(RegisterNotFoundException.class, () -> serviceOfferedService.getServiceOfferedById(999));
    }

    @Test
    void createAndUpdateServiceTest() {
        ServiceOffered newService = new ServiceOffered("Depilação");
        ServiceOffered savedService = serviceOfferedService.createServiceOffered(newService);
        assertNotNull(savedService);
        assertEquals("Depilação", savedService.getType());

        savedService.setType("Depilação a Laser");
        try {
            ServiceOffered updatedService = serviceOfferedService.updateServiceOffered(3, savedService);
            assertNotNull(updatedService);
            assertEquals("Depilação a Laser", updatedService.getType());
        } catch (RegisterNotFoundException exception) {
            fail("o registro nao existe" + exception.getMessage());
        }
    }

    @Test
    void deleteServiceSuccessTest() {
        assertTrue(serviceOfferedService.deleteServiceOffered(1));
    }

    @Test
    void deleteServiceFailureTest() {
        assertFalse(serviceOfferedService.deleteServiceOffered(999));
    }
}
