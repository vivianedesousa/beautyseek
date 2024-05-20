package com.unigraneuropa.beautyseek.service;

import com.unigraneuropa.beautyseek.exception.RegisterNotFoundException;
import com.unigraneuropa.beautyseek.model.AvailableTime;
import com.unigraneuropa.beautyseek.repository.AvailableTimeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AvailableTimeTest {
    @InjectMocks
    private AvailableTimeService availableTimeService;
    @Mock
    private AvailableTimeRepository availableTimeRepository;

    @BeforeEach
    void setUp() {
        AvailableTime availableTime1 = new AvailableTime(true, false, true);
        AvailableTime availableTime2 = new AvailableTime(false, true, true);
        List<AvailableTime> availableTime = Arrays.asList(availableTime1, availableTime2);
        when(availableTimeRepository.findAll()).thenReturn(availableTime);
        when(availableTimeRepository.findById(1)).thenReturn(Optional.of(availableTime1));
        when(availableTimeRepository.save(any(AvailableTime.class))).thenAnswer(i -> i.getArgument(0));
        when(availableTimeRepository.existsById(1)).thenReturn(true);
        when(availableTimeRepository.existsById(999)).thenReturn(false);
    }

    @Test
    public void getAllAvailableTimeTest() {
        List<AvailableTime> availableTimes = availableTimeService.getAllAvailableTimes();
        assertNotNull(availableTimes);// aqui no pod ser nula e passar no teste
        assertEquals(2, availableTimes.size());// vai mostar o tamanho
    }

    @Test
    public void getAvailableTimeByIdFoundTest() throws RegisterNotFoundException {
        AvailableTime availableTime = availableTimeService.getAvailableTimeById(1);
        assertNotNull(availableTime);
        assertTrue(availableTime.isMorning());
    }

    @Test
    public void getAvailableDayByIdNotFoundTest() {
        assertThrows(RegisterNotFoundException.class, () -> availableTimeService.getAvailableTimeById(999));
    }

    @Test
    public void createAndUpdateAvailableDayTest() {
        // Cria um novo objeto AvailableTime para ser criado
        AvailableTime newAvailableTime = new AvailableTime(true, true, true);
        // Chama o método para criar o novo AvailableTime
        AvailableTime savedAvailableTime = availableTimeService.createAvailableTime(newAvailableTime);

        // Verifica se o objeto foi criado corretamente e se está configurado como esperado
        assertNotNull(savedAvailableTime);
        assertTrue(savedAvailableTime.isMorning());
        assertTrue(savedAvailableTime.isAfternoon());
        assertTrue(savedAvailableTime.isEvening());

        // Modifica os atributos do objeto criado para simular uma atualização
        savedAvailableTime.setAfternoon(false);
        try {
            //Chama o método para atualizar o AvailableTime com o ID correto
            AvailableTime updatedAvailableTime = availableTimeService.updateAvailableTime(savedAvailableTime.getId(), savedAvailableTime.getId());

            // Verifica se a atualização foi bem-sucedida e se os atributos foram modificados conforme esperado
            assertNotNull(updatedAvailableTime);
            assertFalse(updatedAvailableTime.isAfternoon());
        } catch (RegisterNotFoundException exception) {
            fail("A exceção RegisterNotFoundException foi lançada:" + exception.getMessage());
        }
    }

    @Test
    public void deleteAvailableDaySuccessTest() {
        assertTrue(availableTimeService.deleteAvailableTime(1));
    }

    @Test
    void deleteAvailableDayFailureTest() {
        assertFalse(availableTimeService.deleteAvailableTime(999));

    }
}
