package io.github.scitia.aleachain.tools;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.copilot.sdk.json.ToolInvocation;
import io.github.scitia.aleatoricism.flows.engine.FlowEngine;
import io.github.scitia.aleatoricism.flows.execution.ExecutionOptions;
import io.github.scitia.config.aleatoricism.tools.domain.agile.AgilePlanSprintToolHandler;
import io.github.scitia.domain.agile.api.response.SprintPlanningResponse;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AgilePlanSprintToolHandlerTest {

    @Test
    void shouldPlanSprintByToolInvocation() {
        try (FlowEngine flowEngine = new FlowEngine(ExecutionOptions.waitForAll())) {
            AgilePlanSprintToolHandler handler = new AgilePlanSprintToolHandler(flowEngine);
            ToolInvocation invocation = new ToolInvocation()
                    .setToolName("agile_plan_sprint")
                    .setArguments(new ObjectMapper().valueToTree(Map.of(
                            "sprintId", "spr-100",
                            "backlogItemIds", List.of("bi-1", "bi-2", "bi-3"),
                            "plannedStoryPoints", 34,
                            "capacity", 30,
                            "team", "alpha"
                    )));

            Object result = handler.invoke(invocation).join();

            SprintPlanningResponse response = (SprintPlanningResponse) result;
            assertNotNull(response.sprintId());
            assertEquals("OVERFLOW", response.status());
            assertTrue(response.overflow());
        }
    }
}

