### Immutability

- state is defined either by property (class-component) or lifecycle hooks (functional-component)
- should never mutate state directly and only thorugh a mutator
- why?
  - mutating state directly = buggy / difficult to optimize
    - only rerendering when prop changes
  - immutability allows for changes to be detected without traversing

### Fetching data

- RestFUL API
  - returns a response from backend to frontend (JSON)
- asynchronous request
  - it takes time to make a http request
  - don't want to stall app waiting on request
- use a useEffect hook with fetch API or axios API

### React Router

- declarative model of navigaitonal components provided with react-router-dom (or react-router-native for mobile)
- React Router DOM

  - BrowserRouter

    - uses HTML5 history API to keep UI sync with url
    - <Switch> Component

      - ensures a single route is rendered exclusively
      - without this could render 2 componetns should as the component and not found at same time
      - ... parmatertized routes satisfied by static route
      - <Route> tags encapsulate a renderable component to switch to based on url

    - <Link to="/">Home</Link> 
      - once router is set up we can use Link to link to different URLs
      - this differs from the <link> tag

### Lifting State

- data is one way
  - parent to child - sharing props - including state
  - closure - inner child has access to its parent varaibels
- parent to multiple child - sharing props between siblings = lifting
- when you want to change state of two components together, move to common parent and pass state down to them via props

### Higher Order Components

- function that takes a component and returns enhanced component
- higher order functions take a component as a parameter and returns it transformed with additional functionality

### Controlled Component

- in HTML form elements (`<input>, <textarea>, and <select>`) typically maintain their own state and update based on user input
- in React, mutable states typically kept within state manager
- we should combine these two for "single source truth" using controlled component
- React input changes based on user input and is controlled by React state

```javascript
const [text, setText] = useState("");
return (
  <>
    <input type="text" value={text} onChange={(e) => setText(e.target.value)} />
    <p>{text}</p>
  </>
);
```

### useRefs

- when we want a component to remember information we can use ref but we don't want it to rerender upon change (useState always rerender upon state change)
- can manipulate the state use .current

```javascript
const initialState = 5;
const state = useRef(initalState);

state.current = 10;
```

### React Context

- gives a way to pass data down through a tree without manually passing a prop at every single level from parent to child
- global storage space that shared between all components
- Creating Context

  ```javascript
  const MyContext = createContext();
  ```

  - method to create global context object

- Provider

  ```javascript
  <MyContext.Provider value={sharedData}>
  ```

  - component at top level to wrap components that has access to the context
  - value attribute provides the shared data to provide in context

- Consuming

  ```javascript
  const sharedData = useContext(MyContext);
  ```

  - hook that has access to the shared data
  - or consumer component wraps what is utilizing the context

### React Testing

- jest
  - pick up any files with .test.js
- react testing

- run test
  `npm run test` or `yarn test`
- creating a test

  ```javascript
  test("test description", () => {
    render(<App />);
    const linkElement = screen.getByText(/test paragraph/i);
    expect(linkElement).toBeInTheDocument();
  });
  ```

- creating a new test suite

  ```javascript
  describe("suite of tests description", () => {
    // tests...
  });
  ```

  - Testing Steps (3A - arrange, act, assert)

    1. render the component and select the elements you want to interact with
    2. interact with the element
    3. assert

    - in Spring Boot
      - create the object and variables needed
      - interact upon the objects / variables
      - assert

  - utilities
    - `render(<Component/>)`
      - renders the component to test
    - `screen` object
      - search something on the UI
      - .getByText(text)
      - .getByTestId()
        - gets based on the attribute data-testid attribute
    - `expect(element)`
      - .toBeInTheDocument()
    - `fireEvent` object
      - .click(buttonElement)

# Event Driven Architecture

- Event-Driven Architecture (EDA) is a software design pattern where the flow of the applicatoin is determined by events\
  - design pattern - solution to common reoccuring problems
- events trigger responses or actions
  real life example: car crashes -> air bags
- commonly used in systems requiring scalability, flexiblity, and real-time processing

- **Events**: represents a signficant action or change in systems

  - user clicks buton, an item is added to cart
  - _asynchronous_ events are _immutable_ and usually have _self-contained_ payload that describe occurrence

- **Producer**: Components that generate and send events

  - detects change or an action that needs to be communicated and create an event
  - often user-facing components that trigger action based on events
  - payment servicie generating "payment succesful" event

