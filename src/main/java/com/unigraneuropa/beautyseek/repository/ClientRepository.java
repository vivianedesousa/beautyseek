package com.unigraneuropa.beautyseek.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.unigraneuropa.beautyseek.model.Client;
@Repository
public interface ClientRepository  extends JpaRepository <Client,Integer>{
}
