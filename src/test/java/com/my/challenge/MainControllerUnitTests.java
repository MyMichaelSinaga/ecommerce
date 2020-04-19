package com.my.challenge;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.my.challenge.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest
public class MainControllerUnitTests {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserRepository userRepository;

    @Test
    public MockHttpServletResponse contextLoads() throws Exception{
        when(userRepository.findById(1));
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/main-controller/get-module-by-user-id/1")
                        .accept(MediaType.APPLICATION_JSON)
        ).andReturn();
        System.out.println(mvcResult.getResponse());
        verify(userRepository).findById(1);
        return mvcResult.getResponse();

    }
}