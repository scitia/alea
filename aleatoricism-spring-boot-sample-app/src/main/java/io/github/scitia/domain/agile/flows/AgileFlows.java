package io.github.scitia.domain.agile.flows;

import static lombok.AccessLevel.PRIVATE;

import io.github.scitia.aleatoricism.flows.annotation.BusinessFlow;
import io.github.scitia.aleatoricism.flows.engine.BusinessFlowBuilder;
import io.github.scitia.aleatoricism.flows.engine.Flow;
import io.github.scitia.domain.agile.api.request.BacklogItemRequest;
import io.github.scitia.domain.agile.api.request.SprintCreateRequest;
import io.github.scitia.domain.agile.api.request.SprintPlanningRequest;
import io.github.scitia.domain.agile.domain.BacklogItem;
import io.github.scitia.domain.agile.domain.Sprint;
import io.github.scitia.domain.agile.domain.SprintPlanning;
import io.github.scitia.domain.agile.flows.process.emission.PublishAgileAuditWaypoint;
import io.github.scitia.domain.agile.flows.process.transform.NormalizeBacklogItemWaypoint;
import io.github.scitia.domain.agile.flows.process.transform.NormalizeSprintPlanningWaypoint;
import io.github.scitia.domain.agile.flows.process.transform.NormalizeSprintRequestWaypoint;
import io.github.scitia.domain.agile.flows.process.value.BuildBacklogItemWaypoint;
import io.github.scitia.domain.agile.flows.process.value.BuildSprintPlanningWaypoint;
import io.github.scitia.domain.agile.flows.process.value.BuildSprintWaypoint;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public final class AgileFlows {

    @BusinessFlow(
            name = "agile-sprint-create-flow",
            description = "Normalizes sprint input, builds sprint summary, and emits audit event."
    )
    public static final Flow<SprintCreateRequest, Sprint> SPRINT_CREATE_FLOW = BusinessFlowBuilder.define()
            .start(NormalizeSprintRequestWaypoint.INSTANCE)
            .then(BuildSprintWaypoint.INSTANCE)
            .emit(PublishAgileAuditWaypoint.SPRINT)
            .build();

    @BusinessFlow(
            name = "agile-sprint-planning-flow",
            description = "Normalizes planning input, commits backlog items, and emits audit event."
    )
    public static final Flow<SprintPlanningRequest, SprintPlanning> SPRINT_PLANNING_FLOW = BusinessFlowBuilder.define()
            .start(NormalizeSprintPlanningWaypoint.INSTANCE)
            .then(BuildSprintPlanningWaypoint.INSTANCE)
            .emit(PublishAgileAuditWaypoint.SPRINT_PLANNING)
            .build();

    @BusinessFlow(
            name = "agile-backlog-item-flow",
            description = "Normalizes backlog item input, creates item, and emits audit event."
    )
    public static final Flow<BacklogItemRequest, BacklogItem> BACKLOG_ITEM_FLOW = BusinessFlowBuilder.define()
            .start(NormalizeBacklogItemWaypoint.INSTANCE)
            .then(BuildBacklogItemWaypoint.INSTANCE)
            .emit(PublishAgileAuditWaypoint.BACKLOG_ITEM)
            .build();
}

