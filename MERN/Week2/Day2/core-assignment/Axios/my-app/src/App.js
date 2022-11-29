
import React, {useState } from 'react';
import axios from 'axios';

function App() {
  const [poke, setPoke] = useState([]);
  const fetching =() =>{ 

    axios.get(" https://pokeapi.co/api/v2/pokemon")

    .then(response =>{
      setPoke (response.data.results);
    })
    
    .catch(err => {
        console.log(err);
    })
    console.log(poke);
  }
  return (
    <div className="App">
      <button onClick={fetching}>Fetch pokeapi</button>
      { poke.map((p, index)=>{
                return <li key={index}>{p.name}</li>
            })}
    </div>
  );
}

export default App;
