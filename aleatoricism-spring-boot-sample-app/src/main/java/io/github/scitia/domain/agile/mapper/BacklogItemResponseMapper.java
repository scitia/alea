package io.github.scitia.domain.agile.mapper;

import static lombok.AccessLevel.PRIVATE;

import java.util.function.Function;

import io.github.scitia.domain.agile.api.response.BacklogItemResponse;
import io.github.scitia.domain.agile.domain.BacklogItem;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public final class BacklogItemResponseMapper implements Function<BacklogItem, BacklogItemResponse> {

    public static final BacklogItemResponseMapper INSTANCE = new BacklogItemResponseMapper();

    @Override
    public BacklogItemResponse apply(BacklogItem backlogItem) {
        return new BacklogItemResponse(
                backlogItem.itemId(),
                backlogItem.title(),
                backlogItem.type(),
                backlogItem.storyPoints(),
                backlogItem.priority(),
                backlogItem.status()
        );
    }
}

