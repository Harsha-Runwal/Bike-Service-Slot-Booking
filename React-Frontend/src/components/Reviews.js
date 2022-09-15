import React from "react";

export default function Reviews()
{
    return(
        <div>
        <head>
            <meta charset="utf-8"/>
            <meta name="viewport" content="width=device-width, initial-scale=1"/>
            
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"/>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>

        </head>

        <label for="comment">Add a Comment:</label>
            <textarea class="form-control" rows="5" id="comment" name="text"></textarea>
            <button type="submit" class="btn btn-primary">Submit</button>

        </div>



    );
}


