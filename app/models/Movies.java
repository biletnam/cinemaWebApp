package models;

import java.util.ArrayList;
import java.util.List;
import com.moneysupermarket.cinema.*;

/**
 * Created with IntelliJ IDEA.
 * User: danfaulkner
 * Date: 16/04/2014
 * Time: 15:26
 * To change this template use File | Settings | File Templates.
 */
public class Movies {

    public static List<Movie> movieLibrary = new ArrayList<Movie>();

    public void addMovie(Movie movie) {
        movieLibrary.add(movie);
    }

    public static List<String> titles() {
        List<String> all = new ArrayList<String>();
        for (int i = 0; i< movieLibrary.size(); i++){
            Movie movie = movieLibrary.get(i);
            all.add(movie.getTitle());
        }
         return all;
    }
}
