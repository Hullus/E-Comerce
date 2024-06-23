```mermaid
flowchart TD
    subgraph User["👤 1. User Interaction"]
        A[fa:fa-user User] -->|Browses/Orders| B[fa:fa-laptop Web/Mobile App]
    end

    subgraph Gateway["🔐 2. API Gateway"]
        B -->|Sends request| C{fa:fa-random API Gateway}
        C -->|Authenticates| D[fa:fa-key Auth Service]
    end

    subgraph Core["⚙️ 3. Core Services"]
        C -->|Routes to| E[[fa:fa-cogs Core Services]]
        E --> F[fa:fa-box Product Service]
        E --> G[fa:fa-shopping-cart Order Service]
        E --> H[fa:fa-user-circle User Service]
    end

    subgraph Data["💾 4. Data Storage"]
        F -.->|Reads/Writes| I[(fa:fa-database Product DB)]
        G -.->|Reads/Writes| J[(fa:fa-database Order DB)]
        H -.->|Reads/Writes| K[(fa:fa-database User DB)]
    end

    subgraph Process["🔄 5. Order Processing"]
        G -->|Creates order| L{fa:fa-exchange-alt Message Queue}
        L -->|Notifies| M[fa:fa-credit-card Payment Service]
        L -->|Notifies| N[fa:fa-truck Shipping Service]
    end

    subgraph Support["🛠️ 6. Support Services"]
        E -.->|Uses| O[[fa:fa-tools Support Services]]
        O --> P[fa:fa-bolt Caching]
        O --> Q[fa:fa-file-alt Logging]
        O --> R[fa:fa-chart-line Monitoring]
    end

    classDef userStyle fill:#e6f3ff,stroke:#4a69bd,stroke-width:2px
    classDef gatewayStyle fill:#d5e8d4,stroke:#82b366,stroke-width:2px
    classDef coreStyle fill:#ffe6cc,stroke:#d79b00,stroke-width:2px
    classDef dataStyle fill:#f8cecc,stroke:#b85450,stroke-width:2px
    classDef processStyle fill:#e1d5e7,stroke:#9673a6,stroke-width:2px
    classDef supportStyle fill:#fff2cc,stroke:#d6b656,stroke-width:2px

    class User,A,B userStyle
    class Gateway,C,D gatewayStyle
    class Core,E,F,G,H coreStyle
    class Data,I,J,K dataStyle
    class Process,L,M,N processStyle
    class Support,O,P,Q,R supportStyle

    linkStyle default stroke-width:2px,fill:none,stroke:gray
