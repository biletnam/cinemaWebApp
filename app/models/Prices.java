package models;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: danfaulkner
 * Date: 17/04/2014
 * Time: 11:15
 * To change this template use File | Settings | File Templates.
 */
public class Prices {
    private BigDecimal studentPrices;
    private BigDecimal concessionPrices;
    private BigDecimal under15Prices;
    private BigDecimal adultPrices;
    private BigDecimal totalPrice;

    public Prices() {

    }

    public Prices(BigDecimal studentPrices, BigDecimal concessionPrices, BigDecimal under15Prices, BigDecimal adultPrices, BigDecimal totalPrice) {
        this.studentPrices = studentPrices;
        this.concessionPrices = concessionPrices;
        this.under15Prices = under15Prices;
        this.adultPrices = adultPrices;
        this.totalPrice = totalPrice;
    }

    public BigDecimal getStudentPrices() {
        return studentPrices;
    }

    public BigDecimal getConcessionPrices() {
        return concessionPrices;
    }

    public BigDecimal getUnder15Prices() {
        return under15Prices;
    }

    public BigDecimal getAdultPrices() {
        return adultPrices;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

}
