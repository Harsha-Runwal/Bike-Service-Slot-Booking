import React from "react";
import { useState } from "react";
import {useNavigate} from 'react-router-dom';

export default function Login()
{
  let [loginDetails, setLoginDetails] = useState({username: '',password: '',gridRadios: ''});
  const navigate = useNavigate();

  let handleChange = (e) => {
    
    let name = e.target.name;
    let value = e.target.value;
    loginDetails[name] = value;
    setLoginDetails(loginDetails);
    
  }

 let handleSubmit = (e) => 
 {
    e.preventDefault();
    console.log(loginDetails);
    //Axios.post('http://localhost:8080/customer/validate',{custDetails}).then((response)=>{console.log(response)}).catch((error)=>{console.log(error)})
    
    if(e.target.gridRadios.value==="option1")
      navigate('/Customer',{ state: { id: 1, name: "sabaoon" } });
    else if(e.target.gridRadios.value==="option2")
      navigate('/ServiceCenter');
    else
      navigate('/Admin');
  }
  
  return (<div>

<form onSubmit={handleSubmit}>

  <div class="row mb-3">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
    <div class="col-sm-10">
      <input type="email" class="form-control" id="inputEmail3" name='username' onChange={handleChange}/>
    </div>
  </div>

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
        <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios1" value="option1" onChange={handleChange}/>
        <label class="form-check-label" for="gridRadios1">
          Customer
        </label>
      </div>
      <div class="form-check">
        <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios2" value="option2" onChange={handleChange}/>
        <label class="form-check-label" for="gridRadios2">
          Service Provider
        </label>
      </div>
      <div class="form-check">
        <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios3" value="option3" onChange={handleChange}/>
        <label class="form-check-label" for="gridRadios3">
          Admin
        </label>
      </div>
    </div>
  </fieldset>
  
  <button type="submit" class="btn btn-primary">Sign in</button>
</form>


    
  </div>);
}












