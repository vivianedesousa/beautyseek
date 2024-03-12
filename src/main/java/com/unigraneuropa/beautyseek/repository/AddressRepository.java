package com.unigraneuropa.beautyseek.repository;  // vao ser as
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.unigraneuropa.beautyseek.model.Address;
@Repository
 // ela extende o model e o tipo da chave primaria ( Integer= Id)
public interface AddressRepository extends JpaRepository<Address,Integer> {
    // repository vai ser a interface de comunicacao de banco de dados
    // import org.springframework.stereotype.Repository;  este aqui e para anotacao do Spring (@Repository)
    //import com.unigraneuropa.beautyseek.model.Address; este esta dentro do pacote model,
    // JpaRepository;  esta e uma classe que tem os metodos padronizados para comunicacao com banco de dados CRUD)
    //  C =criacao ,R = leitura , U = atualizacao, D =delete
}
