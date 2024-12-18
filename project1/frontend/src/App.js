import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import NavBar from './Components/Navigation/NavBar';
import HomePage from './Components/Home/HomePage';
import RegistrationPage from './Components/Registration/RegistrationPage';
import LoginPage from './Components/Login/LoginPage';
import ProfilePage from './Components/Profile/ProfilePage';

function App() {
  return (

    <Router>
      {/* <nav>
        <NavBar/>
      </nav> */}

      <Routes>
        <Route path="/" element={<HomePage/>} />
        <Route path="/register" element={<RegistrationPage/>} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/profile" element={<ProfilePage />} />
      </Routes>
    </Router>

  );
}

export default App;
