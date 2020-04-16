package com.info.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "proc_out_emp")
public class ProcEmpOut {
    @Id
    private long id;
    private String empCode;
    private String empName;

    @Column(name = "adm_om_le_id")
    private String admOmLeId;

    @Column(name = "adm_om_ou_id")
    private String admOmOuId;

    private String empGrp;
    private String empType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getAdmOmLeId() {
        return admOmLeId;
    }

    public void setAdmOmLeId(String admOmLeId) {
        this.admOmLeId = admOmLeId;
    }

    public String getAdmOmOuId() {
        return admOmOuId;
    }

    public void setAdmOmOuId(String admOmOuId) {
        this.admOmOuId = admOmOuId;
    }

    public String getEmpGrp() {
        return empGrp;
    }

    public void setEmpGrp(String empGrp) {
        this.empGrp = empGrp;
    }

    public String getEmpType() {
        return empType;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }
}
