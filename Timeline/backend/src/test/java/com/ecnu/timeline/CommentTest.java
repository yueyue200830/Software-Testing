package com.ecnu.timeline;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

public class CommentTest {
    @Autowired
    private CommentRepository commentRepository;

    @Test
    @Transactional
    public void testComment() {
        Comment comment = new Comment();
        Long id = 10L;
        String user = "Test";
        Date time = new Date();
        String c = "Hello test";

        comment.setId(id);
        comment.setUser(user);
        comment.setTime(time);
        comment.setComment(c);

        commentRepository.save(comment);
        Optional<Comment> verify = commentRepository.findById(10);

    }
}
