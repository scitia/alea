# Aleatoricism Spring Boot Sample App

This sample app includes domain flows for quotes and agile scrum workflows. The agile package mirrors the quote structure with request/response models, flow definitions, and tool handlers.

## Agile tools

- `agile_create_sprint` creates a sprint summary.
- `agile_plan_sprint` plans backlog items for a sprint and checks capacity.
- `agile_add_backlog_item` registers a backlog item with initial metadata.

### Sample payloads

```json
{
  "name": "Sprint 12",
  "goal": "Ship planning improvements",
  "startDate": "2026-06-01",
  "endDate": "2026-06-14",
  "capacity": 30,
  "team": "alpha"
}
```

```json
{
  "sprintId": "spr-100",
  "backlogItemIds": ["bi-1", "bi-2"],
  "plannedStoryPoints": 21,
  "capacity": 20,
  "team": "alpha"
}
```

```json
{
  "title": "Implement sprint board",
  "description": "Add basic sprint board with columns",
  "type": "story",
  "storyPoints": 5,
  "priority": 2,
  "reporter": "product-owner"
}
```

