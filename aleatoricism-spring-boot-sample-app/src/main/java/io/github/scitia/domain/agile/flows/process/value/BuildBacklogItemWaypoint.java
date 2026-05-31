package io.github.scitia.domain.agile.flows.process.value;

import io.github.scitia.aleatoricism.flows.annotation.WaypointContract;
import io.github.scitia.aleatoricism.flows.annotation.WaypointContractType;
import io.github.scitia.aleatoricism.flows.api.Waypoint;
import io.github.scitia.aleatoricism.flows.execution.ExecutionContext;
import io.github.scitia.domain.agile.api.request.BacklogItemRequest;
import io.github.scitia.domain.agile.domain.BacklogItem;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@WaypointContract(
        name = "Build Backlog Item",
        description = "Creates backlog item with identifier and lifecycle status",
        contractType = WaypointContractType.CLOSED_OUTPUT
)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BuildBacklogItemWaypoint implements Waypoint<BacklogItemRequest, BacklogItem> {

    public static final BuildBacklogItemWaypoint INSTANCE = new BuildBacklogItemWaypoint();

    @Override
    public BacklogItem handle(BacklogItemRequest input, ExecutionContext context) {
        String itemId = "bi-" + Instant.now().toEpochMilli() + "-" + UUID.randomUUID();
        return new BacklogItem(
                itemId,
                input.title(),
                input.description(),
                input.type(),
                input.storyPoints(),
                input.priority(),
                input.reporter(),
                "NEW"
        );
    }
}

