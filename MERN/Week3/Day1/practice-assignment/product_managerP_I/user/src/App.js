
import './App.css';
import Main from './components/Main';
import Display from './components/Display';
import {Route ,Routes} from 'react-router-dom'
import OneProd from './components/OneProd';
function App() {
  return (
    <div className="App">
        <h1>Product Manager</h1>
      
      <hr/>
      <Routes>
      <Route path='/' element={<Main/>}/>
      <Route path="/prodect/:id"element={<OneProd/>}/>
      <Route path="/display" element={<Display/>} />
   
     </Routes>
    </div>
  );
}

export default App;
