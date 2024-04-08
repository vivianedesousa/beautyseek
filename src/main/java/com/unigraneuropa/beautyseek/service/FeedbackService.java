package com.unigraneuropa.beautyseek.service;
import com.unigraneuropa.beautyseek.exception.RegisterNotFoundException;
import com.unigraneuropa.beautyseek.model.Feedback;
import com.unigraneuropa.beautyseek.model.PaymentMethod;
import com.unigraneuropa.beautyseek.model.User;
import com.unigraneuropa.beautyseek.repository.FeedbackRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service

public class FeedbackService{
    private final  FeedbackRepository feedbackRepository;// constante

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public List<Feedback> getAllFeedbacks(){
        List<Feedback> feedbackList = new ArrayList();
        feedbackList.addAll(feedbackRepository.findAll());// adcionando dentro da lista
        return feedbackList;
    }

    public Feedback getFeedbackById(Integer id) throws RegisterNotFoundException {
        Optional<Feedback> validFeedback = feedbackRepository.findById(id);
        if(validFeedback.isPresent()){
            return validFeedback.get();
        }else{
            throw new RegisterNotFoundException();
        }
    }

    public Feedback createFeedback (Feedback feedback){
        return feedbackRepository.save(feedback);
    }

    public Feedback updateFeedback (Integer id,Feedback feedback) throws RegisterNotFoundException {
        if(feedbackRepository.existsById(id)){
            feedback.setId(id);// estamos colocando id dentro User
            return feedbackRepository.save(feedback);
        }else{
            throw new RegisterNotFoundException();
        }
    }

    public boolean deleteFeedback (Integer id){
        if(feedbackRepository.existsById(id)){
            feedbackRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
