import React from 'react'
import  './Boxes.module.css'

function Display(props) {
  return (
    <div className='box' >
       {
        props.boxs.map((box,idx)=>{
            return <div key={idx} style={{height:box.Height,width:box.width,backgroundColor:box.color}}></div>
        })
       } 
       
    </div>
  )
}

export default Display