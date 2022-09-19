import React, { useState } from 'react'
import { useLocation, useNavigate } from "react-router-dom";
import Logout from './authenticate/Logout'
import 'bootstrap/dist/css/bootstrap.min.css'
import JwtDecode from 'jwt-decode'
import Axios from 'axios';
import { Link, Outlet } from "react-router-dom"




export default function Admin() {
  const navigate = useNavigate();
  const location = useLocation();
  const [getPage,setGetPage]=useState(false);

  function getRegPage(e){
        setGetPage(true);
  }


  return (
    <div>Admin

<div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <button class="btn btn-danger" type="button" onClick={Logout}>Logout</button>
        </div>
      {/*<div class="card" style={{ width :`100px`}}>
      <img class="card-img-top" src={require("../images/img_avatar-png-2.png")} alt="Card image"/>
       <div class="card-body">
     <h6 class="card-title">HI, {location.state.name}</h6>
       </div>
      </div>*/}
<div class="card mb-3" style={{width:`350px`,height:`100px`}}>
  <div class="row no-gutters">
    <div class="col-md-4">
      <img src={require("../images/img_avatar-png-2.png")} class="card-img" alt="..."/>
    </div>
    <div class="col-md-8">
      <div class="card-body">
        <h5 class="card-title">HI, {location.state.name}</h5>
      </div>
    </div>
  </div>
</div>

<div class="d-grid gap-2 col-6 mx-auto">
  <button type="button" class="btn btn-info" value="reg" onClick={getRegPage}>Add Service Centers</button>
</div>


{getPage && <ServiceCenterRegistration></ServiceCenterRegistration>}



    </div>
  )
}




export function ServiceCenterRegistration() {

 
  
  const [onGettingRegister, setOnGettingRegister] = useState(false);
  let [onSucess, setOnSucess]=useState('');
  
 
  

  const [serviceCenterDetails, setServiceCenterDetails] = useState({
    role:'ADMIN',
    pincode:'',
    password:'',
    name:'',
    city:'',
    address:'',
    email:'',
    contactNo:'',
    capacity:'',
    regNo:'',
    id:''});

    
  let handleChange = (e) => {
    
    let name = e.target.name;
    let value = e.target.value;
    serviceCenterDetails[name] = value;
    setServiceCenterDetails(serviceCenterDetails);
    
  }

  let handleSubmit = (e)=>{
    e.preventDefault();
  
    console.log(serviceCenterDetails);
    Axios.post('http://localhost:8080/center/register',serviceCenterDetails).then((response)=>{console.log(response)
                                                                  setOnGettingRegister(true)
                                                                setOnSucess('Registration Successful!!')}).catch((error)=>{console.log(error)})
  }







  return(
<div>


<div>
    <div class="card">
        <div class="row g-0">
            <div class="col-md-6">
                <div class="h-100 d-flex justify-content-center align-items-center">
                    <div class="py-4 px-3">
                        <h4>Signup</h4>
                      <form onSubmit={handleSubmit}>
                        <div class="row g-2 mt-1">
                        <div class="col-md-4">
                           <label for="name" class="form-label">ServiceCenter Name:</label>
                           <input type="text" class="form-control" id="name" placeholder="Enter Service Center Name" name="name" onChange={handleChange} required/>
                           <div class="valid-feedback">Valid.</div>
                           <div class="invalid-feedback">Please fill field.</div>
                        </div>
                        <div class="col-md-4">
                          <label for="address" class="form-label">Address:</label>
                          <input type="text" class="form-control" id="address" placeholder="Enter address" name="address" onChange={handleChange} required/>
                          <div class="valid-feedback">Valid.</div>
                          <div class="invalid-feedback">Please fill field.</div>
                       </div>
                       <div class="col-md-4">
                          <label for="city" class="form-label">City:</label>
                          <input type="text" class="form-control" id="city" placeholder="Enter city" name="city" onChange={handleChange} required/>
                          <div class="valid-feedback">Valid.</div>
                          <div class="invalid-feedback">Please fill field.</div>
                       </div>
                       <div class="col-md-4">
                          <label for="pincode" class="form-label">Pin code:</label>
                          <input type="number" class="form-control" id="pincode" placeholder="Enter pincode" name="pincode" onChange={handleChange} required/>
                          <div class="valid-feedback">Valid.</div>
                          <div class="invalid-feedback">Please fill field.</div>
                       </div>
                       <div class="col-md-4">
                          <label for="regNo" class="form-label">Registration No.:</label>
                          <input type="number" class="form-control" id="regNo" placeholder="Enter regNo" name="regNo" onChange={handleChange} required/>
                          <div class="valid-feedback">Valid.</div>
                          <div class="invalid-feedback">Please fill field.</div>
                       </div>
                       <div class="col-md-4">
                          <label for="capacity" class="form-label">Service Capacity:</label>
                          <input type="number" class="form-control" id="capacity" placeholder="Enter capacity" name="capacity" onChange={handleChange} required/>
                          <div class="valid-feedback">Valid.</div>
                          <div class="invalid-feedback">Please fill field.</div>
                       </div>
                       <div class="col-md-4">
                          <label for="contactNo" class="form-label">Mobile No:</label>
                          <input type="number" class="form-control" id="contactNo" placeholder="Enter contactNo" name="contactNo" onChange={handleChange} required/>
                          <div class="valid-feedback">Valid.</div>
                          <div class="invalid-feedback">Please fill field.</div>
                       </div>
                       <div class="col-md-4">
                          <label for="email" class="form-label">Email:</label>
                          <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" onChange={handleChange} required/>
                          <div class="valid-feedback">Valid.</div>
                          <div class="invalid-feedback">Please fill field.</div>
                       </div>
                       <div class="col-md-4">
                          <label for="password" class="form-label">Password:</label>
                          <input type="password" class="form-control" id="password" placeholder="Enter password" name="password" onChange={handleChange} required/>
                          <div class="valid-feedback">Valid.</div>
                          <div class="invalid-feedback">Please fill field.</div>
                       </div>
                       </div>
                    
                        <div class="row mt-2">
                            <div class="col-md-12"> <button class="btn btn-primary w-100 signup-button" type="submit">Signup</button>
                           
                            </div>
                        </div>
                        
                  </form>
                  <h5>{onSucess}</h5>

                  {onGettingRegister && <a><Link to="/Login" >Click here to Login</Link></a>}     
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="right-side-content">
                    <div class="content d-flex flex-column">
                        <h6>Explore Bike Service Slot Booking Application</h6>
                        <span>Book your slot today!!</span>
                    </div>
                    <div class="right-side"> <span></span> <span></span> <span></span> <span></span>
                        <span><img src="https://i.imgur.com/kWmyZvb.jpg"/> </span> <span></span> <span></span>
                        <span></span> <span> <img src="https://i.imgur.com/U0863iD.jpg"/> </span> <span></span> </div>
                </div>
            </div>
        </div>
    </div>
    <div class="parallelogram"> <span></span> <span></span> <span></span> </div>
</div>



</div>


  )
}