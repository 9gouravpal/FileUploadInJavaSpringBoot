import './App.css';
import { Routes, Route } from "react-router-dom"
import Login from './components/login';
import Signup from './components/signup';
import Page from './components/About';
import Resume from './components/resume';
import ResumeForm from './components/ResumeForm';

function App() {
  return (
    <div className="App">
     
        <Routes>
         
          <Route path="/" element={<Signup />} />
          <Route path="/login" element={<Login />} />
          <Route path="/page" element={<Page />} />
          <Route path="/resume" element={<Resume/>} />
          <Route path="/create" element={<ResumeForm/>} />
        </Routes>
      
    </div>
  );
}

export default App;
