
import './App.css';
import { Router } from '@reach/router';
import Home from './components/Home';
import People from './components/People';
import Planet from './components/Planet';

function App() {
  return (
    <div className="App">
      <Home/>
      <People path="/people/:id" />
          <Planet path='/planet/:id'/>
    </div>
  );
}

export default App;
