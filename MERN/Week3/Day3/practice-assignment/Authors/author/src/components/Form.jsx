import React ,{useState}from 'react'
import axios from 'axios';
import {useNavigate , Link} from 'react-router-dom';

const Form=() =>{
    const navigate = useNavigate()
    const[name,setName]=useState('');
    const[errors,setErrors]=useState({})
    
const creacteAuthor=e=>{
    e.preventDefault();
    axios.post('http://localhost:8000/api/authors/', {name})
        .then(()=>{
          navigate('/');
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
    <Link to="/">Home</Link>

<form onSubmit={creacteAuthor} >
      
      <label>Name</label><br/>
      <input onChange={(e)=>setName(e.target.value)} value={name}/>  
      <p>{errors.name}</p>
<br/>  <input type="submit" value='add'/>
</form>


    </div>
  )
}

export default Form