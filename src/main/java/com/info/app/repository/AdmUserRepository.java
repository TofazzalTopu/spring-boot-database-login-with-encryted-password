package com.info.app.repository;

import com.info.app.model.AdmUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmUserRepository extends CrudRepository<AdmUser, Long> {

    AdmUser getByUsername(String username);
}
