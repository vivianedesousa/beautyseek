package com.unigraneuropa.beautyseek.service;

import com.unigraneuropa.beautyseek.exception.RegisterNotFoundException;
import com.unigraneuropa.beautyseek.model.SocialMedia;
import com.unigraneuropa.beautyseek.repository.SocialMediaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class SocialMediaTest {

    @Autowired
    private SocialMediaService socialMediaService;

    @MockBean
    private SocialMediaRepository socialMediaRepository;

    @BeforeEach
    void setUp() {
        SocialMedia socialMedia1 = new SocialMedia("111111111", "@instagram1", "Facebook 1");
        SocialMedia socialMedia2 = new SocialMedia("222222222", "@instagram2", "Facebook 2");

        List<SocialMedia> socialMedias = Arrays.asList(socialMedia1, socialMedia2);

        when(socialMediaRepository.findAll()).thenReturn(socialMedias);
        when(socialMediaRepository.findById(1)).thenReturn(Optional.of(socialMedia1));
        when(socialMediaRepository.save(any(SocialMedia.class))).thenAnswer(i -> i.getArgument(0));
        when(socialMediaRepository.existsById(1)).thenReturn(true);
        when(socialMediaRepository.existsById(999)).thenReturn(false);
    }

    @Test
    void getAllSocialMediasTest() {
        List<SocialMedia> socialMedias = socialMediaService.getAllSocialMedias();
        assertNotNull(socialMedias);
        assertEquals(2, socialMedias.size());
    }

    @Test
    void getSocialMediaByIdFoundTest() throws RegisterNotFoundException {
        SocialMedia socialMedia = socialMediaService.getSocialMediaById(1);
        assertNotNull(socialMedia);
        assertEquals("111111111", socialMedia.getWhatsApp());
        assertEquals("@instagram1", socialMedia.getInstagram());
        assertEquals("Facebook 1", socialMedia.getFacebook());
    }

    @Test
    void getSocialMediaByIdNotFoundTest() {
        assertThrows(RegisterNotFoundException.class, () -> socialMediaService.getSocialMediaById(999));
    }

    @Test
    void createAndUpdateSocialMediaTest() {
        SocialMedia newSocialMedia = new SocialMedia("333333333", "@instagram3", "Facebook 3");
        SocialMedia savedSocialMedia = socialMediaService.createSocialMedia(newSocialMedia);
        assertNotNull(savedSocialMedia);
        assertEquals("333333333", savedSocialMedia.getWhatsApp());
        assertEquals("@instagram3", savedSocialMedia.getInstagram());
        assertEquals("@Facebook 3", savedSocialMedia.getFacebook());

        // Testing update
        savedSocialMedia.setWhatsApp("@updated_whatsapp3");
        savedSocialMedia.setInstagram("@updated_instagram3");
        savedSocialMedia.setFacebook("Updated Facebook 3");

        try {
            SocialMedia updatedSocialMedia = socialMediaService.updateSocialMedia(3, savedSocialMedia);
            assertNotNull(updatedSocialMedia);
            assertEquals("@updated_whatsapp3", updatedSocialMedia.getWhatsApp());
            assertEquals("@updated_instagram3", updatedSocialMedia.getInstagram());
            assertEquals("Updated Facebook 3", updatedSocialMedia.getFacebook());
        } catch (RegisterNotFoundException exception) {
            fail("o registro nao existe" + exception.getMessage());
        }
    }

    @Test
    void deleteSocialMediaSuccessTest() {
        assertTrue(socialMediaService.deleteSocialMedia(1));
    }

    @Test
    void deleteSocialMediaFailureTest() {
        assertFalse(socialMediaService.deleteSocialMedia(999));
    }
}
