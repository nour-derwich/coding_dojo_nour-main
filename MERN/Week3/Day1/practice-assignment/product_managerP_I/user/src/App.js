
import './App.css';
import Main from './components/Main';
import Display from './components/Display';
import {Route ,Routes, Link} from 'react-router-dom'
import OneProd from './components/OneProd';
import Update from './components/Update';
function App() {
  return (
    <div className="App">
        <h1>Product Manager</h1>
      <Link to="/display">Home</Link>  |
         <Link to="/">create</Link>

      <hr/>
      <Routes>
      <Route path='/' element={<Main/>}/>
      <Route path="/prodect/:id"element={<OneProd/>}/>
      <Route path="/display" element={<Display/>} />
      <Route path="/update/:id" element={<Update/>} />
   
     </Routes>
    </div>
  );
}

export default App;
