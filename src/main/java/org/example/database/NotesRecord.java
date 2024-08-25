package org.example.database;

import java.util.Date;


public class NotesRecord {
    private static int counter = 1000;

    {
        id = counter++;
    }

    private int id;
    private int userId;
    private String title;
    private String content;
    private Date creationDate;
    private Date updateDate;

    public NotesRecord(String title, String content) {
        this.title = title;
        this.content = content;
    }

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
}
