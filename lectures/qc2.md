### Kafka 
- multiple componetns running asychornous messaging
- pub/sub with broker
- messaging and processing large volumes of real data

### why you need
- different services dont need to wait for each other
- to avoid blocking and bottle necks where one component is slower than the rest but take too much traffic to process
- multiprocessing allows us to avoid this
- modularity

### Microservices 
- event driven archtiecture is one microservices
- decoupling parts of the backend -> break apart backend services to make it more modular
- other things continue to work if one thing goes down
- fault tolerance: if theres a problem (ex message queue goes down) other should take over - multiple replications of partitions
