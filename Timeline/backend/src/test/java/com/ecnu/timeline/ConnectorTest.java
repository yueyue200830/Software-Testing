package com.ecnu.timeline;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * @author Jiayi Zhu
 * @date 2019-11-12 18:13
 */
@RunWith(SpringRunner.class)
@WebMvcTest(Connector.class)
public class ConnectorTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testOnCreate() throws Exception {
        this.mockMvc.perform(get("/onCreate"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

}
