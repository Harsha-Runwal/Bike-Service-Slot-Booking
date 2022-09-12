import axios from 'axios';
import React, {useState} from 'react'
import { useLocation, useNavigate } from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css'

export default function ServiceCenter(props) {

  const navigate = useNavigate();
  const location = useLocation();
 
  


  return (
    <div>
      <h5> {location.state.name} </h5>
      
  </div>
  )
}
