import React from 'react';
import { useLocation, useNavigate } from "react-router-dom";
import Axios from 'axios';
import Logout from './authenticate/Logout';


export default function SeeAllBooking()
{
    return(
        <div>
            <h3>All Bookings for Today</h3>
             {/**<h5> Welcome {location.state.name} </h5>  */}








            {/**Logout button to destroy jwt token and navigate to home page*/}
            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <button class="btn btn-danger" type="button" onClick={Logout}>Logout</button>
        </div>
        </div>
    );
}