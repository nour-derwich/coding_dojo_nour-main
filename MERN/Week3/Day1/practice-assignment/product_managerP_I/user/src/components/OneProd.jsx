import React from 'react'
import {useEffect, useState} from 'react'
import axios from 'axios';
import {useParams} from 'react-router-dom';

function OneProd(props) {
    const[oneProdect,setOneProdect]=useState(null);
    const {id}=useParams();
    console.log(id);
    useEffect(()=>{
        axios.get('http://localhost:8000/api/prodects/'+id)
        .then(res=>{console.log(res.data);
            setOneProdect(res.data)
        })
        .catch(err=>console.log(err))
    },[])
  return (
    <div>
     
    {
      oneProdect ? <div>text: {oneProdect.title}<br/>
         Price$:  {oneProdect.price}<br/>
         <p>description:{oneProdect.description}</p>
         <p>created at: {oneProdect.createdAt}</p>
      </div> : "loading..."
      }
      
  </div>
  )
}

export default OneProd