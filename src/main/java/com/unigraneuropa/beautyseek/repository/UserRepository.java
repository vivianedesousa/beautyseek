package com.unigraneuropa.beautyseek.repository;
// fazer isto
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.unigraneuropa.beautyseek.model.User;
@Repository // anotacoes
public interface UserRepository extends JpaRepository<User,Integer> {
}
