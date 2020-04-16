package com.info.app.repository;

import com.info.app.model.ProcEmpOut;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProcEmpOutRepository extends CrudRepository<ProcEmpOut, Long> {
    ProcEmpOut getByEmpCode(String empCode);
    ProcEmpOut getByEmpCodeAndAdmOmLeIdEqualsAndAdmOmOuIdEqualsAndEmpGrp(
            String empCode, String amdOmLeId, String amdOmOuId,
            String empGrp
    );
}
