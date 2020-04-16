package com.info.app.repository;

import com.info.app.model.VotingHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VotingHistoryRepository extends CrudRepository<VotingHistory, Long> {
    List<VotingHistory> getByEmpCodeAndSessionId(String empCode, long sessionId);
}
