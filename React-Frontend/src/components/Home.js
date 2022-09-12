import React from 'react'
import { Link, Outlet } from "react-router-dom"
import 'bootstrap/dist/css/bootstrap.min.css'


export default function Home() {
  
  
  

  return (
    <div>
<img src={require("../images/BikeServiceShop.jpg")} height="20%" width="20%" alt="..."></img>
{/*<nav class="navbar navbar-expand-lg navbar-light bg-light" >
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
      <li class="nav-item">
          <a class="nav-link" href="#"><Link to="/HomePage" >Home</Link></a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#"><Link to="/Registration"  >Registration</Link></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"><Link to="/Login" >Login</Link></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"><Link to="/AboutUs" >About Us</Link></a>
        </li>
        
      </ul>
    </div>
</nav>*/}

<div className="container">

    <header className="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
      <ul className="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
        <li><a href="#" className="nav-link px-2 link-secondary"><Link to="/HomePage" >Home</Link></a></li>
        <li><a href="#" className="nav-link px-2 link-dark"><Link to="/AboutUs" >About Us</Link></a></li>
        
      </ul>

      <div className="col-md-3 text-end">
        <button type="button" className="btn btn-outline-primary me-2"><Link to="/Login" >Login</Link></button>
        <button type="button" className="btn btn-outline-primary me-2"><Link to="/Registration">Sign-up</Link></button>
      </div>
    </header>
  </div>

      
                  <div className="item">
                  <Outlet>
                  
                    </Outlet>  {/* the component will be rendered here*/}
                  </div>

                
    </div>
  )
}
