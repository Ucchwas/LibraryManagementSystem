package com.example.LibraryManagementSystem.DTO;

import com.example.LibraryManagementSystem.Model.Feedback;

public class FeedbackDTO {
    public long user_id;

    public long book_id;

    private Long rating;

    public long getUserId() {
        return user_id;
    }

    public void setUserId(long userId) {
        this.user_id = userId;
    }

    public FeedbackDTO(Feedback feedback) {
        this.user_id = feedback.getUserId();
        this.book_id = feedback.getBookId();
        this.rating = feedback.getRating();
    }

    public long getBookId() {
        return book_id;
    }

    public void setBookId(long bookId) {
        this.book_id = bookId;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }
}
