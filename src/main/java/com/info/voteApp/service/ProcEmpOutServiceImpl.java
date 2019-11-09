package com.info.voteApp.service;

import com.info.voteApp.model.ProcEmpOut;
import com.info.voteApp.repository.ProcEmpOutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcEmpOutServiceImpl implements ProcEmpOutService {

    @Autowired
    ProcEmpOutRepository procEmpOutRepository;

    @Override
    public ProcEmpOut getByEmpCode(String empCode) {

        ProcEmpOut procEmpOut = procEmpOutRepository.getByEmpCodeAndAdmOmLeIdEqualsAndAdmOmOuIdEqualsAndEmpGrp(
                empCode, "4", "47", "ACTIVE");
        if (procEmpOut != null) {
            return procEmpOut;
        } else {
            return null;
        }
    }


}
