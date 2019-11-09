package com.info.voteApp.service;

import com.info.voteApp.model.AdmUser;
import com.info.voteApp.repository.AdmUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdmUserServiceImpl implements AdmUserService {

    @Autowired
    AdmUserRepository admUserRepository;

    @Override
    public AdmUser getByUsername(String username) {
        AdmUser admUser = admUserRepository.getByUsername(username);
        if(admUser != null){
            return admUser;
        }else {
            return null;
        }
    }
}
