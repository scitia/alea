package io.github.scitia.domain.agile.flows.process.value;

import io.github.scitia.aleatoricism.flows.annotation.WaypointContract;
import io.github.scitia.aleatoricism.flows.annotation.WaypointContractType;
import io.github.scitia.aleatoricism.flows.api.Waypoint;
import io.github.scitia.aleatoricism.flows.execution.ExecutionContext;
import io.github.scitia.domain.agile.api.request.SprintPlanningRequest;
import io.github.scitia.domain.agile.domain.SprintPlanning;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@WaypointContract(
        name = "Build Sprint Planning",
        description = "Commits backlog items into a sprint plan and flags capacity overflow",
        contractType = WaypointContractType.CLOSED_OUTPUT
)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BuildSprintPlanningWaypoint implements Waypoint<SprintPlanningRequest, SprintPlanning> {

    public static final BuildSprintPlanningWaypoint INSTANCE = new BuildSprintPlanningWaypoint();

    @Override
    public SprintPlanning handle(SprintPlanningRequest input, ExecutionContext context) {
        List<String> committedItems = List.copyOf(input.backlogItemIds());
        boolean overflow = input.plannedStoryPoints() > input.capacity();
        String status = overflow ? "OVERFLOW" : "COMMITTED";
        return new SprintPlanning(
                input.sprintId(),
                committedItems,
                input.plannedStoryPoints(),
                input.capacity(),
                overflow,
                status
        );
    }
}

