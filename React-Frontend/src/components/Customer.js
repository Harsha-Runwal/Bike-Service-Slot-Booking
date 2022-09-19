import React, {useState,useEffect} from 'react'
import { useLocation, useNavigate } from "react-router-dom";
import Logout from './authenticate/Logout'
import 'bootstrap/dist/css/bootstrap.min.css'
import JwtDecode from 'jwt-decode'
import axios from 'axios';
//mport '../CSS/signupbutton.css'



export default function Customer() {
 
      const navigate = useNavigate();
      const location = useLocation();
      const [cities,setCities]=useState([]);
      const [serviceCenters,setServiceCenters]=useState([]);
      const [city, setCity] = useState("");
      const [serviceCenter, setServiceCenter] = useState("");
      const [serviceCenterDetails, setServiceCenterDetails] = useState({
        name:'',
        city:'',
        address:'',
        email:'',
        contactNo:'',
        capacity:'',
        regNo:'',
        id:''});
      const [onGettingServiceCenterDetails, setOnGettingServiceCenterDetails] = useState(false);
      const [customerName, setcustomerName] = useState("xyz");
      const [token, setToken] = useState(localStorage.getItem("token"));
      axios.defaults.headers.common["Authorization"] = "Bearer" + token;

     useEffect(() => { 
          axios.get("http://localhost:8080/center/getCities").then((response) => {
          setCities(response.data);
        }).catch((error) => {console.log(error);});}, []);
          
      
      
        function getServiceCenters(event){
        console.log(event.target.value);
        axios.get(`http://localhost:8080/center/getCenterByCity/${event.target.value}`).then((response)=>{console.log(response.data)
                                                         setServiceCenters(response.data.map(city=>{return city})); 
                                                        console.log(response.data.map(e => {
                                                          return (e.name);
                                                        }))}).catch((error)=>{console.log(error)})
      }

      function getServiceCenterDetails(e){
        console.log("hiiiiii")
        console.log(e.target.value);
        setOnGettingServiceCenterDetails(true);
        axios.get(`http://localhost:8080/center/getCenterByName/${e.target.value}`).then((response)=>{console.log(response.data)
        setServiceCenterDetails(response.data);
        setOnGettingServiceCenterDetails(true);
       }).catch((error)=>{console.log(error)})
      }

      function get(e){
        console.log(serviceCenterDetails)
      }
    

  return (
    <div>
      {/**get customer name from jwt token */}
    
        {/**Logout button to destroy jwt token and navigate to home page*/}
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

  {/*<div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <button class="btn btn-danger" type="button" onClick={get}>Logout</button>
  </div>*/}

      <br></br>

<table class="table">
  <thead>
    <tr>
      <th scope="col"></th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">Select Your City:</th>
      <td><select class="select" placeholder="Example placeholder" onChange={getServiceCenters}>
        <option>select city</option>
      {
        cities.map(city => {
          return (<option value={city}>{city}</option>);
        })
      }
      </select></td>
    </tr>
    <tr>
      <th scope="row">Select ServiceCenter:</th>
      <td><select class="select" placeholder="Example placeholder" onChange={getServiceCenterDetails}>
      <option>select center</option>
      {
      serviceCenters.map(center => {
          return <option value={center}>{center}</option>;
        })
      }
      </select></td>
    </tr>
  </tbody>
    </table>

  







      {/**Dropdown for CITY 
      <label>Select Your City:</label>
      <select class="select" placeholder="Example placeholder" onChange={getServiceCenters}>
      {
        cities.map(city => {
          return (<option value={city}>{city}</option>);
        })
      }
      </select>

     <br></br>
      {/**Dropdown for SERVICE PROVIDER 
      <label>Select ServiceCenter:</label>
      <select class="select" placeholder="Example placeholder" onChange={getServiceCenterDetails}>
      <option>select Center</option>
      {
        
      serviceCenters.map(center => {
          return <option value={center}>{center}</option>;
        })
      }
      </select>*/}
  
      {/**Conditional rendering on getting service center details */}    
      {onGettingServiceCenterDetails && <ServiceCenterrr details={serviceCenterDetails}></ServiceCenterrr>}
  </div>
  )
}



export function ServiceCenterrr(props) {

  const [plan,setPlan]=useState([]);
  const [onGettingServiceCenterPlan, setOnGettingServiceCenterPlan] = useState(false);
  

  function getServicePlan(e){
    console.log(e.target.value);
    axios.get(`http://localhost:8080/plan/getPlans/${e.target.value}`).then((response)=>{console.log(response)
                                                              setPlan(response.data)
                                                              setOnGettingServiceCenterPlan(true)}).catch((error)=>{console.log(error)})
  }

  return (
    <div>
     <h3>ServiceCenter Details</h3> 
     
     <table class="table table-success table-striped">
  <thead>
    <tr>
    <th scope="row">Service Center:</th>
      <th scope="col">{props.details.name}</th>
      
    </tr>
  </thead>
  <tbody>
    <tr>
    <th scope="row">Address:</th>
      <td>{props.details.address}</td>
     
    </tr>
    <tr>
    <th scope="row">City:</th>
      <td>{props.details.city}</td>
    </tr>
   {/* <tr>
    <th scope="row">Contact No.:</th> 
      <td>{props.details.contactNo}</td>
    </tr>*/}
    <tr>
    <th scope="row">Email:</th> 
      <td>{props.details.email}</td>
    </tr>
   {/* <tr>
    <th scope="row">Servicing Capacity/Day:</th> 
      <td>{props.details.capacity}</td>
  </tr>*/}
    <tr>
    <th scope="row">Reg NO:</th> 
      <td>{props.details.regNo}</td>
    </tr>
    
  </tbody>
</table>

<div class="d-grid gap-2 col-6 mx-auto">
  <button type="button" class="btn btn-info" value={props.details.regNo} onClick={getServicePlan}>Show Service Plans</button>
</div>
        
{onGettingServiceCenterPlan && <ServicePlan planDetails={plan} regId={props.details.regNo}></ServicePlan>}
  </div>)
}




