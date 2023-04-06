package app;

import java.util.ArrayList;

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
public class Page2 implements Handler {

    // URL of this page relative to http://localhost:7000/
    public static final String URL = "/page2.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Header information
        html = html + "<head>" + "<title>Homelessness By Area</title>";

        //Link to the java script file.
        html = html + "<script type = 'text/javascript' src=\"resources/javascript/tableFilter.js\"></script>";

        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";
        html = html + "<script src='data.js'> </script>";

        html = html + "</head>";


        
        // Add the body
        html = html + "<body>";

        // Add HTML for the logo.png image
        html = html + "<h1> Homelessness in Australia </h1>";

        //Navigation bar list
        html = html + "<ul class = \"navBar\">";
        html = html + "<li> <a href='/'>Landing Page</a> </li>";
        html = html + "<li> <a href='page1.html'>Big Picture Page</a> </li>";
        html = html + "<li> <a href='page2.html'class='active-page'>Homelessness By Area</a> </li>";
        html = html + "<li> <a href='atrisk.html'>People At Risk</a> </li>";
        html = html + "<li> <a href='deepdive.html'>Deep dive</a> </li>";
        html = html + "</ul>";

        // drop down box
        html = html + "<form class = 'dropDown' method = 'post'>";
        html = html+ "<input type='text' id='myInput' onkeyup='myFunction()' placeholder='Search for City (Melbourne,Sydney)..''> &nbsp";        
        html = html + "<label for = '2016_2018' class ='text'> Select category :&nbsp</label>";
        html = html + "<select class = 'drop' onchange = 'display(this.value)'>";
        html = html + "<option value = 'table1'> Gender 2016 </option>";
        html = html + "<option value = 'table2'> Gender 2018 </option>";
        html = html + "<option value = 'table3'> Age 2016 </option>";
        html = html + "<option value = 'table4'> Age 2018 </option>";
        html = html + "</select>";

    
        html = html + "</form>";

        JDBCConnection jdbc = new JDBCConnection();


        //gender homeless 2016
        ArrayList<HomeData> tableData1 = jdbc.getHomeless2016();
        html = html + "<div class='table-wrapper'>";
        
        html = html + "<table class='allTables' id='table1'>";
        html = html + "<th> LGA </th>";
        html = html + "<th> Females </th>";
        html = html + "<th> Males </th>";
        html = html + "<th> Total </th>";
        
        for (HomeData fems : tableData1) {
            html = html + "<tr>";
            html = html + "<td>" + fems.lga + "</td>";
            html = html + "<td>" + fems.homeless_f + "</td>";
            html = html + "<td>" + fems.homeless_m + "</td>";
            html = html + "<td>" + fems.homeless_total + "</td>";
            html = html + "</tr>";
        }
        
        html = html + "</table>";

        //gender homeless 2018
        ArrayList<HomeData> tableData2 = jdbc.getHomeless2018();
        html = html + "<div class='table-wrapper'>";
        
        html = html + "<table class='allTables' id='table2'>";
        html = html + "<th> LGA </th>";
        html = html + "<th> Females </th>";
        html = html + "<th> Males </th>";
        html = html + "<th> Total </th>";
        
        for (HomeData fems : tableData2) {
            html = html + "<tr>";
            html = html + "<td>" + fems.lga + "</td>";
            html = html + "<td>" + fems.homeless_f + "</td>";
            html = html + "<td>" + fems.homeless_m + "</td>";
            html = html + "<td>" + fems.homeless_total + "</td>";
            html = html + "</tr>";
        }
        
        html = html + "</table>";





        //age homeless 2016
        ArrayList<HomeData> tableData3 = jdbc.getage2016();
        html = html + "<div class='table-wrapper'>";
        
        html = html + "<table class='allTables' id='table3'>";
        html = html + "<th> LGA </th>";
        html = html + "<th> Under 10 </th>";
        html = html + "<th> Under 20 </th>";
        html = html + "<th> Under 30 </th>";
        html = html + "<th> Under 40 </th>";
        html = html + "<th> Under 50 </th>";
        html = html + "<th> Over 60 </th>";
        
        for (HomeData fems : tableData3) {
            html = html + "<tr>";
            html = html + "<td>" + fems.lga + "</td>";
            html = html + "<td>" + fems.age1 + "</td>";
            html = html + "<td>" + fems.age2 + "</td>";
            html = html + "<td>" + fems.age3 + "</td>";
            html = html + "<td>" + fems.age4 + "</td>";
            html = html + "<td>" + fems.age5 + "</td>";
            html = html + "<td>" + fems.age6 + "</td>";
            html = html + "</tr>";
        }
        
        html = html + "</table>";

        //age 2018 homeless
        ArrayList<HomeData> tableData4 = jdbc.getage2018();


        html = html + "<table class='allTables' id='table4'>";
        html = html + "<th> LGA </th>";
        html = html + "<th> Under 10 </th>";
        html = html + "<th> Under 20 </th>";
        html = html + "<th> Under 30 </th>";
        html = html + "<th> Under 40 </th>";
        html = html + "<th> Under 50 </th>";
        html = html + "<th> Over 60 </th>";

        for (HomeData fems : tableData4) {
            html = html + "<tr>";
            html = html + "<td>" + fems.lga + "</td>";
            html = html + "<td>" + fems.age1 + "</td>";
            html = html + "<td>" + fems.age2 + "</td>";
            html = html + "<td>" + fems.age3 + "</td>";
            html = html + "<td>" + fems.age4 + "</td>";
            html = html + "<td>" + fems.age5 + "</td>";
            html = html + "<td>" + fems.age6 + "</td>";
            html = html + "</tr>";
        }

        html = html + "</table>";

        html = html + "</section>";





        // Add HTML for link back to the homepage
        html = html + "<p>Return to Homepage: ";
        html = html + "<a href='/'>Link to Homepage</a>";
        html = html + "</p>";

        // Finish the HTML webpage
        html = html + "</body>" + "</html>";


        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

}
