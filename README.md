<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>LinkedIn Microservices Clone</title>
</head>
<body>
  <h1>LinkedIn Microservices Clone</h1>
  <p>
    A robust LinkedIn-inspired application built using a microservices architecture. This project demonstrates the design and implementation of scalable and efficient microservices using Spring Boot, Kubernetes, and Docker.
  </p>

  <h2>Features</h2>
  <ul>
    <li><strong>User Management:</strong> User registration, authentication, and profile management.</li>
    <li><strong>Posts Service:</strong> Create, update, delete, and retrieve posts.</li>
    <li><strong>Connections Service:</strong> Manage friend requests, connections, and network updates.</li>
    <li><strong>Notifications Service:</strong> Real-time notifications for user activities.</li>
    <li><strong>Kafka Integration:</strong> Event-driven architecture for seamless inter-service communication.</li>
    <li><strong>API Gateway:</strong> Centralized entry point for routing requests to individual microservices.</li>
    <li><strong>Service Discovery:</strong> Eureka-based service discovery for dynamic scaling.</li>
    <li><strong>Ingress Controller:</strong> Efficient traffic routing for the application.</li>
    <li><strong>Database Management:</strong> Postgres databases for each microservice.</li>
  </ul>

  <h2>Tech Stack</h2>
  <ul>
    <li><strong>Backend:</strong> Spring Boot</li>
    <li><strong>Messaging:</strong> Kafka</li>
    <li><strong>Database:</strong> PostgreSQL</li>
    <li><strong>Containerization:</strong> Docker</li>
    <li><strong>Service Discovery:</strong> Eureka</li>
    <li><strong>API Gateway:</strong> Spring Cloud Gateway</li>
  </ul>

  <h2>Project Structure</h2>
  <pre>
├── api-gateway
├── connections-service
├── discovery-service
├── notification-service
├── posts-service
├── user-service
└── README.md
  </pre>

  <h2>Getting Started</h2>
  <ol>
    <li>Clone the repository:
      <pre><code>git clone https://github.com/ManmeetBatth/MicroserviceArchitectureBasedLinkedInLikeApplication.git</code></pre>
    </li>
    <li>Build Docker images:
      <pre><code>docker-compose build</code></pre>
    </li>
  </ol>

  <h2>Microservices Overview</h2>
  <ul>
    <li><strong>API Gateway:</strong> Handles all client requests and routes them to the appropriate services.</li>
    <li><strong>User Service:</strong> Manages user-related functionality like registration and login.</li>
    <li><strong>Posts Service:</strong> Allows users to create and interact with posts.</li>
    <li><strong>Connections Service:</strong> Handles user connections and networking.</li>
    <li><strong>Notification Service:</strong> Sends real-time notifications to users.</li>
  </ul>

</body>
</html>
