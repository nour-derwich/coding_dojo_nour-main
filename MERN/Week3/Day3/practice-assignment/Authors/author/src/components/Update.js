
import React, {useState,useEffect } from 'react'
import axios from 'axios';

import { useParams ,useNavigate} from 'react-router-dom';
const Update=(props)=> {
    const navigate=useNavigate();
    const {id}=useParams();
    const [name,setName]=useState('')
    const[errors,setErrors]=useState({})
    useEffect(()=>{
        axios.get('http://localhost:8000/api/authors/'+id)
        .then(res=>{
            setName(res.data);
        //    navigate("/")
           
        })
        .catch(err=>console.log(err))
    },[id])
    const updateAuthor=(e)=>{
        e.preventDefault();
        axios.put(`http://localhost:8000/api/authors/${id}`,{name})
        .then(res=>{console.log(res.data);
            navigate("/")
        })
        .catch((err)=>{
            const errResponse=err.response.data.errors;
                  const errObj= {};
                  for(const key of Object.keys(errResponse)){
                    errObj[key]=errResponse[key].message;
                  }
                  setErrors(errObj);
                }
            )
    }
  return (
    <div>
    
<form onSubmit={updateAuthor} >
  
      <label>Name</label><br/>
      <input onChange={(e)=>setName(e.target.value)} value={name.name}/>
      <p>{errors.name}</p>
<br/>  <input type="submit"/>
</form></div>
  )
}

export default Update