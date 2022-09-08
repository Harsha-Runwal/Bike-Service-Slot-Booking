import React,{useState} from 'react'
import Axios from 'axios'

export default function Registration() {

  let [customerDetails, setCustomerDetails] = useState({fname: '',lname: '',mobno: '',emailid: '',password: ''});

  let handleChange = (e) => {
    
    let name = e.target.name;
    let value = e.target.value;
    customerDetails[name] = value;
    setCustomerDetails(customerDetails);
    
  }

  let handleSubmit = (e)=>{
    e.preventDefault();
    const custDetails={...customerDetails};
    console.log(custDetails);
    Axios.post('http://localhost:8080/customer/register',{custDetails}).then((response)=>{console.log(response)}).catch((error)=>{console.log(error)})
  }


  return (
    <div>
<form  class="was-validated" onSubmit={handleSubmit}>
  <div class="col-md-4">
    <label for="uname" class="form-label">First Name:</label>
    <input type="text" class="form-control" id="uname" placeholder="Enter Firstname" name="fname" onChange={handleChange} required/>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
  </div>
  <div class="col-md-4">
    <label for="uname" class="form-label">Last Name:</label>
    <input type="text" class="form-control" id="lname" placeholder="Enter Lastname" name="lname" onChange={handleChange} required/>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
  </div>
  <div class="col-md-4">
    <label for="uname" class="form-label">Mobile No:</label>
    <input type="number" class="form-control" id="mobno" placeholder="Enter Mobile No" name="mobno" onChange={handleChange} required/>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
  </div>
  <div class="col-md-4">
    <label for="uname" class="form-label">Username:</label>
    <input type="email" class="form-control" id="emailid" placeholder="Enter Email" name="emailid" onChange={handleChange} required/>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
  </div>
  <div class="col-md-4">
    <label for="pwd" class="form-label">Password:</label>
    <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password" onChange={handleChange} required/>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
  </div>
  <div class="form-check mb-3">
    <input class="form-check-input" type="checkbox" id="myCheck" name="remember" required/>
    <label class="form-check-label" for="myCheck">I agree.</label>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Check this checkbox to continue.</div>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
    </div>
  )
}
