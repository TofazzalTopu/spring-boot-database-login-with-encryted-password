package com.info.app.repository;

import com.info.app.model.SessionInfo;
import org.springframework.data.repository.CrudRepository;

public interface SessionInfoRepository extends CrudRepository<SessionInfo, Long> {
}
