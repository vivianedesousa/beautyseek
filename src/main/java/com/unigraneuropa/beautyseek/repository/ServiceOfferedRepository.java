package com.unigraneuropa.beautyseek.repository;
import org.springframework.data.jpa.repository.JpaRepository; // esta importando da qui
import org.springframework.stereotype.Repository;
import com.unigraneuropa.beautyseek.model.ServiceOffered;
@Repository
public interface ServiceOfferedRepository extends  JpaRepository <ServiceOffered,Integer>{
}
