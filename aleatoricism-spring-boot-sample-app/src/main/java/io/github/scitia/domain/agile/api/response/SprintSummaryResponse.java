package io.github.scitia.domain.agile.api.response;

public record SprintSummaryResponse(
        String sprintId,
        String name,
        String goal,
        String startDate,
        String endDate,
        int capacity,
        String team,
        String status
) {
}

