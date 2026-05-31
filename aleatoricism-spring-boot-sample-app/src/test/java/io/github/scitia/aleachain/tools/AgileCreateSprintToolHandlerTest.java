package io.github.scitia.aleachain.tools;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.copilot.sdk.json.ToolInvocation;
import io.github.scitia.aleatoricism.flows.engine.FlowEngine;
import io.github.scitia.aleatoricism.flows.execution.ExecutionOptions;
import io.github.scitia.config.aleatoricism.tools.domain.agile.AgileCreateSprintToolHandler;
import io.github.scitia.domain.agile.api.response.SprintSummaryResponse;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AgileCreateSprintToolHandlerTest {

    @Test
    void shouldCreateSprintByToolInvocation() {
        try (FlowEngine flowEngine = new FlowEngine(ExecutionOptions.waitForAll())) {
            AgileCreateSprintToolHandler handler = new AgileCreateSprintToolHandler(flowEngine);
            ToolInvocation invocation = new ToolInvocation()
                    .setToolName("agile_create_sprint")
                    .setArguments(new ObjectMapper().valueToTree(Map.of(
                            "name", "Sprint 12",
                            "goal", "Ship planning improvements",
                            "startDate", "2026-06-01",
                            "endDate", "2026-06-14",
                            "capacity", 30,
                            "team", "alpha"
                    )));

            Object result = handler.invoke(invocation).join();

            SprintSummaryResponse response = (SprintSummaryResponse) result;
            assertNotNull(response.sprintId());
            assertEquals("PLANNED", response.status());
            assertEquals(30, response.capacity());
        }
    }
}

