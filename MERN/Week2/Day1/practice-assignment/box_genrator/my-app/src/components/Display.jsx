import React from 'react'
import styles from './Boxes.module.css';
const Display = (props) => {
    return (
        <div>
           <h1>Test</h1>
                {props.box.map((b, idx) => {
                    return <div key={idx} style={{backgroundColor:b, height:100, width:100} }></div>
                })

            }
        </div>
    )
}

export default Display