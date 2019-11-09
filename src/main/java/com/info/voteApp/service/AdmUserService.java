package com.info.voteApp.service;

import com.info.voteApp.model.AdmUser;

public interface AdmUserService {

    AdmUser getByUsername(String username);

}
