package org.rbernalop.spring_boot_cucumber.it;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.rbernalop.spring_boot_cucumber.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;

public class CucumberSteps extends IntegrationTest {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void initialization() {
        userRepository.deleteAll();
    }

    @When("^a call is made to (.+) endpoint with (.+) method$")
    public void makeHttpRequest(String path, String method) throws Exception {
        HttpMethod httpMethod = HttpMethod.valueOf(method);
        MvcResult serverResponse = mockMvc.perform(request(httpMethod, path)).andReturn();
        context.setResponseEntity(serverResponse);
    }

    @When("^a call is made to (.+) endpoint with (.+) method and (.+) body")
    public void makeHttpRequestWithBody(String path, String method, String bodyFileName) throws Exception {
        String body = getContentByFileName(bodyFileName + ".json");
        HttpMethod httpMethod = HttpMethod.valueOf(method);
        MvcResult serverResponse = mockMvc.perform(
                request(httpMethod, path)
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn();
        context.setResponseEntity(serverResponse);
    }

    @Then("^the response status code is (\\d+)$")
    public void checkHttpStatus(int expectedStatusCode) {
        MvcResult serverResponse = context.getResponseEntity();
        final int actualStatusCode = serverResponse.getResponse().getStatus();
        assertEquals(expectedStatusCode, actualStatusCode);
    }


    @And("user does not exist in database")
    public void userDoesNotExistsInDatabase() {
        assertEquals(0, userRepository.count());
    }

    @And("user exists in database")
    public void userExistsInDatabase() {
        assertEquals(1, userRepository.count());
    }
}
