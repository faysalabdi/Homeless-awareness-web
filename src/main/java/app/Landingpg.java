package app;


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
public class Landingpg implements Handler {

    // URL of this page relative to http://localhost:7000/
    public static final String URL = "/";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";
        html = html + "<head>";

        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='landing.css' />";


        //Navigation bar list

                html = html + "<ul class = 'navBar'>";
                html = html + "<li> <a href='/'><b> (LOGO) </b> </a> </li>";
                html = html + "<li> <a href='page1.html'>Big Picture Page</a> </li>";
                html = html + "<li> <a href='page2.html'>Homelessness By Area</a> </li>";
                html = html + "<li> <a href='atrisk.html'>People At Risk</a> </li>";
                html = html + "<li> <a href='deepdive.html'>Deep dive</a> </li>";
                html = html + "<li> <a href='/'>Contact us! (links) </a> </li>";
                html = html + "</ul>";
        

        html = html + "</ul>";
        html = html + "</div>";
  

        // Add some Header information
        html = html + "<header id='showcase'>";
        html = html + "<h1 class ='swag'>On average, over 157,000 people are at risk of being homeless. Every year. </h1>";
        html = html + "<p>They need YOUR help.</p>";
        html = html + "<br>";
        html = html + "<a href='donation.html' class='button'>Donate now</a>";
        html = html + "</header>";

        
        html = html + "</head>";
        // Add the body
        html = html + "<body>";

        html = html + "<section id='a'> <p></p> </section>";
        html = html + "<hr>";
        html = html + " <section id='b'> <p>Australia has a serious housing crisis. Here are the facts. </p> </section>";
        html = html + "<hr>";
        html = html + "<section id='c'>";
        html = html + "<div class='box-1'> <b>20%</b> <br> Of Australians at risk are under 30 years old </div>";
        html = html + " <div class='box-2'> <b>7%</b> <br> Of females in NSW are at risk of homelessness </div>";
        html = html + "<div class='box-3'> <b>2%</b> <br> Increase in homelessness since 2016  </div>";

        html = html + "</section>";

        html = html + "</section>";

        html = html + "<section id='section-b'>";
        html = html + "<p></p>";
        html = html + " </section>";


        html = html + "</section>";
        html = html + "<hr>";
        html = html + "<section id='section-c'>";
        html = html + "<p>Want to see the bigger picture? <a href='page1.html' <strong> CLICK HERE! <strong> </a> </p>";
        html = html + " </section>";
        html = html + "<hr>";

        
        // Finish the HTML webpage
        html = html + "</body>" + "</html>";


        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

}
