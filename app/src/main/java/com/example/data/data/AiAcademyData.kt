package com.example.data.data

import com.example.data.model.Category
import com.example.data.model.Technology

object AiAcademyData {

    val categories: List<Category> = listOf(
        Category(
            id = "llm",
            name = "Large Language Models (LLMs)",
            shortDescription = "Foundational autoregressive neural networks trained on massive text corpora for language generation and reasoning.",
            fullPurpose = "LLMs process and generate human-like text, code, and structured data, serving as the cognitive foundation for generative AI applications.",
            iconName = "Psychology",
            colorHex = "#5C6BC0"
        ),
        Category(
            id = "agentic",
            name = "Agentic AI Frameworks",
            shortDescription = "Frameworks designed for multi-step reasoning, tool orchestration, planning, and autonomous task execution.",
            fullPurpose = "Agentic frameworks provide multi-agent coordination, stateful control flow loops, and dynamic action execution to solve complex multi-step workflows.",
            iconName = "AccountTree",
            colorHex = "#26A69A"
        ),
        Category(
            id = "rag",
            name = "Retrieval-Augmented Generation (RAG)",
            shortDescription = "Architectures that connect generative language models to external knowledge sources for grounded context.",
            fullPurpose = "RAG systems retrieve facts from private domain documents or databases and supply them to LLMs to prevent hallucinations and maintain current knowledge.",
            iconName = "MenuBook",
            colorHex = "#AB47BC"
        ),
        Category(
            id = "embedding",
            name = "Embedding Models",
            shortDescription = "Neural encoders that transform text, images, and code into dense numerical vector representations.",
            fullPurpose = "Embedding models capture semantic relationships between concepts in high-dimensional vector space for semantic search and clustering.",
            iconName = "Hub",
            colorHex = "#42A5F5"
        ),
        Category(
            id = "mcp",
            name = "Model Context Protocol (MCP)",
            shortDescription = "Open standard protocol enabling AI models to securely connect to external tools, databases, and services.",
            fullPurpose = "MCP standardizes client-server integrations between LLMs and enterprise data systems, replacing custom bespoke tool-calling APIs.",
            iconName = "Extension",
            colorHex = "#FF7043"
        ),
        Category(
            id = "security",
            name = "AI Security and Guardrails",
            shortDescription = "Input and output validation systems that enforce safety, compliance, prompt injection defense, and PII masking.",
            fullPurpose = "Guardrails inspect LLM inputs and outputs in real time to filter harmful content, detect jailbreaks, and ensure policy adherence.",
            iconName = "Shield",
            colorHex = "#EF5350"
        ),
        Category(
            id = "observability",
            name = "AI Observability and Evaluation",
            shortDescription = "Platforms for tracing, debugging, monitoring latency, evaluating response quality, and analyzing costs in LLM apps.",
            fullPurpose = "Observability tools record LLM call chains, monitor output metrics (faithfulness, hallucination, latency), and track token usage.",
            iconName = "Analytics",
            colorHex = "#EC407A"
        ),
        Category(
            id = "memory",
            name = "AI Memory Systems",
            shortDescription = "Stateful storage engines designed to manage short-term, long-term, and episodic context across user conversations.",
            fullPurpose = "AI memory systems preserve entity knowledge, user preferences, and historical interactions beyond individual context window limits.",
            iconName = "Memory",
            colorHex = "#7E57C2"
        ),
        Category(
            id = "agent_sdk",
            name = "AI Agent SDKs and Platforms",
            shortDescription = "SDKs and cloud infrastructure services for building, hosting, and deploying production-grade AI agents.",
            fullPurpose = "Agent SDKs provide turnkey abstractions for model access, code execution, sandboxing, memory management, and deployment.",
            iconName = "Code",
            colorHex = "#26C6DA"
        ),
        Category(
            id = "workflow",
            name = "AI Workflow Automation",
            shortDescription = "Low-code and orchestration engines that blend traditional software triggers with AI inference nodes.",
            fullPurpose = "Workflow engines coordinate business processes, API calls, webhooks, and AI task steps into resilient automated pipelines.",
            iconName = "AutoMode",
            colorHex = "#FFA726"
        ),
        Category(
            id = "vector_db",
            name = "Vector Databases and Vector Search",
            shortDescription = "Database engines optimized for high-speed approximate nearest neighbor (ANN) similarity search across vector embeddings.",
            fullPurpose = "Vector databases store dense numeric vector embeddings with metadata to support sub-second semantic retrieval at scale.",
            iconName = "Storage",
            colorHex = "#66BB6A"
        )
    )

