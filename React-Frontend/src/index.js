import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter,Route, Routes } from "react-router-dom"
import './index.css';
//import App from './App';
import reportWebVitals from './reportWebVitals';
import 'bootstrap/dist/css/bootstrap.min.css'
import Login from './components/Login';
import Registration from './components/Registration';
import Home from './components/Home';
import Customer from './components/Customer';
import ServiceCenter from './components/ServiceCenter';
import Admin from './components/Admin';
import AboutUs from './components/AboutUs';
import HomePage from './components/HomePage';

export default function AppForRoutes(){
 
  return(
  < BrowserRouter >
          <Routes>  
            
            <Route path="/" element={<Home></Home>} >
                <Route path="HomePage" element={<HomePage></HomePage>} />
                <Route path="Login" element={<Login></Login>} />
                <Route path="Registration" element={<Registration></Registration>} />
                <Route path="AboutUs" element={<AboutUs></AboutUs>} />
                <Route path="Customer" element={<Customer></Customer>} />
                <Route path="ServiceCenter" element={<ServiceCenter></ServiceCenter>} />
                <Route path="Admin" element={<Admin></Admin>} />
            </Route> 
          </Routes>     
    </ BrowserRouter >
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
