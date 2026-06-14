<br>
<div align="center">
  <img width="350" src="assets/logo.png" alt="Vibe Labs Logo">

  <h1>Aleatoricism</h1>

  <p><em>Aleatoric execution chain design pattern with synergy of flow oriented architecture</em></p>

![Sessions](https://img.shields.io/badge/Modules-5-blueviolet?style=flat-square)
![License](https://img.shields.io/badge/License-MIT-green?style=flat-square)
![Status](https://img.shields.io/badge/Status-Active-brightgreen?style=flat-square)
</div>

---

An open-source framework for building application servers that separate **decision-making** from **business logic**.

Instead of binding HTTP endpoints directly to predefined handlers, Aleatoricism introduces an agent-driven execution model in which requests are interpreted dynamically and mapped to business processes represented as process graphs.

---
<!-- TOC -->
  * [About](#about)
    * [Aleatoricism](#aleatoricism)
  * [Modules](#modules)
  * [Architecture Overview](#architecture-overview)
    * [Beyond Traditional Server Design](#beyond-traditional-server-design)
    * [Agent Layer](#agent-layer)
    * [Business Processes as Graphs](#business-processes-as-graphs)
    * [Adaptability and Scalability](#adaptability-and-scalability)
    * [Process Visibility](#process-visibility)
    * [High-Level API Communication](#high-level-api-communication)
    * [Request Lifecycle](#request-lifecycle)
  * [Sample Application](#sample-application)
<!-- TOC -->

## About

**Aleatoricism** is an open-source project that explores a different approach to server-side application architecture.

Traditional server applications are typically deterministic: each endpoint is explicitly mapped to a specific piece of business logic. Aleatoricism challenges this assumption by introducing an agent layer responsible for interpreting incoming requests and selecting the most appropriate business process at runtime.

Business logic is modeled as **forests of process graphs**, where each process consists of interconnected execution nodes called **Waypoints**. These graphs can be composed, extended, reused, and shared across different business capabilities.

The result is a highly adaptable architecture that allows applications to evolve without constantly redesigning their HTTP interface.

### Aleatoricism

The name *Aleatoricism* originates from **aleatoric music**, a compositional technique in which certain elements of a musical work are intentionally left open to performer interpretation or chance.

Rather than defining every note and transition in advance, an aleatoric composition provides a set of structures, rules, and possibilities from which the final performance emerges.

This idea serves as the inspiration for the framework.

In Aleatoricism, the application does not rigidly bind a request to a single predefined execution path. Instead, an agent evaluates the request, interprets its intent, and selects an appropriate process from a collection of available process graphs.

Just as aleatoric music balances structure with freedom, Aleatoricism balances deterministic business logic with dynamic runtime decision-making.

## Modules

- 📂 **[`aleatoricism-chain`](aleatoricism-chain/)**  
  HTTP routing and instruction-driven execution entry point.

- 📂 **[`aleatoricism-flows`](aleatoricism-flows/)**  
  Typed flow runtime, waypoint definitions, and process execution engine.

- 📂 **[`aleatoricism-spring-boot-autoconfigure`](aleatoricism-spring-boot-autoconfigure/)**  
  Spring Boot auto-configuration and property wiring.

- 📂 **[`aleatoricism-spring-boot-starter`](aleatoricism-spring-boot-starter/)**  
  Starter dependencies for Spring Boot applications.

- 📂 **[`aleatoricism-spring-boot-sample-app`](aleatoricism-spring-boot-sample-app/)**  
  Reference implementation demonstrating framework capabilities.

---

## Architecture Overview

### Beyond Traditional Server Design

Aleatoricism intentionally departs from several common assumptions found in modern backend systems:

- Requests are not statically bound to controller methods.
- Business capabilities are not modeled as endpoint hierarchies.
- REST maturity levels and rigid resource-oriented APIs are not the primary architectural concern.
- The HTTP layer acts as a transport mechanism rather than the source of business decisions.

### Agent Layer

The agent layer is responsible for determining how a request should be processed.

Agent behavior is configured through an `aleatoricism.md` file located on the application's classpath. This file contains instructions and operational guidance that help the agent understand:

- available business capabilities,
- execution constraints,
- domain-specific rules,
- request interpretation strategies.

When an HTTP request arrives, the request payload and metadata are passed to the agent layer. The agent analyzes the request together with the instructions defined in `aleatoricism.md` and decides which business process should be executed.

### Business Processes as Graphs

Business logic is represented as a collection of process graphs.

Each process (**Flow**) consists of interconnected **Waypoints**, which represent individual execution steps. Waypoints can be reused across multiple processes, enabling modular process composition and reducing duplication.

This approach provides:

- reusable business capabilities,
- clear separation of orchestration and execution,
- composable workflows,
- simplified process evolution over time.

### Adaptability and Scalability

Because process selection happens dynamically, new business capabilities can be introduced without modifying the HTTP layer.

Developers can:

- add new flows,
- modify existing flows,
- introduce new waypoints,
- change orchestration strategies,

while keeping the external API stable.

This makes the system particularly suitable for domains where business requirements evolve rapidly.

### Process Visibility

Representing business logic as graphs makes application behavior easier to understand and analyze.

Process structures can be visualized directly from source code definitions, providing:

- improved maintainability,
- easier onboarding,
- better architectural transparency,
- clearer domain modeling.

### High-Level API Communication

Aleatoricism promotes a higher-level interaction model between clients and servers.

Rather than invoking narrowly defined operations, clients express **intent** and provide instructions describing the desired outcome.

The agent layer interprets these instructions and determines which process graph should be executed.

In many scenarios, interacting with the API feels closer to communicating objectives than calling individual operations.

### Request Lifecycle

1. An HTTP request is received.
2. The request is forwarded to the agent layer.
3. The agent evaluates the request and available instructions.
4. A matching business process is selected.
5. The process graph is executed asynchronously.
6. Results are returned to the client.

If execution cannot be completed, the client receives a structured explanation describing why the request could not be processed.

---

## Sample Application

The sample application demonstrates:

- tool definitions,
- flow construction,
- waypoint composition,
- dynamic process selection,
- agent-driven request handling.

📂 **[`Sample Application`](aleatoricism-spring-boot-sample-app/README.md)**

For a complete walkthrough, see the sample application's documentation: 📖 [Read the guide](aleatoricism-spring-boot-sample-app/README.md)



