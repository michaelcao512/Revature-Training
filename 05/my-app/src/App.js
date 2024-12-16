import './App.css';
import Hello from './components/Hello';
import ListandKeysComponent from './components/listandkeys/ListandKeysComponent';
import Post from './components/Post/Post';
import StateDemoComponent from './components/StateDemoComponent';
import FetchDemo from './components/axiosdemo/fetchingDemo';
import NavBar from './components/NavBar';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import ToDoList from './components/todolist/ToDoList';
function App() {
  return (

    <Router>
      <div className="App">
        <NavBar />
      </div>
      <Routes>
        <Route path="/hello" element={<Hello />} />
        <Route path="/sdc" element={<StateDemoComponent />} />
        <Route path="/listandkeys" element={<ListandKeysComponent />} />
        {/* <Route path="/posts" element={<Post />} /> */}
        <Route path="/fetchdemo" element={<FetchDemo />} />
        <Route path="/todolist" element={<ToDoList />} />
      </Routes>
    </Router>
  );
}

export default App;
