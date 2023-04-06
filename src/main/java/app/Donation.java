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
public class Donation implements Handler {

    // URL of this page relative to http://localhost:7000/
    public static final String URL = "donation.html";

    @Override
    public void handle(Context context) throws Exception {
    

String html = "<html>";
html = html + "<div class=container'>";

html = html + "<div class='col-xs-12'>";
html = html + "<div class='panel panel-default'>";
html = html + "<div class='panel-heading'>";
html = html + " <h3 class='panel-title'>Donation Details</h3>";
html = html + "</div>";
html = html + "<div class='panel-body'>";
html = html + "<div class='col-sm-6'>";
html = html + "<div class='form-group'>";
html = html + "<label for='cardNumber'>Amount</label>";
html = html + " <div class='input-group'>";
html = html + "<input type='text'class='form-control' name='Amount' placeholder='$129.00' required autofocus />";
html = html + "<span class='input-group-addon'><i class='fa fa-usd'></i></span>";
html = html + " </div>";
html = html + "</div>";
html = html + "</div>";


html = html + "<div class='col-sm-6'>";
html = html + "<label for='donateTye'>Frequency</label>";
html = html + "<select name='donateType' id='donateType' class='form-control'>";

html = html + "<option value='once'>Once</option>";

html = html + "<option value='weekly'>Weekly</option>";
html = html + "<option value='Fortnightl'>Fortnightly</option>";
html = html + "<option value='Monthly'>Monthly</option>";

html = html + "  </select>";
html = html + "</div>";
html = html + "</div>";
html = html + "</div>";



html = html + " </div>";

html = html + "<div class='col-xs-12 col-md-6 col-md-offset-3'> <div class='panel panel-default'> <div class='panel-heading'> <h3 class='panel-title'>Payment Details</h3> </div>";
                
html = html + "<div class='panel-body'> <form role='form' id='payment-form'> <div class='row'> <div class='col-xs-12'>";
html = html + "<div class='form-group'> <label for='cardNumber'>CARD NUMBER</label> <div class='input-group'> <input type='text' class='form-control' name='cardNumber' placeholder='Valid Card Number' required autofocus data-stripe='number' /> <span class='input-group-addon'><i class='fa fa-credit-card'></i></span> </div> </div> </div> </div>";
html = html + "<div class='row'>";
html = html + "<div class='col-xs-7 col-md-7'>";
html = html + "<div class='form-group'>";
html = html + "<div class='row'>";
html = html + "<div class='col-sm-12'>";
html = html + "<label for='expMonth'>EXPIRATION DATE</label> </div> </div>";
html = html + "<div class=row'>";
html = html + "<div class='col-xs-6 col-lg-6 pl-ziro'>";
html = html + "<input type='text' class='form-control' name='expMonth' placeholder='MM' required data-stripe='exp_month'/>";
html = html + "</div>";
html = html + "<div class='col-xs-6 col-lg-6 pl-ziro'>";
html = html + "<input type='text' class='form-control' name='expYear' placeholder='YY' required data-stripe='exp_year' />";
html = html + "</div> </div> </div> </div>";
html = html + "<div class='col-xs-5 col-md-5 pull-right'>";
html = html + "<div class='form-group'>";
html = html + "<label for='cvCode'>CVC</label>";
html = html + "<input type='password' class='form-control' name='cvCode' placeholder='CV' required data-stripe='cvc' /> </div> </div> </div>";

html = html + " <div class='row'>";
html = html + " <div class='col-xs-12'>";
html = html + " <button class='btn btn-success btn-lg btn-block' type='submit'>Donate Now</button> </div> </div>";
html = html + "<div class='row' style='display:none;''>";
html = html + "<div class='col-xs-12'> </div> </div>";
html = html + " </form>";
html = html + "</div>";
html = html + " </div>";
html = html + "</div>";
html = html + "</div>";
html = html + "</div>";

html = html + "<html>";

context.html(html);

    }

}