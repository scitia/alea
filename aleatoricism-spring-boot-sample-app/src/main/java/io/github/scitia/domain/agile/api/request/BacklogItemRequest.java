package io.github.scitia.domain.agile.api.request;

public record BacklogItemRequest(
        String title,
        String description,
        String type,
        int storyPoints,
        int priority,
        String reporter
) {
}

