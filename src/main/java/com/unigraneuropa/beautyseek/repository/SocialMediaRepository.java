package com.unigraneuropa.beautyseek.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.unigraneuropa.beautyseek.model. SocialMedia;
@Repository
public interface SocialMediaRepository extends JpaRepository<SocialMedia,Integer> {
}
