package io.github.scitia.domain.agile.flows.process.transform;

import io.github.scitia.aleatoricism.flows.annotation.WaypointContract;
import io.github.scitia.aleatoricism.flows.annotation.WaypointContractType;
import io.github.scitia.aleatoricism.flows.api.Waypoint;
import io.github.scitia.aleatoricism.flows.execution.ExecutionContext;
import io.github.scitia.domain.agile.api.request.SprintPlanningRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@WaypointContract(
        name = "Normalize Sprint Planning Input",
        description = "Ensures planning request defaults and cleans backlog item list",
        contractType = WaypointContractType.TRANSFORM
)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class NormalizeSprintPlanningWaypoint implements Waypoint<SprintPlanningRequest, SprintPlanningRequest> {

    public static final NormalizeSprintPlanningWaypoint INSTANCE = new NormalizeSprintPlanningWaypoint();

    @Override
    public SprintPlanningRequest handle(SprintPlanningRequest input, ExecutionContext context) {
        String sprintId = normalize(input.sprintId(), "unknown-sprint");
        List<String> backlogItemIds = input.backlogItemIds() == null
                ? List.of()
                : input.backlogItemIds().stream()
                .filter(Objects::nonNull)
                .map(String::trim)
                .filter(id -> !id.isBlank())
                .collect(Collectors.toList());
        int plannedStoryPoints = Math.max(0, input.plannedStoryPoints());
        int capacity = Math.max(1, input.capacity());
        String team = normalize(input.team(), "core-team");
        return new SprintPlanningRequest(sprintId, backlogItemIds, plannedStoryPoints, capacity, team);
    }

    private String normalize(String value, String fallback) {
        if (value == null || value.isBlank()) {
            return fallback;
        }
        return value.trim();
    }
}

