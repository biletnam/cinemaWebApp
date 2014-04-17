package controllers;

//import com.moneysupermarket.cinema.Calculator;
import com.moneysupermarket.cinema.Calculator;
import com.moneysupermarket.cinema.Movie;
import com.moneysupermarket.cinema.PurchaseInformation;
import com.moneysupermarket.cinema.Rounder;
import models.BasketItem;
import models.Movies;
import models.Prices;
import play.*;
import play.data.*;
import play.mvc.*;

import views.html.*;

import java.math.BigDecimal;

public class Application extends Controller {

    final static Form<BasketItem> userForm = Form.form(BasketItem.class);
    final static Movies movies = new Movies();
    final static Calculator calculator = new Calculator();
    final static Rounder rounder = new Rounder();

    static Prices prices = new Prices();

    static Movie movie1 = new Movie("Batman and Robin", 1, "3pm");
    static Movie movie2 = new Movie("RED", 1, "3pm");
    static Movie movie3 = new Movie("The Good, The Bad and The Ugly", 1, "3pm");
    static Movie movie4 = new Movie("Gladiator", 1, "3pm");

    public static Result index() {
        return redirect(controllers.routes.Application.displayBasketItem());
    }


    //display a blank form
    public static Result displayBasketItem(){
        movies.addMovie(movie1);
        movies.addMovie(movie2);
        movies.addMovie(movie3);
        movies.addMovie(movie4);
        return ok(views.html.index.render(BasketItem.all(), userForm, prices));
    }

    public static Result newBasketItem(){
        Form<BasketItem> filledForm = userForm.bindFromRequest();
        BasketItem item = filledForm.get();
        Movie movieChoice = Movies.getMovieByTitleAndStartTime(item.getMovieTitle(), item.getMovieStartTime());
        PurchaseInformation order = new PurchaseInformation(movieChoice,4,5,6,7);


        BigDecimal totalStudentTicketsPrice = calculator.totalPriceOfStudentTickets(order);
        BigDecimal totalConcessionTicketsPrice = calculator.totalPriceConcessionTickets(order);
        BigDecimal totalUnder15TicketsPrice = calculator.totalPriceUnder15Tickets((order));
        BigDecimal totalAdultTicketsPrice = calculator.totalPriceFullPriceTickets(order);
        BigDecimal totalPrice = calculator.totalPriceOfAllTickets(order);

        Prices calculatedPrices = new Prices(totalStudentTicketsPrice,totalConcessionTicketsPrice,totalUnder15TicketsPrice,totalAdultTicketsPrice,totalPrice);
        System.out.println(calculatedPrices.getAdultPrices());
        System.out.println(totalPrice);
        if(filledForm.hasErrors()){
            return badRequest(
                views.html.index.render(BasketItem.all(), filledForm, calculatedPrices)
            );
        }else {
           BasketItem.addToBasket(filledForm.get());
            return redirect(routes.Application.displayBasketItem());
        }
    }

    public static Result removeBasketItem(Long id){
          BasketItem.remove(id);
            return redirect(routes.Application.displayBasketItem());

    }

    public static Result confirmBasket(){
        return TODO;
    }

    public static Result returnBooking(){
        return TODO;
    }

}
