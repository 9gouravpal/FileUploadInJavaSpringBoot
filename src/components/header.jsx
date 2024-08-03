import React from 'react';
import { Link } from 'react-router-dom';

function Header() {
  return (
    <nav className="navbar navbar-expand-lg navbar-dark" style={{backgroundColor:'#85EA2D'}}>
      <div className="container-fluid">
        <a className="navbar-brand text-dark" href="#">Gourav Pal</a>
        <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarNav">
          <ul className="navbar-nav ms-auto">
            <li className="nav-item">
              <a className="nav-link text-dark" href="#about"> <Link to="/page " style={{color:'black'}}>About</Link> </a>
            </li>
            <li className="nav-item">
              <a className="nav-link text-dark" href="#contact"> <Link to="/" style={{color:'black'}}>Register</Link></a>
            </li>
            <li className="nav-item">
              <a className="nav-link text-dark" href="#contact"> <Link to="/login" style={{color:'black'}}>Login</Link></a>
            </li>
            <li className="nav-item">
              <a className="nav-link text-dark" href="#contact"> <Link to="/resume" style={{color:'black'}}>Resume</Link></a>
            </li>
            <li className="nav-item">
              <a className="nav-link text-dark" href="#contact"> <Link to="/create" style={{color:'black'}}>Create resume</Link></a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
}

export default Header;
