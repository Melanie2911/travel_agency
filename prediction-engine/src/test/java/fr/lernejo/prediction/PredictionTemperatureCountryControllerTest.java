package fr.lernejo.prediction;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ResourceBanner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import java.util.regex.Matcher;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class PredictionTemperatureCountryControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getCountry() throws Exception {
        mockMvc.perform(get("/api/temperature?country=Brazil"))
            .andExpect(status().isOk())
            .andExpect((ResultMatcher) jsonPath("$.country", Matchers.equalTo("Brazil")))
            .andExpect(MockMvcResultMatchers.jsonPath("$.temperatures").exists())
            .andExpect(MockMvcResultMatchers.jsonPath("$.temperatures[0].date").exists())
            .andExpect(MockMvcResultMatchers.jsonPath("$.temperatures[0].temperature").exists())
            .andExpect(MockMvcResultMatchers.jsonPath("$.temperatures[1].date").exists())
            .andExpect(MockMvcResultMatchers.jsonPath("$.temperatures[1].temperature").exists());
    }

    @Test
    void getCountryFailed() throws Exception {
        mockMvc.perform(get("/api/temperature?country=AA"))
            .andExpect(status().isExpectationFailed());
    }
}


