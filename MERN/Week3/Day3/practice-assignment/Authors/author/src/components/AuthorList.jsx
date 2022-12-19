import React from 'react'
import {Link} from 'react-router-dom'
const AuthorList=({authors ,deleteAther}) =>{
    // (props)=>props.authors
    // const {authors}=props
  return (
    <div>
        <table>
            <thead>
                <tr>
                    <th>name</th>
                    <th>action</th>
                </tr>
            </thead>
            <tbody>
                {authors.map(author =>{
                    return <tr key={author._id}>
                              <td>{author.name}</td>
                              <td>
                                <Link to={`/update/${author._id}`}>Update</Link> | <Link to={`/authors/${author._id}`}>Delaits</Link>
                                | <button onClick={()=>deleteAther(author._id)}>Delete</button>
                              </td>
                    </tr>
                })}
            </tbody>
        </table>
    </div>
  )
}

export default AuthorList