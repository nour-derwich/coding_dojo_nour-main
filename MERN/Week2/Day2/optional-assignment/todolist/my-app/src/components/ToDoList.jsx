import React ,{ useState }from 'react'
import { useEffect } from 'react'
import uuid from 'react-uuid'

const ToDoList = () => {
    const [refresh,setRefresh]=useState(false);
    const [input,setInput]=useState('');
    const [tasks,setTasks]=useState(JSON.parse(localStorage.getItem('todoList'))||[]);
    // get inout value
    const onChangeHandler=e =>{
        setInput(e.target.value);
    }
    // add task
    const onsubmitHandler= e =>{
      e.preventDefault();
      if(input){ setTasks([...tasks, {task: input,id:uuid(),isCompleted:false}]);
      setInput('')}
      
      setRefresh(!refresh);
      

    }
    // delete task
    const DeleteTask =id =>{
   const filtredTasks=tasks.filter(task=> task.id!==id );
   setTasks(filtredTasks);
    }
    // add db in local
    useEffect(() => {
      localStorage.setItem('todoList',JSON.stringify(tasks));


    }, [tasks])

  return (
    <main className='main'>To Do List
    <div className='form'>
        <form onSubmit={onsubmitHandler}>
            <label></label>
            <input name='input' onChange={onChangeHandler} value={input} />
            <input type="submit" value="Add" />
        </form>
    </div>
    <div className="tasks">
    {tasks.map((el) => {
                    return <div className='task' key={el.id}>
                      <p style={el.isCompleted?{textDecoration:'line-through'}:{}}>{el.task}</p>
                      <input checked={el.isCompleted} type="checkbox" onChange={e =>{
                      setTasks((prevTasks)=>{
                        const newTasks= prevTasks.map(prevTask => prevTask.task===el.task?{...el,isCompleted:!prevTask.isCompleted}:prevTask)
                         return newTasks
                      })
                    }} />
                    <button onClick={() =>DeleteTask(el.id)}>delete</button></div>
                })}
    </div>
    </main>
  )
}

export default ToDoList