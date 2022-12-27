import React from "react";
import {
  Link,
  Routes,
  Route
} from "react-router-dom";
import { useParams } from "react-router";  
import Survey from "./components/Survey"; 
import Home from "./components/Home";
import Number from "./components/Number";
import About from "./components/About";

// const Location = (props) => { 
  // const { city } = useParams(); // matches our :city in our Routes
    
  // return (
  //   <h1>Welcome to { city }!</h1>
  // );
// } 
function App() {
  return (
    <div>
      {/* <p>
        <Link to="/location/seattle">Seattle</Link>
         | 
        <Link to="/location/chicago">Chicago</Link>
         | 
        <Link to="/location/burbank">Burbank</Link>
      </p> */}
      <Routes>
        <Route path="/home" element={<Home/>}/>
        <Route path="/Number/:id" element={<Number/>}/>
        <Route path='/:id/:col1/:col2' element={<About />} />
      </Routes>
      
    </div>
  );
}
    
export default App;
