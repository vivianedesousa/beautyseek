package com.unigraneuropa.beautyseek.service;

import com.unigraneuropa.beautyseek.exception.RegisterNotFoundException;
import com.unigraneuropa.beautyseek.model.Feedback;
import com.unigraneuropa.beautyseek.model.Schedule;
import com.unigraneuropa.beautyseek.model.User;
import com.unigraneuropa.beautyseek.repository.FeedbackRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FeedbackTest {

    @Autowired
    private FeedbackService feedbackService;

    @MockBean
    private FeedbackRepository feedbackRepository;

    @BeforeEach
    void setUp() {
        Feedback feedback1 = new Feedback("5", "Excelente serviço!", new Date(), new Schedule(), new User(), new User());
        Feedback feedback2 = new Feedback("4", "Bom atendimento.", new Date(), new Schedule(), new User(), new User());
        List<Feedback> feedbacks = Arrays.asList(feedback1, feedback2);

        when(feedbackRepository.findAll()).thenReturn(feedbacks);
        when(feedbackRepository.findById(1)).thenReturn(Optional.of(feedback1));
        when(feedbackRepository.save(any(Feedback.class))).thenAnswer(i -> i.getArgument(0));
        when(feedbackRepository.existsById(1)).thenReturn(true);
        when(feedbackRepository.existsById(999)).thenReturn(false);
    }

    @Test
    void getAllFeedbacksTest() {
        List<Feedback> feedbacks = feedbackService.getAllFeedbacks();
        assertNotNull(feedbacks);
        assertEquals(2, feedbacks.size());
    }

    @Test
    void getFeedbackByIdFoundTest() throws RegisterNotFoundException {
        Feedback feedback = feedbackService.getFeedbackById(1);
        assertNotNull(feedback);
        assertEquals("5", feedback.getRating());
    }

    @Test
    void getFeedbackByIdNotFoundTest() {
        assertThrows(RegisterNotFoundException.class, () -> feedbackService.getFeedbackById(999));
    }

    @Test
    void createAndUpdateFeedbackTest() {
        Feedback newFeedback = new Feedback("4", "Serviço satisfatório.", new Date(), new Schedule(), new User(), new User());
        Feedback savedFeedback = feedbackService.createFeedback(newFeedback);
        assertNotNull(savedFeedback);
        assertEquals("4", savedFeedback.getRating());

        savedFeedback.setMessage("Serviço muito bom.");
        try {
            Feedback updatedFeedback = feedbackService.updateFeedback(1, savedFeedback);
            assertNotNull(updatedFeedback);
            assertEquals("Serviço muito bom.", updatedFeedback.getMessage());
        } catch (RegisterNotFoundException exception) {
            fail("o registro nao existe" + exception.getMessage());
        }
    }

    @Test
    void deleteFeedbackSuccessTest() {
        assertTrue(feedbackService.deleteFeedback(1));
    }

    @Test
    void deleteFeedbackFailureTest() {
        assertFalse(feedbackService.deleteFeedback(999));
    }
}
