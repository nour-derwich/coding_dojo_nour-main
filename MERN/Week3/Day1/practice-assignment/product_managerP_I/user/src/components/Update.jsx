
import React, {useState,useEffect } from 'react'
import axios from 'axios';

import { useParams ,useNavigate} from 'react-router-dom';
const Update=(props)=> {
    const navigate=useNavigate();
    const {id}=useParams();
    const [inputs,setInputs]=useState({title:"",price:"",description:false})
    useEffect(()=>{
        axios.get('http://localhost:8000/api/prodects/'+id)
        .then(res=>{console.log(res.data);
            setInputs(res.data);
        //    navigate("/notes")
           
        })
        .catch(err=>console.log(err))
    },[])
    const updateProdect=(e)=>{
        e.preventDefault();
        axios.put(`http://localhost:8000/api/prodects/${id}`,{
            title: inputs.title , price: inputs.price , description: inputs.description
        })
        .then(res=>{console.log(res.data);
            navigate("/display")
        })
        .catch(err=>console.log(err))
    }
  return (
    <div>
    
<form onSubmit={updateProdect} >
  
      <label>Title</label><br/>
      <input onChange={(e)=>setInputs({...inputs, title:e.target.value})} value={inputs.title}/>
      <br/> 
      
      <label>price</label><br/>
      <input onChange={(e)=>setInputs({...inputs, price:e.target.value})} value={inputs.price}/>
      <br/> 
      <label>description</label><br/>
      <textarea  onChange={(e)=>setInputs({...inputs, description: e.target.value})} value={inputs.description}></textarea>
    
<br/>  <input type="submit"/>
</form></div>
  )
}

export default Update