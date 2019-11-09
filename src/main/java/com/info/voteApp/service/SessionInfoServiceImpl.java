package com.info.voteApp.service;

import com.info.voteApp.model.SessionInfo;
import com.info.voteApp.repository.SessionInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SessionInfoServiceImpl implements SessionInfoService {

    @Autowired
    SessionInfoRepository sessionInfoRepository;

    @Override
    public List<SessionInfo> getActiveSessionInfo() {
        List<SessionInfo> infoList = new ArrayList<>();
        Iterable<SessionInfo> iterable = sessionInfoRepository.findAll();
        for (SessionInfo info : iterable) {
            if (info.isActive() == true) {
                infoList.add(info);
            }
        }
        return infoList;
    }
}
