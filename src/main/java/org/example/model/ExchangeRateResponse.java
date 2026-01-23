package org.example.model;

public class ExchangeRateResponse {

    public String result;
    public String error_type;
    private String base_code;
    private String target_code;
    private double conversion_rate;
    private double conversion_result;

    public String getBase_code() {
        return base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public double getConversion_rate() {
        return conversion_rate;
    }

    public double getConversion_result() {
        return conversion_result;
    }
}
