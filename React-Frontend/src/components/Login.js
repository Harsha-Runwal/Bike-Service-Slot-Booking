import React from 'react'
import { useState } from "react";
import {useNavigate} from 'react-router-dom';
import { LoginValidate } from './authenticate/LoginValidation';
import { LoginValidateCenter } from './authenticate/LoginValidation';
import { LoginValidateAdmin } from './authenticate/LoginValidation';
import Home from './Home';
import JwtDecode from 'jwt-decode'
import Customer from './Customer';
//import Customer from './Customer';
import '../CSS/r.css'



export default function Login() {
  const navigate = useNavigate();
  let [loginDetails, setLoginDetails] = useState({username: '',password: '',role: ''});
  let [validationStatus, setValidationStatus]= useState(false);
  let[afterLoginStatus,setAfterLoginStatus]=useState(false);
  let [loggedInUserDetails,setLoggedInUserDetails]=useState();
  

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
        //setAfterLoginStatus(true);
      //window.location="/Home"
      
      navigate("/Customer", {
        state: {
            name: user,
            }
          })
      
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
        
        let jwt=promise.data.token;
        
        localStorage.setItem("token",jwt);
        let decodedToken=JwtDecode(jwt);   // decoding the token
        const user=decodedToken.sub; 
        
      

      navigate("/ServiceCenter", {
        state: {
            name: user
            }
          })
    }catch (error) {
    
      if(error.response.status===401)
      {
        setValidationStatus(true);
        console.log(error.response.status)
      }
}}
     
    else if(e.target.gridRadios.value==="admin")
    {
      console.log("admin")
      try {

       const promise=await LoginValidateAdmin(loginDetails);
        console.log(promise)
        let jwt=promise.data.token;
        
        localStorage.setItem("token",jwt);
        let decodedToken=JwtDecode(jwt);   // decoding the token
        const user=decodedToken.sub; 
        console.log(user);console.log(decodedToken)
      

      navigate("/admin", {
        state: {
            name: user
            }
          })
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
{/*afterLoginStatus && <Home user={loggedInUserDetails}></Home>*/}

                                   {/*} <h4 class="text-center mt-4 mb-4" >Login</h4>
                                    <form onSubmit={handleSubmit}>
                                        <div class="form-row">
                                            <div class="form-group col-md-4">
                                                <label for="inputName">Username</label>
    
                                                <input type="email" class="form-control" id="inputEmail3" name='username' onChange={handleChange}/>
                                            </div>
                                            <div class="form-group col-md-4">
                                                <label for="inputName">Password</label>
                                                <input type="password" class="form-control" id="inputPassword3" name='password' onChange={handleChange}/>
                                            </div>
                                            <div class="form-group form-row mt-2">
                                            <label class="col-md-2 col-form-label user_group">I am a</label>
                                            <div class="col-md-10 pt-1">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios1" value="customer" onChange={handleChange}/>
                                                    <label class="form-check-label" for="inlineRadio1">Customer</label>
                                                </div>
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios2" value="center" onChange={handleChange}/>
                                                    <label class="form-check-label" for="inlineRadio2">Service Center</label>
                                                </div>
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios3" value="admin" onChange={handleChange}/>
                                                    <label class="form-check-label" for="inlineRadio2">Admin</label>
                                                </div>
                                            </div><br></br>
                                        </div>
                                            <div class="form-group col-md-12">
                                                <div class="d-flex flex-wrap justify-content-between align-items-center">
                                                    <div class="custom-checkbox d-block">
                                                        <label class="custom-control custom-checkbox checkbox-lg">
                                                            <input type="checkbox" class="custom-control-input" id="customCheck1"/>
                                                            <div class="custom-control-label" for="customCheck1">Remember Password</div>
                                                        </label>
                                                    </div>
                                                    <a href="#" target="_blank">Forgot Password?</a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="mt-2 mb-3">
                                            <button class="btn btn-primary full-width" type="submit">Login</button>
                                        </div>
  </form>*/}
                                    
                                
                              
<div >
    <div class="card">
        <div class="row g-0">
            <div class="col-md-6">
                <div class="h-100 d-flex justify-content-center align-items-center">
                    <div class="py-4 px-3">
                        <h4>Signin</h4>
                        <form onSubmit={handleSubmit}>
                        <div class="row mt-2">
                            <div class="col-md-8">
                            <div class="form-group col-md-4">
                                                <label for="inputName">Username</label></div>
    
                                                <input type="email" class="form-control" id="inputEmail3" name='username' onChange={handleChange}/>
                                            </div>
                        </div>
                        <div class="row mt-2 mb-2">
                            <div class="col-md-8">
                            <div class="form-group col-md-4">
                                                <label for="inputName">Password</label></div>
                                                <input type="password" class="form-control" id="inputPassword3" name='password' onChange={handleChange}/>
                                            </div>
                        
                        </div> <span class=""></span><br></br>
                        <label class="col-md-2 col-form-label user_group">I am a</label><br></br>
                                            <div class="col-md-10 pt-1">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios1" value="customer" onChange={handleChange}/>
                                                    <label class="form-check-label" for="inlineRadio1">Customer</label>
                                                </div>
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios2" value="center" onChange={handleChange}/>
                                                    <label class="form-check-label" for="inlineRadio2">Service Center</label>
                                                </div>
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios3" value="admin" onChange={handleChange}/>
                                                    <label class="form-check-label" for="inlineRadio2">Admin</label>
                                                </div>
                                            </div><br></br>
                        <div class="row mt-2">
                            <div class="col-md-8"> <button class="btn btn-primary w-100 signup-button" type="submit" >Signin</button>
                            </div>
                        </div>
                        <div class="member mt-1"> <span>Already a member?</span> <a class="text-decoration-none"
                                href="#">Signin</a> </div>
                      </form>
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




    
  </div>)
}
