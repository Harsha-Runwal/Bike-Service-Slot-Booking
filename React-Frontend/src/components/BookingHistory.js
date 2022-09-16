import React,{ useState } from 'react';
import { useLocation, useNavigate } from "react-router-dom";
import Axios from 'axios';
import Logout from './authenticate/Logout';

export default function bookingHistory()
{
    let [ServiceCenter, setServiceCenter] = useState({startdate: '',enddate: '',email: ''});

    let handleChange = (e) => {
      
      let name = e.target.name;
      let value = e.target.value;
      ServiceCenter[name] = value;
      setServiceCenter(ServiceCenter);
      
    }
  
    let handleSubmit = (e)=>{
          e.preventDefault();
          const Center={...ServiceCenter};
          console.log(Center.startdate);
          console.log(typeof(Center.email));
      Axios.get(`http://localhost:8080/booking/bookingHistory/${Center.startdate}/${Center.enddate}/${Center.email}`)
      .then((response)=>{
        console.log("got data..!");
        
        console.log("got data from server=",response.data)})
      .catch((error)=>{console.log(error)})

    }



    return(
        <div>
            <h3>See the Bookings History</h3>
             {/**<h5> Welcome {location.state.name} </h5>  */}  
            
            
    <div>
<form  class="was-validated" onSubmit={handleSubmit}>
  <div class="col-md-4">
    <label for="startDate" class="form-label">Enter Start Date :</label>
    <input type="Date" class="form-control" id="startdate" placeholder="From Date" name="startdate" onChange={handleChange} required/>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
  </div>

  <div class="col-md-4">
    <label for="endDate" class="form-label">Enter End Date :</label>
    <input type="Date" class="form-control" id="enddate" placeholder="To Date" name="enddate" onChange={handleChange} required/>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
  </div>
  
  
  <div class="col-md-4">
    <label for="email" class="form-label">Username:</label>
    <input type="email" class="form-control" id="email" placeholder="Enter Email" name="email" onChange={handleChange} required/>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
  </div>
  
  
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
    </div>







            {/**Logout button to destroy jwt token and navigate to home page*/}
            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <button class="btn btn-danger" type="button" onClick={Logout}>Logout</button>
        </div>
        </div>
    );
    }