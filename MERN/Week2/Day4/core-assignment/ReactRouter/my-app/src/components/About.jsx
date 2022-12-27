import React from 'react'
import { useParams } from 'react-router-dom';
const About = (props) => {
    const {id} = useParams();
    const {col1 } = useParams();
    const {col2} = useParams();
  return (
    <div>
        <div style={{color:col1,backgroundColor:col2, border:'2px solid'}}>
    <h1>{isNaN (+id) ? "The word is : " +id : "The id is : "+id}</h1>
</div>
</div>
  )
}

export default About