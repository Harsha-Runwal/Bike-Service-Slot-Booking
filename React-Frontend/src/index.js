import React from "react";
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';
import { BrowserRouter,Route, Routes } from "react-router-dom";
import AboutUs from "./MyComponents/AboutUs"
import HomePage from "./HomePage";
import Login from "./MyComponents/Login";
import Reviews from "./MyComponents/Reviews";
import Customer from "./MyComponents/Customer";
import ServiceCenter from "./MyComponents/ServiceCenter";
import Admin from "./MyComponents/Admin";
import Registration from "./MyComponents/Registration";

export default function AppForRoutes()
{
  return(
    
    <BrowserRouter>
        <Routes>

            <Route path="/" element={<HomePage></HomePage>}>
            <Route path="home" element={<HomePage></HomePage>}></Route>
            <Route path="aboutus" element={<AboutUs></AboutUs>}></Route>
            <Route path="login" element={<Login></Login>}></Route>
            <Route path="registration" element={<Registration></Registration>}></Route>
            <Route path="review" element={<Reviews></Reviews>}></Route>
            <Route path="Customer" element={<Customer></Customer>} />
            <Route path="ServiceCenter" element={<ServiceCenter></ServiceCenter>} />
            <Route path="Admin" element={<Admin></Admin>} />
            
            
            
            </Route>
        </Routes>
    </BrowserRouter>

  );
}
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <AppForRoutes />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();



























