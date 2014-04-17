package models;

import com.moneysupermarket.cinema.Calculator;
import com.moneysupermarket.cinema.Movie;
import com.moneysupermarket.cinema.PurchaseInformation;
import play.data.validation.Constraints.*;
import play.db.ebean.*;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: danfaulkner
 * Date: 16/04/2014
 * Time: 14:22
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class BasketItem extends Model {

    public int numberOfStudentTickets;
    public int numberOfConcessionTickets;
    public int numberOfUnder15Tickets;
    public int numberOfAdultTickets;

    Calculator calculator = new Calculator();

    @Id
    public Long id;

    @Required
    public String movieTitle;

    @Required
    public String movieStartTime;

    @Required
    public String ticketType;

    @Required
    public int numberTickets;

    public BasketItem() {

    }

    public BasketItem(String ticketType, int numberTickets) {
        this.ticketType = ticketType;
        this.numberTickets = numberTickets;

        switch(ticketType) {
            case "Student":
                numberOfStudentTickets = numberTickets;
                break;
            case "Concession":
                numberOfConcessionTickets = numberTickets;
                break;
            case "Under 15":
                numberOfUnder15Tickets = numberTickets;
                break;
            case "Adult":
                numberOfAdultTickets = numberTickets;
                break;
        }
    }

    public int getNumberOfStudentTickets() {
        return numberOfStudentTickets;
    }

    public int getNumberOfConcessionTickets() {
        return numberOfConcessionTickets;
    }

    public int getNumberOfUnder15Tickets() {
        return numberOfUnder15Tickets;
    }

    public int getNumberOfAdultTickets() {
        return numberOfAdultTickets;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getMovieStartTime() {
        return movieStartTime;
    }

    public static Finder<Long,BasketItem> find = new Finder(
            Long.class, BasketItem.class
    );

    public static List<BasketItem> all() {
        return find.all();
    }

    public static void addToBasket(BasketItem item) {
        item.save();
    }

    public static void remove(Long id) {
        find.ref(id).delete();
    }

}
