package com.unigraneuropa.beautyseek.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.unigraneuropa.beautyseek.model.AvailableDay;
@Repository
public interface AvailableDayRepository extends JpaRepository<AvailableDay,Integer> {
}
