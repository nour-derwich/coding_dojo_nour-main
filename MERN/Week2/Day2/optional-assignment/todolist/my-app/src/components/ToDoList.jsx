import React ,{ useState }from 'react'
import { useEffect } from 'react'

const ToDoList = () => {
    const [input,setInput]=useState('');
    const [tasks,setTasks]=useState([]);
    // get inout value
    const onChangeHandler=e =>{
        setInput(e.target.value);
    }

  return (
    <main className='main'>To Do List
    <div className='form'>
        <form>
            <label></label>
            <input name='input' onChange={onChangeHandler} value={input} />
            <input type="submit" value="Add" />
        </form>
    </div></main>
  )
}

export default ToDoList