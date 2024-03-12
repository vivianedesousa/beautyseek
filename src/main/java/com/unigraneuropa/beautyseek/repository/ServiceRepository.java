package com.unigraneuropa.beautyseek.repository;
import org.springframework.data.jpa.repository.JpaRepository; // esta importando da qui
import org.springframework.stereotype.Repository;
import com.unigraneuropa.beautyseek.model.Service;
@Repository
public interface ServiceRepository extends  JpaRepository <Service,Integer>{
}
