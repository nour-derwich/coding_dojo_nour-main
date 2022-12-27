import React ,{useEffect,useState} from 'react'
import axios from 'axios';
import { Link } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';

const Display=(props)=> {
   const  navigate=useNavigate()
    const [prodects,setProdect]=useState([]);
    useEffect(()=>{
        axios.get("http://localhost:8000/api/prodects")
        .then(res=>{
            console.log(res.data);
            setProdect(res.data)

        })
        .catch(err=>console.log("🧨🎇",err))

    },[])

    const goToUpdate= (prodectId)=>{
        navigate(`/update/${prodectId}`)
    
    }
    const deleteProdect=(prodectId)=>{
    axios.delete(`http://localhost:8000/api/prodects/${prodectId}`)
    .then(res=>{
        console.log(res.data);
        console.log("DELETE SUCCESS!");
       setProdect(prodects.filter((prodect)=>prodect._id!==prodectId))
    })
    .catch(err=>console.log("❌❌",err))
    }

  return (
    <div>{prodects.map((prodect)=>{
        return(
            <div key={prodect._id} >
              <div><Link to={"/prodect/"+prodect._id}>
               <h3>  🐱‍👤{prodect.title} </h3>
                 </Link><button onClick={()=>goToUpdate(prodect._id)}>🧹</button> <button onClick={()=>deleteProdect(prodect._id)}>❌</button>
                
                </div>  
            </div>
        )
    }

    )
        }</div>
  )
}

export default Display