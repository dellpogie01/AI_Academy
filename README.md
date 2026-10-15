# AI Academy — AI Technology Guide

**AI Academy** is a modern, mobile-friendly Android reference encyclopedia introducing developers, researchers, students, and product managers to modern artificial intelligence technologies, tools, frameworks, platforms, and infrastructure.

---

## 🌟 Key Features

- **100% Offline Educational Reference**: Bundled with comprehensive factual guide entries across all 11 AI domains and 87 technologies.
- **5 Navigation Tabs**:
  1. **Home**: Dashboard with top stats, daily featured technology, category overview, recently viewed history, and quick search.
  2. **Explore**: Browse all 11 AI categories and filter domain frameworks.
  3. **Search**: Instant offline search across names, categories, capabilities, and tag keywords with category filter chips.
  4. **Bookmarks**: Saved technologies persisted locally using Room SQLite database.
  5. **Settings**: Theme selection (Dark, Light, System Default), history reset, and app info.
- **Side-by-Side Technology Comparison**: Contrast any two AI tools across overview, features, advantages, and trade-offs.
- **Structured Detail Layouts**: Concise 8-part detail pages (Overview, Purpose, Key Features, Common Uses, Advantages, Limitations, Related Tools, Official Links).
- **Material 3 Design**: Deep Indigo & Violet dark/light theme, custom adaptive icon, clean typography, and smooth touch feedback.

---

## 📚 11 AI Categories Included

1. **Large Language Models (LLMs)** (OpenAI GPT, Claude, Gemini, Llama, Mistral, Cohere, Hugging Face, Ollama, vLLM)
2. **Agentic AI Frameworks** (LangGraph, CrewAI, AutoGen, Microsoft Agent Framework, LlamaIndex Workflows, AWS Strands, CAMEL, Agno)
3. **Retrieval-Augmented Generation (RAG)** (LangChain, LlamaIndex, Haystack, DSPy, RAGFlow, GraphRAG, Unstructured, EmbedChain)
4. **Embedding Models** (OpenAI Embeddings, Cohere Embed, Voyage AI, Sentence Transformers, BGE, Vertex AI Embeddings, Azure OpenAI Embeddings)
5. **Model Context Protocol (MCP)** (MCP SDK, FastMCP, MCP Registry, GitHub MCP Server, Slack MCP Server, PostgreSQL MCP Server, Google Drive MCP Server, Filesystem MCP Server)
6. **AI Security & Guardrails** (NVIDIA NeMo Guardrails, Guardrails AI, Microsoft Presidio, Lakera Guard, Prompt Security, Protect AI, Azure Content Safety, AWS Bedrock Guardrails)
7. **AI Observability & Evaluation** (LangSmith, Langfuse, Arize Phoenix, W&B Weave, TruLens, Ragas, Promptfoo, Helicone)
8. **AI Memory Systems** (Mem0, Zep, Letta, LangGraph Memory, Redis, PostgreSQL, Neo4j, Chroma)
9. **AI Agent SDKs & Platforms** (OpenAI Agents SDK, LangChain Agents, PydanticAI, Semantic Kernel, Google ADK, AWS Bedrock Agents, Azure AI Foundry)
10. **AI Workflow Automation** (n8n, Zapier, Make, Power Automate, Temporal, Apache Airflow, Prefect, Kestra, Pipedream)
11. **Vector Databases & Vector Search** (Pinecone, Weaviate, Qdrant, Milvus, Chroma, pgvector, Elasticsearch, Redis, MongoDB Atlas Vector Search)

---

## 🛠️ Technology Stack

- **Language**: Kotlin 2.0+
- **UI Framework**: Jetpack Compose with Material 3
- **Architecture**: MVVM (Model-View-ViewModel) + Repository Pattern
- **Local Persistence**: Room SQLite Database via KSP
- **Asynchronous Flow**: Kotlin Coroutines & `StateFlow`
- **Build System**: Gradle (Kotlin DSL) with Version Catalog

---

## 🚀 Building & Running in Android Studio

1. **Open Project**: Launch Android Studio and choose **Open**, then select this root repository directory.
2. **Gradle Sync**: Android Studio will automatically resolve Gradle dependencies defined in `build.gradle.kts` and `gradle/libs.versions.toml`.
3. **Run App**: Select the `:app` target, choose an Android Emulator or connected physical device (API Level 24+), and click **Run (Shift+F10)**.
4. **Unit Tests**: Run local JVM unit tests via `gradle :app:testDebugUnitTest`.
