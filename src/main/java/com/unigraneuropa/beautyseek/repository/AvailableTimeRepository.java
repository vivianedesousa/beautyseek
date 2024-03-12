package com.unigraneuropa.beautyseek.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.unigraneuropa.beautyseek.model.AvailableTime;
@Repository
public interface AvailableTimeRepository extends JpaRepository< AvailableTime,Integer> {
}
