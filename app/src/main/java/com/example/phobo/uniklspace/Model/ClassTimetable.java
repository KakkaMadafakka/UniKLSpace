package com.example.phobo.uniklspace.Model;

/**
 * Created by phobo on 19-Feb-18.
 */

public class ClassTimetable {

    private long id;
    private String timestart;
    private String timeend;
    private String day;
    private String subject;
    private String classs;
    private String lecture;

    public ClassTimetable() {
    }

    public ClassTimetable(String timestart,String timeend,String day, String subject, String classs, String lecture) {
        this.timestart = timestart;
        this.timeend = timeend;
        this.day = day;
        this.subject = subject;
        this.subject = classs;
        this.subject = lecture;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTimestart() {
        return timestart;
    }

    public void setTimestart(String timestart) {
        this.timestart = timestart;
    }

    public String getTimeend() {
        return timeend;
    }

    public void setTimeend(String timeend) {
        this.timeend = timeend;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getClasss() {
        return classs;
    }

    public void setClasss(String classs) {
        this.classs = classs;
    }

    public String getLecture() {
        return lecture;
    }

    public void setLecture(String lecture) {this.lecture = lecture;}
}