export function ServicePlan(props){

  const [afterGettingPlan,setAfterGettingPlan]=useState(false);
  const [selectedPlan,setSelectedPlan]=useState('');
  const [centerRegId,setCenterRegId]=useState('');
  const [planArr,setPlanArr]=useState(props.planDetails);

  const [planObj,setPlanObj]=useState({});

  function handlePlan(e){
        console.log(e.target.value);
        console.log(props.regId);
        setSelectedPlan(e.target.value);
        setCenterRegId(props.regId);
        setAfterGettingPlan(true)
        console.log(planArr)
        setPlanObj(planArr.find(obj => obj.name === e.target.value))
  }

  const tableRows=props.planDetails.map((element)=>{
    return( 
      <tr>
        <td>
         <button value={element.name} onClick={handlePlan}>{element.name}</button>
        </td>
        <td>{element.description}</td>
        <td>{element.cost}</td>
      <td>
      </td>
    </tr>)
  
  })

return(
  <div>
      <h3>Plan Details</h3>
  <h6>select plan:</h6>
  <table class="table table-dark table-striped">
            <thead>
              <tr>    
                <th> Name</th>
                <th>Desc</th>
                <th>cost</th>
                <th></th>
              </tr>
            </thead>
            <tbody>
              {tableRows}
            </tbody>
</table> 


  
      
     


  {afterGettingPlan && <VehicleDetails _planObj={planObj} _selectedPlan={selectedPlan} _regId={centerRegId} _cost={props.ServicePlan}></VehicleDetails>}

    </div>
  )

}




export function VehicleDetails(props){

  const [servicedate,setServiceDate]=useState('');
  const [availableSlots,setAvailableSlots]=useState('')
  const [token, setToken] = useState(localStorage.getItem("token"));
  axios.defaults.headers.common["Authorization"] = token;
  let decodedToken=JwtDecode( axios.defaults.headers.common["Authorization"]);   // decoding the token
  const user=decodedToken.sub;

  const [obj,setObj]=useState({
    vehicleRegNo:"GJ1234",
    modelNo:"Hero224",
    status:false,
    totalCost:props._planObj.cost,
    planName:props._selectedPlan,
    customer:{"email":user},
    serviceCenterref:{"regNo":props._regId},
    bookingDate:"2022/09/13"
  });

  const [isSlot,setIsSlot]=useState(false);
  const [isNoSlot,setIsNoSlot]=useState('');

  {/**getting slots on selected Date */}
  const dropdownChangeHandler = (event) => {
    setServiceDate(event.target.value);
    let name = event.target.name;
    let value = event.target.value;
    obj[name] = value;
    setObj(obj);
    console.log(event.target.value);
    axios.get(`http://localhost:8080/slotmanagement/getSlots/${props._regId}/${event.target.value}`).then((response)=>{console.log(response.data)
                                                                             setAvailableSlots(response.data) 
                                                                            if(response.data>0)
                                                                            {
                                                                                setIsSlot(true);
                                                                            }else{
                                                                              setIsNoSlot("sorry No slot available,check for another date")
                                                                            }
                                                                          }).catch((error)=>{console.log(error)})
  
  }; 

  let handleChange = (e) => {
    
    let name = e.target.name;
    let value = e.target.value;
    obj[name] = value;
    setObj(obj);
    
  }



  return(
    <div>

      <h6>your selected plan is {props._selectedPlan}</h6>
      {/*{props._regId}*/}
    <table class="table table-striped">
  <thead>
    <tr>
      <th scope="col"></th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">Select Date</th>
      <td><input type="date" name="bookingDate" onBlur={dropdownChangeHandler}/></td>
    </tr>
    <tr>
      <th scope="row">Available Slots</th>
      <td>{availableSlots}</td>
    </tr>
  </tbody>
</table>

{isNoSlot}
{isSlot && <VehicleInfo object={obj}></VehicleInfo>}
  
    </div>
  )
}




export function VehicleInfo(props){
  const navigate = useNavigate();

  const [obj,setObj]=useState(props.object);
  const [toInvoice,setToInvoice]=useState(false)
  let handleChange = (e) => {
    let name = e.target.name;
    let value = e.target.value;
    obj[name] = value;
    setObj(obj);
  }

  let h=(e)=>{
    console.log(obj);
    setToInvoice(true);
  }

  return(
    <div>

<h2>Enter Your Vehicle Details</h2>

<form  class="was-validated" >
<div class="col-md-4">
<label for="vehicleRegNo" class="form-label">Enter Vehicle Registration No.:</label>
<input type="text" class="form-control" id="vehicleRegNo" placeholder="Enter vehicleRegNo" name="vehicleRegNo" onChange={handleChange} required/>
<div class="valid-feedback">Valid.</div>
<div class="invalid-feedback">Please fill out this field.</div>
</div>
<div class="col-md-4">
<label for="modelNo" class="form-label">Enter model No:</label>
<input type="text" class="form-control" id="lastName" placeholder="Enter modelNo" name="modelNo" onChange={handleChange} required/>
<div class="valid-feedback">Valid.</div>
<div class="invalid-feedback">Please fill out this field.</div>
</div>
</form>

<button onClick={h}>Click here to book your slot</button>

{toInvoice && navigate("/EndGame", {
        state: {
           finalObj: obj
            }
          }) }
    </div>
  )
}
