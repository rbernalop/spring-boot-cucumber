package org.rbernalop.spring_boot_cucumber.it;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@CucumberContextConfiguration
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class IntegrationTest {
    private static final String FILES_BASE_PATH = "src/test/resources/body_samples/";

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    protected TestContext context;

    protected String getContentByFileName(String fileName) throws IOException {
        return Files.readString(Paths.get(FILES_BASE_PATH + fileName));
    }
}

