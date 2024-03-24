package org.rbernalop.spring_boot_cucumber.it;

import io.cucumber.spring.ScenarioScope;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MvcResult;

@ScenarioScope
@Component
@Data
public class TestContext {
    private MvcResult responseEntity;
}
