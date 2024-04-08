package com.unigraneuropa.beautyseek.service;
import com.unigraneuropa.beautyseek.exception.RegisterNotFoundException;
import com.unigraneuropa.beautyseek.model.Entrepreneur;
import com.unigraneuropa.beautyseek.model.Feedback;
import com.unigraneuropa.beautyseek.model.User;
import com.unigraneuropa.beautyseek.repository.EntrepreneurRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class EntrepreneurService {
    private final EntrepreneurRepository entrepreneurRepository;

    public EntrepreneurService(EntrepreneurRepository entrepreneurRepository) {
        this.entrepreneurRepository = entrepreneurRepository;
    }

    public List<Entrepreneur> getAllEntrepreneurs(){
        List<Entrepreneur> entrepreneurList = new ArrayList();
        entrepreneurList.addAll(entrepreneurRepository.findAll());// adcionando dentro da lista
        return entrepreneurList;
    }

    public Entrepreneur getEntrepreneurById(Integer id) throws RegisterNotFoundException {
        Optional<Entrepreneur> validEntrepreneur = entrepreneurRepository.findById(id);
        if(validEntrepreneur.isPresent()){
            return validEntrepreneur.get();
        }else{
            throw new RegisterNotFoundException();
        }
    }
    public Entrepreneur createEntrepreneur(Entrepreneur entrepreneur){
         return entrepreneurRepository.save(entrepreneur);
    }

    public Entrepreneur updateEntrepreneur (Integer id,Entrepreneur entrepreneur) throws RegisterNotFoundException {
        if(entrepreneurRepository.existsById(id)){
            entrepreneur.setId(id);// estamos colocando id dentro User
            return entrepreneurRepository.save(entrepreneur);
        }else{
            throw new RegisterNotFoundException();
        }
    }

    public boolean deleteEntrepreneur (Integer id){
        if(entrepreneurRepository.existsById(id)){
            entrepreneurRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
    }

