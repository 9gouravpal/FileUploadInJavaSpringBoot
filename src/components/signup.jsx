import React from 'react'
import { Link } from 'react-router-dom'
import axios from 'axios'
import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import Header from './header'


const Signup = () => {
  const navigate = useNavigate()
  const [inputs,setinputs] =useState({
    
      "id": 0,
      "name": "",
      "email": "",
      "password": 0,
      "phoneNo": 0
    
  })

  const handlesignup = async(e) => {
    e.preventDefault();

    const response = await axios.post('http://localhost:8080/userDetail/save',inputs) 
    console.log(response.data)
    if(response.status === 200)
    { 
      alert("Signup Successfull")
      navigate('/page')
    }
    console.log("inputs",inputs)
  }
  return (
    <div>
        <Header/>
      
    <div className='login template d-flex justify-content-center align-items-center 100-w vh-100 bg-primary'>
      
    <div className='form_container bg-white p-5 rounded'>
    <form>
    <h3>Sign-Up</h3>
    <div className='mb-2'>
    <label htmlFor="name">Name</label>
    <input type="text" placeholder='name' className='form-control' onChange={(e) => setinputs({...inputs,name:e.target.value})} value={inputs.name} />
        
    </div>
    <div className='mb-2'>
    <label htmlFor="email">Email</label>
    <input type="email" placeholder='email' className='form-control' onChange={(e) => setinputs({...inputs,email:e.target.value})} value={inputs.email} />
        
    </div>
    <div className='mb-2'>
    <label htmlFor="email">Phone No.</label>
    <input type="phone" placeholder='+91 ' className='form-control' onChange={(e) => setinputs({...inputs,phoneNo:e.target.value})} value={inputs.phoneNo} />
        
    </div>
    
    <div className='mb-2'>
    <label htmlFor="password">Password</label>
        <input type="password" placeholder='Password' className='form-control' onChange={(e) => setinputs({...inputs,password:e.target.value})} value={inputs.password} />
    </div>
   
    <div className="d-grid">
    <button className="btn btn-primary" onClick={handlesignup}>Sign-Up</button>

    </div>
    <p className='text-right mt-2'>
    click on <Link to="/login">login </Link>
    <span>& </span>
     <Link to="/page">About us</Link>
    </p>
    </form>
    </div>

    </div>
    </div>
  )
  
}

export default Signup