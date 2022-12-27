import React, { useState } from  'react';
    
    
const UserForm = (props) => {
   const [firstName, setFirstName] = useState("");
   const [lastName, setLastName] = useState("");
   const [email, setEmail] = useState("");
   const [password, setPassword] = useState("");
   const [confirm, setConfirm] = useState("");  
   const [hasBeenSubmitted, setHasBeenSubmitted] = useState(false);
  

    
    const createUser = (e) => {
        e.preventDefault();
        const newUser = { firstName,lastName, email, password };
        console.log("login", newUser);
    };


const MessageFirstName = (e) => {

    if(e.target.value.length < 2) {
        setHasBeenSubmitted(true);
        
    
    }else{
        setHasBeenSubmitted(false);
        setFirstName(e.target.value)
    } }   
    // 
    const MessageLastName = (e) => {

        if(e.target.value.length < 2) {
            setHasBeenSubmitted(true);
            
        
        }else{
            setHasBeenSubmitted(false);
            setLastName(e.target.value)
        } }  
        // 
        const MessageEmail = (e) => {

            if(e.target.value.length < 2) {
                setHasBeenSubmitted(true);
                
            
            }else{
                setHasBeenSubmitted(false);
                setEmail(e.target.value)
            } }   
    
    
    return(
        <form onSubmit={ createUser }>
    
            <div>
                <label>First name: </label> 
                <input type="text" onChange={(e)=>MessageFirstName(e)}/>
                   <div>{hasBeenSubmitted? <p>The name should more than 2</p> : <p></p> }</div>
            </div>
<div>
                <label>Last Name: </label> 
                <input  onChange={ (e) => MessageLastName(e) } />
<div>{hasBeenSubmitted? <p>The name should more than 2</p> : <p></p> }</div>
            </div>
            <div>
                <label>Email Address: </label> 
                <input type="email" onChange={ (e) => MessageEmail(e) } />
                <div>{hasBeenSubmitted? <p>IT should test@gmail.com</p> : <p></p> }</div>

            </div>
            <div>
                <label>Password: </label>
                <input type="password" onChange={ (e) => setPassword(e.target.value) } />
                </div>
                 <div> <label>Conforim Password: </label>
                <input type="password" onChange={ (e) => setConfirm(e.target.value) } /> 
            </div>
                <input type="submit" value="Create User" />
               
        </form>
    );
};
    
export default UserForm;
