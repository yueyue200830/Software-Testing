package com.ecnu.timeline;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String user;
    private Date time;
    private String comment;
    private String image;

    public Comment() {
    }

    public Comment(Long id, String user, Date time, String comment, String image) {
        this.id = id;
        this.user = user;
        this.time = time;
        this.comment = comment;
        this.image = image;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getTime() {
        Date time = new Date();
        time.setTime(this.time.getTime());
        return time;
    }

    public void setTime(Date time) {
        this.time.setTime(time.getTime());
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return this.id + ", " + this.user + ", " + this.comment + ", " + this.time.toString();
    }
}
