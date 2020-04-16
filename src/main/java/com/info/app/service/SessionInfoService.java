package com.info.app.service;


import com.info.app.model.SessionInfo;

import java.util.List;

public interface SessionInfoService {

    List<SessionInfo> getActiveSessionInfo();
}
