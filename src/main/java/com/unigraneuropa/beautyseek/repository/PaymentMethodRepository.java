package com.unigraneuropa.beautyseek.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.unigraneuropa.beautyseek.model.PaymentMethod;
@Repository
public interface PaymentMethodRepository extends JpaRepository <PaymentMethod,Integer> {
}
