import './App.css';
import { Link, Routes, Route } from 'react-router-dom';
import Home from './components/Home';
import Other from './components/Other';
import Hero from './components/Hero';
import ErrorPage from './components/ErrorPage';
import Form from './components/Form';
function App() {
  return (
    <div className="App">
      <h1>Routing</h1>
     
      <br />
      <Link to="/">React Home</Link>
      <br />
      <Link to="/other">OTHER</Link>

      <hr />
      
      <Routes>
        <Route path='form' element={<Form />} />
        <Route path='/hero/:heroId' element={<Hero />} />
        <Route path='/error' element={<ErrorPage />} />
       
        <Route path='/other' element={<Other />} />
        <Route path='/' element={<Home />} />
      
        <Route path={"*"} element={
          <main style={{ padding: "1rem" }}>
            <p>There nothing here!</p>
            <ErrorPage />
          </main>} />
      </Routes>
    </div>
  );
}
//40:29
export default App;