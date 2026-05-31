package io.github.scitia.domain.agile.mapper;

import static lombok.AccessLevel.PRIVATE;

import java.util.function.Function;

import io.github.scitia.domain.agile.api.response.SprintPlanningResponse;
import io.github.scitia.domain.agile.domain.SprintPlanning;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public final class SprintPlanningResponseMapper implements Function<SprintPlanning, SprintPlanningResponse> {

    public static final SprintPlanningResponseMapper INSTANCE = new SprintPlanningResponseMapper();

    @Override
    public SprintPlanningResponse apply(SprintPlanning planning) {
        return new SprintPlanningResponse(
                planning.sprintId(),
                planning.committedItems(),
                planning.plannedStoryPoints(),
                planning.capacity(),
                planning.overflow(),
                planning.status()
        );
    }
}

