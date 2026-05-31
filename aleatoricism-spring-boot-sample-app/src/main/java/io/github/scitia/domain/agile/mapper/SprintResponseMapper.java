package io.github.scitia.domain.agile.mapper;

import static lombok.AccessLevel.PRIVATE;

import java.util.function.Function;

import io.github.scitia.domain.agile.api.response.SprintSummaryResponse;
import io.github.scitia.domain.agile.domain.Sprint;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public final class SprintResponseMapper implements Function<Sprint, SprintSummaryResponse> {

    public static final SprintResponseMapper INSTANCE = new SprintResponseMapper();

    @Override
    public SprintSummaryResponse apply(Sprint sprint) {
        return new SprintSummaryResponse(
                sprint.sprintId(),
                sprint.name(),
                sprint.goal(),
                sprint.startDate(),
                sprint.endDate(),
                sprint.capacity(),
                sprint.team(),
                sprint.status()
        );
    }
}

