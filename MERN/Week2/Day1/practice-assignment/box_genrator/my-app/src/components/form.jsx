import react, { useState } from 'react';
    
    
const Form = (props) => {
    const [color, setColor] = useState("");
const handleSubmit = (e) => {
                e.preventDefault();
                props.setBox([...props.box,color]);
    
    const handleSubmit = (e) => {
        e.preventDefault();
        props.setBox([...props.box,height]);
   const [height, setHeight] = useState("");
    
    const handleSubmit = (e) => {
        e.preventDefault();
        props.setBox([...props.box,width]);
    const [width, setWidth] = useState("");
}};
    
    return (
        <form onSubmit={ handleSubmit }>
            <label htmlFor="">color</label>
<input   onChange={ (e) => setColor(e.target.value)}  value={ color } />
  <label htmlFor="">height</label>
<input   onChange={ (e) => setHeight(e.target.value)}  value={ height } />
  <label htmlFor="">width</label>
<input   onChange={ (e) => setWidth(e.target.value)}  value={ width } />

<input type="submit" value="Add" />
        </form>
    );
}};
    
export default Form;
