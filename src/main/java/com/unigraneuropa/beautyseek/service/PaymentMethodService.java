package com.unigraneuropa.beautyseek.service;
import com.unigraneuropa.beautyseek.model.PaymentMethod;
import com.unigraneuropa.beautyseek.exception.RegisterNotFoundException;
import com.unigraneuropa.beautyseek.model.User;
import com.unigraneuropa.beautyseek.repository.PaymentMethodRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentMethodService {
    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodService(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    public List<PaymentMethod> getAllPaymentMethods(){
        List<PaymentMethod> paymentMethodList = new ArrayList();
        paymentMethodList.addAll(paymentMethodRepository.findAll());
        return paymentMethodList;
    }

    public PaymentMethod  getPaymentMethodById(Integer id) throws RegisterNotFoundException {
        Optional<PaymentMethod> validPaymentMethod = paymentMethodRepository.findById(id);
        if(validPaymentMethod.isPresent()){
            return validPaymentMethod.get();
        }else{
            throw new RegisterNotFoundException();
        }
    }

    public  PaymentMethod  createPaymentMethod (PaymentMethod paymentMethod){
      return paymentMethodRepository.save(paymentMethod);
    }

    public PaymentMethod updatepaymentMethod (Integer id,PaymentMethod paymentMethod) throws RegisterNotFoundException {
        if(paymentMethodRepository.existsById(id)){
            paymentMethod.setId(id);// estamos colocando id dentro User
            return paymentMethodRepository.save(paymentMethod);
        }else{
            throw new RegisterNotFoundException();
        }
    }

    public boolean deletePaymentMethod (Integer id){
        if(paymentMethodRepository.existsById(id)){
            paymentMethodRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
