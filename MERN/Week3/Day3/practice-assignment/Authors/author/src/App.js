
import './App.css';
import { Link, Route ,Routes} from 'react-router-dom';
import Main from './components/Main';
import Form from './components/Form';
import Update from './components/Update';
import ViewOne from './components/ViewOne';
function App() {
  return (
    <div className="App">
      <h1>Favorite authors</h1>
      
      <Routes>
      <Route path="/" element={<Main/>}/>
      <Route path="/create" element={<Form/>}/>
      
      <Route path="/update/:id"element={<Update/>}/>
      <Route path="/authors/:id"element={<ViewOne/>}/>
   
     </Routes>
    </div>
  );
}

export default App;
