import './App.css';
import Hello from './Hello';
import Post from './Post';
import StateDemoComponent from './StateDemoComponent';
function App() {
  let message = "Hello, world! from message";
  let comments = [
    { id: 1, text: "Comment 1" },
    { id: 2, text: "Comment 2" },
    { id: 3, text: "Comment 3" },
    { id: 4, text: "Comment 4" },
    { id: 5, text: "Comment 5" }
  ];
  let post = {
    id: 1,
    content: "Post content",
  };
  return (
    <div className="App">
      <h2>This is my App</h2>
      <Hello message={message} />
      <Hello message="Custom message prop" />
      <StateDemoComponent />
      <Post post={post} comments={comments} />
    </div>
  );
}

export default App;
