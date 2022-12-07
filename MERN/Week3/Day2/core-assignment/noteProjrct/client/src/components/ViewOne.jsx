import React from 'react'
import {useEffect, useState} from 'react'
import axios from 'axios';
import {useParams} from 'react-router-dom';

const ViewOne =(props)=>{

    const [oneNote,setOneNote]=useState(null);
    const {id}=useParams();
    console.log(id);
    useEffect(()=>{
        axios.get('http://localhost:8000/api/notes/'+id)
        .then(res=>{console.log(res.data);
            setOneNote(res.data)
        })
        .catch(err=>console.log(err))
    },[])

  return (
    <div>
     
      {
        oneNote ? <div>text:{oneNote.title}<br/>
           context:  {oneNote.context}<br/>
           <p>created at:{oneNote.createdAt}</p>
        </div> : "loading..."
        }
        
    </div>
  )
}
;
export default ViewOne