    val technologies: List<Technology> = listOf(
        // A. LLMs
        Technology(
            id = "openai_gpt",
            categoryId = "llm",
            name = "OpenAI GPT",
            overview = "OpenAI GPT (Generative Pre-trained Transformer) is a family of proprietary, frontier-tier autoregressive language models that power ChatGPT and enterprise APIs.",
            mainPurpose = "Provides multi-modal understanding, complex reasoning, structured code generation, and function calling for diverse AI applications.",
            keyFeatures = listOf(
                "Frontier multi-modal reasoning capabilities across text, vision, and audio.",
                "Native function calling and JSON mode output guarantees.",
                "Extended context windows supporting up to 128k+ tokens.",
                "Real-time reasoning models (o1/o3 series) optimized for deep problem solving."
            ),
            commonUses = listOf(
                "Enterprise conversational assistants and agent workflows.",
                "Code synthesis, refactoring, and automated debugging.",
                "Complex document analysis, translation, and summarization."
            ),
            advantages = listOf(
                "State-of-the-art general intelligence and instruction following.",
                "Mature API ecosystem, widespread SDK support, and tooling integration."
            ),
            limitations = listOf(
                "Proprietary closed-weights model requiring commercial API access.",
                "Higher API token costs relative to open-weights models."
            ),
            relatedTechIds = listOf("anthropic_claude", "google_gemini", "meta_llama"),
            officialUrl = "https://openai.com"
        ),
        Technology(
            id = "anthropic_claude",
            categoryId = "llm",
            name = "Anthropic Claude",
            overview = "Anthropic Claude is a family of safety-focused frontier language models trained with Constitutional AI techniques for high reliability and nuanced reasoning.",
            mainPurpose = "Delivers precise long-context comprehension, coding capabilities, and nuanced analytical reasoning with strong safety alignments.",
            keyFeatures = listOf(
                "Constitutional AI safety alignment to minimize harmful or biased outputs.",
                "Large 200k+ token context window capable of ingesting entire books and codebases.",
                "Artifacts feature for rendering interactive code and UI side-by-side.",
                "Computer use capabilities for interacting directly with desktop GUI applications."
            ),
            commonUses = listOf(
                "Large codebase auditing and complex software engineering tasks.",
                "Technical writing, legal document synthesis, and data policy review.",
                "Enterprise virtual assistants requiring strict corporate alignment."
            ),
            advantages = listOf(
                "Exceptional instruction following and highly nuanced writing quality.",
                "Outstanding code generation and long-document reasoning retention."
            ),
            limitations = listOf(
                "Closed-source proprietary model architecture.",
                "Strict rate limits and moderation filters."
            ),
            relatedTechIds = listOf("openai_gpt", "google_gemini", "mistral_ai"),
            officialUrl = "https://anthropic.com"
        ),
        Technology(
            id = "google_gemini",
            categoryId = "llm",
            name = "Google Gemini",
            overview = "Google Gemini is a multimodal model family natively built from the ground up to understand and operate seamlessly across text, images, audio, video, and code.",
            mainPurpose = "Enables multimodal intelligence with massive context capacity and deep integration into Google Workspace and Cloud infrastructure.",
            keyFeatures = listOf(
                "Native multimodal design handling text, images, video, and audio streams.",
                "Industry-leading 1M to 2M token context window capacity.",
                "Integration with Google Vertex AI and Gemini API Developer Studio.",
                "Optimized model sizes ranging from Nano (on-device) to Ultra."
            ),
            commonUses = listOf(
                "Long-video and audio content analysis and information retrieval.",
                "On-device mobile AI applications using Gemini Nano.",
                "Enterprise knowledge synthesis across cloud storage documents."
            ),
            advantages = listOf(
                "Unmatched context window length allowing full repository ingestion.",
                "Strong native multimodal performance without external adapter models."
            ),
            limitations = listOf(
                "Commercial cloud dependency for high-tier models.",
                "Varying latency on maximum context window operations."
            ),
            relatedTechIds = listOf("openai_gpt", "anthropic_claude", "meta_llama"),
            officialUrl = "https://deepmind.google/technologies/gemini/"
        ),
        Technology(
            id = "meta_llama",
            categoryId = "llm",
            name = "Meta Llama",
            overview = "Meta Llama is the leading open-weights foundational model family, providing high-performance language modeling for self-hosted and open research deployment.",
            mainPurpose = "Offers customizable, privacy-conscious open weights that developers can fine-tune, quantize, and run on private infrastructure.",
            keyFeatures = listOf(
                "Open-weights availability across parameter sizes (8B to 405B).",
                "Support for custom fine-tuning via LoRA and QLoRA techniques.",
                "Permissive community and commercial licensing options.",
                "Extensive quantization support (GGUF, EXL2, AWQ) for hardware efficiency."
            ),
            commonUses = listOf(
                "On-premises offline LLM deployments for data privacy compliance.",
                "Domain-specific fine-tuning for specialized industries (medical, legal).",
                "Edge computing and embedded hardware language applications."
            ),
            advantages = listOf(
                "Full ownership of weights and data privacy without external vendor lock-in.",
                "Vast global open-source community tooling and optimization ecosystem."
            ),
            limitations = listOf(
                "Requires local compute resources or GPU cloud hosting infrastructure.",
                "Largest 405B variants demand significant multi-GPU hardware to serve."
            ),
            relatedTechIds = listOf("mistral_ai", "ollama", "vllm"),
            officialUrl = "https://llama.meta.com"
        ),
        Technology(
            id = "mistral_ai",
            categoryId = "llm",
            name = "Mistral AI",
            overview = "Mistral AI is a European AI developer creating high-efficiency open and proprietary models, pioneering Mixture-of-Experts (MoE) architectures.",
            mainPurpose = "Delivers high inference speed and low latency per parameter through sparse Mixture-of-Experts architectural designs.",
            keyFeatures = listOf(
                "Pioneered sparse Mixture-of-Experts (Mixtral 8x7B, 8x22B) for high efficiency.",
                "Dual offering of open-weights models and managed commercial APIs.",
                "Native multi-lingual capabilities with European language strength.",
                "Function calling and JSON output optimization."
            ),
            commonUses = listOf(
                "Cost-effective inference pipelines for high-throughput applications.",
                "Multilingual chat and translation tools across global markets.",
                "Self-hosted developer tools and private API endpoints."
            ),
            advantages = listOf(
                "Exceptional performance-to-cost ratio due to sparse MoE design.",
                "Strong coding and logical reasoning capabilities."
            ),
            limitations = listOf(
                "Top-tier models (Mistral Large) are proprietary commercial models.",
                "Smaller models require fine-tuning for domain-specific tasks."
            ),
            relatedTechIds = listOf("meta_llama", "cohere", "ollama"),
            officialUrl = "https://mistral.ai"
        ),
        Technology(
            id = "cohere",
            categoryId = "llm",
            name = "Cohere",
            overview = "Cohere specializes in enterprise AI models optimized for RAG, multilingual search, text classification, and business integration.",
            mainPurpose = "Powers enterprise search, retrieval, and language understanding with specialized Command R models built for RAG.",
            keyFeatures = listOf(
                "Command R and Command R+ models specifically tuned for RAG workflows.",
                "Native citation generation and verifiable source tracing.",
                "Multi-cloud deployment options across AWS, GCP, and Azure.",
                "Enterprise security, SOC2 compliance, and private deployment."
            ),
            commonUses = listOf(
                "Enterprise knowledge base Q&A with strict citation requirements.",
                "Multilingual document categorization and semantic search.",
                "Customer support automation integrated into ERP systems."
            ),
            advantages = listOf(
                "Built-in citation mechanism reduces ungrounded hallucinations.",
                "Tailored specifically for enterprise cloud environments."
            ),
            limitations = listOf(
                "Less targeted toward casual consumer chat applications.",
                "Commercial API pricing structure."
            ),
            relatedTechIds = listOf("openai_gpt", "cohere_embed", "langchain"),
            officialUrl = "https://cohere.com"
        ),
        Technology(
            id = "hugging_face",
            categoryId = "llm",
            name = "Hugging Face",
            overview = "Hugging Face is the premier open platform and hub for sharing, discovering, and deploying machine learning models, datasets, and AI applications.",
            mainPurpose = "Acts as the central repository and platform for open-source AI models, tokenizers, datasets, and demo spaces.",
            keyFeatures = listOf(
                "Hub housing over 500,000 open-source models and datasets.",
                "Transformers library providing unified APIs across PyTorch and TensorFlow.",
                "Inference Endpoints for managed serverless or dedicated model deployment.",
                "Gradio and Streamlit integration via Hugging Face Spaces."
            ),
            commonUses = listOf(
                "Discovering and benchmarking open-source LLMs and embedding models.",
                "Fine-tuning and hosting custom open-weights models.",
                "Sharing dataset benchmarks and building interactive AI prototypes."
            ),
            advantages = listOf(
                "Definitive industry standard for open-source model sharing.",
                "Vast collection of community datasets, benchmarks, and fine-tunes."
            ),
            limitations = listOf(
                "Hosting custom large models requires compute hardware subscription.",
                "Requires careful filtering when selecting community-uploaded weights."
            ),
            relatedTechIds = listOf("meta_llama", "sentence_transformers", "ollama"),
            officialUrl = "https://huggingface.co"
        ),
        Technology(
            id = "ollama",
            categoryId = "llm",
            name = "Ollama",
            overview = "Ollama is a lightweight, cross-platform tool that allows developers to run open-weights LLMs (Llama, Mistral, Gemma) locally on macOS, Linux, and Windows.",
            mainPurpose = "Simplifies local LLM serving by bundling model downloading, quantization, management, and an OpenAI-compatible REST API.",
            keyFeatures = listOf(
                "Single-command downloading and execution of GGUF quantized models.",
                "Local REST API endpoint compatible with OpenAI client SDKs.",
                "Modelfile format for defining custom system prompts and parameters.",
                "Support for GPU acceleration (Apple Silicon Metal, CUDA, ROCm)."
            ),
            commonUses = listOf(
                "Local offline developer testing of LLM applications without API fees.",
                "Privacy-sensitive personal productivity tools and IDE plugins.",
                "Air-gapped deployment of AI models on desktop workstations."
            ),
            advantages = listOf(
                "Zero cost, total privacy, and effortless set up on local laptops.",
                "Seamless integration with popular frameworks (LangChain, LlamaIndex)."
            ),
            limitations = listOf(
                "Inference speed is constrained by local consumer hardware RAM/VRAM.",
                "Not designed as a multi-node enterprise production server."
            ),
            relatedTechIds = listOf("meta_llama", "vllm", "fastmcp"),
            officialUrl = "https://ollama.com"
        ),
        Technology(
            id = "vllm",
            categoryId = "llm",
            name = "vLLM",
            overview = "vLLM is a high-throughput, low-latency open-source LLM serving engine powered by PagedAttention memory management algorithm.",
            mainPurpose = "Maximizes GPU hardware utilization and serving throughput for production LLM API endpoints.",
            keyFeatures = listOf(
                "PagedAttention technology for efficient KV-cache memory allocation.",
                "Continuous batching for high concurrent query throughput.",
                "OpenAI-compatible server interface for easy drop-in replacement.",
                "Distributed tensor parallel inference across multiple GPUs."
            ),
            commonUses = listOf(
                "High-volume production API serving of open-weights models.",
                "Enterprise internal LLM gateway infrastructure.",
                "SaaS platforms serving thousands of concurrent inference requests."
            ),
            advantages = listOf(
                "Up to 2x-4x higher throughput compared to standard Hugging Face serving.",
                "Drastically reduces GPU memory waste due to dynamic cache paging."
            ),
            limitations = listOf(
                "Requires Linux production server environment with NVIDIA GPUs.",
                "Higher setup complexity compared to local desktop tools like Ollama."
            ),
            relatedTechIds = listOf("meta_llama", "ollama", "hugging_face"),
            officialUrl = "https://github.com/vllm-project/vllm"
        ),

        // B. Agentic AI Frameworks
        Technology(
            id = "langgraph",
            categoryId = "agentic",
            name = "LangGraph",
            overview = "LangGraph is a stateful, orchestration framework by LangChain for building agentic workflows using graph-based state machine nodes and edges.",
            mainPurpose = "Enables reliable, multi-agent control loops with human-in-the-loop validation, persistence, and state rewind capability.",
            keyFeatures = listOf(
                "Graph-based state machine architecture with cycles, branching, and parallelism.",
                "Built-in state persistence and time-travel debugging.",
                "Human-in-the-loop approval nodes and dynamic breakpoint interrupts.",
                "Seamless integration with LangChain ecosystem and LangSmith tracing."
            ),
            commonUses = listOf(
                "Complex multi-step coding agents with iterative automated testing.",
                "Customer service agents with human escalation and approvals.",
                "Automated research and multi-document synthesis workflows."
            ),
            advantages = listOf(
                "Superior control over agent loops compared to unpredictable open-ended loops.",
                "Built-in state checkpoints prevent lost work on failures."
            ),
            limitations = listOf(
                "Requires explicit graph state schema design.",
                "Steeper learning curve than linear chain frameworks."
            ),
            relatedTechIds = listOf("langchain", "crewai", "autogen"),
            officialUrl = "https://www.langchain.com/langgraph"
        ),
        Technology(
            id = "crewai",
            categoryId = "agentic",
            name = "CrewAI",
            overview = "CrewAI is an intuitive Python framework for orchestrating role-playing autonomous AI agents that collaborate in structured teams or crews.",
            mainPurpose = "Simplifies multi-agent teamwork by assigning distinct roles, goals, backstories, tools, and delegation tasks to individual agents.",
            keyFeatures = listOf(
                "Role-based agent definitions with backstories, goals, and allowed tools.",
                "Sequential, hierarchical, and asynchronous task execution processes.",
                "Inter-agent delegation and collaborative problem-solving.",
                "Framework agnostic model provider compatibility."
            ),
            commonUses = listOf(
                "Content creation crews (Researcher, Writer, Editor agents).",
                "Market research analysis with dedicated analyst roles.",
                "Automated lead enrichment and sales intelligence pipelines."
            ),
            advantages = listOf(
                "Highly intuitive human-centric conceptual model (Crews, Agents, Tasks).",
                "Fast prototyping of collaborative multi-agent scenarios."
            ),
            limitations = listOf(
                "Less fine-grained graph state control than LangGraph.",
                "Higher token consumption due to inter-agent conversation loops."
            ),
            relatedTechIds = listOf("langgraph", "autogen", "agno"),
            officialUrl = "https://crewai.com"
        ),
        Technology(
            id = "autogen",
            categoryId = "agentic",
            name = "Microsoft AutoGen",
            overview = "Microsoft AutoGen is an open-source framework for building multi-agent applications that solve tasks through multi-agent conversation.",
            mainPurpose = "Enables multi-agent conversational ecosystems where autonomous agents converse with each other and humans to complete tasks.",
            keyFeatures = listOf(
                "Conversational agent architecture supporting multi-party chats.",
                "Code execution sandboxing for safe Python script execution.",
                "Human involvement patterns ranging from full autonomy to step-by-step guidance.",
                "AutoGen Studio low-code interface for building agent teams."
            ),
            commonUses = listOf(
                "Automated software engineering (developer, tester, code reviewer agents).",
                "Scientific research simulation and hypothesis iteration.",
                "Interactive data analysis and code execution notebooks."
            ),
            advantages = listOf(
                "Strong code execution capabilities and multi-agent problem-solving.",
                "Backing from Microsoft Research with active academic exploration."
            ),
            limitations = listOf(
                "Unbounded conversational loops can incur unexpected API costs.",
                "Requires isolated Docker containers for safe code execution."
            ),
            relatedTechIds = listOf("crewai", "langgraph", "semantic_kernel"),
            officialUrl = "https://microsoft.github.io/autogen/"
        ),
        Technology(
            id = "ms_agent_framework",
            categoryId = "agentic",
            name = "Microsoft Agent Framework",
            overview = "Microsoft Agent Framework is an enterprise-grade agent orchestration stack integrating Semantic Kernel, AutoGen, and Azure AI Agent Service capabilities.",
            mainPurpose = "Provides enterprise-ready infrastructure for building, deploying, and monitoring safe multi-agent ecosystems at scale.",
            keyFeatures = listOf(
                "Unified enterprise architecture bridging C# and Python environments.",
                "Native Azure AI Foundry cloud hosting and enterprise security.",
                "Standardized tool calling, memory connectors, and telemetry.",
                "Built-in compliance, content safety, and RBAC governance."
            ),
            commonUses = listOf(
                "Enterprise AI agent systems deployed on Azure Cloud.",
                "Cross-department automated workflow orchestration.",
                "Secure agentic tools integrated with Microsoft 365 Copilot."
            ),
            advantages = listOf(
                "Deep Microsoft enterprise stack and Azure ecosystem alignment.",
                "Robust C# / .NET and Python multi-language support."
            ),
            limitations = listOf(
                "Primary optimization is tied to Azure Cloud infrastructure.",
                "Higher organizational complexity for small indie projects."
            ),
            relatedTechIds = listOf("autogen", "semantic_kernel", "azure_agent_service"),
            officialUrl = "https://learn.microsoft.com/azure/ai-services/"
        ),
        Technology(
            id = "llamaindex_workflows",
            categoryId = "agentic",
            name = "LlamaIndex Workflows",
            overview = "LlamaIndex Workflows is an event-driven framework for building complex, asynchronous AI agents and RAG pipelines using step decorators and event queues.",
            mainPurpose = "Provides deterministic event-driven orchestration for multi-step AI agents and complex retrieval workflows.",
            keyFeatures = listOf(
                "Event-driven architecture based on Python asyncio.",
                "Strong typing and state passing between workflow steps.",
                "Seamless integration with LlamaIndex indexes, retrievers, and query engines.",
                "Built-in visualization tools for step dependencies."
            ),
            commonUses = listOf(
                "Event-driven multi-stage RAG pipelines with fallback branching.",
                "Asynchronous agentic workflows handling background processing.",
                "Document processing agents with step-by-step state verification."
            ),
            advantages = listOf(
                "Clean event-driven syntax without complex graph setup overhead.",
                "Direct native access to LlamaIndex data connectors and vector stores."
            ),
            limitations = listOf(
                "Tightly coupled to the LlamaIndex Python ecosystem.",
                "Relies heavily on Python asynchronous programming paradigms."
            ),
            relatedTechIds = listOf("llamaindex", "langgraph", "dspy"),
            officialUrl = "https://www.llamaindex.ai"
        ),
        Technology(
            id = "aws_strands_agents",
            categoryId = "agentic",
            name = "AWS Strands Agents",
            overview = "AWS Strands Agents is an AWS developer preview tool and framework designed to build modular, composable agents integrated into AWS Bedrock.",
            mainPurpose = "Provides modular agent strands that execute specialized cloud micro-tasks with native AWS resource bindings.",
            keyFeatures = listOf(
                "Modular strand architecture for decomposing agent logic.",
                "Direct integration with AWS Lambda functions and Bedrock models.",
                "Built-in AWS IAM security context propagation.",
                "Automated CloudWatch tracing and log aggregation."
            ),
            commonUses = listOf(
                "Cloud infrastructure management and DevOps automation agents.",
                "Serverless microservice coordination using AWS Bedrock.",
                "Enterprise data processing pipelines on AWS S3 and DynamoDB."
            ),
            advantages = listOf(
                "Native AWS cloud security, governance, and IAM permissioning.",
                "Serverless execution model with minimal infrastructure management."
            ),
            limitations = listOf(
                "Tightly coupled to AWS Cloud ecosystem.",
                "Less portable to non-AWS cloud platforms."
            ),
            relatedTechIds = listOf("aws_bedrock_agents", "crewai", "langgraph"),
            officialUrl = "https://aws.amazon.com/bedrock/"
        ),
        Technology(
            id = "camel",
            categoryId = "agentic",
            name = "CAMEL",
            overview = "CAMEL (Communicative Agents for 'Mind' Exploration) is an open-source framework pioneering role-play agent communication for cooperative task solving.",
            mainPurpose = "Studies and implements communicative multi-agent interaction patterns using inception prompting techniques.",
            keyFeatures = listOf(
                "Inception prompting methodology to guide multi-agent alignment.",
                "Communicative agent pairs (e.g. User agent and Assistant agent).",
                "Task-oriented conversation simulation and synthetic dataset generation.",
                "Support for multi-modal agent interactions."
            ),
            commonUses = listOf(
                "Generating synthetic conversational datasets for fine-tuning.",
                "Simulating human-AI interactions for domain research.",
                "Automated code development through developer-critique dialogue."
            ),
            advantages = listOf(
                "Pioneered structured role-play agent methodology in academic literature.",
                "Excellent for synthetic data generation and research experiments."
            ),
            limitations = listOf(
                "More research-focused than production enterprise tooling.",
                "Requires tuning to prevent circular conversations."
            ),
            relatedTechIds = listOf("autogen", "crewai", "langgraph"),
            officialUrl = "https://www.camel-ai.org"
        ),
        Technology(
            id = "agno",
            categoryId = "agentic",
            name = "Agno",
            overview = "Agno (formerly Phidata) is a lightweight, high-performance Python framework for building multimodal AI agents with memory, tools, and storage.",
            mainPurpose = "Delivers fast, developer-friendly agent creation with minimal boilerplate and built-in database state management.",
            keyFeatures = listOf(
                "Minimalistic Python API with fast execution overhead.",
                "Built-in PostgreSQL and SQLite database state and memory engines.",
                "Native support for multimodal inputs and structured outputs.",
                "Interactive CLI and Web UI for testing agent instances."
            ),
            commonUses = listOf(
                "Lightweight API microservices with embedded AI agents.",
                "Personal assistant tools with persistent local memory.",
                "Fast prototyping of tool-calling AI agents."
            ),
            advantages = listOf(
                "Extremely low latency and clean, readable Python code structure.",
                "No heavy framework bloat or unnecessary abstraction layers."
            ),
            limitations = listOf(
                "Smaller community ecosystem compared to LangChain/LangGraph.",
                "Fewer off-the-shelf third-party tool integrations."
            ),
            relatedTechIds = listOf("crewai", "pydantic_ai", "langgraph"),
            officialUrl = "https://www.agno.com"
        ),

        // C. RAG
        Technology(
            id = "langchain",
            categoryId = "rag",
            name = "LangChain",
            overview = "LangChain is the widely adopted open-source framework for building applications powered by language models, providing data loaders, chunkers, and retrievers.",
            mainPurpose = "Composes LLMs, vector stores, document loaders, and tools into composable chains and RAG pipelines.",
            keyFeatures = listOf(
                "Hundreds of document loaders for PDFs, HTML, Notion, Slack, and DBs.",
                "Flexible text splitters and chunking strategies (semantic, recursive).",
                "Unified interface for 50+ vector database providers.",
                "Expression Language (LCEL) for declarative chain composition."
            ),
            commonUses = listOf(
                "Building custom document Q&A and internal knowledge search.",
                "Connecting LLMs to enterprise SQL databases and APIs.",
                "Prototyping end-to-end RAG pipelines rapidly."
            ),
            advantages = listOf(
                "Largest ecosystem of pre-built integrations and community examples.",
                "Available in both Python and TypeScript / JavaScript implementations."
            ),
            limitations = listOf(
                "High abstraction level can make deep debugging complex.",
                "Rapid API evolution requires keeping track of version updates."
            ),
            relatedTechIds = listOf("llamaindex", "langgraph", "langsmith"),
            officialUrl = "https://www.langchain.com"
        ),
        Technology(
            id = "llamaindex",
            categoryId = "rag",
            name = "LlamaIndex",
            overview = "LlamaIndex is the premier data framework for building context-augmented LLM applications and advanced Retrieval-Augmented Generation (RAG) systems.",
            mainPurpose = "Ingests, indexes, structures, and retrieves private data to give LLMs structured context.",
            keyFeatures = listOf(
                "LlamaHub containing 300+ data connectors (S3, SQL, Jira, Google Docs).",
                "Advanced indexing structures (tree, keyword, vector, knowledge graph).",
                "Sophisticated retrieval techniques (hybrid search, sub-query, auto-merging).",
                "Query engines with response synthesis and citation tracking."
            ),
            commonUses = listOf(
                "Advanced enterprise document search and retrieval across disparate silos.",
                "Hierarchical multi-document summarization and analysis.",
                "Complex structured data extraction from unstructured files."
            ),
            advantages = listOf(
                "Industry standard for complex data indexing and advanced RAG strategies.",
                "Exceptional performance on multi-document reasoning tasks."
            ),
            limitations = listOf(
                "Can be overly complex for simple, single-document search tasks.",
                "Requires understanding specialized indexing concepts."
            ),
            relatedTechIds = listOf("langchain", "haystack", "dspy"),
            officialUrl = "https://www.llamaindex.ai"
        ),
        Technology(
            id = "haystack",
            categoryId = "rag",
            name = "Haystack",
            overview = "Haystack by deepset is an end-to-end open-source Python framework for building production-ready RAG applications, semantic search, and agentic pipelines.",
            mainPurpose = "Provides a modular, pipeline-centric architecture for production search and document QA systems.",
            keyFeatures = listOf(
                "Explicit DAG pipeline design for deterministic execution.",
                "Built-in document converters, cleaners, splitters, and rankers.",
                "Support for BM25 keyword search alongside dense vector search.",
                "REST API deployment and Docker containerization support."
            ),
            commonUses = listOf(
                "Enterprise semantic search portals and knowledge management.",
                "Production QA engines in regulated industries.",
                "Hybrid keyword and vector search systems."
            ),
            advantages = listOf(
                "Highly predictable, clean pipeline architecture with explicit data flow.",
                "Excellent production stability and enterprise engineering design."
            ),
            limitations = listOf(
                "Smaller community size compared to LangChain.",
                "Fewer experimental agent extensions than academic frameworks."
            ),
            relatedTechIds = listOf("langchain", "llamaindex", "qdrant"),
            officialUrl = "https://haystack.deepset.ai"
        ),
        Technology(
            id = "dspy",
            categoryId = "rag",
            name = "DSPy",
            overview = "DSPy (Declarative Self-improving Python) by Stanford is a framework for programming—rather than prompting—language models through compiled algorithmic optimizers.",
            mainPurpose = "Replaces fragile manual prompt engineering with compiled, declarative modules that automatically optimize prompts and few-shot examples.",
            keyFeatures = listOf(
                "Declarative Signatures defining input/output behavior without raw text prompts.",
                "Teleprompters (Optimizers) that synthesize optimal prompts and few-shot examples.",
                "Automatic metric-driven compilation and evaluation loops.",
                "Seamless integration with LM models and vector retrievers."
            ),
            commonUses = listOf(
                "Automating prompt optimization across changing model versions.",
                "Building systematic, reproducible RAG and multi-step reasoning systems.",
                "Eliminating manual prompt tweaking in production engineering."
            ),
            advantages = listOf(
                "Programmatic, empirical approach to LLM prompt generation.",
                "Dramatically improves accuracy by systematically optimizing context usage."
            ),
            limitations = listOf(
                "Requires a paradigm shift away from traditional prompt string design.",
                "Optimization compilation runs consume multiple training/tuning API calls."
            ),
            relatedTechIds = listOf("langchain", "llamaindex", "ragas"),
            officialUrl = "https://github.com/stanfordnlp/dspy"
        ),
        Technology(
            id = "ragflow",
            categoryId = "rag",
            name = "RAGFlow",
            overview = "RAGFlow is an open-source RAG engine based on deep document understanding, providing transparent and verifiable retrieval for complex layouts.",
            mainPurpose = "Extracts and parses complex documents (tables, figures, multi-column PDFs) with visual layout understanding before vector indexing.",
            keyFeatures = listOf(
                "Deep document parsing for OCR, complex tables, and figures.",
                "Visual layout inspection and chunk boundary verification.",
                "Out-of-the-box web UI for document management and chat.",
                "Hybrid search combining vector similarity and full-text keyword indexing."
            ),
            commonUses = listOf(
                "Financial report and table-heavy PDF document retrieval.",
                "Legal contract inspection and tabular data extraction.",
                "Enterprise document portals requiring visual chunk validation."
            ),
            advantages = listOf(
                "Superior PDF layout and table parsing compared to simple text splitters.",
                "Turnkey Docker setup with complete admin Web UI."
            ),
            limitations = listOf(
                "Parsing visual layouts requires higher CPU/GPU compute during ingestion.",
                "Less lightweight than simple CLI libraries."
            ),
            relatedTechIds = listOf("unstructured", "llamaindex", "graphrag"),
            officialUrl = "https://github.com/infiniflow/ragflow"
        ),
        Technology(
            id = "graphrag",
            categoryId = "rag",
            name = "GraphRAG",
            overview = "GraphRAG by Microsoft is a modular RAG approach that uses LLMs to construct a Knowledge Graph from unstructured text for holistic context retrieval.",
            mainPurpose = "Enables global context understanding and query-focused summarization across entire document corpora using knowledge graphs.",
            keyFeatures = listOf(
                "Knowledge graph extraction (entities, claims, relationships) from text.",
                "Community detection algorithms (Leiden) to summarize semantic clusters.",
                "Dual retrieval modes: Local (entity-level) and Global (corpus-level).",
                "Superior performance on sense-making and dataset-wide questions."
            ),
            commonUses = listOf(
                "Dataset-wide thematic synthesis (e.g., 'What are the top themes across all interviews?').",
                "Investigative research across complex entity relationships.",
                "Domain knowledge graph creation from unstructured technical docs."
            ),
            advantages = listOf(
                "Answers global corpus-level questions that standard vector chunk RAG fails on.",
                "Provides structured, graph-backed relationship evidence."
            ),
            limitations = listOf(
                "Significantly higher indexing cost due to multiple LLM extraction passes.",
                "Slower ingestion times for large document collections."
            ),
            relatedTechIds = listOf("llamaindex", "neo4j", "langchain"),
            officialUrl = "https://github.com/microsoft/graphrag"
        ),
        Technology(
            id = "unstructured",
            categoryId = "rag",
            name = "Unstructured",
            overview = "Unstructured is an open-source library and API platform designed to ingest, parse, clean, and transform unstructured documents into LLM-ready text.",
            mainPurpose = "Transforms messy files (PDFs, PPTX, DOCX, images, HTML) into clean structured JSON elements for embedding models.",
            keyFeatures = listOf(
                "Parsers for over 20+ document file formats.",
                "Automatic element classification (titles, narrative text, tables, headers).",
                "OCR integration for scanned document image extraction.",
                "Downstream connectors for major vector databases and RAG stacks."
            ),
            commonUses = listOf(
                "Document pre-processing ETL pipelines prior to vector indexing.",
                "Extracting structured tables from legacy corporate PDFs.",
                "Bulk ingestion of enterprise file archives into cloud search."
            ),
            advantages = listOf(
                "Industry benchmark for document parsing and format normalization.",
                "Available as open-source Python package or scalable Cloud API."
            ),
            limitations = listOf(
                "High-density OCR parsing can require GPU acceleration.",
                "Complex custom documents may require tuning layout models."
            ),
            relatedTechIds = listOf("ragflow", "llamaindex", "langchain"),
            officialUrl = "https://unstructured.io"
        ),
        Technology(
            id = "embedchain",
            categoryId = "rag",
            name = "EmbedChain",
            overview = "EmbedChain (now part of Mem0) is an abstraction framework that allows developers to create RAG bots with a simple `app.add()` interface.",
            mainPurpose = "Provides a dead-simple, developer-friendly abstraction layer to load data sources and create chat bots in minutes.",
            keyFeatures = listOf(
                "Simple `app.add('url_or_file')` data loading API.",
                "Automatic chunking, embedding, and vector storage under the hood.",
                "Support for web pages, PDFs, YouTube videos, and database connections.",
                "REST API and web widget deployment support."
            ),
            commonUses = listOf(
                "Rapid prototyping of website Q&A widgets and customer bots.",
                "Adding instant document search to developer side-projects.",
                "Quick demo applications for technical presentations."
            ),
            advantages = listOf(
                "Extremely low line-of-code requirement to get a RAG bot running.",
                "Handles data loading, chunking, and embedding setup automatically."
            ),
            limitations = listOf(
                "Less flexibility for fine-tuning chunking strategy details.",
                "High-level abstraction masks underlying pipeline components."
            ),
            relatedTechIds = listOf("langchain", "mem0", "llamaindex"),
            officialUrl = "https://github.com/embedchain/embedchain"
        ),

        // D. Embedding Models
        Technology(
            id = "openai_embeddings",
            categoryId = "embedding",
            name = "OpenAI Embeddings",
            overview = "OpenAI Embeddings (text-embedding-3-small / text-embedding-3-large) are commercial embedding models offering high semantic quality and flexible dimensions.",
            mainPurpose = "Converts text inputs into dense numerical vector representations for similarity search, classification, and RAG.",
            keyFeatures = listOf(
                "text-embedding-3-small (1536 dimensions) and 3-large (3072 dimensions).",
                "Matryoshka representation learning allowing dimension truncation to save storage.",
                "High multilingual performance across dozens of languages.",
                "Simple, standardized REST API access."
            ),
            commonUses = listOf(
                "Primary embedding engine for enterprise OpenAI RAG pipelines.",
                "Semantic document search and recommendation engines.",
                "Clustering and anomaly detection in unstructured text datasets."
            ),
            advantages = listOf(
                "Extremely easy integration for developers already using OpenAI APIs.",
                "Matryoshka embeddings reduce vector storage costs without losing accuracy."
            ),
            limitations = listOf(
                "Proprietary cloud API dependent on external service availability.",
                "Per-token commercial pricing for high-volume batch indexing."
            ),
            relatedTechIds = listOf("cohere_embed", "voyage_ai", "sentence_transformers"),
            officialUrl = "https://platform.openai.com/docs/guides/embeddings"
        ),
        Technology(
            id = "cohere_embed",
            categoryId = "embedding",
            name = "Cohere Embed",
            overview = "Cohere Embed v3 is a state-of-the-art embedding model series designed specifically for enterprise search and RAG quality across 100+ languages.",
            mainPurpose = "Provides high-accuracy semantic embeddings with search-type tuning (queries vs documents) and compressed vector outputs.",
            keyFeatures = listOf(
                "Input type tuning (`search_document` vs `search_query`) for asymmetric search.",
                "Native int8 and binary vector compression support to cut database costs.",
                "Trained on real-world noisy enterprise document layouts.",
                "Support for over 100 global languages."
            ),
            commonUses = listOf(
                "High-accuracy enterprise semantic search portals.",
                "Cost-effective large vector database indexing using int8 quantization.",
                "Cross-lingual document retrieval across global offices."
            ),
            advantages = listOf(
                "Binary / int8 compression drastically reduces vector DB RAM requirements.",
                "Asymmetric query vs document embedding optimization."
            ),
            limitations = listOf(
                "Commercial API pricing model.",
                "Requires selecting correct input type parameters during indexing."
            ),
            relatedTechIds = listOf("cohere", "openai_embeddings", "bge"),
            officialUrl = "https://cohere.com/embed"
        ),
        Technology(
            id = "voyage_ai",
            categoryId = "embedding",
            name = "Voyage AI",
            overview = "Voyage AI creates domain-specific, state-of-the-art embedding models and rerankers optimized for finance, legal, code, and general retrieval.",
            mainPurpose = "Delivers maximum retrieval accuracy through specialized domain-customized embedding architectures.",
            keyFeatures = listOf(
                "Specialized models: voyage-code-2, voyage-finance-2, voyage-law-2.",
                "Consistently ranks at the top of MTEB (Massive Text Embedding Benchmark).",
                "Large context lengths up to 32,000 tokens for long-document embedding.",
                "Custom domain fine-tuning service for enterprise clients."
            ),
            commonUses = listOf(
                "Legal contract and financial report semantic retrieval.",
                "Codebase search and technical documentation QA engines.",
                "High-precision enterprise RAG systems."
            ),
            advantages = listOf(
                "Industry-leading retrieval accuracy on MTEB benchmarks.",
                "Long context window eliminates aggressive document fragmenting."
            ),
            limitations = listOf(
                "Cloud API dependency.",
                "Smaller brand recognition compared to OpenAI."
            ),
            relatedTechIds = listOf("openai_embeddings", "cohere_embed", "bge"),
            officialUrl = "https://www.voyageai.com"
        ),
        Technology(
            id = "sentence_transformers",
            categoryId = "embedding",
            name = "Sentence Transformers",
            overview = "Sentence Transformers (SBERT) is the popular open-source Python framework for compute-efficient sentence, paragraph, and image embeddings.",
            mainPurpose = "Allows developers to run open-source embedding and cross-encoder models locally on private CPU/GPU hardware.",
            keyFeatures = listOf(
                "Access to thousands of open pre-trained models on Hugging Face.",
                "Support for dense embeddings and Cross-Encoder reranking models.",
                "PyTorch and ONNX runtime support for ultra-fast CPU inference.",
                "Built-in fine-tuning and triplet loss training utilities."
            ),
            commonUses = listOf(
                "Local, zero-cost embedding generation for offline RAG systems.",
                "Duplicate question detection and sentence clustering.",
                "Fine-tuning custom embedding models on domain-specific pairs."
            ),
            advantages = listOf(
                "100% open source, free, private, and runs entirely offline.",
                "Vast ecosystem of compatible community weights and architectures."
            ),
            limitations = listOf(
                "Requires managing local hardware compute and deployment memory.",
                "Older default models (e.g. all-MiniLM-L6-v2) have smaller context windows."
            ),
            relatedTechIds = listOf("hugging_face", "bge", "openai_embeddings"),
            officialUrl = "https://www.sbert.net"
        ),
        Technology(
            id = "bge",
            categoryId = "embedding",
            name = "BGE (BAAI General Embedding)",
            overview = "BGE (BAAI General Embedding) is a top-performing open-source family of embedding and reranker models developed by the Beijing Academy of Artificial Intelligence.",
            mainPurpose = "Provides high-performance open-source embeddings and rerankers for open semantic search architectures.",
            keyFeatures = listOf(
                "Consistently top-ranked open model family on the MTEB leaderboard.",
                "Includes dense models, sparse models (BGE-M3), and reranker models.",
                "BGE-M3 supports multi-functionality: multi-linguality, multi-granularity, and multi-retrieval.",
                "Full open-weights availability on Hugging Face."
            ),
            commonUses = listOf(
                "Open-source production RAG systems requiring top retrieval accuracy.",
                "Two-stage retrieval pipelines (Dense Vector Search + BGE Reranker).",
                "Multilingual semantic search engines."
            ),
            advantages = listOf(
                "BGE-M3 combines dense vectors, sparse vectors, and multi-vector search.",
                "Outstanding performance rivaling top commercial embedding APIs."
            ),
            limitations = listOf(
                "Requires hosting and inference GPU compute infrastructure.",
                "BGE-M3 model size demands higher VRAM than lightweight MiniLM models."
            ),
            relatedTechIds = listOf("sentence_transformers", "cohere_embed", "hugging_face"),
            officialUrl = "https://github.com/FlagOpen/FlagEmbedding"
        ),
        Technology(
            id = "vertex_embeddings",
            categoryId = "embedding",
            name = "Google Vertex AI Embeddings",
            overview = "Google Vertex AI Text and Multimodal Embeddings are enterprise cloud services providing high-dimensional vectors backed by Google infrastructure.",
            mainPurpose = "Generates text and image embeddings deeply integrated with Google Cloud Platform, BigQuery, and Vertex Vector Search.",
            keyFeatures = listOf(
                "Text and image multimodal embedding capabilities.",
                "Native integration with Google Cloud Vertex AI Vector Search.",
                "Enterprise SLA, security, IAM control, and SOC2 compliance.",
                "Support for task-specific embedding parameters."
            ),
            commonUses = listOf(
                "Enterprise RAG applications deployed on Google Cloud Platform.",
                "Multimodal product catalog search (text query to image results).",
                "Large-scale BigQuery data analytics and semantic indexing."
            ),
            advantages = listOf(
                "Seamless integration with GCP ecosystem and BigQuery.",
                "High enterprise reliability and compliance guarantees."
            ),
            limitations = listOf(
                "Requires GCP account and cloud service billing configuration.",
                "Proprietary Google Cloud API."
            ),
            relatedTechIds = listOf("google_gemini", "azure_openai_embeddings", "openai_embeddings"),
            officialUrl = "https://cloud.google.com/vertex-ai"
        ),
        Technology(
            id = "azure_openai_embeddings",
            categoryId = "embedding",
            name = "Azure OpenAI Embeddings",
            overview = "Azure OpenAI Embeddings deliver OpenAI embedding models hosted within Microsoft Azure's enterprise security boundary and private networking.",
            mainPurpose = "Provides enterprise-compliant OpenAI vector embeddings with VNet isolation, regional residency, and Azure security.",
            keyFeatures = listOf(
                "OpenAI text-embedding-3 models deployed inside private Azure subscriptions.",
                "Integration with Azure AI Search and Azure Cosmos DB vector search.",
                "Private Endpoints, VNet support, and enterprise RBAC.",
                "Regional data residency guarantees."
            ),
            commonUses = listOf(
                "Enterprise RAG for healthcare, finance, and government sectors.",
                "Azure AI Search hybrid retrieval indexing.",
                "Corporate compliance-mandated vector embedding pipelines."
            ),
            advantages = listOf(
                "Combines OpenAI model performance with Azure enterprise security.",
                "Meets strict data privacy, HIPAA, and regional sovereignty rules."
            ),
            limitations = listOf(
                "Requires Azure quota approval for enterprise deployments.",
                "Management overhead tied to Azure Cloud resource provisioning."
            ),
            relatedTechIds = listOf("openai_embeddings", "vertex_embeddings", "cohere_embed"),
            officialUrl = "https://azure.microsoft.com/services/cognitive-services/openai-service/"
        ),

        // E. Model Context Protocol (MCP)
        Technology(
            id = "mcp_sdk",
            categoryId = "mcp",
            name = "MCP SDK",
            overview = "The MCP SDK (Model Context Protocol SDK) is the official open-source software development kit for building MCP clients and servers in TypeScript and Python.",
            mainPurpose = "Provides standard protocol implementations for exposing tools, prompts, and resources to AI models over JSON-RPC 2.0.",
            keyFeatures = listOf(
                "Standardized specification for Client-Server context exchange.",
                "Built-in primitives for Tools (actions), Resources (data), and Prompts (templates).",
                "Transport layers for Stdio (local processes) and SSE (HTTP/server-sent events).",
                "Official SDK maintenance in TypeScript, Python, and Kotlin."
            ),
            commonUses = listOf(
                "Building custom tool servers for local desktop AI apps (Claude Desktop, IDEs).",
                "Exposing internal corporate databases and APIs as standard AI tools.",
                "Creating reusable tool adapters for LLM agents."
            ),
            advantages = listOf(
                "Eliminates writing custom integration glue code for every distinct AI app.",
                "Backed by Anthropic and an expanding open industry coalition."
            ),
            limitations = listOf(
                "Protocol standard is actively evolving.",
                "Requires understanding transport layer mechanics (Stdio vs SSE)."
            ),
            relatedTechIds = listOf("fastmcp", "mcp_registry", "github_mcp"),
            officialUrl = "https://modelcontextprotocol.io"
        ),
        Technology(
            id = "fastmcp",
            categoryId = "mcp",
            name = "FastMCP",
            overview = "FastMCP is a high-level, Pythonic framework (inspired by FastAPI) designed to build Model Context Protocol servers rapidly with minimal boilerplate.",
            mainPurpose = "Simplifies MCP server development in Python using clean function decorators and automatic type hints.",
            keyFeatures = listOf(
                "Decorator-based syntax (`@mcp.tool()`, `@mcp.resource()`).",
                "Automatic Pydantic schema generation from Python type annotations.",
                "Built-in CLI for testing, running, and inspecting MCP servers.",
                "Seamless handling of Stdio and SSE transports."
            ),
            commonUses = listOf(
                "Building production MCP tool servers in Python in minutes.",
                "Exposing Python data analysis libraries to LLM clients.",
                "Prototyping desktop AI assistant tools."
            ),
            advantages = listOf(
                "Drastically reduces lines of code compared to raw MCP SDK usage.",
                "Extremely familiar API style for FastAPI and Python developers."
            ),
            limitations = listOf(
                "Python-specific framework.",
                "High-level abstraction hides some low-level protocol transport flags."
            ),
            relatedTechIds = listOf("mcp_sdk", "pydantic_ai", "ollama"),
            officialUrl = "https://github.com/jlowin/fastmcp"
        ),
        Technology(
            id = "mcp_registry",
            categoryId = "mcp",
            name = "MCP Registry",
            overview = "The MCP Registry is an open catalog and discovery directory for community and official Model Context Protocol (MCP) servers.",
            mainPurpose = "Catalogues verified MCP servers so developers and AI applications can discover and connect to external data sources.",
            keyFeatures = listOf(
                "Centralized index of official and community-maintained MCP servers.",
                "Metadata tagging for tool capabilities, prerequisites, and authentication.",
                "One-click configuration strings for Claude Desktop and MCP clients.",
                "Security auditing guidelines for community servers."
            ),
            commonUses = listOf(
                "Discovering pre-built MCP servers for databases, SaaS tools, and APIs.",
                "Publishing custom open-source MCP tools for global developer usage.",
                "Standardizing application plugin marketplaces."
            ),
            advantages = listOf(
                "Accelerates development by avoiding reinventing existing API connectors.",
                "Fosters an open ecosystem of interoperable AI integrations."
            ),
            limitations = listOf(
                "Community-contributed servers require security verification before use.",
                "Varying maintenance quality across open community listings."
            ),
            relatedTechIds = listOf("mcp_sdk", "github_mcp", "postgres_mcp"),
            officialUrl = "https://github.com/modelcontextprotocol/servers"
        ),
        Technology(
            id = "github_mcp",
            categoryId = "mcp",
            name = "GitHub MCP Server",
            overview = "The GitHub MCP Server is an official reference MCP integration that exposes GitHub repositories, issues, pull requests, and file contents to AI models.",
            mainPurpose = "Enables AI models to search code, read issues, create pull requests, and manage repositories via standardized MCP tools.",
            keyFeatures = listOf(
                "Tools for searching repositories, code, and issues.",
                "Actions to read, create, and edit file contents on branches.",
                "Pull request creation, review comment generation, and merge checks.",
                "Personal Access Token (PAT) authentication management."
            ),
            commonUses = listOf(
                "AI coding assistants inspecting remote repository structures.",
                "Automated PR summary generation and issue triage.",
                "AI agentic bug fixing workflows directly on GitHub."
            ),
            advantages = listOf(
                "Standardized protocol access to GitHub without custom REST API wrappers.",
                "Official support ensuring compatibility with GitHub API updates."
            ),
            limitations = listOf(
                "Requires GitHub API rate limit monitoring.",
                "Requires careful Personal Access Token permission scoping."
            ),
            relatedTechIds = listOf("mcp_sdk", "slack_mcp", "filesystem_mcp"),
            officialUrl = "https://github.com/modelcontextprotocol/servers/tree/main/src/github"
        ),
        Technology(
            id = "slack_mcp",
            categoryId = "mcp",
            name = "Slack MCP Server",
            overview = "The Slack MCP Server connects AI clients to Slack workspaces, allowing models to read channels, post messages, and search message history.",
            mainPurpose = "Enables conversational AI assistants to interact safely with team communications on Slack.",
            keyFeatures = listOf(
                "Tools to list public channels, read thread histories, and post messages.",
                "Semantic search across team message archives.",
                "Slack Bot Token and OAuth permission integration.",
                "Markdown formatting conversion for Slack message blocks."
            ),
            commonUses = listOf(
                "AI team assistants summarizing daily Slack discussions.",
                "Automated customer support notification bots.",
                "Cross-channel knowledge retrieval for engineering teams."
            ),
            advantages = listOf(
                "Seamless integration of workspace chat context into AI desktop apps.",
                "Standardized tool definitions across all MCP-compliant LLM clients."
            ),
            limitations = listOf(
                "Requires workspace admin app installation and permissions.",
                "High-volume message fetching can hit Slack API tier limits."
            ),
            relatedTechIds = listOf("mcp_sdk", "github_mcp", "gdrive_mcp"),
            officialUrl = "https://github.com/modelcontextprotocol/servers/tree/main/src/slack"
        ),
        Technology(
            id = "postgres_mcp",
            categoryId = "mcp",
            name = "PostgreSQL MCP Server",
            overview = "The PostgreSQL MCP Server provides safe read/write access and schema inspection tools for PostgreSQL databases via the Model Context Protocol.",
            mainPurpose = "Allows AI agents to inspect database schemas, execute SQL queries, and analyze tabular data securely.",
            keyFeatures = listOf(
                "Database schema inspection (tables, columns, foreign keys).",
                "Read-only query mode options for security isolation.",
                "SQL query validation and error feedback.",
                "PostgreSQL connection string and connection pooling support."
            ),
            commonUses = listOf(
                "Natural language text-to-SQL query interfaces for business intelligence.",
                "AI database auditing and schema documentation generation.",
                "Data analysis agents inspecting relational data."
            ),
            advantages = listOf(
                "Gives AI models structured database understanding without manual schema copy-pasting.",
                "Includes read-only safety flags to protect production data."
            ),
            limitations = listOf(
                "Executing arbitrary write queries poses security risks if unmonitored.",
                "Complex queries on massive tables require execution timeout guards."
            ),
            relatedTechIds = listOf("mcp_sdk", "postgres_db", "pgvector"),
            officialUrl = "https://github.com/modelcontextprotocol/servers/tree/main/src/postgres"
        ),
        Technology(
            id = "gdrive_mcp",
            categoryId = "mcp",
            name = "Google Drive MCP Server",
            overview = "The Google Drive MCP Server connects AI clients to Google Drive, enabling search, text extraction, and document inspection across Docs, Sheets, and Slides.",
            mainPurpose = "Provides tools for AI assistants to locate and read cloud documents stored in Google Workspace.",
            keyFeatures = listOf(
                "File search by keyword, mime-type, and folder structure.",
                "Text extraction from Google Docs, Sheets, and PDFs.",
                "Google OAuth 2.0 user authentication flow.",
                "Support for Shared Drives and permission checking."
            ),
            commonUses = listOf(
                "Desktop AI assistants searching corporate Google Drive archives.",
                "Automated summarization of meeting notes and strategy docs.",
                "Data extraction from spreadsheets for report generation."
            ),
            advantages = listOf(
                "Direct connection to personal and enterprise Google Drive storage.",
                "Respects user OAuth permissions and document access scopes."
            ),
            limitations = listOf(
                "Large binary files require server-side text conversion.",
                "OAuth token refresh management."
            ),
            relatedTechIds = listOf("mcp_sdk", "slack_mcp", "filesystem_mcp"),
            officialUrl = "https://github.com/modelcontextprotocol/servers/tree/main/src/gdrive"
        ),
        Technology(
            id = "filesystem_mcp",
            categoryId = "mcp",
            name = "Filesystem MCP Server",
            overview = "The Filesystem MCP Server provides secure local file reading, writing, directory listing, and file searching capabilities to AI clients within allowed directory paths.",
            mainPurpose = "Exposes local desktop file system operations to AI models with strict path sandboxing.",
            keyFeatures = listOf(
                "Tools: `read_file`, `write_file`, `list_directory`, `search_files`.",
                "Strict path scoping restricting operations to user-specified allowed directories.",
                "Support for text and binary file metadata inspection.",
                "Fast local Stdio transport execution."
            ),
            commonUses = listOf(
                "Local AI coding assistants modifying code on local disk.",
                "Desktop AI tools reorganizing local document folders.",
                "Log file inspection and local file analysis."
            ),
            advantages = listOf(
                "Enables desktop LLMs (like Claude Desktop) to operate directly on local files.",
                "Sandboxing prevents unauthorized access outside approved directory trees."
            ),
            limitations = listOf(
                "Allows file overwrites if granted write permissions.",
                "Requires careful folder path selection."
            ),
            relatedTechIds = listOf("mcp_sdk", "github_mcp", "fastmcp"),
            officialUrl = "https://github.com/modelcontextprotocol/servers/tree/main/src/filesystem"
        ),

        // F. AI Security & Guardrails
        Technology(
            id = "nemo_guardrails",
            categoryId = "security",
            name = "NVIDIA NeMo Guardrails",
            overview = "NVIDIA NeMo Guardrails is an open-source toolkit for adding programmable safety guardrails to LLM-based conversational applications using Colang syntax.",
            mainPurpose = "Enforces conversational flows, domain boundaries, safety rules, and fact-checking between users and LLM APIs.",
            keyFeatures = listOf(
                "Colang modeling language for defining conversational flows and rules.",
                "Topical guardrails to keep conversations on specific business subjects.",
                "Safety guardrails to block harmful language, PII, and jailbreaks.",
                "Execution guardrails to validate third-party tool actions."
            ),
            commonUses = listOf(
                "Enterprise customer service bots with strict topic boundaries.",
                "Preventing brand reputation damage from unexpected LLM outputs.",
                "Blocking prompt injection and jailbreak attempts."
            ),
            advantages = listOf(
                "Declarative Colang syntax provides readable control over conversation paths.",
                "Backed by NVIDIA enterprise AI engineering."
            ),
            limitations = listOf(
                "Requires learning Colang rule syntax.",
                "Guardrail checking calls add latency to LLM response pipelines."
            ),
            relatedTechIds = listOf("guardrails_ai", "lakera_guard", "presidio"),
            officialUrl = "https://github.com/NVIDIA/NeMo-Guardrails"
        ),
        Technology(
            id = "guardrails_ai",
            categoryId = "security",
            name = "Guardrails AI",
            overview = "Guardrails AI is an open-source Python framework and hub (`RAIL` specification) for validating and structuring LLM inputs and outputs.",
            mainPurpose = "Enforces structural correctness, semantic validation, PII redaction, and hallucination checks on LLM responses.",
            keyFeatures = listOf(
                "Guardrails Hub with dozens of pre-built community validators.",
                "Enforces JSON schema adherence and typed data validation.",
                "Automatic re-asking mechanism to prompt LLM to correct invalid outputs.",
                "PII detection, toxic language filtering, and competitor mention blocking."
            ),
            commonUses = listOf(
                "Guaranteeing valid JSON outputs for database insertion.",
                "Masking sensitive customer PII before sending text to external LLMs.",
                "Real-time factual validation and hallucination mitigation."
            ),
            advantages = listOf(
                "Extensive Guardrails Hub validator marketplace.",
                "Built-in corrective re-prompting loop on validation failure."
            ),
            limitations = listOf(
                "Re-asking loops increase token usage if models repeatedly fail schemas.",
                "Validator execution adds processing latency."
            ),
            relatedTechIds = listOf("nemo_guardrails", "presidio", "promptfoo"),
            officialUrl = "https://www.guardrailsai.com"
        ),
        Technology(
            id = "presidio",
            categoryId = "security",
            name = "Microsoft Presidio",
            overview = "Microsoft Presidio is an open-source data protection and anonymization SDK that detects and anonymizes sensitive Personally Identifiable Information (PII) in text and images.",
            mainPurpose = "Detects, masks, redacts, or encrypts PII (SSNs, credit cards, emails, names, phone numbers) prior to cloud LLM processing.",
            keyFeatures = listOf(
                "Presidio Analyzer using spaCy NLP, regex, and ML recognition models.",
                "Presidio Anonymizer offering masking, hashing, encryption, and redaction.",
                "Custom recognizer support for company-specific confidential formats.",
                "Support for multiple languages and image OCR masking."
            ),
            commonUses = listOf(
                "Redacting confidential user data before sending prompts to third-party APIs.",
                "HIPAA and GDPR compliance enforcement in healthcare AI.",
                "Cleansing internal data logs before vector embedding storage."
            ),
            advantages = listOf(
                "Gold standard open-source library for PII detection and anonymization.",
                "Highly customizable rule sets and custom recognizer plugins."
            ),
            limitations = listOf(
                "Requires tuning custom recognizers to minimize false positives.",
                "Heavy NLP spaCy models require memory overhead."
            ),
            relatedTechIds = listOf("guardrails_ai", "lakera_guard", "azure_content_safety"),
            officialUrl = "https://microsoft.github.io/presidio/"
        ),
        Technology(
            id = "lakera_guard",
            categoryId = "security",
            name = "Lakera Guard",
            overview = "Lakera Guard is a enterprise AI security API that protects LLM applications in real time from prompt injections, jailbreaks, data loss, and toxic content.",
            mainPurpose = "Delivers sub-second security API defenses against direct and indirect prompt injection attacks.",
            keyFeatures = listOf(
                "Real-time detection of direct jailbreaks and indirect prompt injections.",
                "Continuous security updates powered by Gandalf security challenge research.",
                "Ultra-low latency (<50ms) security proxy API.",
                "PII leak detection and harmful content classification."
            ),
            commonUses = listOf(
                "Securing public-facing conversational AI agents against hackers.",
                "Protecting RAG systems from indirect prompt injection in retrieved docs.",
                "Enterprise AI firewall deployment."
            ),
            advantages = listOf(
                "Industry-leading prompt injection detection accuracy.",
                "Extremely fast API response time designed for production proxying."
            ),
            limitations = listOf(
                "Commercial API subscription service.",
                "SaaS cloud dependency."
            ),
            relatedTechIds = listOf("prompt_security", "protect_ai", "nemo_guardrails"),
            officialUrl = "https://www.lakera.ai"
        ),
        Technology(
            id = "prompt_security",
            categoryId = "security",
            name = "Prompt Security",
            overview = "Prompt Security is a comprehensive enterprise security platform that secures the full lifecycle of generative AI across employees, applications, and LLMs.",
            mainPurpose = "Provides visibility, shadow AI discovery, prompt inspection, and threat prevention for enterprise AI adoption.",
            keyFeatures = listOf(
                "Shadow AI discovery and employee browser extension monitoring.",
                "Real-time API firewall against prompt injection and data exfiltration.",
                "Sensitive data leakage (IP, PII, secrets) prevention.",
                "Centralized governance, audit logs, and compliance reporting."
            ),
            commonUses = listOf(
                "Securing internal corporate usage of GenAI tools (ChatGPT, Claude).",
                "Protecting custom-built enterprise LLM API applications.",
                "Chief Information Security Officer (CISO) AI compliance tracking."
            ),
            advantages = listOf(
                "Full spectrum security covering both employee usage and internal LLM apps.",
                "Strong enterprise governance and compliance reporting features."
            ),
            limitations = listOf(
                "Targeted exclusively at commercial enterprise security teams.",
                "Requires enterprise deployment setup."
            ),
            relatedTechIds = listOf("lakera_guard", "protect_ai", "aws_bedrock_guardrails"),
            officialUrl = "https://www.prompt.security"
        ),
        Technology(
            id = "protect_ai",
            categoryId = "security",
            name = "Protect AI",
            overview = "Protect AI provides an end-to-end AI Application Security Platform (Reckoner, Guardian, ModelScan) to secure ML models, pipelines, and supply chains.",
            mainPurpose = "Defends the AI supply chain by scanning ML model artifacts (PyTorch, TensorFlow, Safetensors) for malware and vulnerabilities.",
            keyFeatures = listOf(
                "ModelScan open-source tool to detect pickle exploits in model weights.",
                "AI Bill of Materials (AIBOM) creation for compliance audits.",
                "LLM application vulnerability scanning and threat detection.",
                "Jupyter notebook and pipeline security auditing."
            ),
            commonUses = listOf(
                "Scanning downloaded Hugging Face model weights for hidden malware.",
                "Securing MLOps pipelines and training data repositories.",
                "Enterprise AI supply chain vulnerability management."
            ),
            advantages = listOf(
                "Pioneered AI supply chain security and model artifact scanning.",
                "Creators of popular open security tools like ModelScan."
            ),
            limitations = listOf(
                "Focuses on ML supply chain security rather than basic chat UX formatting.",
                "Requires integration into DevOps/MLOps deployment pipelines."
            ),
            relatedTechIds = listOf("lakera_guard", "prompt_security", "hugging_face"),
            officialUrl = "https://protectai.com"
        ),
        Technology(
            id = "azure_content_safety",
            categoryId = "security",
            name = "Azure AI Content Safety",
            overview = "Azure AI Content Safety is a cloud service that detects harmful user-generated and AI-generated content in applications across text and image modalities.",
            mainPurpose = "Filters hate speech, violence, self-harm, sexual content, and prompt injections with severity scoring.",
            keyFeatures = listOf(
                "Multi-category threat detection (Hate, Violence, Sexual, Self-Harm).",
                "Granular severity level scoring (0 to 6) for flexible thresholding.",
                "Prompt Shields feature specifically targeting prompt injection attacks.",
                "Groundedness detection to measure if LLM responses match source context."
            ),
            commonUses = listOf(
                "Content moderation for enterprise applications and gaming platforms.",
                "Safety filtering for Azure OpenAI Service deployments.",
                "Measuring RAG output groundedness against retrieved documents."
            ),
            advantages = listOf(
                "Deep native integration with Azure AI and Azure OpenAI Service.",
                "Sophisticated severity scoring allows fine-tuning block thresholds."
            ),
            limitations = listOf(
                "Commercial Azure Cloud service billing.",
                "Tightly integrated into Azure Cloud environment."
            ),
            relatedTechIds = listOf("presidio", "aws_bedrock_guardrails", "lakera_guard"),
            officialUrl = "https://azure.microsoft.com/services/ai-services/ai-content-safety/"
        ),
        Technology(
            id = "aws_bedrock_guardrails",
            categoryId = "security",
            name = "AWS Bedrock Guardrails",
            overview = "AWS Bedrock Guardrails allows developers to implement customized safety, privacy, and topic filters across all LLMs available in Amazon Bedrock.",
            mainPurpose = "Enforces enterprise safety controls and PII redaction across Bedrock foundation models with a single configuration.",
            keyFeatures = listOf(
                "Denied topics filtering to block unwanted subject matter.",
                "Content filters for hate speech, insults, violence, and sexual content.",
                "Sensitive information filters for PII redaction and regex matching.",
                "Contextual grounding checks to prevent hallucinations."
            ),
            commonUses = listOf(
                "Enforcing unified safety policies across multiple Bedrock LLMs.",
                "Redacting sensitive customer PII in Bedrock agent conversations.",
                "Preventing off-topic conversations in enterprise AWS bots."
            ),
            advantages = listOf(
                "Applies consistently across different model providers on Bedrock (Anthropic, Meta, Mistral).",
                "Native AWS IAM permissioning and CloudWatch telemetry."
            ),
            limitations = listOf(
                "Exclusive to applications running on AWS Bedrock.",
                "Requires AWS cloud infrastructure configuration."
            ),
            relatedTechIds = listOf("aws_bedrock_agents", "azure_content_safety", "nemo_guardrails"),
            officialUrl = "https://aws.amazon.com/bedrock/guardrails/"
        ),

        // G. AI Observability & Evaluation
        Technology(
            id = "langsmith",
            categoryId = "observability",
            name = "LangSmith",
            overview = "LangSmith by LangChain is a premier developer platform for debugging, testing, evaluating, and monitoring LLM applications, chains, and agents.",
            mainPurpose = "Provides full execution tracing, prompt playground testing, automated evaluation, and latency/cost tracking.",
            keyFeatures = listOf(
                "Nested call tree visualization tracing exact prompt inputs, tool calls, and outputs.",
                "Dataset management and automated evaluation benchmarks.",
                "Online monitoring for latency, token cost, feedback scores, and errors.",
                "One-line SDK integration (`LANGCHAIN_TRACING_V2=true`)."
            ),
            commonUses = listOf(
                "Debugging complex multi-step agent loops and LangGraph workflows.",
                "Regression testing LLM prompts against curated test datasets.",
                "Production latency and token cost tracking across team deployments."
            ),
            advantages = listOf(
                "Seamless, effortless integration with LangChain and LangGraph ecosystems.",
                "Outstanding UI for stepping through complex multi-agent execution trees."
            ),
            limitations = listOf(
                "SaaS platform with tiered usage pricing.",
                "Best experience is optimized around LangChain framework primitives."
            ),
            relatedTechIds = listOf("langchain", "langgraph", "langfuse"),
            officialUrl = "https://www.langchain.com/langsmith"
        ),
        Technology(
            id = "langfuse",
            categoryId = "observability",
            name = "Langfuse",
            overview = "Langfuse is an open-source LLM observability and evaluation platform offering tracing, prompt management, evaluation, and cost analytics.",
            mainPurpose = "Provides self-hostable or cloud observability for LLM applications with open telemetry standard support.",
            keyFeatures = listOf(
                "Open-source and 100% self-hostable via Docker.",
                "Detailed trace trees showing latency, token usage, and cost per generation.",
                "Centralized prompt management and version control SDK.",
                "Human annotation queues and automated LLM-as-a-judge evaluations."
            ),
            commonUses = listOf(
                "Production LLM app observability for privacy-sensitive enterprises.",
                "Tracking token expenditures across multi-tenant user accounts.",
                "Prompt versioning and deployment without code redeployments."
            ),
            advantages = listOf(
                "Open-source core allows hosting on private cloud or on-premises.",
                "Framework-agnostic SDKs for Python, JS/TS, OpenAI, and LangChain."
            ),
            limitations = listOf(
                "Self-hosting requires maintaining PostgreSQL and ClickHouse instances.",
                "Requires infrastructure setup for self-hosted production."
            ),
            relatedTechIds = listOf("langsmith", "arize_phoenix", "helicone"),
            officialUrl = "https://langfuse.com"
        ),
        Technology(
            id = "arize_phoenix",
            categoryId = "observability",
            name = "Arize Phoenix",
            overview = "Arize Phoenix is an open-source AI observability library designed for tracing, evaluation, and dataset analysis in RAG and agent applications.",
            mainPurpose = "Delivers notebook-first and containerized tracing with specialized RAG evaluation metrics (faithfulness, relevance).",
            keyFeatures = listOf(
                "OpenTelemetry-based tracing for LlamaIndex, LangChain, and DSPy.",
                "Evals for RAG: QA correctness, hallucination, toxicity, and document relevance.",
                "3D vector space visualization for embedding drift analysis.",
                "Runs locally inside Jupyter Notebooks or as a standalone server."
            ),
            commonUses = listOf(
                "RAG pipeline evaluation and retrieval accuracy troubleshooting.",
                "Analyzing embedding distribution and retrieval gaps in 3D plots.",
                "Local developer debugging of LLM applications."
            ),
            advantages = listOf(
                "Runs directly inside local Jupyter notebooks with zero SaaS account required.",
                "Deep specialization in RAG retrieval and embedding space analysis."
            ),
            limitations = listOf(
                "In-notebook server is temporary unless deployed as a persistent service.",
                "Focuses heavily on technical RAG metrics."
            ),
            relatedTechIds = listOf("ragas", "trulens", "llamaindex"),
            officialUrl = "https://phoenix.arize.com"
        ),
        Technology(
            id = "wandb_weave",
            categoryId = "observability",
            name = "Weights & Biases Weave",
            overview = "Weights & Biases Weave is a lightweight toolkit for tracking, evaluating, and monitoring LLM applications, building on W&B's MLOps heritage.",
            mainPurpose = "Provides developer-friendly function logging, trace tracking, and systematic evaluation loops for GenAI pipelines.",
            keyFeatures = listOf(
                "Simple `@weave.op()` Python decorator for automatic tracing.",
                "Structured evaluation framework for comparing models and prompts.",
                "Rich W&B dashboard for visual experiment tracking.",
                "Built-in token cost calculation and latency analytics."
            ),
            commonUses = listOf(
                "Experiment tracking when comparing different LLM providers or prompts.",
                "Systematic evaluation of fine-tuned models vs base frontier models.",
                "Production trace logging integrated into existing W&B MLOps setups."
            ),
            advantages = listOf(
                "Minimal friction decorator syntax (`@weave.op()`).",
                "Integrates seamlessly with established Weights & Biases MLOps workflows."
            ),
            limitations = listOf(
                "Requires Weights & Biases account ecosystem.",
                "SaaS cloud dependency."
            ),
            relatedTechIds = listOf("langsmith", "langfuse", "promptfoo"),
            officialUrl = "https://wandb.ai/site/weave"
        ),
        Technology(
            id = "trulens",
            categoryId = "observability",
            name = "TruLens",
            overview = "TruLens by TruEra is an open-source evaluation framework for measuring and monitoring LLM application performance using the 'RAG Triad'.",
            mainPurpose = "Evaluates RAG systems systematically against Context Relevance, Groundedness, and Answer Relevance.",
            keyFeatures = listOf(
                "The RAG Triad evaluation methodology (Relevance, Groundedness, Answer Quality).",
                "Feedback functions powered by open-source and commercial LLM judges.",
                "Streamlit-based local dashboard for visual inspection of evaluations.",
                "Integrations with LlamaIndex, LangChain, and custom frameworks."
            ),
            commonUses = listOf(
                "Benchmarking RAG system quality before production launch.",
                "Detecting hallucinations in automated document summarizers.",
                "Continuous feedback evaluation in CI/CD build pipelines."
            ),
            advantages = listOf(
                "Pioneered the clear, actionable 'RAG Triad' evaluation conceptual framework.",
                "Open-source Python package with local Streamlit dashboard."
            ),
            limitations = listOf(
                "Running continuous LLM-as-a-judge evaluations incurs API costs.",
                "Evaluation speed depends on judge model response latency."
            ),
            relatedTechIds = listOf("ragas", "arize_phoenix", "promptfoo"),
            officialUrl = "https://www.trulens.org"
        ),
        Technology(
            id = "ragas",
            categoryId = "rag",
            name = "Ragas",
            overview = "Ragas (Retrieval Augmented Generation Assessment) is an open-source framework for evaluating Retrieval Augmented Generation pipelines.",
            mainPurpose = "Provides automated metric scores (Faithfulness, Answer Relevance, Context Precision, Context Recall) without requiring human ground-truth labels.",
            keyFeatures = listOf(
                "Metrics: Faithfulness, Answer Relevance, Context Precision, Context Recall, Harmfulness.",
                "Synthetic test dataset generation capabilities from domain documents.",
                "Integrations with LangChain, LlamaIndex, and CI/CD testing frameworks.",
                "Lightweight Python library integration."
            ),
            commonUses = listOf(
                "Automating RAG evaluation in continuous integration test suites.",
                "Generating synthetic evaluation datasets from raw PDF archives.",
                "Comparing retrieval quality between different vector databases."
            ),
            advantages = listOf(
                "Industry standard metrics for automated RAG evaluation.",
                "Generates synthetic question-context-answer test sets automatically."
            ),
            limitations = listOf(
                "Relies on LLM-as-a-judge models (e.g. GPT-4) for evaluation scoring.",
                "Requires careful prompt selection for judge models."
            ),
            relatedTechIds = listOf("trulens", "arize_phoenix", "llamaindex"),
            officialUrl = "https://docs.ragas.io"
        ),
        Technology(
            id = "promptfoo",
            categoryId = "observability",
            name = "Promptfoo",
            overview = "Promptfoo is a fast, CLI-first open-source security scanner and evaluation framework for LLM prompts, guardrails, and RAG outputs.",
            mainPurpose = "Runs automated prompt red-teaming, security vulnerability scans, and matrix evaluations in local CLI or CI/CD pipelines.",
            keyFeatures = listOf(
                "CLI tool for fast matrix evaluation (`promptfoo eval`).",
                "Automated red-teaming for jailbreaks, prompt injection, and PII leaks.",
                "Supports testing local models (Ollama), cloud APIs, and custom HTTP targets.",
                "Generates shareable HTML matrix test reports."
            ),
            commonUses = listOf(
                "Red-teaming LLM applications for security vulnerabilities before release.",
                "Regression testing prompts across multiple model versions in CI/CD.",
                "Comparing prompt variations side-by-side in HTML tables."
            ),
            advantages = listOf(
                "Ultra-fast local CLI execution with lightweight YAML configuration.",
                "Excellent security red-teaming and prompt injection test batteries."
            ),
            limitations = listOf(
                "CLI-first focus rather than live production APM real-time monitoring.",
                "Requires writing YAML evaluation test cases."
            ),
            relatedTechIds = listOf("guardrails_ai", "trulens", "langsmith"),
            officialUrl = "https://www.promptfoo.dev"
        ),
        Technology(
            id = "helicone",
            categoryId = "observability",
            name = "Helicone",
            overview = "Helicone is an open-source LLM observability platform that acts as a lightweight API proxy to monitor costs, latency, caching, and rate limits.",
            mainPurpose = "Monitors, caches, and logs LLM API traffic in real time by changing a single base URL string.",
            keyFeatures = listOf(
                "One-line integration by changing base API URL to Helicone proxy.",
                "Automatic response caching to save API costs during development.",
                "Real-time cost, token, and latency analytics dashboards.",
                "Custom user rate-limiting and threat mitigation rules."
            ),
            commonUses = listOf(
                "Caching repeated identical LLM requests during local development.",
                "Tracking customer API usage and token billing metrics.",
                "Production proxy for error handling and fallback routing."
            ),
            advantages = listOf(
                "Zero code changes required beyond modifying the model API base URL.",
                "Built-in caching significantly cuts developer API expenses."
            ),
            limitations = listOf(
                "Proxy architecture introduces a network hop.",
                "Requires trusting proxy infrastructure with API traffic."
            ),
            relatedTechIds = listOf("langfuse", "langsmith", "wandb_weave"),
            officialUrl = "https://www.helicone.ai"
        ),

        // H. AI Memory Systems
        Technology(
            id = "mem0",
            categoryId = "memory",
            name = "Mem0",
            overview = "Mem0 (The Memory Layer for AI Agents) is an open-source intelligent memory engine that provides personalized long-term memory for AI agents and assistants.",
            mainPurpose = "Extracts, stores, updates, and retrieves user preferences, context, and episodic memory across multi-session conversations.",
            keyFeatures = listOf(
                "Self-improving memory graph that updates and resolves conflicting user facts.",
                "Multi-level memory support: User level, Session level, and Agent level.",
                "Automatic entity extraction and preference tracking.",
                "Python and TypeScript SDKs with vector DB integration."
            ),
            commonUses = listOf(
                "Personalized AI assistants that remember user preferences over time.",
                "Customer support bots tracking historical customer issues across calls.",
                "Adaptive AI tutoring systems maintaining student learning history."
            ),
            advantages = listOf(
                "Dynamically updates facts (e.g. 'User moved to NY') instead of storing raw chat history.",
                "Drastically reduces context window token consumption by retrieving only pertinent facts."
            ),
            limitations = listOf(
                "Requires background LLM calls to extract and consolidate facts.",
                "Needs vector DB backing for vector search."
            ),
            relatedTechIds = listOf("zep", "letta", "langgraph_memory"),
            officialUrl = "https://mem0.ai"
        ),
        Technology(
            id = "zep",
            categoryId = "memory",
            name = "Zep",
            overview = "Zep is a long-term memory service for AI applications that enriches conversation history with semantic search, entity extraction, and knowledge graphs.",
            mainPurpose = "Manages chat history persistence, automatic summarization, vector search, and temporal knowledge graphs for AI assistants.",
            keyFeatures = listOf(
                "Temporal Knowledge Graph constructing dynamic entity relationships.",
                "Automatic background dialog summarization and intent extraction.",
                "Low-latency memory retrieval API.",
                "Built-in PII detection and message metadata tagging."
            ),
            commonUses = listOf(
                "Enterprise conversational assistants requiring multi-session memory.",
                "Sales and CRM agents building relationship history from conversations.",
                "Long-running customer support AI threads."
            ),
            advantages = listOf(
                "Temporal knowledge graph tracks how user facts evolve over time.",
                "Purpose-built cloud service handling memory extraction automatically."
            ),
            limitations = listOf(
                "Commercial cloud platform pricing model.",
                "Requires integrating Zep API into application workflow."
            ),
            relatedTechIds = listOf("mem0", "letta", "neo4j"),
            officialUrl = "https://www.getzep.com"
        ),
        Technology(
            id = "letta",
            categoryId = "memory",
            name = "Letta",
            overview = "Letta (formerly MemGPT) is an open-source framework and server for building stateful LLM services with self-editing memory architecture.",
            mainPurpose = "Gives LLMs unbounded memory through OS-like memory management (Core, Recall, and Archival Memory tiers).",
            keyFeatures = listOf(
                "MemGPT architecture: Core Memory (in-context), Recall (chat history), Archival (vector DB).",
                "Explicit self-editing memory tool calls (`core_memory_append`, `archival_memory_insert`).",
                "Server deployment with multi-agent state persistence.",
                "REST API and web interface for memory inspection."
            ),
            commonUses = listOf(
                "Perpetual AI companions that never forget long-term conversations.",
                "Long-running autonomous agents executing multi-week tasks.",
                "Complex stateful conversational tools."
            ),
            advantages = listOf(
                "Allows LLMs to manage their own context memory explicitly via tool calls.",
                "Overcomes strict context window limits for infinite-turn interactions."
            ),
            limitations = listOf(
                "Higher token overhead due to memory management tool descriptions.",
                "Steeper architectural concepts (OS-like memory tiers)."
            ),
            relatedTechIds = listOf("mem0", "zep", "langgraph_memory"),
            officialUrl = "https://www.letta.com"
        ),
        Technology(
            id = "langgraph_memory",
            categoryId = "memory",
            name = "LangGraph Memory",
            overview = "LangGraph Memory refers to the native checkpointing and store mechanisms built into LangGraph for short-term thread state and long-term cross-thread memory.",
            mainPurpose = "Provides built-in state persistence and cross-thread memory stores directly within LangGraph agent state machines.",
            keyFeatures = listOf(
                "BaseCheckpointSaver for short-term thread state persistence.",
                "BaseStore interface for long-term memory across distinct user threads.",
                "Support for SqliteSaver, PostgresSaver, and AsyncMemorySaver.",
                "Seamless time-travel debugging and state rewind."
            ),
            commonUses = listOf(
                "Maintaining agent state across user web requests in production.",
                "Storing user-specific facts across distinct LangGraph conversations.",
                "Implementing human-in-the-loop state pause and resume."
            ),
            advantages = listOf(
                "Native zero-dependency integration for LangGraph developer applications.",
                "Handles both short-term thread state and long-term memory in one model."
            ),
            limitations = listOf(
                "Specific to the LangGraph execution framework.",
                "Requires setting up PostgreSQL or SQLite storage backends."
            ),
            relatedTechIds = listOf("langgraph", "mem0", "postgres_db"),
            officialUrl = "https://www.langchain.com/langgraph"
        ),
        Technology(
            id = "redis_memory",
            categoryId = "memory",
            name = "Redis",
            overview = "Redis is an in-memory data structure store used as an ultra-fast cache, session state manager, vector database, and real-time short-term AI memory engine.",
            mainPurpose = "Delivers sub-millisecond retrieval of conversation session states, semantic vector caching, and ephemeral memory.",
            keyFeatures = listOf(
                "Sub-millisecond latency for in-memory key-value state retrieval.",
                "RedisJSON and RedisSearch modules for vector and structured data.",
                "Automatic TTL (Time-To-Live) expiration for conversation session tokens.",
                "Pub/Sub messaging for real-time agent event streaming."
            ),
            commonUses = listOf(
                "Ultra-fast conversational session caching for high-scale web apps.",
                "Semantic caching of LLM prompt-response pairs to cut API costs.",
                "Ephemeral short-term memory storage for multi-tenant agents."
            ),
            advantages = listOf(
                "Unrivaled read/write throughput and sub-millisecond response latency.",
                "Industry standard in-memory caching infrastructure."
            ),
            limitations = listOf(
                "In-memory storage requires scaling RAM for massive datasets.",
                "Requires configuring persistence (RDB/AOF) to prevent data loss on restarts."
            ),
            relatedTechIds = listOf("redis_vector", "postgres_db", "mem0"),
            officialUrl = "https://redis.io"
        ),
        Technology(
            id = "postgres_db",
            categoryId = "memory",
            name = "PostgreSQL",
            overview = "PostgreSQL is the world's most advanced open-source relational database, serving as the foundational persistence layer for structured AI state, logs, and memory.",
            mainPurpose = "Provides ACID-compliant persistent storage for AI agent state, user accounts, chat logs, and long-term memory graph stores.",
            keyFeatures = listOf(
                "ACID transactional guarantees for critical enterprise agent data.",
                "JSONB data type for flexible, semi-structured memory schema storage.",
                "Extension ecosystem including pgvector for unified vector and relational queries.",
                "Universal cloud availability across AWS RDS, GCP Cloud SQL, and Azure."
            ),
            commonUses = listOf(
                "Primary persistent database for enterprise AI platforms and agent state.",
                "Storing conversation logs, user profiles, and application metadata.",
                "Unified relational + vector storage engine using pgvector."
            ),
            advantages = listOf(
                "Unmatched reliability, maturity, security, and developer ecosystem.",
                "Eliminates needing a separate vector DB when using the pgvector extension."
            ),
            limitations = listOf(
                "Requires database administration, indexing, and connection pooling.",
                "Slower than pure in-memory caches like Redis for sub-millisecond ops."
            ),
            relatedTechIds = listOf("pgvector", "postgres_mcp", "redis_memory"),
            officialUrl = "https://www.postgresql.org"
        ),
        Technology(
            id = "neo4j_memory",
            categoryId = "memory",
            name = "Neo4j",
            overview = "Neo4j is the leading graph database management system, used in AI memory architectures to model complex, interconnected entity relationships.",
            mainPurpose = "Stores and traverses complex entity graphs, knowledge graphs, and multi-relational facts for AI context augmentation.",
            keyFeatures = listOf(
                "Cypher graph query language for intuitive relationship traversal.",
                "Native graph storage and index-free adjacency.",
                "Vector search index integration alongside property graph nodes.",
                "Graph Data Science (GDS) library for community detection and centrality."
            ),
            commonUses = listOf(
                "Knowledge Graph RAG (GraphRAG) and entity-relationship search.",
                "Enterprise AI memory systems tracking interconnected domain data.",
                "Fraud detection and supply chain relationship analysis."
            ),
            advantages = listOf(
                "Unrivaled performance on multi-hop graph relationship queries.",
                "Explicit visualization of complex entity structures."
            ),
            limitations = listOf(
                "Requires learning Cypher query language syntax.",
                "Higher memory overhead for massive graph nodes."
            ),
            relatedTechIds = listOf("graphrag", "zep", "chroma_db"),
            officialUrl = "https://neo4j.com"
        ),
        Technology(
            id = "chroma_memory",
            categoryId = "memory",
            name = "Chroma",
            overview = "Chroma is an open-source AI-native vector database that doubles as an easy embedded memory engine for local and Python-based AI applications.",
            mainPurpose = "Provides zero-friction vector search and document memory for local applications, notebooks, and small services.",
            keyFeatures = listOf(
                "Embedded in-process execution (`import chromadb`) or client-server mode.",
                "Built-in embedding function support (OpenAI, Sentence Transformers).",
                "Simple document filtering using metadata dictionaries.",
                "Lightweight, developer-friendly Python and JavaScript SDKs."
            ),
            commonUses = listOf(
                "Local application memory and vector storage.",
                "Prototyping semantic search in Python notebooks.",
                "Desktop AI apps requiring local embedded memory."
            ),
            advantages = listOf(
                "Zero installation required when running in local embedded Python mode.",
                "Cleanest developer developer experience for fast prototyping."
            ),
            limitations = listOf(
                "Embedded mode is designed for single-process memory, not massive distributed clusters.",
                "Fewer enterprise clustering features than Milvus or Qdrant."
            ),
            relatedTechIds = listOf("chroma_db", "mem0", "pinecone"),
            officialUrl = "https://www.trychroma.com"
        ),

        // I. AI Agent SDKs and Platforms
        Technology(
            id = "openai_agents_sdk",
            categoryId = "agent_sdk",
            name = "OpenAI Agents SDK",
            overview = "The OpenAI Agents SDK is a lightweight, ergonomic framework for building multi-agent workflows, tool execution, and handoffs with OpenAI models.",
            mainPurpose = "Provides official abstractions for defining autonomous agents, tool functions, guardrails, and inter-agent handoffs.",
            keyFeatures = listOf(
                "Agent definition with instructions, tools, and handoffs.",
                "Handoff mechanism allowing seamless control transfer between specialized agents.",
                "Guardrail execution prior to tool calling or agent handoffs.",
                "Built-in tracing and compatibility with OpenAI Assistants API."
            ),
            commonUses = listOf(
                "Multi-agent triage systems (e.g. Triage Agent routing to Tech Support Agent).",
                "Structured tool execution workflows with OpenAI models.",
                "Building production conversational agents on OpenAI infrastructure."
            ),
            advantages = listOf(
                "Official lightweight SDK directly maintained by OpenAI.",
                "Clean mental model centered on Agents, Tools, and Handoffs."
            ),
            limitations = listOf(
                "Optimized primarily for OpenAI model provider endpoints.",
                "Evolving feature set."
            ),
            relatedTechIds = listOf("langchain_agents", "pydantic_ai", "autogen"),
            officialUrl = "https://github.com/openai/openai-agents-python"
        ),
        Technology(
            id = "langchain_agents",
            categoryId = "agent_sdk",
            name = "LangChain Agents",
            overview = "LangChain Agents is the agent execution module within the LangChain framework, enabling LLMs to dynamically select and invoke tools in loops.",
            mainPurpose = "Connects language models to custom tools, search engines, APIs, and python code executors using tool-calling reasoning loops.",
            keyFeatures = listOf(
                "Tool-calling agent algorithms (ReAct, OpenAI Tools Agent).",
                "Access to hundreds of pre-built LangChain tool integrations.",
                "Structured tool input validation using Pydantic schemas.",
                "Seamless integration with LangGraph for advanced stateful graphs."
            ),
            commonUses = listOf(
                "Creating AI web research assistants with search tools.",
                "Database querying and API automation bots.",
                "Prototyping tool-calling AI agents."
            ),
            advantages = listOf(
                "Massive collection of ready-to-use third-party tool adapters.",
                "Available across Python and TypeScript language ecosystems."
            ),
            limitations = listOf(
                "Complex agent loops are better served by LangGraph state machines.",
                "Higher abstraction layer can complicate low-level debugging."
            ),
            relatedTechIds = listOf("langchain", "langgraph", "crewai"),
            officialUrl = "https://python.langchain.com/docs/concepts/agents/"
        ),
        Technology(
            id = "pydantic_ai",
            categoryId = "agent_sdk",
            name = "PydanticAI",
            overview = "PydanticAI is a Python agent framework built by the creators of Pydantic, bringing type-safe structured data validation and ergonomics to AI agents.",
            mainPurpose = "Delivers production-grade, type-safe agent development with strict Pydantic validation on model inputs and outputs.",
            keyFeatures = listOf(
                "Built on Pydantic v2 for ultra-fast schema validation.",
                "Type-safe tool definition, dependency injection, and result validation.",
                "Model-agnostic support (OpenAI, Anthropic, Gemini, Ollama).",
                "Logfire integration for instant observability."
            ),
            commonUses = listOf(
                "Building production Python microservices with strict schema requirements.",
                "Type-safe structured data extraction pipelines.",
                "Enterprise software engineering with rigid typing standards."
            ),
            advantages = listOf(
                "Unmatched type safety, IDE auto-completion, and schema guarantees.",
                "Designed by the trusted maintainers of Pydantic."
            ),
            limitations = listOf(
                "Python-only framework requiring Pydantic v2.",
                "Newer framework relative to LangChain."
            ),
            relatedTechIds = listOf("agno", "fastmcp", "openai_agents_sdk"),
            officialUrl = "https://ai.pydantic.dev"
        ),
        Technology(
            id = "semantic_kernel",
            categoryId = "agent_sdk",
            name = "Semantic Kernel",
            overview = "Semantic Kernel is an open-source enterprise SDK by Microsoft that allows developers to integrate AI LLMs with conventional programming languages (C#, Python, Java).",
            mainPurpose = "Provides enterprise application developers with AI orchestration primitives (Plugins, Memories, Planners) inside C#, Python, and Java codebases.",
            keyFeatures = listOf(
                "Native multi-language support: C# / .NET, Python, and Java.",
                "Plugins architecture exposing standard code functions to LLMs.",
                "Process Framework and Planners for multi-step execution.",
                "Native enterprise security, telemetry, and OpenAPI import."
            ),
            commonUses = listOf(
                "Enterprise C# / .NET application AI integration.",
                "Building Microsoft 365 Copilot extensions and Azure services.",
                "Cross-language enterprise AI platform engineering."
            ),
            advantages = listOf(
                "The undisputed standard for enterprise .NET and C# AI engineering.",
                "Backed and maintained by Microsoft enterprise engineering teams."
            ),
            limitations = listOf(
                "Python ecosystem community is smaller than LangChain's.",
                "Higher object-oriented enterprise design pattern complexity."
            ),
            relatedTechIds = listOf("ms_agent_framework", "autogen", "azure_agent_service"),
            officialUrl = "https://github.com/microsoft/semantic-kernel"
        ),
        Technology(
            id = "google_adk",
            categoryId = "agent_sdk",
            name = "Google Agent Development Kit (ADK)",
            overview = "Google Agent Development Kit (ADK) is a set of tools, libraries, and best-practice frameworks for building and deploying production AI agents on Google Cloud.",
            mainPurpose = "Simplifies building production-ready agents powered by Gemini models and Vertex AI infrastructure.",
            keyFeatures = listOf(
                "Native Gemini model optimization and function calling tools.",
                "Vertex AI Agent Builder integration.",
                "Enterprise Google Cloud IAM security and telemetry bindings.",
                "Extensions for Google Workspace, BigQuery, and Google Search grounding."
            ),
            commonUses = listOf(
                "Building enterprise AI agents hosted on Google Cloud Platform.",
                "Gounding Gemini agents with Google Search and enterprise data.",
                "Automating workflows across Google Cloud services."
            ),
            advantages = listOf(
                "Native optimization for Gemini models and Google Cloud infrastructure.",
                "Built-in grounding connectors for Google Search and BigQuery."
            ),
            limitations = listOf(
                "Tightly aligned with Google Cloud ecosystem.",
                "Requires GCP billing and account infrastructure."
            ),
            relatedTechIds = listOf("google_gemini", "vertex_embeddings", "aws_bedrock_agents"),
            officialUrl = "https://cloud.google.com/products/agent-builder"
        ),
        Technology(
            id = "aws_bedrock_agents",
            categoryId = "agent_sdk",
            name = "AWS Bedrock Agents",
            overview = "AWS Bedrock Agents is a fully managed Amazon Web Services capability that allows developers to build, orchestrate, and deploy AI agents without managing server code.",
            mainPurpose = "Provides serverless, managed AI agent execution connected to AWS Lambda functions and API knowledge bases.",
            keyFeatures = listOf(
                "Fully managed orchestration loop handled automatically by AWS Cloud.",
                "Automatic OpenAPI schema parsing to connect agents to AWS Lambda.",
                "Native integration with Bedrock Knowledge Bases for RAG.",
                "AWS IAM security, encryption, and audit trail logging."
            ),
            commonUses = listOf(
                "Serverless enterprise agents taking automated actions via AWS Lambda.",
                "Customer support automation on AWS Cloud.",
                "Cloud infrastructure management and automated remediation."
            ),
            advantages = listOf(
                "Zero server management required; fully managed by AWS infrastructure.",
                "Direct seamless integration with AWS Lambda functions."
            ),
            limitations = listOf(
                "Requires AWS Cloud hosting and service configuration.",
                "Vendor lock-in to AWS Cloud ecosystem."
            ),
            relatedTechIds = listOf("aws_strands_agents", "aws_bedrock_guardrails", "azure_agent_service"),
            officialUrl = "https://aws.amazon.com/bedrock/agents/"
        ),
        Technology(
            id = "azure_agent_service",
            categoryId = "agent_sdk",
            name = "Azure AI Foundry Agent Service",
            overview = "Azure AI Foundry Agent Service is a fully managed Azure enterprise service for building, deploying, and scaling autonomous AI agents.",
            mainPurpose = "Delivers enterprise-grade, secure agent hosting with Bing Search grounding, Azure AI Search RAG, and Python/C# execution sandboxes.",
            keyFeatures = listOf(
                "Fully managed agent runtime with multi-agent orchestration.",
                "Built-in code interpreter sandboxes and Bing Search grounding.",
                "Native integration with Azure AI Search and enterprise databases.",
                "Enterprise security, VNet isolation, and RBAC governance."
            ),
            commonUses = listOf(
                "Enterprise-scale agentic deployments across Fortune 500 companies.",
                "Secure code execution and data analysis agents.",
                "Multi-agent collaborative systems on Azure Cloud."
            ),
            advantages = listOf(
                "Top-tier enterprise cloud security, compliance, and isolation.",
                "Managed code interpreter and web search grounding out of the box."
            ),
            limitations = listOf(
                "Requires Microsoft Azure subscription and quota allocation.",
                "Cloud infrastructure management overhead."
            ),
            relatedTechIds = listOf("ms_agent_framework", "azure_openai_embeddings", "aws_bedrock_agents"),
            officialUrl = "https://azure.microsoft.com/products/ai-foundry"
        ),

        // J. AI Workflow Automation
        Technology(
            id = "n8n",
            categoryId = "workflow",
            name = "n8n",
            overview = "n8n is a fair-code, self-hostable workflow automation platform with native AI nodes for connecting 400+ services with LLMs and vector stores.",
            mainPurpose = "Enables visual creation of complex automation workflows combining webhooks, APIs, custom JavaScript/Python code, and AI agents.",
            keyFeatures = listOf(
                "Visual node-based workflow editor with 400+ SaaS integrations.",
                "Native AI nodes powered by LangChain (Agents, Vector Stores, Document Loaders).",
                "Self-hostable open-code deployment via Docker.",
                "Support for sub-workflows, error handling triggers, and webhook listeners."
            ),
            commonUses = listOf(
                "Self-hosted business automation pipelines incorporating AI processing.",
                "Automated email customer support classification and drafting.",
                "Connecting webhook events to vector database ingestion."
            ),
            advantages = listOf(
                "100% self-hostable with no execution limits on private servers.",
                "Exceptional visual workflow builder combining traditional APIs with AI nodes."
            ),
            limitations = listOf(
                "Self-hosting requires server maintenance and Docker setup.",
                "Fair-code license has commercial reseller restrictions."
            ),
            relatedTechIds = listOf("zapier", "make_automation", "temporal"),
            officialUrl = "https://n8n.io"
        ),
        Technology(
            id = "zapier",
            categoryId = "workflow",
            name = "Zapier",
            overview = "Zapier is the leading web automation platform that connects thousands of business apps with Zapier Central and AI action steps.",
            mainPurpose = "Allows non-technical and technical users to build automated AI workflows across 7,000+ app integrations.",
            keyFeatures = listOf(
                "7,000+ app integration connectors (Gmail, Slack, Salesforce, HubSpot).",
                "Zapier Central AI assistants and custom AI action steps.",
                "Formatted AI prompt steps powered by OpenAI models.",
                "No-code visual builder with conditional branching."
            ),
            commonUses = listOf(
                "Connecting incoming lead forms to AI summary generators and CRM entries.",
                "Automated social media content generation and scheduling.",
                "Simple business process automation without writing code."
            ),
            advantages = listOf(
                "Largest library of pre-built SaaS app connectors in the industry.",
                "No coding skills required to build functional workflows."
            ),
            limitations = listOf(
                "Per-task pricing can become expensive for high-volume execution.",
                "Less flexibility for low-level code debugging."
            ),
            relatedTechIds = listOf("make_automation", "n8n", "ms_power_automate"),
            officialUrl = "https://zapier.com"
        ),
        Technology(
            id = "make_automation",
            categoryId = "workflow",
            name = "Make",
            overview = "Make (formerly Integromat) is a visual automation platform that allows users to build, design, and automate complex workflows with modular AI components.",
            mainPurpose = "Provides a drag-and-drop visual canvas for mapping multi-branch workflows and API data transformations with AI steps.",
            keyFeatures = listOf(
                "Interactive visual canvas with real-time data flow animation.",
                "1,500+ pre-built app modules and universal HTTP REST/JSON connectors.",
                "Native OpenAI, Anthropic, and custom AI API modules.",
                "Advanced data parsing, array aggregators, and error handlers."
            ),
            commonUses = listOf(
                "Visual data transformation pipelines involving LLM analysis.",
                "E-commerce order enrichment and AI customer outreach.",
                "Multi-branch automation across cloud platforms."
            ),
            advantages = listOf(
                "Highly visual canvas providing unmatched clarity on complex data paths.",
                "More cost-effective task pricing than Zapier for complex workflows."
            ),
            limitations = listOf(
                "SaaS cloud subscription dependency.",
                "Requires understanding JSON data mapping structures."
            ),
            relatedTechIds = listOf("zapier", "n8n", "pipedream"),
            officialUrl = "https://www.make.com"
        ),
        Technology(
            id = "ms_power_automate",
            categoryId = "workflow",
            name = "Microsoft Power Automate",
            overview = "Microsoft Power Automate is an enterprise workflow automation service integrated into Microsoft 365, Power Platform, and Copilot Studio.",
            mainPurpose = "Automates business processes and Robotic Process Automation (RPA) across Microsoft 365, SharePoint, and legacy desktop apps.",
            keyFeatures = listOf(
                "Deep native integration with Microsoft 365, Teams, and SharePoint.",
                "Copilot AI assistant for generating workflows from natural language.",
                "AI Builder modules for document processing, sentiment analysis, and OCR.",
                "Robotic Process Automation (RPA) desktop flow capabilities."
            ),
            commonUses = listOf(
                "Enterprise document approval and processing in SharePoint.",
                "Automated invoice processing using AI Builder OCR models.",
                "Internal Microsoft Teams workflow automation."
            ),
            advantages = listOf(
                "Native component of the Microsoft enterprise software stack.",
                "Includes desktop RPA for automating legacy software without APIs."
            ),
            limitations = listOf(
                "Requires Microsoft Power Platform licensing.",
                "Optimized primarily for Microsoft enterprise ecosystem."
            ),
            relatedTechIds = listOf("zapier", "make_automation", "temporal"),
            officialUrl = "https://powerautomate.microsoft.com"
        ),
        Technology(
            id = "temporal",
            categoryId = "workflow",
            name = "Temporal",
            overview = "Temporal is an open-source durable execution platform that guarantees code execution state even in the face of network or server failures.",
            mainPurpose = "Executes long-running, mission-critical workflow code reliably without losing state during crashes or API outages.",
            keyFeatures = listOf(
                "Durable execution guarantee (workflows resume exact state on server crash).",
                "SDKs in Go, Java, Python, and TypeScript.",
                "Automatic retries, backoff strategies, and timeout handling for external AI APIs.",
                "State replay and event history audit logs."
            ),
            commonUses = listOf(
                "Mission-critical AI pipelines executing multi-hour background tasks.",
                "Financial transaction processing involving AI risk verification.",
                "Reliable human-in-the-loop approval processes lasting days or weeks."
            ),
            advantages = listOf(
                "Unmatched fault tolerance; impossible to lose workflow state due to crashes.",
                "Developers write standard code (loops, try/catch) rather than JSON configs."
            ),
            limitations = listOf(
                "Requires writing code in Go, Python, TS, or Java (not no-code).",
                "Requires running Temporal cluster infrastructure or Temporal Cloud."
            ),
            relatedTechIds = listOf("airflow", "prefect", "kestra"),
            officialUrl = "https://temporal.io"
        ),
        Technology(
            id = "airflow",
            categoryId = "workflow",
            name = "Apache Airflow",
            overview = "Apache Airflow is the industry-standard open-source platform for programmatically authoring, scheduling, and monitoring batch data pipelines as DAGs.",
            mainPurpose = "Orchestrates complex batch data processing, machine learning model training, and bulk vector database indexing pipelines.",
            keyFeatures = listOf(
                "Pipelines defined as Python code (Directed Acyclic Graphs / DAGs).",
                "Extensive provider ecosystem (AWS, GCP, Snowflake, Vector DBs).",
                "Rich web UI for monitoring DAG runs, task logs, and execution times.",
                "Scalable executor architectures (Celery, Kubernetes)."
            ),
            commonUses = listOf(
                "Nightly batch ingestion and re-indexing of massive vector databases.",
                "Machine learning model training and feature store preparation.",
                "Enterprise data warehouse ETL pipelines."
            ),
            advantages = listOf(
                "Definitive global standard for enterprise batch data orchestration.",
                "Vast community operator ecosystem for almost every database and service."
            ),
            limitations = listOf(
                "Designed for batch processing, not real-time event streaming or low-latency webhooks.",
                "Higher infrastructure management overhead."
            ),
            relatedTechIds = listOf("prefect", "kestra", "temporal"),
            officialUrl = "https://airflow.apache.org"
        ),
        Technology(
            id = "prefect",
            categoryId = "workflow",
            name = "Prefect",
            overview = "Prefect is a modern Python workflow orchestration platform designed for data engineering and AI pipelines, turning standard Python functions into observable flows.",
            mainPurpose = "Adds automatic retries, logging, scheduling, and observability to Python AI data functions with a single `@flow` decorator.",
            keyFeatures = listOf(
                "Python-native workflow creation using `@flow` and `@task` decorators.",
                "Dynamic DAG creation at runtime without static configuration.",
                "Prefect Cloud managed control plane or self-hosted server option.",
                "Native asynchronous execution support and task caching."
            ),
            commonUses = listOf(
                "Orchestrating Python data ingestion and vector embedding tasks.",
                "Automated LLM evaluation pipeline schedules.",
                "Data pipeline error recovery and notification alerts."
            ),
            advantages = listOf(
                "Minimalistic Pythonic design with dynamic runtime DAG creation.",
                "Significantly easier developer onboarding than Apache Airflow."
            ),
            limitations = listOf(
                "Python ecosystem focus.",
                "Requires running worker agents to execute tasks."
            ),
            relatedTechIds = listOf("airflow", "kestra", "temporal"),
            officialUrl = "https://www.prefect.io"
        ),
        Technology(
            id = "kestra",
            categoryId = "workflow",
            name = "Kestra",
            overview = "Kestra is an open-source, event-driven orchestrator that simplifies building both data and AI workflows using declarative YAML definition files.",
            mainPurpose = "Enables developers and data engineers to build event-driven pipelines using clean declarative YAML with embedded code blocks.",
            keyFeatures = listOf(
                "Declarative YAML workflow definitions with embedded Python, Node, and SQL.",
                "Built-in web UI with execution flow visualizer and log viewer.",
                "Event-driven triggers (webhooks, file uploads, schedule crons).",
                "Plugins for major cloud services, vector databases, and AI APIs."
            ),
            commonUses = listOf(
                "Event-driven document ingestion pipelines triggering on file upload.",
                "Cross-cloud automation combining Python scripts and SQL queries.",
                "Data pipeline orchestration for modern data stacks."
            ),
            advantages = listOf(
                "Language-agnostic YAML definitions make workflows accessible across teams.",
                "Combines both batch and real-time event-driven triggers natively."
            ),
            limitations = listOf(
                "YAML configuration model requires using Kestra syntax structures.",
                "Newer framework compared to Apache Airflow."
            ),
            relatedTechIds = listOf("prefect", "airflow", "n8n"),
            officialUrl = "https://kestra.io"
        ),
        Technology(
            id = "pipedream",
            categoryId = "workflow",
            name = "Pipedream",
            overview = "Pipedream is an integration platform for developers that allows building serverless workflows triggered by HTTP webhooks or events using Node.js and Python code.",
            mainPurpose = "Connects webhooks, APIs, and AI models instantly using serverless Python/Node code steps with built-in state management.",
            keyFeatures = listOf(
                "Serverless execution of custom Node.js or Python code steps.",
                "Built-in authentication handling for 2,000+ API integrations.",
                "Instant HTTP webhook trigger endpoint generation.",
                "Auto-scaling serverless cloud infrastructure."
            ),
            commonUses = listOf(
                "Building custom webhook processors that call LLM APIs.",
                "Connecting external API events to Slack/Email notifications.",
                "Rapid API prototyping and backend micro-integrations."
            ),
            advantages = listOf(
                "Instant webhook generation and zero infrastructure management.",
                "Write actual serverless Python/Node code with full npm/pip package access."
            ),
            limitations = listOf(
                "Cloud serverless platform usage limits on free tiers.",
                "Requires developer code step familiarity."
            ),
            relatedTechIds = listOf("make_automation", "n8n", "zapier"),
            officialUrl = "https://pipedream.com"
        ),

        // K. Vector Databases and Vector Search
        Technology(
            id = "pinecone",
            categoryId = "vector_db",
            name = "Pinecone",
            overview = "Pinecone is a fully managed, cloud-native vector database designed for high-performance approximate nearest neighbor (ANN) search at massive scale.",
            mainPurpose = "Provides serverless, zero-maintenance vector indexing and sub-second similarity search for production RAG and AI search.",
            keyFeatures = listOf(
                "Serverless architecture automatically scaling compute based on usage.",
                "High-speed ANN similarity search (Cosine, Euclidean, Dot Product).",
                "Metadata filtering during vector queries.",
                "Integrated hybrid search and sparse-dense vector indexing."
            ),
            commonUses = listOf(
                "Production enterprise RAG vector retrieval pipelines.",
                "Real-time e-commerce recommendation systems.",
                "Semantic document search across millions of items."
            ),
            advantages = listOf(
                "Fully managed serverless operations; no index tuning or infrastructure maintenance.",
                "Extremely low latency and high query-per-second performance."
            ),
            limitations = listOf(
                "Closed-source commercial cloud SaaS service.",
                "Data must be stored on Pinecone cloud servers."
            ),
            relatedTechIds = listOf("weaviate", "qdrant", "milvus"),
            officialUrl = "https://www.pinecone.io"
        ),
        Technology(
            id = "weaviate",
            categoryId = "vector_db",
            name = "Weaviate",
            overview = "Weaviate is an open-source, AI-native vector database that allows developers to store data objects and vector embeddings with hybrid search capabilities.",
            mainPurpose = "Combines vector similarity search with structured scalar filtering, hybrid search, and built-in ML embedding modules.",
            keyFeatures = listOf(
                "Native hybrid search combining BM25 keyword search and vector ANN.",
                "Built-in vectorizer modules (OpenAI, Hugging Face, Cohere) inside the DB.",
                "Multi-tenancy support for isolating data across distinct customers.",
                "Available as open-source Docker, self-hosted Kubernetes, or Managed Cloud."
            ),
            commonUses = listOf(
                "Production hybrid search engines combining keywords and vectors.",
                "Multi-tenant SaaS RAG applications requiring tenant data isolation.",
                "Enterprise semantic search portals."
            ),
            advantages = listOf(
                "Outstanding hybrid search capabilities out-of-the-box.",
                "Flexible deployment options: 100% open-source or managed cloud."
            ),
            limitations = listOf(
                "Self-hosting large clusters requires Kubernetes management expertise.",
                "Higher memory usage when running built-in vectorizer modules."
            ),
            relatedTechIds = listOf("pinecone", "qdrant", "milvus"),
            officialUrl = "https://weaviate.io"
        ),
        Technology(
            id = "qdrant",
            categoryId = "vector_db",
            name = "Qdrant",
            overview = "Qdrant is an open-source vector database written in Rust, offering high-performance, low-latency vector search with rich payload filtering.",
            mainPurpose = "Delivers high-throughput vector similarity search with precise metadata payload filtering written in memory-safe Rust.",
            keyFeatures = listOf(
                "Written in Rust for maximum memory efficiency and speed.",
                "Advanced JSON payload filtering attached to vector points.",
                "Quantization support (Scalar, Product, Binary) to cut RAM footprint by 4x+.",
                "Distributed cluster deployment support."
            ),
            commonUses = listOf(
                "High-performance RAG systems requiring complex metadata filtering.",
                "Cost-effective large vector deployments using Rust memory optimizations.",
                "Image and multimodal similarity search engines."
            ),
            advantages = listOf(
                "Exceptional execution speed and memory efficiency due to Rust codebase.",
                "Full open-source availability with self-hosted Docker and Qdrant Cloud."
            ),
            limitations = listOf(
                "Requires understanding vector quantization trade-offs for massive datasets.",
                "Cluster administration for large multi-node clusters."
            ),
            relatedTechIds = listOf("pinecone", "weaviate", "milvus"),
            officialUrl = "https://qdrant.tech"
        ),
        Technology(
            id = "milvus",
            categoryId = "vector_db",
            name = "Milvus",
            overview = "Milvus is an open-source, highly scalable distributed vector database built for massive enterprise datasets containing billions of vectors.",
            mainPurpose = "Handles billion-scale vector embedding search with cloud-native distributed architecture and hardware acceleration.",
            keyFeatures = listOf(
                "Distributed cloud-native architecture decoupling storage and compute.",
                "Support for billion-scale vector collections.",
                "Zilliz Cloud managed service option.",
                "Zilliz/Milvus Lite embedded Python option for local testing."
            ),
            commonUses = listOf(
                "Billion-scale enterprise vector search and data warehousing.",
                "Large-scale facial recognition and biometric identification systems.",
                "Global enterprise RAG platforms."
            ),
            advantages = listOf(
                "Proven scalability handling billion-scale vector workloads.",
                "Rich ecosystem of index types (HNSW, IVF, DiskANN)."
            ),
            limitations = listOf(
                "Full distributed cluster installation requires Kubernetes expertise.",
                "Overkill for small side-projects (though Milvus Lite helps)."
            ),
            relatedTechIds = listOf("pinecone", "qdrant", "weaviate"),
            officialUrl = "https://milvus.io"
        ),
        Technology(
            id = "chroma_db",
            categoryId = "vector_db",
            name = "Chroma",
            overview = "Chroma is an open-source AI-native vector database designed to make it effortless to build LLM apps through simple in-memory or client-server modes.",
            mainPurpose = "Provides a lightweight vector store for Python/JS developers requiring fast setup without cloud database infrastructure.",
            keyFeatures = listOf(
                "Embedded local execution mode (`import chromadb`) with zero server setup.",
                "Built-in automatic embedding integration with OpenAI and local models.",
                "Metadata filtering and document storage.",
                "Client-server REST mode for containerized deployments."
            ),
            commonUses = listOf(
                "Rapid prototyping of RAG applications in local Python code.",
                "Developer side-projects and desktop AI tools.",
                "Educational tutorials and quick vector search demos."
            ),
            advantages = listOf(
                "Zero installation overhead when running embedded in Python.",
                "The easiest vector database to get started with for beginners."
            ),
            limitations = listOf(
                "Not engineered for distributed multi-node billion-scale enterprise clusters.",
                "Embedded mode single-process limits."
            ),
            relatedTechIds = listOf("chroma_memory", "pinecone", "qdrant"),
            officialUrl = "https://www.trychroma.com"
        ),
        Technology(
            id = "pgvector",
            categoryId = "vector_db",
            name = "pgvector",
            overview = "pgvector is an open-source vector similarity search extension for PostgreSQL, enabling vector storage directly inside existing Postgres databases.",
            mainPurpose = "Adds vector similarity search (HNSW, IVFFlat) to PostgreSQL without deploying a dedicated standalone vector database.",
            keyFeatures = listOf(
                "Vector data type support (`vector(dimensions)` column) in PostgreSQL.",
                "HNSW and IVFFlat index types for fast approximate nearest neighbor search.",
                "Unified SQL queries combining relational joins, WHERE filters, and vector distance.",
                "Supported across AWS RDS, GCP Cloud SQL, Azure Database, and Supabase."
            ),
            commonUses = listOf(
                "Adding vector search capability to existing enterprise PostgreSQL databases.",
                "Unified application architectures keeping relational data and vectors together.",
                "RAG applications leveraging existing Postgres backup and security setups."
            ),
            advantages = listOf(
                "Eliminates the operational overhead of managing a separate vector DB service.",
                "Allows combining complex SQL joins and transactional filters directly with vector search."
            ),
            limitations = listOf(
                "Extremely high vector query volume on massive datasets can compete for Postgres CPU/RAM.",
                "Requires tuning Postgres shared_buffers and maintenance_work_mem for HNSW indexing."
            ),
            relatedTechIds = listOf("postgres_db", "postgres_mcp", "pinecone"),
            officialUrl = "https://github.com/pgvector/pgvector"
        ),
        Technology(
            id = "elasticsearch_vector",
            categoryId = "vector_db",
            name = "Elasticsearch",
            overview = "Elasticsearch is a distributed search and analytics engine that includes dense vector field types and ELSER sparse vector models for hybrid search.",
            mainPurpose = "Combines industry-standard full-text BM25 search with dense vector similarity search in a unified enterprise cluster.",
            keyFeatures = listOf(
                "Dense vector field support (`dense_vector`) with HNSW indexing.",
                "ELSER (Elastic Learned Sparse EncodeR) for out-of-the-box sparse vector search.",
                "Hybrid search with Reciprocal Rank Fusion (RRF) scoring.",
                "Enterprise cluster security, scalability, and Kibana analytics."
            ),
            commonUses = listOf(
                "Enterprise hybrid search across legacy document repositories.",
                "E-commerce search engines combining keyword product codes and vector similarity.",
                "Log analytics and security threat intelligence with semantic capabilities."
            ),
            advantages = listOf(
                "Leverages existing enterprise Elasticsearch infrastructure deployments.",
                "Best-in-class combination of full-text BM25 keyword search and vector retrieval."
            ),
            limitations = listOf(
                "Requires significant cluster RAM allocation for HNSW vector indexes.",
                "Higher infrastructure setup complexity for non-Elasticsearch users."
            ),
            relatedTechIds = listOf("mongodb_vector", "redis_vector", "pgvector"),
            officialUrl = "https://www.elastic.co"
        ),
        Technology(
            id = "redis_vector",
            categoryId = "vector_db",
            name = "Redis",
            overview = "Redis Vector Search (via RediSearch) extends Redis with sub-millisecond vector indexing, KNN search, and hybrid vector/scalar filtering.",
            mainPurpose = "Delivers sub-millisecond vector similarity search in-memory for real-time recommendation and semantic caching.",
            keyFeatures = listOf(
                "In-memory HNSW and Flat vector index types.",
                "Sub-millisecond similarity query latency.",
                "Hybrid query filtering combining vector distance and scalar tag/numeric fields.",
                "Semantic caching of LLM prompt/response pairs."
            ),
            commonUses = listOf(
                "Sub-millisecond semantic caching for production LLM APIs.",
                "Real-time vector search in low-latency mobile and gaming applications.",
                "Ultra-fast session context retrieval."
            ),
            advantages = listOf(
                "Unmatched sub-millisecond vector query response speed.",
                "Combines in-memory key-value speed with vector similarity indexing."
            ),
            limitations = listOf(
                "In-memory RAM cost considerations for multi-million vector datasets.",
                "Requires RAM capacity sizing."
            ),
            relatedTechIds = listOf("redis_memory", "pgvector", "pinecone"),
            officialUrl = "https://redis.io/docs/interact/search-and-query/"
        ),
        Technology(
            id = "mongodb_vector",
            categoryId = "vector_db",
            name = "MongoDB Atlas Vector Search",
            overview = "MongoDB Atlas Vector Search brings native vector indexing and similarity search to MongoDB document collections in the cloud.",
            mainPurpose = "Enables storing document payloads and vector embeddings together in MongoDB collections with single-query retrieval.",
            keyFeatures = listOf(
                "Vector indexing directly inside MongoDB Atlas cloud document collections.",
                "HNSW index support with vector pre-filtering.",
                "Aggregation pipeline integration (`\$vectorSearch` stage).",
                "Unified developer experience for document database users."
            ),
            commonUses = listOf(
                "Adding semantic search to existing MongoDB document databases.",
                "RAG applications storing document metadata and vectors together.",
                "E-commerce product catalog search."
            ),
            advantages = listOf(
                "No need to sync data between a document DB and a separate vector DB.",
                "Seamless integration for developers already using MongoDB."
            ),
            limitations = listOf(
                "Feature is specific to MongoDB Atlas Cloud deployments.",
                "Requires Atlas cloud tier for vector search indexing."
            ),
            relatedTechIds = listOf("pgvector", "elasticsearch_vector", "pinecone"),
            officialUrl = "https://www.mongodb.com/products/platform/atlas-vector-search"
        )
    )

