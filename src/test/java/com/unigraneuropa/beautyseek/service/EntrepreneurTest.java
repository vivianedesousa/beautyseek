package com.unigraneuropa.beautyseek.service;
import com.unigraneuropa.beautyseek.model.Entrepreneur;
import org.junit.jupiter.api.Test;
import com.unigraneuropa.beautyseek.repository.EntrepreneurRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
public class EntrepreneurTest {
    @Mock
    private EntrepreneurRepository entrepreneurRepository;
    @InjectMocks
    private EntrepreneurService  entrepreneurService ;
    @Test
    public void testAllEntrepreneur(){

    }
    @Test
    public void testEntrepreneurById(){

    }
    @Test
    public void testCreateEntrepreneur(){

    }
    @Test
    public void testUpdateEntrepreneur(){

    }
    @Test
    public void testDeleteEntrepreneur(){
    }

}