- **Consumer**: Component that listens for events and processes them

  - consumer subscribe to events and take appropriate action when event of interest occurs
  - mayy act by updating databases, invoking business logic, or notifying other service
  - email service sending confirmation email when "payment successful" event recieved

- **Event Bus/Brokers**: System (Middleware) component responsible for transmitting events between producer and consumer

  - decouples event generation from event handling by ensuring roducer don't interact directly with consumer
  - examples: Kafka(stream), RabbitMQ(mq), AWS SNS/SQS(pub/sub)
  - Roles:
    - **Event Dispatching**: ensures events are sent from producer to appropriate consumer
    - **Message Queuing**: temporarily store events, allowing consumer to process event at own pace
    - **Routing**: determines which conusmers should receive specfic events
    - **Persistence**: some events brokers can persist events, enabling replay and auditing
  - Types
    - **Message Queues (MQ)**: events consumed by single consumer where order matter
    - **Publish-Subscribe Systems (Pub/Sys)**: events broadcasted to multiple consumers who subscribe to specific event type
    - **Event Streams**: Systems allows continous stream of events, often for real time processing

- **Event Handler**: Logic that executes in response to event

  - ex: updating database when event is received

- How EDA works
  - **Event Production**: producer detects a change or action and generates an event
  - **Event Propagation**: event is transmitted to an event broker
  - **Event Consumption**: consumer subscribes to relevant events and react accordingly
- Benefits
  - Scalable - independent components can be scaled based on load
  - Loosely Coupled Systems - producer / consumers operate indepdently - reducing dependecies
  - Real-Time Processing - near-instantaneous response
  - Flexible - adding a new feature/consumer doesnt change existing components signficantly
  - Resilience - can continue operating even if components fail
- Types
  - Simple Event Processing
    - event triggers specific action in near real-time
    - motion sensor turning on line
  - Event Stream Processing
    - events continously analyzed in stream
    - real-time fraud detection
  - Complex Event Processing (CEP)
    - multiple events analyzed and correlated to identify patterns
    - monitoring stock trading for unusal pattern
- Common Use Casees
  - Real Time Apps (Chat app, live dashboard, notifcaations)
  - IoT Systems (sensors generating events)
  - Microservice Communication (service communicate asynch to achieve scalaiblity)
  - E-commerece (order processing workflows with events like "order placed" or "item shipped")
  - Event Sourcing (capturing state changes as seuqence of events for reconstructuring state)
- Challenges
  - Event Dupplication: handling duplicate events due to retries
    - use idempotent consumer
  - Debugging: async nature
    - implement logging and monitoring
  - Complexity: designing / maintaingly loosely coupled systems is difficult
    - proper documentation and standards
  - Data Consistency: ensuring eventual consistency across components
    - adopt patterns like Saga for distirbuted transactions

### Apache Kafka

- middleware event streaming platform to handle large volumes of real time data
- most widely used for EDA
- usually for managing streams of data

- Producer
  - service sends data to Kafka topics
  - producers can send message in real-time to a Kafka topic or multiple topics
  - producers typically write to a topic's partition, and Kafka brokers will handle distribution of the data across nodes
- Consumer

  - application/service that subscribes to Kafka topics and processes data messages
  - can either read from specific partition or all partition of the topic

- Broker

  - core servers in Kafka clusters that manage the storage, distribution, and retrieval of event messages
  - handle incoming producerve messgages and cserve consuemr requets

- Topic
  - Category or feed name to which messages are sent by producer
  - divided into partitions - each partition distirbuted across multiple brokers in cluster
  - Allow consuemrs to subscribe specific categories of messages
- Partition
  - topics split into partition for scalability and parallel processing
  - each partition is ordered, immutable sequence of messages
  - allows Kafka to sacle horizontally by distirbuting them across different brokers in the Kafka clusters
  - multiple consumers can consume at sametime
- ZooKeeper
  - WAS used by Kfka for distrubted coordination and management of broker
  - managed leader election and metadata for topics nad partitions
  - newer versions replaced with KRaft for managing internal metadata
- Consumer Group

  - group of consumers that jointly consume messages from one or more Kafka topics

- Kafka Architecture
  - **Cluster**: multiple brokers work together to handle ingestion, storage, and processing of messages
  - **Replication**: handles fault tolerancing - each partition replicated across different rokers ensuring data is not lost even if broker fails

```

```
