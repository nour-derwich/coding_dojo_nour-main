import { useParams } from "react-router"; //Top of App.js
//Rest of imports here...
    
const Number = (props) => { 
  const { id } = useParams(); // matches our :city in our Routes
   
  return (
    <div>{isNaN (+id)?"the word is :"+id:"the number is:"+id }</div>
  )
}

export default Number