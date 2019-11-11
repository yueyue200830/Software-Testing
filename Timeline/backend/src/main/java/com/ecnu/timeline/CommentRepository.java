package com.ecnu.timeline;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * @author Jiayi Zhu
 * @date 2019-10-14
 */
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    /**
     * Find latest number of comments.
     * @param number The number of comments.
     * @return List of latest comments.
     */
    @Query(value = "SELECT * FROM comment ORDER BY time DESC LIMIT :number", nativeQuery = true)
    List<Comment> findLatestComments(@Param("number") int number);

    /**
     * Get more comments based on the date time.
     * @param lastTime The last comment's time.
     * @param number The number of comments.
     * @return List of next comments.
     */
    @Query(value = "SELECT * FROM comment WHERE time < :lastTime ORDER BY time DESC LIMIT :number", nativeQuery = true)
    List<Comment> findMoreCommentsBefore(@Param("lastTime") Date lastTime, @Param("number") int number);
}
