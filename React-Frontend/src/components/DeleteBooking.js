import React,{ useState } from 'react';
import { useLocation, useNavigate } from "react-router-dom";
import Axios from 'axios';
import Logout from './authenticate/Logout';

export default function DeleteBooking()
{
    let [ServiceCenter, setServiceCenter] = useState({bid: 0});

    let handleChange = (e) => {
      
      let name = e.target.name;
      let value = e.target.value;
      ServiceCenter[name] = value;
      setServiceCenter(ServiceCenter);
      
    }
  
    let handleSubmit = (e)=>{
          e.preventDefault();
          const Center={...ServiceCenter};
          console.log(Center.bid);
          console.log(typeof(Center.bid));
      Axios.delete(`http://localhost:8080/booking/deleteBooking/${Center.bid}`)
      .then((response)=>{
       
        console.log("got data from server=",response.data)})
      .catch((error)=>{console.log(error)})

    }



    return(
        <div>
            <h3> Delete a Booking </h3>
            {/**<h5> Welcome {location.state.name} </h5>  */}
            
    <div>
<form  class="was-validated" onSubmit={handleSubmit}>
  <div class="col-md-4">
    <label for="bid" class="form-label">Enter Booking Id :</label>
    <input type="Number" class="form-control" id="bid" placeholder="Booking Id" name="bid" onChange={handleChange} required/>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
  </div>

 
  
  <button type="submit" class="btn btn-primary">Delete</button>
</form>
    </div>







            {/**Logout button to destroy jwt token and navigate to home page*/}
            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <button class="btn btn-danger" type="button" onClick={Logout}>Logout</button>
        </div>
        </div>
    );
    }