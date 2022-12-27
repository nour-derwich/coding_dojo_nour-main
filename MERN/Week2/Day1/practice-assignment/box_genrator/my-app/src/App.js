import './App.css';
import Form from './components/form';
import React, { useState } from 'react';
import Display from './components/Display';

function App() {
  const [boxs, setBoxs] = useState([{color:"red",Height:"100px",width:"100px"},{color:"blue",Height:"100px",width:"100px"},{color:"purple",Height:"100px",width:"100px"}]);
  const newbox = (color,Height,width) => {
    setBoxs([...boxs,{color:color,Height:Height,width:width}]);
    // console.log(boxs);
    
  }
  return (
    <div className="App">
      <Form newbox={newbox}/>
      <div className="boxs">  
    
    <Display boxs={boxs}/>
    </div>
    </div>
  );
}

export default App;

