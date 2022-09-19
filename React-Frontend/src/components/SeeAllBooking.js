import React, { useState } from 'react';
import { useLocation, useNavigate } from "react-router-dom";
import Axios from 'axios';
import Logout from './authenticate/Logout';


export default function SeeAllBooking()
{
  const location = useLocation();

   
    let [arr,setarr] = useState(location.state.name)     //got array of objects containing booking objects

      
      const all_list = arr.map((e)=>{ return(
       <tr> <td>{e.bookingDate}</td>
        <td>{e.bookingId}</td>
        <td>{e.modelNo}</td>
        <td>{e.planName}</td>
        <td>{e.totalCost}</td>
        <td>{e.vehicleRegNo}</td></tr>)
      }) 
     
    return(
        <div>
           
            <h3>All Bookings for Today</h3>
<div>
              
  <table class="table table-hover">
    <thead>
      <tr>
        <th>Booking Date </th>
        <th>Booking Id </th>
        <th>Model No </th>
        <th>Plan Name </th>
        <th>Total cost </th>
        <th>vehicle Reg No </th>
      </tr>
    </thead>
    <tbody>
      
       {all_list}
      
       
    </tbody>
  </table>
</div>

            
        
        </div>
    );
}