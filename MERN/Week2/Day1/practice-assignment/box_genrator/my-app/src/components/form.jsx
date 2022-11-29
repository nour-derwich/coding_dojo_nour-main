import react, { useState } from 'react';
    
    
const Form = (props) => {
    const [color, setColor] = useState("");
    
    const handleSubmit = (e) => {
        e.preventDefault();
        props.setBox([...props.box,color]);

      
    };
    
    return (
        <form onSubmit={ handleSubmit }>
            <label htmlFor="">color</label>
<input   onChange={ (e) => setColor(e.target.value)}  value={ color } />
<input type="submit" value="Add" />
        </form>
    );
};
    
export default Form;
