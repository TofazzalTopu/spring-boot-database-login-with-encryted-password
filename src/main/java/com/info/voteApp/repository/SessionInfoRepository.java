package com.info.voteApp.repository;

import com.info.voteApp.model.SessionInfo;
import org.springframework.data.repository.CrudRepository;

public interface SessionInfoRepository extends CrudRepository<SessionInfo, Long> {
}
