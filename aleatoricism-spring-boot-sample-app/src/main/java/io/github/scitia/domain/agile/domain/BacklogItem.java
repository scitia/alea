package io.github.scitia.domain.agile.domain;

public record BacklogItem(
        String itemId,
        String title,
        String description,
        String type,
        int storyPoints,
        int priority,
        String reporter,
        String status
) {
}

