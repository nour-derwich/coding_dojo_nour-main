// import React , {useState} from 'react'
// import { navigate } from '@reach/router';
// function Home() {
//     const[resouce,setResource]=useState('people');
//     const[selectedId,setSelectedId]=useState('planet');
//     const handleSubmit=(e) =>{
//         e.preventDefault();
//         // navigate('/${resource}/${selectedId}');
//     }
//   return (
//     <div> <form onSubmit={handleSubmit}>
//     <label>Search for: </label>
//     <select onChange={ e=>setResource(e.target.value)}>
//         <option value='people'>People</option>
//         <option value='planet'>Planet</option>
//     </select>
//     <label>ID: </label>
//     <input type='number' onChange={ e=>setSelectedId(e.target.value) } />
//     <button> Search </button>
// </form></div>
//   )
// }

// export default Home