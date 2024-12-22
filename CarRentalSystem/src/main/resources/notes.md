Why Singleton Pattern?
1. Centralized Control: The RentalSystem class represents the core logic of the car rental system. A single instance ensures that data such as the list of cars and reservations is consistent across the application.
2. Shared Access: Multiple components (e.g., UI, backend services) can access the same RentalSystem instance to perform operations without duplicating data or logic.
3. Thread Safety: Since it uses synchronized in the getInstance method, the Singleton ensures thread-safe initialization in a multi-threaded environment.

-------------------------------
