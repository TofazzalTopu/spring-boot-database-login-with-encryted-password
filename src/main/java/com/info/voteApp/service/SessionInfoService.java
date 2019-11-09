package com.info.voteApp.service;


import com.info.voteApp.model.SessionInfo;

import java.util.List;

public interface SessionInfoService {

    List<SessionInfo> getActiveSessionInfo();
}
