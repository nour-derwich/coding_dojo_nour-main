import {useState} from 'react'
import './App.css';

function App() {
  const [poke, setPoke] = useState([]);

    const pokeapi = () => { fetch(" https://pokeapi.co/api/v2/pokemon")
    .then(response =>{
      return response.json();
    })
    .then(response =>{
      setPoke(response.results);
    })
    .catch(err => {
        console.log(err);
    })
    console.log(pokeapi);
  }
  return (
    <div className="App">
      <button onClick={pokeapi}>Fetch pokeapi</button>
      { poke.map((p, index)=>{
                return <li key={index}>{p.name}</li>
            })}
    </div>
  );
}

export default App;
