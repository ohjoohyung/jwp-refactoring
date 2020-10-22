package kitchenpos.ui;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import kitchenpos.fixture.TestFixture;

public abstract class MvcTest extends TestFixture {

    protected ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext ctx;

    @BeforeEach
    void setUpEncoding() {
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        mockMvc = MockMvcBuilders.webAppContextSetup(ctx)
            .addFilters(new CharacterEncodingFilter("UTF-8", true))
            .alwaysDo(print())
            .build();
    }

    protected ResultActions getAction(String url) throws Exception {
        return mockMvc.perform(get(url));
    }

    protected ResultActions postAction(String url) throws Exception {
        return mockMvc.perform(post(url));
    }

    protected ResultActions postAction(String url, String inputJson) throws Exception {
        return mockMvc.perform(post(url)
            .content(inputJson)
            .contentType(MediaType.APPLICATION_JSON));
    }

    protected ResultActions deleteAction(String url) throws Exception {
        return mockMvc.perform(delete(url));
    }

    protected ResultActions putAction(String url, String inputJson) throws Exception {
        return mockMvc.perform(put(url)
            .content(inputJson)
            .contentType(MediaType.APPLICATION_JSON));
    }
}