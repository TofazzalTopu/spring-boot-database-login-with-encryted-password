package com.info.app.service;

public interface VotingHistoryService {
    void save(String empCode, long sessionId,
              String main_q, String first_q, String second_q,
              String third_q, String fourth_q, String fifth_q,
              String sixth_q, String seventh_q, String eight_q,
              String ninth_q, String tenth_q, String notes
    );

    boolean getByEmpCodeAndSessionId(String empCode, long sessionId);
}
