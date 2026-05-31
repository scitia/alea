package io.github.scitia.domain.agile.domain;

public record Sprint(
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

