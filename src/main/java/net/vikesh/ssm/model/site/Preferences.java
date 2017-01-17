package net.vikesh.ssm.model.site;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Currency;
import java.util.Locale;

/**
 * Created by Vikesh on 23-Dec-16.
 */
@Embeddable
public class Preferences {

    @Column(name = "LONG_DATE_FORMAT")
    private String longDateFormat = "";

    @Column(name = "SHORT_DATE_FORMAT")
    private String shortDateFormat = "";

    @Column(name = "LOCALE")
    private Locale locale = Locale.US;

    @Column(name = "CURRENCY")
    private Currency currency;

    @Column(name = "SHORT_TIME_FORMAT")
    private String shortTimeFormat;

    @Column(name = "LONG_TIME_FORMAT")
    private String longTimeFormat;

    @Column(name = "CURRENCY_DECIMAL_PRECISION")
    private int currencyDecimalPrecision;

    @Column(name = "NORMAL_DECIMAL_PRECISION")
    private int decimalPrecision;

    public String getLongDateFormat() {
        return longDateFormat;
    }

    public void setLongDateFormat(String longDateFormat) {
        this.longDateFormat = longDateFormat;
    }

    public String getShortDateFormat() {
        return shortDateFormat;
    }

    public void setShortDateFormat(String shortDateFormat) {
        this.shortDateFormat = shortDateFormat;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getShortTimeFormat() {
        return shortTimeFormat;
    }

    public void setShortTimeFormat(String shortTimeFormat) {
        this.shortTimeFormat = shortTimeFormat;
    }

    public String getLongTimeFormat() {
        return longTimeFormat;
    }

    public void setLongTimeFormat(String longTimeFormat) {
        this.longTimeFormat = longTimeFormat;
    }

    public int getCurrencyDecimalPrecision() {
        return currencyDecimalPrecision;
    }

    public void setCurrencyDecimalPrecision(int currencyDecimalPrecision) {
        this.currencyDecimalPrecision = currencyDecimalPrecision;
    }

    public int getDecimalPrecision() {
        return decimalPrecision;
    }

    public void setDecimalPrecision(int decimalPrecision) {
        this.decimalPrecision = decimalPrecision;
    }
}
