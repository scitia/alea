package io.github.scitia.domain.agile.domain;

import java.util.List;

public record SprintPlanning(
        String sprintId,
        List<String> committedItems,
        int plannedStoryPoints,
        int capacity,
        boolean overflow,
        String status
) {
}

