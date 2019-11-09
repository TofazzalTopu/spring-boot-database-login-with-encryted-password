package com.info.voteApp.service;


import com.info.voteApp.model.ProcEmpOut;

public interface ProcEmpOutService {
    ProcEmpOut getByEmpCode(String empCode);
}
