package com.unigraneuropa.beautyseek.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.unigraneuropa.beautyseek.model.Entrepreneur;
@Repository
public interface EntrepreneurRepository extends JpaRepository <Entrepreneur,Integer>{
}
