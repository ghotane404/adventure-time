package com.pluralsight;

public class Step {
    private int id;
    private String storyText;
    private String option1Text;
    private int option1NextId;
    private String option2Text;
    private int option2NextId;

    Step(int id, String storyText, String option1Text, int option1NextId, String option2Text, int option2NextId) {
        this.id = id;
        this.storyText = storyText;
        this.option1Text = option1Text;
        this.option1NextId = option1NextId;
        this.option2Text = option2Text;
        this.option2NextId = option2NextId;
    }

    public int getId() {
        return id;
    }

    public String getStoryText() {
        return storyText;
    }

    public String getOption1Text() {
        return option1Text;
    }

    public int getOption1NextId() {
        return option1NextId;
    }

    public String getOption2Text() {
        return option2Text;
    }

    public int getOption2NextId() {
        return option2NextId;
    }

    public void setId(int newId) {
        this.id = newId;
    }

    public void setStoryText(String newStoryText) {
        this.storyText = newStoryText;
    }

    public void setOption1Text(String newOption1Text) {
        this.option1Text = newOption1Text;
    }

    public void setOption1NextId(int newOption1NextId) {
        this.option1NextId = newOption1NextId;
    }

    public void setOption2Text(String newOption2Text) {
        this.option2Text = newOption2Text;
    }

    public void setoption2NextId(int newOption2NextId) {
        this.option2NextId = newOption2NextId;
    }
}