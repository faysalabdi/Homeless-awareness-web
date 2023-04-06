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
public class Page1 implements Handler {

    // URL of this page relative to http://localhost:7000/
    public static final String URL = "/page1.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Header information
        html = html + "<head>" + 
               "<title>Homelessness In Australia</title>";

        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />" +
                    "</head>";

        // Add the body
        html = html + "<body>";

        // Add HTML for the image
        html = html + "<h1> Homelessness in Australia </h1>";

        //Navigation bar list
        html = html + "<ul class = \"navBar\">";
        html = html + "<li> <a href='/'>Landing Page</a> </li>";
        html = html + "<li> <a href='page1.html'class='active-page'>Big Picture Page</a> </li>";
        html = html + "<li> <a href='page2.html'>Homelessness By Area</a> </li>";
        html = html + "<li> <a href='atrisk.html'>People At Risk</a> </li>";
        html = html + "<li> <a href='deepdive.html'>Deep dive</a> </li>";
        html = html + "</ul>";


        //add main image
        html = html + "<img class = \"mainimage\" src = 'homeless-big-picture-page.jpg'>";

        html = html + "<div class = \"generalInformation\">";
        html = html + "<h2>What is Homelessness?</h2>";
        html = html + "<p>Homelessness refers to the people in our society who are unfortunately without any home and are forced to live on the streets. Approximately one third of homeless people in Australia are under 18 years old. Thousands of people go homeless ever year and a big portion of those people are either women, elderly or still children.</p>";
        html = html + "<h2>Causes of Homelessness?</h2>";
        html = html + "<p>There are many different causes of homelessness and they are often very situational or unlucky. The main causes of homelessness are poverty, unemployment, domestic violence and many more.";
        html = html + "Homelessness, is most often caused by other human rights being abused in a way that is unfavourable for people who are at risk of homelessness. </p>";
        html = html + "</div>";                


        // Finish the HTML webpage
        html = html + "</body>" + "</html>";


        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

}
