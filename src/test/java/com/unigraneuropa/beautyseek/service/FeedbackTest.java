package com.unigraneuropa.beautyseek.service;

import com.unigraneuropa.beautyseek.model.Feedback;
import com.unigraneuropa.beautyseek.repository.FeedbackRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
public class FeedbackTest {
    @Mock
    private FeedbackRepository feedbackRepository;
    @InjectMocks
    private  FeedbackService   feedbackService ;
    @Test
    public void testAllFeedback(){

    }
    @Test
    public void testFeedbackById(){

    }
    @Test
    public void testCreateFeedback(){

    }
    @Test
    public void testUpdateFeedback(){

    }
    @Test
    public void testDeleteFeedback(){
    }

}
