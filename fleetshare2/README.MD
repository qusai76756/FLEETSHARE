# FleetShare - Smart Vehicle Sharing Simulator

##  Project Overview
Java console application simulating a vehicle-sharing service with OOP principles and design patterns.

##  Architecture
- Domain Layer: Vehicle, User, Trip, Pricing entities
- Infrastructure Layer: In-memory repositories
- OOP Principles: Full implementation (Inheritance, Polymorphism, Encapsulation, Abstraction)

##  Design Patterns
- Strategy Pattern (Pricing Strategies)
- Factory Pattern (Vehicle Creation)
- Repository Pattern (Data Persistence)

##  How to Run
`bash
mvn compile
mvn exec:java -Dexec.mainClass="org.example.main"
![UML](diagram.png)