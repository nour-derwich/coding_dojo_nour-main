import React from 'react'
import {useEffect, useState} from 'react'
import axios from 'axios';
import {useParams} from 'react-router-dom';


const ViewOne =(props)=>{
  const [isLoading, setIsLoading] = useState(true);
    const [oneAuthor,setOneAuthor]=useState({});
    const {id}=useParams();
    const[bookData,setBookData]=useState({title:'',num_page:0});
    const [refresh, setRefresh] = useState(false);
    useEffect(()=>{
        axios.get('http://localhost:8000/api/authors/'+id)
        .then(res=>{
          setOneAuthor(res.data);
          setIsLoading(false);
        })
        .catch(err=>console.log(err))
    },[id,refresh]);
    const changeHandler =e=>{
      setBookData({
        ...bookData,
        [e.target.name]: e.target.value,
      });
    };
    const submitHandler=e=>{
      e.preventDefault();
      axios
        .put(`http://localhost:8000/api/authors/books/${id}`, bookData)
        .then((res) => {
          setRefresh(!refresh);
        })
        .catch((err) => {
          console.log(err);
        });
    };
    if (isLoading) {
      return <h2>Loading...</h2>;
    }

  return (
    <div>
     
     <div>nome :{oneAuthor.name}<br/>
           
           <p>created at:{oneAuthor.createdAt}</p>
           <h2>books</h2>
      
          {oneAuthor.books.map((book) =>{
            return( <div key={book?._id}>
              <h4>book name: {book?.title}</h4>
              <h4>num page: {book?.num_page}</h4>

            </div>);
           })}
          <form onSubmit={submitHandler}>
        <div>
          <label htmlFor="">Title</label>
          <input
            type="text"
            name="title"
            onChange={changeHandler}
            value={bookData.title}
          />
        </div>
        <div>
          <label htmlFor="">Number Of Pages</label>
          <input
            type="number"
            name="num_page"
            onChange={changeHandler}
            value={bookData.num_page}
          />
        </div>
        <input type="submit" value="Add" />
      </form>

        </div> 
        
    </div>
  )
}
;
export default ViewOne