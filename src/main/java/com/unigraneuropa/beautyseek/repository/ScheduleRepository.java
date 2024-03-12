package com.unigraneuropa.beautyseek.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.unigraneuropa.beautyseek.model.Schedule;
@Repository
public interface ScheduleRepository  extends JpaRepository< Schedule,Integer> {
}
