
import './App.css';
import { Link, Route ,Routes} from 'react-router-dom'
import Main from './components/Main';
import Form from './components/Form';
import ViewOne from './components/ViewOne';
import Update from './components/Update';
function App() {
  return (
    <div className="App">
      <h1>Notes</h1>
      <Link to="/notes">home</Link> &thinsp;&thinsp;
      <Link to="/create">Create</Link>
      <hr/>
      <Routes >
      <Route path="/notes" element={<Main/>}/>
      <Route path="/create" element={<Form/>}/>
      <Route path="/note/:id"element={<ViewOne/>}/>
      <Route path="/update/:id"element={<Update/>}/>
   
     </Routes>
    </div>
  );
}

export default App;
