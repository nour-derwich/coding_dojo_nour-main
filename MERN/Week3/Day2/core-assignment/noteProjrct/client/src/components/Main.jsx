import React from 'react'
import {useEffect,useState} from 'react';
import axios from 'axios'
import './style.main.css'
import { Link ,useNavigate} from 'react-router-dom'

function Main(props) {
    const navigate=useNavigate();
    const [notes,setNotes]=useState([])
    useEffect(()=>{
        axios.get("http://localhost:8000/api/notes")
        .then(res=>{
            console.log(res.data);
            setNotes(res.data)
        })
        .catch(err=>console.log("XX",err))

    },[])
const goToUpdate= (nodeId)=>{
    navigate(`/update/${nodeId}`)

}
const deleteNote=(nodeId)=>{
axios.delete(`http://localhost:8000/api/notes/${nodeId}`)
.then(res=>{
    console.log(res.data);
    console.log("DELETE SUCCESS!");
    setNotes(notes.filter((note)=>note._id!==nodeId))
})
.catch(err=>console.log("XX",err))
}
  return (
    <div>{notes.map((note)=>{
        return(
            <div key={note._id} className="note">
              <div><Link to={"/note/"+note._id}>
                <h3>{note.is_inptant?"🎈":""}{note.title}</h3>
                <p>{note.context}</p>
             <p>{note.createdAt}</p> </Link>
                <button onClick={()=>goToUpdate(note._id)}>edit</button>
                <button onClick={()=>deleteNote(note._id)}>delete</button>
                </div>  
            </div>
        )
    }

    )
        }</div>
  )
}

export default Main