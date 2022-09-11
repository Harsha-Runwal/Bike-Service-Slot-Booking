import React  from "react";
import { Navigate } from "react-router-dom";


export default function Logout()
{

       // let token =localStorage.getItem("token");
        //console.log("before removing"+token);
        localStorage.removeItem("token")
        //console.log("after removing"+token);
     window.location="/"
           
}