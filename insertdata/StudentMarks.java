package com.example.insertdata;

public class StudentMarks {

    private String stdID;
    private String stdName;
    private String subject;
    private int total;
    private int qOne;
    private int qTwo;
    private int qThree;
    private int qFour;

    public StudentMarks() {
    }

    public StudentMarks(String stdID, String stdName, String subject, int total, int qOne, int qTwo, int qThree, int qFour) {
        this.stdID = stdID;
        this.stdName = stdName;
        this.subject = subject;
        this.total = total;
        this.qOne = qOne;
        this.qTwo = qTwo;
        this.qThree = qThree;
        this.qFour = qFour;
    }

    public String getStdID() {
        return stdID;
    }

    public void setStdID(String stdID) {
        this.stdID = stdID;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getqOne() {
        return qOne;
    }

    public void setqOne(int qOne) {
        this.qOne = qOne;
    }

    public int getqTwo() {
        return qTwo;
    }

    public void setqTwo(int qTwo) {
        this.qTwo = qTwo;
    }

    public int getqThree() {
        return qThree;
    }

    public void setqThree(int qThree) {
        this.qThree = qThree;
    }

    public int getqFour() {
        return qFour;
    }

    public void setqFour(int qFour) {
        this.qFour = qFour;
    }
}
