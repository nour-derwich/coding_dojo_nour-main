import React from 'react'
import {useEffect,useState} from 'react';
import axios from 'axios'
import AuthorList from './AuthorList';
import {Link} from 'react-router-dom';
function Main(props) {
   const [isloading,setIsloading]=useState(true)
    const [authors,setAuthors]=useState([])
    useEffect(()=>{
        axios.get("http://localhost:8000/api/authors")
        .then(res=>{
            setAuthors(res.data)
            setIsloading(false)
        })
        .catch(err=>console.log("🔞",err))

    },[])

    if (isloading){
        return <h2>loading.....</h2>
    }
    // 
    const deleteAther = id =>
    {
 axios.delete(`http://localhost:8000/api/authors/${id}`)
.then(()=>{
    console.log("DELETE SUCCESS!");
    setAuthors(authors.filter((author)=>author._id!==id))
    })
    .catch(err=>console.log("XX",err))

}
  return (
    <div>
        <Link to='/create'>Add new author</Link>
        <AuthorList authors={authors} deleteAther={deleteAther}/>
        </div>
  )
}

export default Main