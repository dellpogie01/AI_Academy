# AI Academy — AI Technology Guide

An educational Android application introducing users to modern AI technologies, frameworks, platforms, and infrastructure with offline-first bundled reference data, local search, bookmarks, reading history, and a side-by-side comparison tool.

## User Review & Critical Decisions

> [!IMPORTANT]
> The following user preferences were confirmed during Phase 1 interactive alignment and will be implemented in the build:

- **Confirmed Choice 1 (Detail Page Layout)**: Structured scrollable sections with clear section headers (Overview, Purpose, Key Features, Common Uses, Advantages, Limitations, Related Technologies, Official Link).
- **Confirmed Choice 2 (Data Persistence)**: Room SQLite Database for robust local storage of saved bookmarks, recent view history, and reading progress.
- **Confirmed Choice 3 (Extra Value Feature)**: Integrated Side-by-Side Technology Comparison feature allowing users to select and contrast two AI technologies across features, use cases, and limitations.

---

## 1. Overview & Core Concept

- **What It Does**: Serves as a comprehensive offline reference encyclopedia for 11 core AI technology domains and all 87 specified technologies (LLMs, Agentic Frameworks, RAG, Embedding Models, MCP, Security/Guardrails, Observability/Eval, Memory Systems, Agent SDKs, Workflow Automation, Vector DBs).
- **Target Audience / Persona**: Developers, architects, AI researchers, software engineering students, and product managers who want concise, factual, and well-structured insights without lengthy tutorials or marketing hype.
- **Key Value**: Instant offline discovery, clear categorization, side-by-side technology comparison, and persistent bookmarks/history—zero API key or cloud backend required.

---

## 2. User Experience & Visual Design

### Key User Flows
1. **Home Flow**: View top stats (87 total technologies across 11 categories), daily featured AI technology, quick category grids, recent views, and bookmarked quick access.
2. **Explore & Category Flow**: Browse 11 domain categories with icon-coded header banners. Filter technologies in real-time or tap into a specific technology card.
3. **Technology Detail Page**: Read organized sections (Overview, Purpose, Features, Uses, Advantages, Limitations, Related Tools, Link) with quick bookmark toggle and "Add to Compare" button.
4. **Search Flow**: Real-time offline search with category chip filters across technology titles, descriptions, capabilities, and tag keywords.
5. **Compare Flow**: Select any two technologies from dropdown/search pickers and view a side-by-side grid comparing purpose, capabilities, pros, and trade-offs.
6. **Bookmarks & History Flow**: View saved technologies and view timeline with search and clear options.
7. **Settings Flow**: Toggle Light / Dark / System themes, reset view history, and view app metadata and version details.

### Visual Identity & Theme
- **Theme Vibe**: Modern AI Knowledge Base (Deep Indigo, Midnight Navy, Electric Violet, Cyber Blue, and Dark Slate).
- **Color Palette (M3 Semantic Tokens)**:
  - Primary: `#5C6BC0` (Indigo Blue) / `#8C9EFF` (Accent Violet)
  - Secondary: `#26A69A` (Teal Cyber)
  - Background Dark: `#0B0E17` (Deep Obsidian Midnight)
  - Surface Dark: `#151B28` (Elevated Obsidian Slate)
  - Surface Variant: `#1E2638`
- **Typography & Layout**: Standard Material 3 Typography scaled cleanly via `sp`. Card layouts with subtle borders (`1.dp` primary alpha outline), elevation layers, and touch targets ($ \ge 48\text{dp} $).

---

## 3. Key Product Decisions & Trade-Offs

- **Decision 1: Bundled Local Data Engine (JSON / Kotlin Data Store)**
  - *Chosen Approach*: Static Kotlin/JSON dataset embedded directly in the APK with 100% complete descriptions for all 87 technologies and 11 categories.
  - *Why*: Ensures 100% offline capability, zero latency, no API key setup, and instant search performance.

- **Decision 2: Room SQLite Persistence for User State**
  - *Chosen Approach*: Room DB holding `BookmarkEntity` and `RecentViewEntity`.
  - *Why*: Clean reactive `Flow` integration with Jetpack Compose ViewModel state, type safety with KSP, and guaranteed persistence across app restarts.

- **Decision 3: Type-Safe Custom Navigation & Back Handling**
  - *Chosen Approach*: ViewState-driven screen switching with `BackHandler` support for seamless tab and detail stack navigation.
  - *Why*: Fast responsive screen transitions and reliable hardware/gesture back button handling.

---

