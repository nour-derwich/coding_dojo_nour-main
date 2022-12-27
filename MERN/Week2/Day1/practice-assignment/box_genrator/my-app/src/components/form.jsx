import React,{ useState }from 'react'



function Form(props) {
    const [color, setColor] = useState("");
    const [Height, setHeight] = useState("");
    const [width, setWidth] = useState("");
    const handleSubmit = (e) => {
        e.preventDefault();
        props.newbox(color,Height,width);
    };


    
  return (
    <form onSubmit={handleSubmit}>
     Color <input type="text" onChange={(e)=>setColor(e.target.value)}/>
     Height <input type="text" onChange={(e)=>setHeight(e.target.value)}/>
     Width <input type="text" onChange={(e)=>setWidth(e.target.value)}/>
        <button type='submit'>ADD</button>
        <div className='box'>
        </div>
    </form>
  )
}

export default Form