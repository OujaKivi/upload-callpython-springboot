package com.wesley.uploadingfiles;

public class Ans {
    private String fileName;
    private String answer;
    private String target;

    public String getFileName() {
        return fileName;
    }

    @Override
    public String toString() {
        return "Ans{" +
                "fileName='" + fileName + '\'' +
                ", answer='" + answer + '\'' +
                ", target='" + target + '\'' +
                '}';
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Ans(String fileName, String answer, String target) {
        this.fileName = fileName;
        this.answer = answer;
        this.target = target;
    }

    public Ans(String answer, String target) {
        this.answer = answer;
        this.target = target;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

}
