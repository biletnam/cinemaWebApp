package controllers;

//import com.moneysupermarket.cinema.Calculator;
import com.moneysupermarket.cinema.Movie;
import models.BasketItem;
import models.Movies;
import play.*;
import play.data.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    final static Form<BasketItem> userForm = Form.form(BasketItem.class);
    final static Movies movies = new Movies();

    static Movie movie1 = new Movie("Batman and Robin", 1, "3pm");
    static Movie movie2 = new Movie("RED", 1, "3pm");
    static Movie movie3 = new Movie("The Good, The Bad and The Ugly", 1, "3pm");
    static Movie movie4 = new Movie("Gladiator", 1, "3pm");

    public static Result index() {
        return redirect(routes.Application.displayBasketItem());
    }


    //display a blank form
    public static Result displayBasketItem(){
        movies.addMovie(movie1);
        movies.addMovie(movie2);
        movies.addMovie(movie3);
        movies.addMovie(movie4);
        return ok(views.html.index.render(BasketItem.all(), userForm));
    }

    public static Result newBasketItem(){
        Form<BasketItem> filledForm = userForm.bindFromRequest();
        if(filledForm.hasErrors()){
            return badRequest(
                views.html.index.render(BasketItem.all(), filledForm)
            );
        }else {
           BasketItem.addToBasket(filledForm.get());
            return redirect(routes.Application.displayBasketItem());
        }
    }

    public static Result confirmBasket(){
        return TODO;
    }

    public static Result returnBooking(){
        return TODO;
    }

}
