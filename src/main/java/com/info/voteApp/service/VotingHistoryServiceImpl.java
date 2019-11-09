package com.info.voteApp.service;


import com.info.voteApp.model.VotingHistory;
import com.info.voteApp.repository.VotingHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotingHistoryServiceImpl implements VotingHistoryService {

    @Autowired
    VotingHistoryRepository votingHistoryRepository;

    @Override
    public void save(String empCode, long sessionId,
                     String main_q, String first_q, String second_q,
                     String third_q, String fourth_q, String fifth_q,
                     String sixth_q, String seventh_q, String eight_q,
                     String ninth_q, String tenth_q, String notes) {

        VotingHistory votingHistory = new VotingHistory();
        votingHistory.setEmpCode(empCode);
        votingHistory.setSessionId(sessionId);
        votingHistory.setMain_ans(main_q != null?Integer.parseInt(main_q): 0);
        votingHistory.setFirst_ans(first_q != null? Integer.parseInt(first_q) : 0);
        votingHistory.setSecond_ans(second_q != null? Integer.parseInt(second_q) : 0);
        votingHistory.setThird_ans(third_q != null? Integer.parseInt(third_q) : 0);
        votingHistory.setFourth_ans(fourth_q != null? Integer.parseInt(fourth_q) : 0);
        votingHistory.setFifth_ans(fifth_q != null? Integer.parseInt(fifth_q) : 0);
        votingHistory.setSixth_ans(sixth_q != null? Integer.parseInt(sixth_q) : 0);
        votingHistory.setSeventh_ans(seventh_q != null? Integer.parseInt(seventh_q) : 0);
        votingHistory.setEight_ans(eight_q != null? Integer.parseInt(eight_q) : 0);
        votingHistory.setNinth_ans(ninth_q != null? Integer.parseInt(ninth_q) : 0);
        votingHistory.setTenth_ans(tenth_q != null? Integer.parseInt(tenth_q) : 0);
        votingHistory.setNotes(notes);

        votingHistoryRepository.save(votingHistory);
    }

    @Override
    public boolean getByEmpCodeAndSessionId(String empCode, long sessionId) {
        try {
            List<VotingHistory> historyList = votingHistoryRepository.getByEmpCodeAndSessionId(empCode, sessionId);
            if (historyList.size() == 0) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
