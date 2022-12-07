import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { useNavigate } from 'react-router-dom';





const Form = () => {
    const navigate=useNavigate();
    //keep track of what is being typed via useState hook
    const [title, setTitle] =useState(""); 
    const [context, setContext] =useState("");
    const [is_inptant,setisInptant]=useState(false);
    //handler when the form is submitted
    const onSubmitHandler = e => {
        //prevent default behavior of the submit
        e.preventDefault();
        //make a post request to create a new note
        axios.post('http://localhost:8000/api/notes', {
            title,
            context,
            is_inptant
        })
            .then(res=>{console.log(res)
                  navigate("/notes")})
            .catch(err=>console.log(err))
    }
  return (
    <div>
              <div>{JSON.stringify(title)}
                {JSON.stringify(context)}
              {JSON.stringify(is_inptant)}</div>
        <form onSubmit={onSubmitHandler}>
            <p>
                <label>Title</label><br/>
                <input onChange={(e)=>setTitle(e.target.value)} value={title}/>
            </p>
            <p>
                <label>Context</label><br/>
                <textarea  onChange={(e)=>setContext(e.target.value)} value={context}></textarea>
            </p>
            <input  type="checkbox"  onChange={(e)=>setisInptant(e.target.checked)} checked={is_inptant} /><label> is inptant</label>
          <br/>  <input type="submit"/>
        </form></div>
  )
}

export default Form;