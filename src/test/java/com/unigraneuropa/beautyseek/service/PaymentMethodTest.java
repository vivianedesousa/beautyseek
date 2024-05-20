package com.unigraneuropa.beautyseek.service;

import com.unigraneuropa.beautyseek.exception.RegisterNotFoundException;
import com.unigraneuropa.beautyseek.model.PaymentMethod;
import com.unigraneuropa.beautyseek.repository.PaymentMethodRepository;
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
public class PaymentMethodTest {

    @Autowired
    private PaymentMethodService paymentMethodService;

    @MockBean
    private PaymentMethodRepository paymentMethodRepository;

    @BeforeEach
    void setUp() {
        PaymentMethod paymentMethod1 = new PaymentMethod(true, false, true, false, true, false);
        PaymentMethod paymentMethod2 = new PaymentMethod(false, true, false, true, false, true);
        List<PaymentMethod> paymentMethods = Arrays.asList(paymentMethod1, paymentMethod2);

        when(paymentMethodRepository.findAll()).thenReturn(paymentMethods);
        when(paymentMethodRepository.findById(1)).thenReturn(Optional.of(paymentMethod1));
        when(paymentMethodRepository.save(any(PaymentMethod.class))).thenAnswer(i -> i.getArgument(0));
        when(paymentMethodRepository.existsById(1)).thenReturn(true);
        when(paymentMethodRepository.existsById(999)).thenReturn(false);
    }

    @Test
    void getAllPaymentMethodsTest() {
        List<PaymentMethod> paymentMethods = paymentMethodService.getAllPaymentMethods();
        assertNotNull(paymentMethods);
        assertEquals(2, paymentMethods.size());
    }

    @Test
    void getPaymentMethodByIdFoundTest() throws RegisterNotFoundException {
        PaymentMethod paymentMethod = paymentMethodService.getPaymentMethodById(1);
        assertNotNull(paymentMethod);
        assertTrue(paymentMethod.isCreditCard());
        assertFalse(paymentMethod.isDebitCard());
        assertTrue(paymentMethod.isCash());
    }

    @Test
    void getPaymentMethodByIdNotFoundTest() {
        assertThrows(RegisterNotFoundException.class, () -> paymentMethodService.getPaymentMethodById(999));
    }

    @Test
    void createAndUpdatePaymentMethodTest() {
        PaymentMethod newPaymentMethod = new PaymentMethod(true, true, false, true, false, true);
        PaymentMethod savedPaymentMethod = paymentMethodService.createPaymentMethod(newPaymentMethod);
        assertNotNull(savedPaymentMethod);
        assertTrue(savedPaymentMethod.isCreditCard());

        savedPaymentMethod.setDebitCard(false);
        try {
            PaymentMethod updatedPaymentMethod = paymentMethodService.updatePaymentMethod(1, savedPaymentMethod);
            assertNotNull(updatedPaymentMethod);
            assertFalse(updatedPaymentMethod.isDebitCard());
        } catch (RegisterNotFoundException exception) {
            fail("A exceção RegisterNotFoundException foi lançada: " + exception.getMessage());
        }
    }

    @Test
    void deletePaymentMethodSuccessTest() {
        assertTrue(paymentMethodService.deletePaymentMethod(1));
    }

    @Test
    void deletePaymentMethodFailureTest() {
        assertFalse(paymentMethodService.deletePaymentMethod(999));
    }
}

