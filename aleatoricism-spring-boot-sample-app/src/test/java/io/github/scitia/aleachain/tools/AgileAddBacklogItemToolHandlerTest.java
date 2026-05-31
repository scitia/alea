package io.github.scitia.aleachain.tools;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.copilot.sdk.json.ToolInvocation;
import io.github.scitia.aleatoricism.flows.engine.FlowEngine;
import io.github.scitia.aleatoricism.flows.execution.ExecutionOptions;
import io.github.scitia.config.aleatoricism.tools.domain.agile.AgileAddBacklogItemToolHandler;
import io.github.scitia.domain.agile.api.response.BacklogItemResponse;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AgileAddBacklogItemToolHandlerTest {

    @Test
    void shouldAddBacklogItemByToolInvocation() {
        try (FlowEngine flowEngine = new FlowEngine(ExecutionOptions.waitForAll())) {
            AgileAddBacklogItemToolHandler handler = new AgileAddBacklogItemToolHandler(flowEngine);
            ToolInvocation invocation = new ToolInvocation()
                    .setToolName("agile_add_backlog_item")
                    .setArguments(new ObjectMapper().valueToTree(Map.of(
                            "title", "Implement sprint board",
                            "description", "Add basic sprint board with columns",
                            "type", "story",
                            "storyPoints", 5,
                            "priority", 2,
                            "reporter", "product-owner"
                    )));

            Object result = handler.invoke(invocation).join();

            BacklogItemResponse response = (BacklogItemResponse) result;
            assertNotNull(response.itemId());
            assertEquals("NEW", response.status());
            assertEquals(2, response.priority());
        }
    }
}

