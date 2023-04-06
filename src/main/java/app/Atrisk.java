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
public class Atrisk implements Handler {

    // URL of this page relative to http://localhost:7000/
    public static final String URL = "/atrisk.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";
         html = html + "<head>";

         // Add some CSS and javascript(external file)
        html = html + "<link rel='stylesheet' type='text/css' href='atrisk.css' />";
        html = html + "<script src='data.js'> </script>";

        html = html + "<h1> Australians AT RISK of homelessness</h1>";
        
        // Add nav
        html = html + "<ul class = 'navBar'>";
        html = html + "<li> <a href='/'>Landing Page</a> </li>";
        html = html + "<li> <a href='page1.html'>Big Picture Page</a> </li>";
        html = html + "<li> <a href='page2.html'>Homelessness By Area</a> </li>";
        html = html + "<li> <a href='atrisk.html'class='active-page'>People At Risk</a> </li>";
        html = html + "<li> <a href='deepdive.html'>Deep dive</a> </li>";
        html = html + "</ul>";

        html = html + "</head>";
        // Add the body
        html = html + "<body>";



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

       
// First we need to use your JDBCConnection class
JDBCConnection jdbc = new JDBCConnection();

ArrayList<HomeData> age2016 = jdbc.getage2016();
html = html + "<div class='table-wrapper'>";

html = html + "<table class='allTables' id='table3'>";
html = html + "<th> LGA </th>";
html = html + "<th> Under 10 </th>";
html = html + "<th> Under 20 </th>";
html = html + "<th> Under 30 </th>";
html = html + "<th> Under 40 </th>";
html = html + "<th> Under 50 </th>";
html = html + "<th> Over 60 </th>";

for (HomeData fems : age2016) {
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

html = html + "<tr>";
html = html + "</tr>";

html = html + "</table>";


ArrayList<HomeData> age2018 = jdbc.getage2018();


html = html + "<table class='allTables' id='table4'>";
html = html + "<th> LGA </th>";
html = html + "<th> Under 10 </th>";
html = html + "<th> Under 20 </th>";
html = html + "<th> Under 30 </th>";
html = html + "<th> Under 40 </th>";
html = html + "<th> Under 50 </th>";
html = html + "<th> Over 60 </th>";

for (HomeData fems : age2018) {
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

html = html + "<tr>";
html = html + "</tr>";

html = html + "</table>";

html = html + "</section>";


         ArrayList<HomeData> gender2016 = jdbc.getgender2016();


        html = html + "<table class='allTables' id ='table1'>";
        html = html + "<th> LGA </th>";
        html = html + "<th> Females at risk </th>";
        html = html + "<th> Males at risk </th>";

        for (HomeData fems : gender2016) {
            html = html + "<tr>";
            html = html + "<td>" + fems.lga + "</td>";
            html = html + "<td>" + fems.atrisk_f + "</td>";
            html = html + "<td>" + fems.atrisk_m + "</td>";
            html = html + "</tr>";
        }
        
        html = html + "<tr>";
        html = html + "</tr>";
        
        html = html + "</table>";


         ArrayList<HomeData> gender2018 = jdbc.getgender2018();

        html = html + "<table class='allTables' id ='table2'>";
        html = html + "<th> LGA </th>";
        html = html + "<th> Females at risk </th>";
        html = html + "<th> Males at risk </th>";

        for (HomeData fems : gender2018) {
            html = html + "<tr>";
            html = html + "<td>" + fems.lga + "</td>";
            html = html + "<td>" + fems.atrisk_f + "</td>";
            html = html + "<td>" + fems.atrisk_m + "</td>";
            html = html + "</tr>";
        }
        
        
        html = html + "</table>";
        html = html + "</div>";



html = html + "</section>";

// Finish the HTML webpage
html = html + "</body>" + "</html>";


        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }


    
/*for dropdown stuff*/

//      public String outputgender2016() {
//        String html = "";
    
//     // Look up movies from JDBC
//      JDBCConnection jdbc = new JDBCConnection();
//      ArrayList<HomeData> fem = jdbc.getgender2016();
    
//     // // Add HTML for the  list
    
//     html = html + "<div class='centre'>";
//      html = html + "<div class='table-wrapper'>";
//     html = html + "<table>";
//     html = html + "<th> LGA </th>";
//      html = html + "<th> females at risk </th>";
//      html = html + "<th> males at risk </th>";

//      for (HomeData fems : fem) {
//         html = html + "<tr>";
//         html = html + "<td>" + fems.lga + "</td>";
//         html = html + "<td>" + fems.atrisk_f + "</td>";
//         html = html + "<td>" + fems.atrisk_m + "</td>";
//         html = html + "</tr>";
//      }
    
//      html = html + "</table>";
//      html = html + "</div>";
//      html = html + "</div>";
    
//      return html;

//      // String age_gender_drop = context.formParam("age_gender_drop");
//         // if (age_gender_drop == "Gender") {
//         //     html = html + outputgender2016();
//         // }


// }

    }