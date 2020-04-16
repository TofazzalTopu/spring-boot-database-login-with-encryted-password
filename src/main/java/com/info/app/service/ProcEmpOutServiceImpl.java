package com.info.app.service;

import com.info.app.model.ProcEmpOut;
import com.info.app.repository.ProcEmpOutRepository;
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
