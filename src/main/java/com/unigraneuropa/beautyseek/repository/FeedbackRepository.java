package com.unigraneuropa.beautyseek.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.unigraneuropa.beautyseek.model.Feedback;
@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,Integer> {
}
