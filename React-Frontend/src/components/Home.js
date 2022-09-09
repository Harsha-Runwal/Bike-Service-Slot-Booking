import React from 'react'
import { Link, Outlet } from "react-router-dom"
import 'bootstrap/dist/css/bootstrap.min.css'


export default function Home() {
  
  
  

  return (
    <div>
      {/*<div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src={require("../images/bssb.jpg")} class="d-block w-100" alt="..."></img>
    </div>
    <div class="carousel-item">
      <img src={require("../images/BikeServiceShop.jpg")} class="d-block w-100" alt="..."></img>
    </div>
    <div class="carousel-item">
      <img src={require("../OIP.jpg")} class="d-block w-100" alt="..."></img>
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>*/}
<img src={require("../images/BikeServiceShop.jpg")} height="20%" width="20%" alt="..."></img>
<nav class="navbar navbar-expand-lg navbar-light bg-light" >
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
</nav>

      
                  <div className="item">
                  <Outlet>
                  
                    </Outlet>  {/* the component will be rendered here*/}
                  </div>

                
    </div>
  )
}
