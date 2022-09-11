import axios from "axios"
export function LoginValidate(user)
{

   return  axios.post('http://localhost:8080/authenticateUser',{"username":user.username,"password":user.password,"role":user.role})
}


export function LoginValidateCenter(user)
{

   return  axios.post('http://localhost:8080//authenticatecenter',{"username":user.username,"password":user.password,"role":user.role})
}