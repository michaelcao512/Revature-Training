import './App.css';
import Hello from './components/Hello/Hello';
import ListandKeysComponent from './components/listandkeys/ListandKeysComponent';
// import Post from './components/Post/Post';
import StateDemoComponent from './components/state/StateDemoComponent';
import FetchDemo from './components/axiosdemo/fetchingDemo';
import NavBar from './components/NavBar';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import ToDoList from './components/todolist/ToDoList';
import UseRefDemo from './components/useRef/UseRefDemo';
import ControlledComponent from './components/controlled component/ControlledComponent';
import MyContext from './components/Context/MyContext';
function App() {
  const sharedData = "this is shared data";
  
  return (
    <MyContext.Provider value={sharedData}>
      <Router>
        <div className="App">
          <NavBar />
        </div>
        <Routes>
          <Route path="/hello" element={<Hello />} />
          <Route path="/sdc" element={<StateDemoComponent />} />
          <Route path="/listandkeys" element={<ListandKeysComponent />} />
          <Route path="/fetchdemo" element={<FetchDemo />} />
          <Route path="/todolist" element={<ToDoList />} />
          <Route path="/useref" element={<UseRefDemo />} />
          <Route path="/controlledcomponent" element={<ControlledComponent />} />
        </Routes>
        </Router>
      </MyContext.Provider>
  );
}

export default App;
