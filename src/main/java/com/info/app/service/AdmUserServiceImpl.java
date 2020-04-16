package com.info.app.service;

import com.info.app.model.AdmUser;
import com.info.app.repository.AdmUserRepository;
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
