package com.info.app.service;

import com.info.app.model.AdmUser;

public interface AdmUserService {

    AdmUser getByUsername(String username);

}
