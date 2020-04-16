package com.info.app.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "voting_history")
public class VotingHistory {

    @Id
    @GeneratedValue
    private long id;
    private String empCode;
    private long sessionId;
    private int main_ans;
    private int first_ans;
    private int second_ans;
    private int third_ans;
    private int fourth_ans;
    private int fifth_ans;
    private int sixth_ans;
    private int seventh_ans;
    private int eight_ans;
    private int ninth_ans;
    private int tenth_ans;

    @Column(length = 1000)
    @Size(max = 1000)
    private String notes;


    public VotingHistory() {
    }

    public VotingHistory(String empCode, long sessionId, int main_ans, int first_ans,
                         int second_ans, int third_ans, int fourth_ans, int fifth_ans, int sixth_ans,
                         int seventh_ans, int eight_ans, int ninth_ans, int tenth_ans,
                         @Size(max = 1000) String notes) {
        this.empCode = empCode;
        this.sessionId = sessionId;
        this.main_ans = main_ans;
        this.first_ans = first_ans;
        this.second_ans = second_ans;
        this.third_ans = third_ans;
        this.fourth_ans = fourth_ans;
        this.fifth_ans = fifth_ans;
        this.sixth_ans = sixth_ans;
        this.seventh_ans = seventh_ans;
        this.eight_ans = eight_ans;
        this.ninth_ans = ninth_ans;
        this.tenth_ans = tenth_ans;
        this.notes = notes;
    }

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

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    public int getMain_ans() {
        return main_ans;
    }

    public void setMain_ans(int main_ans) {
        this.main_ans = main_ans;
    }

    public int getFirst_ans() {
        return first_ans;
    }

    public void setFirst_ans(int first_ans) {
        this.first_ans = first_ans;
    }

    public int getSecond_ans() {
        return second_ans;
    }

    public void setSecond_ans(int second_ans) {
        this.second_ans = second_ans;
    }

    public int getThird_ans() {
        return third_ans;
    }

    public void setThird_ans(int third_ans) {
        this.third_ans = third_ans;
    }

    public int getFourth_ans() {
        return fourth_ans;
    }

    public void setFourth_ans(int fourth_ans) {
        this.fourth_ans = fourth_ans;
    }

    public int getFifth_ans() {
        return fifth_ans;
    }

    public void setFifth_ans(int fifth_ans) {
        this.fifth_ans = fifth_ans;
    }

    public int getSixth_ans() {
        return sixth_ans;
    }

    public void setSixth_ans(int sixth_ans) {
        this.sixth_ans = sixth_ans;
    }

    public int getSeventh_ans() {
        return seventh_ans;
    }

    public void setSeventh_ans(int seventh_ans) {
        this.seventh_ans = seventh_ans;
    }

    public int getEight_ans() {
        return eight_ans;
    }

    public void setEight_ans(int eight_ans) {
        this.eight_ans = eight_ans;
    }

    public int getNinth_ans() {
        return ninth_ans;
    }

    public void setNinth_ans(int ninth_ans) {
        this.ninth_ans = ninth_ans;
    }

    public int getTenth_ans() {
        return tenth_ans;
    }

    public void setTenth_ans(int tenth_ans) {
        this.tenth_ans = tenth_ans;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
