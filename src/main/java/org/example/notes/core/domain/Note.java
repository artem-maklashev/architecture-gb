package org.example.notes.core.domain;

import java.util.Date;

public class Note {
    //region Private Fields
    private int id;
    private int userId;
    private String title;
    private String content;
    private Date creationDate;
    private Date updateDate;
    //endregion


    public Note(int id, int userId, String title, String content, Date creationDate) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
    }

    //region Getters and Setters
    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    //endregion


    @Override
    public String toString() {
        return String.format("Note id: %d, userId: %d, title: %s, content: %s", id, userId, title, content);
    }
}
