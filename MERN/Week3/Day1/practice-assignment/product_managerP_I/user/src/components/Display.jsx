import React ,{useEffect,useState} from 'react'
import axios from 'axios';
import { Link } from 'react-router-dom'

const Display=(props)=> {
   
    const [prodects,setProdect]=useState([]);
    useEffect(()=>{
        axios.get("http://localhost:8000/api/prodects")
        .then(res=>{
            console.log(res.data);
            setProdect(res.data)

        })
        .catch(err=>console.log("🧨🎇",err))

    },[])



  return (
    <div>{prodects.map((prodect)=>{
        return(
            <div key={prodect._id} >
              <div><Link to={"/prodect/"+prodect._id}>
                <h3>🐱‍👤{prodect.title} </h3>
                 </Link>
                
                </div>  
            </div>
        )
    }

    )
        }</div>
  )
}

export default Display