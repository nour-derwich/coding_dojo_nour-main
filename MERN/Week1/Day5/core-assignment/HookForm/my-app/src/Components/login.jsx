import React, { useState } from  'react';
    
    
const UserForm = (props) => {
    const [firstName, setFirstName] = useState("");
const [lastName, setLastName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");  
    
    const createUser = (e) => {
        e.preventDefault();
        const newUser = { firstName,lastName, email, password };
        console.log("login", newUser);
    };
    
    return(
        <form onSubmit={ createUser }>
            <div>
                <label>Firdt name: </label> 
                <input onChange={ (e) => setFirstName(e.target.value) } />
            </div>
<div>
                <label>Last Name: </label> 
                <input  onChange={ (e) => setLastName(e.target.value) } />
            </div>
            <div>
                <label>Email Address: </label> 
                <input type="email" onChange={ (e) => setEmail(e.target.value) } />
            </div>
            <div>
                <label>Password: </label>
                <input type="password" onChange={ (e) => setPassword(e.target.value) } /> </div>
                 <div> <label>Conforim Password: </label>
                <input type="password" onChange={ (e) => setPassword(e.target.value) } /> </div>
                <input type="submit" value="Create User" />
                <p>First Name :{firstName}</p>
                <p>last name :{lastName}</p>
                <p>Eamil:{email}</p>
                <p>password:{password}</p>
                <p>confrim password:{password}</p>
           
            
        </form>
    );
};
    
export default UserForm;
