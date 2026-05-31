package io.github.scitia.domain.agile.api.request;

import java.util.List;

public record SprintPlanningRequest(
        String sprintId,
        List<String> backlogItemIds,
        int plannedStoryPoints,
        int capacity,
        String team
) {
}

