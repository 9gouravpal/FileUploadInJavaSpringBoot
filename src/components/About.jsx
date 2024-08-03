import React from "react";
    import { Link } from "react-router-dom";
    import Header from "./header";

const Page=()=>{

return(
<div>
    <Header/>
    <div className="container mt-5">
      <div className="row justify-content-center">
        <div className="col-md-8">
          <div className="card">
            <div className="card-header bg-primary text-white">
              <h2 style={{textAlign:'center'}}>About me</h2>
            </div>
            <div className="card-body">
              <h4>Gourav Pal</h4>
                <p>gouravp386@gmail.com</p>
                <p>Phone No: 7668214973   </p>
                <p>GitHub Link: <a href="https://github.com/9gouravpal">click-here</a> </p>
                <p>LinkedIn: <a href="https://www.linkedin.com/in/gourav-pal-391a6a235/">click-here</a></p>
                <h5>Education</h5>
                <p> BCA in Computer Science and Engineering from Mathama Joytiba Phule Rohelkhand University ,Bariely Uttar Pradesh. </p>
              <p>Skills:</p>
              <ul>
                <li>Core Java </li>
                <li>J2EE</li>
                <li>JDBC</li>
                <li>Spring boot</li>
                <li>React JS</li>
                <li>HTML</li>
                <li>CSS</li>
                <li>Bootstrap</li>

              </ul>
              <p><Link to="/  " style={{color:'black'}}>Back</Link></p>
            </div>
          </div>
        </div>
      </div>
    </div>
    {/* <Link to="/about">About</Link> */}
    
</div>

)

}
export default  Page