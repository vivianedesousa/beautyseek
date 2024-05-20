package com.unigraneuropa.beautyseek.service;

import com.unigraneuropa.beautyseek.exception.RegisterNotFoundException;
import com.unigraneuropa.beautyseek.model.Entrepreneur;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.unigraneuropa.beautyseek.repository.EntrepreneurRepository;
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
public class EntrepreneurTest {

    @Autowired
    private EntrepreneurService entrepreneurService;

    @MockBean
    private EntrepreneurRepository entrepreneurRepository;

    @BeforeEach
    void setUp() {
        Entrepreneur entrepreneur1 = new Entrepreneur("Bela Imagem", "Bela Imagem Estética Ltda.",
                "456789123", "11-98765-4321");
        Entrepreneur entrepreneur2 = new Entrepreneur("Encanto dos Cabelos", "Encanto dos Cabelos Salão de Beleza e Estética Ltda.",
                "956789100", "27-91234-5678");
        List<Entrepreneur> entrepreneurs = Arrays.asList(entrepreneur1, entrepreneur2);

        when(entrepreneurRepository.findAll()).thenReturn(entrepreneurs);
        when(entrepreneurRepository.findById(1)).thenReturn(Optional.of(entrepreneur1));
        when(entrepreneurRepository.save(any(Entrepreneur.class))).thenAnswer(i -> i.getArgument(0));
        when(entrepreneurRepository.existsById(1)).thenReturn(true);
        when(entrepreneurRepository.existsById(999)).thenReturn(false);
    }

    @Test
    void getAllEntrepreneursTest() {
        List<Entrepreneur> entrepreneurs = entrepreneurService.getAllEntrepreneurs();
        assertNotNull(entrepreneurs);
        assertEquals(2, entrepreneurs.size());
    }

    @Test
    void getEntrepreneurByIdFoundTest() throws RegisterNotFoundException {
        Entrepreneur entrepreneur = entrepreneurService.getEntrepreneurById(1);
        assertNotNull(entrepreneur);
        assertEquals("Bela Imagem", entrepreneur.getFantasyName());
    }

    @Test
    void getEntrepreneurByIdNotFoundTest() {
        assertThrows(RegisterNotFoundException.class, () -> entrepreneurService.getEntrepreneurById(999));
    }

    @Test
    void createAndUpdateEntrepreneurTest() {
        Entrepreneur newEntrepreneur = new Entrepreneur("Unhas de Encanto", "Encanto das Unhas Ltda.",
                "246813579", "51-98765-4321");

        Entrepreneur savedEntrepreneur = entrepreneurService.createEntrepreneur(newEntrepreneur);
        assertNotNull(savedEntrepreneur);
        assertEquals("Unhas de Encanto", savedEntrepreneur.getFantasyName());

        savedEntrepreneur.setCorporateName("Mulheres Bela Ltda");
        try {
            Entrepreneur updatedEntrepreneur = entrepreneurService.updateEntrepreneur(3, savedEntrepreneur);
            assertNotNull(updatedEntrepreneur);
            assertEquals("Mulheres Bela Ltda", updatedEntrepreneur.getCorporateName());
        } catch (RegisterNotFoundException exception) {
            fail("A exceção RegisterNotFoundException foi lançada: " + exception.getMessage());
        }
    }

    @Test
    void deleteEntrepreneurSuccessTest() {
        assertTrue(entrepreneurService.deleteEntrepreneur(1));
    }

    @Test
    void deleteEntrepreneurFailureTest() {
        assertFalse(entrepreneurService.deleteEntrepreneur(999));
    }
}