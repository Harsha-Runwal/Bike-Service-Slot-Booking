
import React from 'react'
import { useState } from "react";
import {useNavigate} from 'react-router-dom';
import { LoginValidate } from './authenticate/LoginValidation';
import { LoginValidateCenter } from './authenticate/LoginValidation';
import Home from './Home';
import JwtDecode from 'jwt-decode'
//import Customer from './Customer';


export default function Login() {
  
  let [loginDetails, setLoginDetails] = useState({username: '',password: '',role: ''});
  let [validationStatus, setValidationStatus]= useState(false);
  let[afterLoginStatus,setAfterLoginStatus]=useState(false);
  let [loggedInUserDetails,setLoggedInUserDetails]=useState();
  const navigate = useNavigate();

  let handleChange = (e) => {
    
    let name = e.target.name;
    let value = e.target.value;
    loginDetails[name] = value;
    setLoginDetails(loginDetails);
    
  }

 let handleSubmit = async (e) => 
 {
    e.preventDefault();
    console.log(loginDetails);
  
    if(e.target.gridRadios.value==="customer")
    {
       
    console.log("custmer");
      try {

        const promise=await LoginValidate(loginDetails);
       // storing token in browser localStorage
        console.log(promise)
        let jwt=promise.data.token;     // getting token 
        localStorage.setItem("token",jwt);
        console.log(promise.request.status)
         let decodedToken=JwtDecode(jwt);   // decoding the token
         const user=decodedToken.sub;      // decoded token object has property sub which will give email of logged in use
         console.log(" testing on console token");
         console.log("logged in user email"+ user);
         setLoggedInUserDetails(user)

      

        // from here write logic so show logged in user email and other link on navbar
        // same way for center decode the token and show on navbar
        setAfterLoginStatus(true);
      //window.location="/Home"
      //navigate("/Home")
  } catch (error) {

      console.log(error);
    
          if(error.response.status===401)
          {
            setValidationStatus(true);
            console.log("error"+error.response.status)
          }
  }
}
     
    else if(e.target.gridRadios.value==="center")
    {
      console.log("center")
      try {

        const promise=await LoginValidateCenter(loginDetails);
        console.log(promise)
        let jwt=promise.data.token;
        
        localStorage.setItem("token",jwt);
        let decodedToken=JwtDecode(jwt);   // decoding the token
        const user=decodedToken.sub; 
      //window.location="/HomePage"
  } catch (error) {
    
          if(error.response.status===401)
          {
            setValidationStatus(true);
            console.log(error.response.status)
          }
  }
    }
  
  }
  
  return (<div>

<form onSubmit={handleSubmit}>

  <div class="row mb-3">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
    <div class="col-sm-10">
      <input type="email" class="form-control" id="inputEmail3" name='username' onChange={handleChange}/>
    </div>
  </div>
  { validationStatus && <div className="alert alert-danger" role="alert">
       Invalid Email or password
</div>  }

  <div class="row mb-3">
    <label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="inputPassword3" name='password' onChange={handleChange}/>
    </div>
  </div>

  <fieldset class="row mb-3">
    <legend class="col-form-label col-sm-2 pt-0">Role</legend>
    <div class="col-sm-10">
      <div class="form-check">
        <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios1" value="customer" onChange={handleChange}/>
        <label class="form-check-label" for="gridRadios1">
          Customer
        </label>
      </div>
      <div class="form-check">
        <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios2" value="center" onChange={handleChange}/>
        <label class="form-check-label" for="gridRadios2">
          Service Provider
        </label>
      </div>
      <div class="form-check">
        <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios3" value="admin" onChange={handleChange}/>
        <label class="form-check-label" for="gridRadios3">
          Admin
        </label>
      </div>
    </div>
  </fieldset>
  
  <button type="submit" class="btn btn-primary">Sign in</button>
</form>

{/*afterLoginStatus && <Home user={loggedInUserDetails}></Home>*/}
    
  </div>)
}
