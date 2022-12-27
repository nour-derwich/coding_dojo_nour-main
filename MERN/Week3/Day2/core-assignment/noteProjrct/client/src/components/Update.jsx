
import React, {useState,useEffect } from 'react'
import axios from 'axios';

import { useParams ,useNavigate} from 'react-router-dom';
const Update=(props)=> {
    const navigate=useNavigate();
    const {id}=useParams();
    const [inputs,setInputs]=useState({title:"",context:"",is_inptant:false})
    useEffect(()=>{
        axios.get('http://localhost:8000/api/notes/'+id)
        .then(res=>{console.log(res.data);
            setInputs(res.data);
        //    navigate("/notes")
           
        })
        .catch(err=>console.log(err))
    },[])
    const updateNote=(e)=>{
        e.preventDefault();
        axios.put(`http://localhost:8000/api/notes/${id}`,{
            title: inputs.title , context: inputs.context , is_inptant: inputs.is_inptant
        })
        .then(res=>{console.log(res.data);
            navigate("/notes")
        })
        .catch(err=>console.log(err))
    }
  return (
    <div>
    
<form onSubmit={updateNote} >
  
      <label>Title</label><br/>
      <input onChange={(e)=>setInputs({...inputs, title:e.target.value})} value={inputs.title}/>
  
      <br/> 
      <label>Context</label><br/>
      <textarea  onChange={(e)=>setInputs({...inputs, context: e.target.value})} value={inputs.context}></textarea>
      <br/> 
  <input  type="checkbox"  onChange={(e)=>setInputs({...inputs,is_inptant :e.target.checked})} checked={inputs.is_inptant} /><label> is inptant</label>
<br/>  <input type="submit"/>
</form></div>
  )
}

export default Update