package io.github.scitia.domain.agile.flows.process.value;

import io.github.scitia.aleatoricism.flows.annotation.WaypointContract;
import io.github.scitia.aleatoricism.flows.annotation.WaypointContractType;
import io.github.scitia.aleatoricism.flows.api.Waypoint;
import io.github.scitia.aleatoricism.flows.execution.ExecutionContext;
import io.github.scitia.domain.agile.api.request.SprintCreateRequest;
import io.github.scitia.domain.agile.domain.Sprint;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@WaypointContract(
        name = "Build Sprint",
        description = "Creates sprint summary with lifecycle metadata",
        contractType = WaypointContractType.CLOSED_OUTPUT
)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BuildSprintWaypoint implements Waypoint<SprintCreateRequest, Sprint> {

    public static final BuildSprintWaypoint INSTANCE = new BuildSprintWaypoint();

    @Override
    public Sprint handle(SprintCreateRequest input, ExecutionContext context) {
        String sprintId = "spr-" + Instant.now().toEpochMilli() + "-" + UUID.randomUUID();
        return new Sprint(
                sprintId,
                input.name(),
                input.goal(),
                input.startDate(),
                input.endDate(),
                input.capacity(),
                input.team(),
                "PLANNED"
        );
    }
}

