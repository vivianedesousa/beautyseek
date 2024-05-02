package com.unigraneuropa.beautyseek.service;

import com.unigraneuropa.beautyseek.model.PaymentMethod;
import com.unigraneuropa.beautyseek.repository.PaymentMethodRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PaymentMethodTest {
    @Mock
    private PaymentMethodRepository paymentMethodRepository;
    @InjectMocks
    private PaymentMethodService  paymentMethodService;

    @Test
    public void testAllPaymentMethod(){

    }
    @Test
    public void testPaymentMethodById(){

    }
    @Test
    public void testCreatePaymentMethod(){

    }
    @Test
    public void testUpdatePaymentMethod(){

    }
    @Test
    public void testDeletePaymentMethod(){
    }
}
