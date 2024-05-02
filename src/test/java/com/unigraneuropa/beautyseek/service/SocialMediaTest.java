package com.unigraneuropa.beautyseek.service;
import com.unigraneuropa.beautyseek.model.SocialMedia;
import com.unigraneuropa.beautyseek.repository.SocialMediaRepository;
import com.unigraneuropa.beautyseek.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SocialMediaTest {
    @Mock // precisar criar um objeto de uma interface
    private SocialMediaRepository socialMediaRepository;
    @InjectMocks
        private SocialMediaService  socialMediaService;
        @Test
        public void testAllSocialMedias(){

        }
        @Test
        public void testSocialMediaById(){

        }
        @Test
        public void testCreateSocialMedia(){

        }
        @Test
        public void testUpdateSocialMedia(){

        }
        @Test
        public void testDeleteSocialMedia(){
    }
}
