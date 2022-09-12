import React, { useState } from 'react'
import { Link, Outlet } from "react-router-dom"
import { useLocation, useNavigate } from "react-router-dom";
import Logout from './authenticate/Logout'
import 'bootstrap/dist/css/bootstrap.min.css'

import axios from 'axios';
import ServiceCenter from './ServiceCenter'

export default function Customer() {
  const navigate = useNavigate();
  const location = useLocation();
      const [cities,setCities]=useState(["pune","mumbai"]);
      const [serviceCenters,setServiceCenters]=useState(["SaiServices","OmServices"]);
      const [city, setCity] = useState("");
      const [serviceCenter, setServiceCenter] = useState("");
      const [serviceCenterDetails, setServiceCenterDetails] = useState('[]');
      const [onGettingServiceCenterDetails, setOnGettingServiceCenterDetails] = useState(false);
      //const cities=["Pune","Mumbai","Delhi","Nagpur"]
      const [customerName, setcustomerName] = useState("xyz");
     {/*useEffect(() => {
        console.log(props.history.location.state.property_id);
        setcustomerName(props.history.location.state.property_id)  
        axios.get("http://localhost:8080/ServiceProvider/getCity")
        .then((response) => {
          setCities(response.data);
        })
        .catch((error) => {
          console.log(error);
        });
      }, []);    */}
      
    

      function getServiceCenters(e){
        console.log(e.target.value);
       
        axios.get(`http://localhost:8080/ServiceProvider/${e.target.value}`).then((response)=>{console.log(response)
                                                          setServiceCenters(response.data.name)}).catch((error)=>{console.log(error)})
      }

      function getServiceCenterDetails(e){
        console.log(e.target.value);
        setOnGettingServiceCenterDetails(true);
        axios.get(`http://localhost:8080/ServiceProvider/${e.target.value}`).then((response)=>{console.log(response)
        setServiceCenterDetails(response.data);
        setOnGettingServiceCenterDetails(true);
       }).catch((error)=>{console.log(error)})
      }
    

  return (
    <div>
      {/**get customer name from jwt token */}
      <h5> Welcome {location.state.name} </h5>

      {/**Logout button to destroy jwt token and navigate to home page*/}
        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <button class="btn btn-danger" type="button" onClick={Logout}>Logout</button>
        </div>
        
      <br></br>
      {/**Dropdown for CITY */}
      <label>Select Your City:</label>
      <select onChange={getServiceCenters}>
      {
        cities.map(city => {
          return (<option value={city}>{city}</option>);
        })
      }
      </select>

      <br></br>
      {/**Dropdown for SERVICE PROVIDER */}
      <label>Select ServiceCenter:</label>
      <select onChange={getServiceCenterDetails}>
      {
      serviceCenters.map(center => {
          return <option value={center}>{center}</option>;
        })
      }
      </select>
  
      {/**Conditional rendering on getting service center details */}    
      {onGettingServiceCenterDetails && <ServiceCenterrr details={serviceCenterDetails}></ServiceCenterrr>}



    </div>
  )
}


export function ServiceCenterrr(props) {
  const [center,setCenter]=useState([]);
  //setCenter(props.details);

  {/**getting slots on selected Date */}
  const dropdownChangeHandler = (event) => {
    const date=event.target.value;
    axios.get(`http://localhost:8080/center/${date}`).then((response)=>{console.log(response)}).catch((error)=>{console.log(error)})
  
  }; 


  return (
    <div>
      ServiceCenter Details
      {center.map((element,index) => { 
        return(
          <tr>
            <th scope="row">{index}</th> 
            {Object.keys(element).map((key)=>{ 
              return(
                <tr scope="row">{element[key]}</tr>
              )})
            }
           </tr>)
       })}

        <br></br>
        <label>Book Slot by Date</label>
        <input type="date" onChange={dropdownChangeHandler}></input>
  </div>
  )
}


