import React from 'react'
import { Link } from 'react-router-dom'
import Header from './header'


const Login = () => {
  return (
    <div>
      <Header />
      <div className='login template d-flex justify-content-center align-items-center 100-w vh-100 bg-primary'>
        <div className='form_container bg-white p-5 rounded'>
          <form>
            <h3>Login</h3>
            <div className='mb-2'>
              <label htmlFor="email">Email</label>
              <input type="email" placeholder='username' className='form-control'/>

            </div>
            <div className='mb-2'>
              <label htmlFor="password">Password</label>
              <input type="password" placeholder='password' className='form-control' />
            </div>
            <div className='mb-2'>

              <input type="checkbox" className='custom-control custom-checkbox' id='check'/>
              <label htmlFor="password">Remember me</label>
            </div>
            <div className="d-grid">
              <button className="btn btn-primary">Login</button>

            </div>
            <p className='text-right mt-2'>
              click on  <Link to="/  ">Password?</Link>
              <span>& </span>
              <Link to="/page">About us</Link>
            </p>
          </form>
        </div>

      </div>
    </div>
  )
}

export default Login