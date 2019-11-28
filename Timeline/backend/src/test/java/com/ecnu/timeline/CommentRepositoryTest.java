package com.ecnu.timeline;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Jiayi Zhu
 * @date 2019-11-28 21:55
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@DirtiesContext
public class CommentRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CommentRepository repository;

    private Comment new_comment;

    @Before
    public void init() {
        new_comment = new Comment.CommentBuilder().user("ECNU")
                .time(new Date())
                .comment("Test.")
                .image("image's url")
                .build();
    }

    @After
    public void cleanup() {
        this.entityManager.clear();
    }

    @Test
    public void testFindLatestComments() {
        this.entityManager.persist(new_comment);

        List<Comment> cList = this.repository.findLatestComments(1);
        assertEquals(cList.size(), 1);

        Comment c = cList.get(0);
        assertEquals("ECNU", c.getUser());
        assertEquals("Test.", c.getComment());
        assertEquals("image's url", c.getImage());
        assertEquals(new_comment.getTime(), c.getTime());

    }

    @Test
    public void testMoreCommentsBefore() {
        Comment earlier_comment = new Comment.CommentBuilder().user("Abbey")
                .time(new Date(new_comment.getTime().getTime() - 10000))
                .comment("Earlier.")
                .image("Image's url")
                .build();

        this.entityManager.persist(new_comment);
        this.entityManager.persist(earlier_comment);

        List<Comment> cList = this.repository.findMoreCommentsBefore(new_comment.getTime(), 1);
        assertEquals(cList.size(), 1);

        Comment c = cList.get(0);
        assertEquals("Abbey", c.getUser());
        assertEquals("Earlier.", c.getComment());
        assertEquals("Image's url", c.getImage());
        assertEquals(earlier_comment.getTime(), c.getTime());

    }
}
