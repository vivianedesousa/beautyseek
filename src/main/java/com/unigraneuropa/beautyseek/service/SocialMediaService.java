package com.unigraneuropa.beautyseek.service;
import com.unigraneuropa.beautyseek.exception.RegisterNotFoundException;
import com.unigraneuropa.beautyseek.model.SocialMedia;
import com.unigraneuropa.beautyseek.model.User;
import com.unigraneuropa.beautyseek.repository.SocialMediaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SocialMediaService {
    private final SocialMediaRepository socialMediaRepository;

    public SocialMediaService(SocialMediaRepository socialMediaRepository) {
        this.socialMediaRepository = socialMediaRepository;
    }
    public List<SocialMedia> getAllSocialMedias(){
        List<SocialMedia> socialMediaList = new ArrayList();
        socialMediaList.addAll(socialMediaRepository.findAll());// adcionando dentro da lista
        return  socialMediaList;
    }
    public SocialMedia getSocialMediaById(Integer id) throws RegisterNotFoundException {
        Optional<SocialMedia> validSocialMedia = socialMediaRepository.findById(id);
        if(validSocialMedia.isPresent()){
            return validSocialMedia.get();
        }else{
            throw new RegisterNotFoundException();
        }
    }
    public SocialMedia createSocialMedia(SocialMedia socialMedia){
        return socialMediaRepository.save(socialMedia);
    }

    public SocialMedia updateSocialMedia(Integer id,SocialMedia socialMedia) throws RegisterNotFoundException {
      if(socialMediaRepository.existsById(id)){ //exist  id =3 feccobook
          socialMedia.setId(id); // . chamando algo que ta dentro objto; que vc difiniu
          // este objeto invocando o metodo SET(ID) muda o estdo do ID
          return socialMediaRepository.save(socialMedia);
      }else{
          throw new RegisterNotFoundException();
      }
    }

    public boolean deleteSocialMedia(Integer id){
        if(socialMediaRepository.existsById(id)){
            socialMediaRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
