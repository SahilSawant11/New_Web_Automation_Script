package com.cmswadhghat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final TestLogsHandler testLogsHandler;

    @Autowired
    public TestController(TestLogsHandler testLogsHandler) {
        this.testLogsHandler = testLogsHandler;
    }

    @GetMapping("/start-test")
    public String startTest() {
        // Simulate test execution and send logs to frontend
        testLogsHandler.sendTestLog("Test execution started...");

        // Here, you would integrate your test logic
        // For example, running the test and sending logs as they appear

        testLogsHandler.sendTestLog("Test in progress...");
        testLogsHandler.sendTestLog("Test completed successfully!");

        return "Test started!";
    }
}