    fun getCategoryById(id: String): Category? = categories.find { it.id == id }

    fun getTechnologyById(id: String): Technology? = technologies.find { it.id == id }

    fun getTechnologiesForCategory(categoryId: String): List<Technology> =
        technologies.filter { it.categoryId == categoryId }

    /** Lower-cased searchable text per technology: name, category, overview, purpose, features, uses. */
    private val searchIndex: Map<String, String> by lazy {
        technologies.associate { tech ->
            tech.id to buildString {
                append(tech.name).append(' ')
                append(getCategoryById(tech.categoryId)?.name.orEmpty()).append(' ')
                append(tech.overview).append(' ')
                append(tech.mainPurpose).append(' ')
                tech.keyFeatures.forEach { append(it).append(' ') }
                tech.commonUses.forEach { append(it).append(' ') }
            }.lowercase()
        }
    }

    /** Splits a raw query into normalized lower-case terms. */
    fun tokenize(query: String): List<String> =
        query.trim().lowercase().split(Regex("\\s+")).filter { it.isNotEmpty() }

    /**
     * Offline search. Every term must appear somewhere in a technology's searchable text
     * (name, category name, overview, main purpose, key features, common uses).
     * An empty query returns all technologies (optionally limited to [categoryIdFilter])
     * in their original order. Non-empty results are ranked so name matches come first.
     */
    fun searchTechnologies(query: String, categoryIdFilter: String? = null): List<Technology> {
        val scoped = if (categoryIdFilter.isNullOrBlank()) {
            technologies
        } else {
            technologies.filter { it.categoryId == categoryIdFilter }
        }

        val terms = tokenize(query)
        if (terms.isEmpty()) return scoped

        val phrase = terms.joinToString(" ")
        return scoped
            .filter { tech ->
                val haystack = searchIndex[tech.id].orEmpty()
                terms.all { haystack.contains(it) }
            }
            .sortedByDescending { tech ->
                val name = tech.name.lowercase()
                val categoryName = getCategoryById(tech.categoryId)?.name?.lowercase().orEmpty()
                when {
                    name == phrase -> 5
                    name.startsWith(phrase) -> 4
                    name.contains(phrase) -> 3
                    terms.all { name.contains(it) } -> 2
                    terms.all { categoryName.contains(it) } -> 1
                    else -> 0
                }
            }
    }
}
