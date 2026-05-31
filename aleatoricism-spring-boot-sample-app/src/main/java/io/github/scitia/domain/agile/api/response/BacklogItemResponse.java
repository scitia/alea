package io.github.scitia.domain.agile.api.response;

public record BacklogItemResponse(
        String itemId,
        String title,
        String type,
        int storyPoints,
        int priority,
        String status
) {
}

