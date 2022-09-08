import React from "react";
import bike from './images/bikeWashing.jfif';
import { Link, Outlet } from "react-router-dom"



function HomePage()
{
    return(<div>
        <head>
            <meta charset="utf-8"/>
            <meta name="viewport" content="width=device-width, initial-scale=1"/>
            <title>Bike-servicing-slot-Booking</title>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"/>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>

        </head>
        
        <body style={{backgroundColor:"black"}}>
        
        <nav className="navbar navbar-expand-sm bg-light justify-content-center">
            <h1><strong>Bike servicing slot Booking</strong></h1>
        </nav>

        <img style={{width: "1500px", height:"300px"}} src={bike} alt="this is bike image"/>
        
  <div className="btn-group">
  <Link to="/"><button type="button" className="btn btn-primary">Home</button></Link>
  <Link to="/aboutus"><button type="button" className="btn btn-primary">About Us</button></Link>
  <Link to="/login"><button type="button" className="btn btn-primary">Login</button></Link>
  <Link to="/registration"><button type="button" className="btn btn-primary">Register New User</button></Link>
  <Link to="/review"><button type="button" className="btn btn-primary">Reviews/Feedback</button></Link>
  </div>
  </body>
  <div class="mt-4 p-5 bg-primary text-white rounded"> 
                  <div className="item">
                  <Outlet>
                  
                    </Outlet>  {/* the component will be rendered here*/}
                  </div>
                  </div>

                  
    
  <div class="mt-4 p-5 bg-primary text-white rounded">
  <h3>The Benefits Of Bike Servicing and Maintenance</h3>
  <p>Bike servicing– why is it necessary

  Regular checkups should be done on your bike to ensure that it runs smoothly, 
  lasts a long time, and is safe. The extreme winter circumstances can have a significant
  impact on a bike’s performance, affecting both moving and static components.
  Grime can be forced into bearings, chains, and brake pads on the road due to the increasingly
  damp conditions of the winter mixed with the continual gritting of the roadways. The muddy, 
  sludgy conditions that the trails can turn to make maintenance of your bike a high priority
  for dedicated mountain bikers riding through the winter if you want it to keep riding like new. 
  The most key reason to have your bike repaired is safety: the more kept and serviced your bike is,
   the less likely it is to develop a technical problem, and the safer your ride will be.
 </p>
</div> 
    
    
    
 
    
    </div>)
}
export default HomePage