## 4. Technical Architecture & Data Strategy

### System Architecture Diagram

```
┌────────────────────────────────────────────────────────────────────────┐
│                        Jetpack Compose UI Layer                        │
│                                                                        │
│ ┌──────────────┐ ┌──────────────┐ ┌──────────────┐ ┌─────────────────┐ │
│ │  HomeView    │ │ ExploreView  │ │  SearchView  │ │ BookmarksView   │ │
│ └──────┬───────┘ └──────┬───────┘ └──────┬───────┘ └────────┬────────┘ │
│        │                │                │                  │          │
│ ┌──────┴────────────────┴────────────────┴──────────────────┴────────┐ │
│ │                      TechnologyDetailView / CompareView           │ │
│ └──────────────────────────────────────┬─────────────────────────────┘ │
└────────────────────────────────────────┼───────────────────────────────┘
                                         │ State & Event Flow
                                         ▼
┌────────────────────────────────────────────────────────────────────────┐
│                         MainViewModel (MVVM)                           │
│  - uiState: StateFlow<UiState>                                         │
│  - searchQuery, selectedCategoryFilter                                 │
│  - toggleBookmark(), recordView(), compareSelection                    │
└──────────────────┬─────────────────────────────────┬───────────────────┘
                   │                                 │
                   ▼                                 ▼
┌──────────────────────────────────────┐  ┌──────────────────────────────┐
│       Bundled Data Repository        │  │   Room AppDatabase (KSP)     │
│  - 11 Categories, 87 Technologies    │  │  - BookmarkDao (Flow<List>) │
│  - Local Search & Filter logic       │  │  - RecentViewDao             │
└──────────────────────────────────────┘  └──────────────────────────────┘
```

### Data Entities & Schema

1. **Category**: `id`, `name`, `shortDescription`, `fullPurpose`, `iconResName`, `colorHex`
2. **Technology**: `id`, `categoryId`, `name`, `overview`, `mainPurpose`, `keyFeatures: List<String>`, `commonUses: List<String>`, `advantages: List<String>`, `limitations: List<String>`, `relatedTechIds: List<String>`, `officialUrl: String`
3. **BookmarkEntity (@Entity)**: `technologyId` (PrimaryKey), `timestamp`
4. **RecentViewEntity (@Entity)**: `technologyId` (PrimaryKey), `timestamp`

---

## 5. Scope & Technology Checklist

All 11 Categories & 87 Technologies to be implemented with full structured content:
- **A. LLMs**: OpenAI GPT, Anthropic Claude, Google Gemini, Meta Llama, Mistral AI, Cohere, Hugging Face, Ollama, vLLM
- **B. Agentic AI Frameworks**: LangGraph, CrewAI, Microsoft AutoGen, Microsoft Agent Framework, LlamaIndex Workflows, AWS Strands Agents, CAMEL, Agno
- **C. RAG**: LangChain, LlamaIndex, Haystack, DSPy, RAGFlow, GraphRAG, Unstructured, EmbedChain
- **D. Embedding Models**: OpenAI Embeddings, Cohere Embed, Voyage AI, Sentence Transformers, BGE, Google Vertex AI Embeddings, Azure OpenAI Embeddings
- **E. MCP**: MCP SDK, FastMCP, MCP Registry, GitHub MCP Server, Slack MCP Server, PostgreSQL MCP Server, Google Drive MCP Server, Filesystem MCP Server
- **F. AI Security & Guardrails**: NVIDIA NeMo Guardrails, Guardrails AI, Microsoft Presidio, Lakera Guard, Prompt Security, Protect AI, Azure AI Content Safety, AWS Bedrock Guardrails
- **G. Observability & Eval**: LangSmith, Langfuse, Arize Phoenix, Weights & Biases Weave, TruLens, Ragas, Promptfoo, Helicone
- **H. AI Memory Systems**: Mem0, Zep, Letta, LangGraph Memory, Redis, PostgreSQL, Neo4j, Chroma
- **I. Agent SDKs & Platforms**: OpenAI Agents SDK, LangChain Agents, PydanticAI, Semantic Kernel, Google ADK, AWS Bedrock Agents, Azure AI Foundry Agent Service
- **J. Workflow Automation**: n8n, Zapier, Make, Microsoft Power Automate, Temporal, Apache Airflow, Prefect, Kestra, Pipedream
- **K. Vector DBs**: Pinecone, Weaviate, Qdrant, Milvus, Chroma, pgvector, Elasticsearch, Redis, MongoDB Atlas Vector Search
