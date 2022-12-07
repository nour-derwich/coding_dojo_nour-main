import React ,{useState}from 'react'
import axios from 'axios';

const Main=()=> {
    const[inputs,setInputs]=useState({title:"",price:"",description:""});

const creacteProd=e=>
{
    e.preventDefault();
    axios.post('http://localhost:8000/api/prodects', {
        title: inputs.title, price:inputs.price,description:inputs.description
    })
        .then(res=>console.log(res))
        .catch(err=>console.log(err))
}
  return (
    <div>
    
    <form onSubmit={creacteProd} >
      
          <label>Title</label><br/>
          <input onChange={(e)=>setInputs({...inputs, title:e.target.value})} value={inputs.title}/>
      
          <br/> 
          <label>Price</label><br/>
          <input type="number"  onChange={(e)=>setInputs({...inputs, price: e.target.value})} value={inputs.price}/>
          <br/> 
          <label> description</label><br/>
      <textarea onChange={(e)=>setInputs({...inputs,description :e.target.value})} value={inputs.description} />
    <br/>  <input type="submit"/>
    </form></div>
  )
}

export default Main