package com.ecnu.timeline;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Jiayi Zhu
 * @date 2019-10-14
 */
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String user;

    private Date time;

    private String comment;

    private String image;

    @Contract(pure = true)
    public Comment() {
    }

    @Contract(pure = true)
    public Comment(String user, Date time, String comment, String image) {
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

    public void setTime(@NotNull Date time) {
        this.time = new Date(time.getTime());
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

    public static class CommentBuilder {
        private Long id;
        private String user;
        private Date time;
        private String comment;
        private String image;

        public CommentBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public CommentBuilder user(String user) {
            this.user = user;
            return this;
        }

        public CommentBuilder time(Date time) {
            this.time = time;
            return this;
        }

        public CommentBuilder comment(String comment) {
            this.comment = comment;
            return this;
        }

        public CommentBuilder image(String image) {
            this.image = image;
            return this;
        }

        public Comment build() {
            return new Comment(user, time, comment, image);
        }
    }

    @Override
    public String toString() {
        return this.id + ", " + this.user + ", " + this.comment + ", " + this.time.toString();
    }
}
