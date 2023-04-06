package app;

//import java.util.ArrayList;

import io.javalin.http.Context;
import io.javalin.http.Handler;

/**
 * Temporary HTML as an example page.
 * 
 * Based on the Project Workshop code examples.
 * This page currently:
 *  - Provides a link back to the index page
 *  - Displays the list of movies from the Movies Database using the JDBCConnection
 *
 * @author Timothy Wiley, 2021. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 */
public class level3page implements Handler {

    // URL of this page relative to http://localhost:7000/
    public static final String URL = "/deepdive.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
    
   String html = "<html>";
   
// Add some Header information
html = html + "<head>" + 
"<title>Homelessness In Australia</title>";

html = html + "<script type='text/javascript' src='https://www.gstatic.com/charts/loader.js'></script>";

html = html + "<script>";

html = html + "google.charts.load('current', {'packages':['corechart']});";
html = html + "google.charts.setOnLoadCallback(drawChart);";

html = html + "function drawChart() {";

html = html + "var data = google.visualization.arrayToDataTable([";
html = html + "['Demographoc', 'Percentage'],";
html = html + "['Females',     11000],";
html = html + "['Males',      10000],";
html = html + "['Under 20',  2000],";
html = html + "['Under 40', 2000],";
html = html + "['Over 60',    7000]";
html = html + "]);";

html = html + "var options = {";
html = html + "title: 'Australian Homeless data 2016'";
html = html + " };";

html = html + "var chart = new google.visualization.PieChart(document.getElementById('piechart'));";

html = html + "chart.draw(data, options);";
html = html + " }";

html = html + "</script>";

html = html + "</head>";

// Add some CSS (external file)
html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";
    

// Add the body
html = html + "<body>";

// Add HTML for the image
html = html + "<h1> Homelessness in Australia </h1>";

//Navigation bar list
html = html + "<ul class = \"navBar\">";
html = html + "<li> <a href='/'>Landing Page</a> </li>";
html = html + "<li> <a href='page1.html'>Big Picture Page</a> </li>";
html = html + "<li> <a href='page2.html'>Homelessness By Area</a> </li>";
html = html + "<li> <a href='atrisk.html'>People At Risk</a> </li>";
html = html + "<li> <a href='deepdive.html'class='active-page'>Deep dive</a> </li>";
html = html + "</ul>";



html = html + "<section id='section-c'>";
        html = html + "<p class='blogcard'> </p>";
        html = html + " </section>";

html = html + "<div style='position: relative; top: 500;' id='piechart''></div>";


   html = html + "</body>";
   html = html + "</html>";
  
   context.html(html);
}

}
