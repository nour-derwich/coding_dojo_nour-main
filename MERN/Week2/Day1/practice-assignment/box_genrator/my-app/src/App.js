
import Form from './components/form';
import Display from './components/Display';
import { useState } from 'react';
function App() {
  const [box, setBox] = useState([]);
  // const boxes = [
  //   {
  //     height: 200,
  //     weight: 200,
  //     color: "red"
  //   },
  //   {
  //     height: 200,
  //     weight: 200,
  //     color: "blue"
  //   },
  //   {
  //     height: 200,
  //     weight: 200,
  //     color: "purple"
  //   }
  // ]
  return (
    <div >
      <h1>App.js</h1>
      <Form  box={box} setBox ={setBox}/>
      {JSON.stringify(box)}
      <Display box={box}/> 
    </div>
  );
}

export default App;
