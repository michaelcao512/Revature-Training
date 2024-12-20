# Message Queue Activity - Implement a Pub/Sub Message Queue
Your goal for this activity is to implement a pub/sub message queue. Included here are two Spring Boot projects, a publisher and a subscriber. You will need to create a third application, one that allows the other two to communicate. 

This will follow the pub/sub pattern. The subscriber service will need to subscribe, the publisher will need to send messages to the queue, and the queue will then deliver those messages to subscribers.

There are two projects included with this activity, ```message-publisher``` and ```message subscriber```. 

The subscriber is set to send a POST to the queue's ```/subscribe``` endpoint at launch, and will then receive messages from the queue and "process" them by printing them to the console.

The publisher is set to send several messages to the queue's ```/publish``` endpoint at launch.

Once implemented you should be able to start your queue first, followed by the subscriber, then run the publisher. You should see some messages from a text file get outputted line by line in the subscriber console.

## Requirements
Start with a new Spring Boot project, and include the Spring Web dependency. Add the Spring Data JPA dependency if you want to persist the messages. This is standard practice for a message queue.

  - Implement the ```/subscribe``` endpoint. POST requests sent to this endpoint should include a SubscriptionDto object which contains host, port, and endpoint to publish messages. Add this information to a list of subscribers.

 - Implement the ```/publish``` endpoint. POST requests sent to this endpoint should include plain text in the body, this is the message to publish. Extract that message and queue it.

 - Implement some sort of processing mechanism. This should constantly look for queued messages and publish them. You may want to include a short delay between processing to simulate latency. You can simply add ```Thread.sleep(1000)``` in order to wait 1 second.

 - (Optional) Persist the messages as they come in, and eject them from persistance (or in some way mark them as complete) once fully processed.

Make sure ports and URLs are correct. Check the ```server.port``` property in the application properties files. The queue is expected to run on port ```8989```.

