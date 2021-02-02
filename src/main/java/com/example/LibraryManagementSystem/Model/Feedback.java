package com.example.LibraryManagementSystem.Model;

public class Feedback {
    private String feedback;
    public void setFeedback(String feedback){
        this.feedback = feedback;
    }
    public String getFeedback(){
        return feedback;
    }
    @org.jetbrains.annotations.NotNull
    @org.jetbrains.annotations.Contract(value = " -> new", pure = true)
    public static User getuserId(){
        return new Member();
    }

}
