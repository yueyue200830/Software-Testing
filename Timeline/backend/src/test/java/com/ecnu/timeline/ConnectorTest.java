package com.ecnu.timeline;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author Jiayi Zhu
 * @date 2019-11-12 18:13
 */
@RunWith(SpringRunner.class)
@WebMvcTest(Connector.class)
public class ConnectorTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CommentRepository commentRepository;

    @Test
    @DisplayName("Test onCreate")
    public void testOnCreate() throws Exception {
        List<Comment> commentList = new ArrayList<>();
        Comment comment1 = new Comment();
        Date date1 = new Date();
        comment1.setComment("This is the 1st comment");
        comment1.setId(1L);
        comment1.setTime(date1);
        comment1.setUser("User 1");
        comment1.setImage("Image 1");
        commentList.add(comment1);
        Comment comment2 = new Comment();
        Date date2 = new Date();
        comment2.setComment("This is the 2nd comment");
        comment2.setId(2L);
        comment2.setTime(date2);
        comment2.setUser("User 2");
        commentList.add(comment2);
        Comment comment3 = new Comment();
        Date date3 = new Date();
        comment3.setComment("This is the 3rd comment");
        comment3.setId(3L);
        comment3.setTime(date3);
        comment3.setUser("User 3");
        commentList.add(comment3);
        Comment comment4 = new Comment();
        Date date4 = new Date();
        comment4.setComment("This is the 4th comment");
        comment4.setId(4L);
        comment4.setTime(date4);
        comment4.setUser("User 4");
        comment4.setImage("Image 4");
        commentList.add(comment4);

        when(commentRepository.findLatestComments(4)).thenReturn(commentList);

        MvcResult result = this.mockMvc.perform(post("/onCreate"))
                            .andExpect(MockMvcResultMatchers.status().isOk())
                            .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
                            .andDo(print())
                            .andReturn();

        JSONObject json = new JSONObject();
        json.append("comments", commentList);

        assertEquals(json.toString(), result.getResponse().getContentAsString());

        verify(commentRepository).findLatestComments(4);
    }

    @Test
    @DisplayName("Test loadMore")
    public void testLoadMore() throws Exception  {
        List<Comment> commentList = new ArrayList<>();
        Comment comment1 = new Comment();
        Date date1 = new Date();
        comment1.setComment("This is the 1st comment");
        comment1.setId(1L);
        comment1.setTime(date1);
        comment1.setUser("User 1");
        comment1.setImage("Image 1");
        commentList.add(comment1);
        Comment comment2 = new Comment();
        Date date2 = new Date();
        comment2.setComment("This is the 2nd comment");
        comment2.setId(2L);
        comment2.setTime(date2);
        comment2.setUser("User 2");
        commentList.add(comment2);

        Date time = new Date();
        // This is because the time accuracy is only in second.
        time.setTime(time.getTime() / 1000 * 1000);

        when(commentRepository.findMoreCommentsBefore(eq(time), eq(2))).thenReturn(commentList);

        MvcResult result = this.mockMvc
                .perform(post("/loadMore").content("{\"time\": \"" + time.toString() + "\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
                .andDo(print())
                .andReturn();

        JSONObject json = new JSONObject();
        json.append("moreComments", commentList);

        assertEquals(json.toString(), result.getResponse().getContentAsString());

        verify(commentRepository).findMoreCommentsBefore(eq(time), eq(2));
    }

    @Test
    @DisplayName("Test refresh")
    public void testRefresh() throws Exception {
        List<Comment> commentList = new ArrayList<>();
        Comment comment1 = new Comment();
        Date date1 = new Date();
        comment1.setComment("This is the 1st comment");
        comment1.setId(1L);
        comment1.setTime(date1);
        comment1.setUser("User 1");
        comment1.setImage("Image 1");
        commentList.add(comment1);
        Comment comment2 = new Comment();
        Date date2 = new Date();
        comment2.setComment("This is the 2nd comment");
        comment2.setId(2L);
        comment2.setTime(date2);
        comment2.setUser("User 2");
        commentList.add(comment2);
        Comment comment3 = new Comment();
        Date date3 = new Date();
        comment3.setComment("This is the 3rd comment");
        comment3.setId(3L);
        comment3.setTime(date3);
        comment3.setUser("User 3");
        commentList.add(comment3);
        Comment comment4 = new Comment();
        Date date4 = new Date();
        comment4.setComment("This is the 4th comment");
        comment4.setId(4L);
        comment4.setTime(date4);
        comment4.setUser("User 4");
        comment4.setImage("Image 4");
        commentList.add(comment4);

        when(commentRepository.findLatestComments(4)).thenReturn(commentList);

        MvcResult result = this.mockMvc.perform(post("/refresh"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
                .andDo(print())
                .andReturn();

        JSONObject json = new JSONObject();
        json.append("comments", commentList);

        assertEquals(json.toString(), result.getResponse().getContentAsString());

        verify(commentRepository).findLatestComments(4);
    }

}
