package io.github.scitia.domain.agile.api.response;

import java.util.List;

public record SprintPlanningResponse(
        String sprintId,
        List<String> committedItems,
        int plannedStoryPoints,
        int capacity,
        boolean overflow,
        String status
) {
}

