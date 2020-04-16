package com.info.app.service;


import com.info.app.model.ProcEmpOut;

public interface ProcEmpOutService {
    ProcEmpOut getByEmpCode(String empCode);
}
