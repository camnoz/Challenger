package cl.ittalent.challenger.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Phone {

  @JsonProperty("number")
  private String number;

  @JsonProperty("citycode")
  private String citycode;

  @JsonProperty("countrycode")
  private String countrycode;

  public Phone(
          final String number,
          final String citycode,
          final String countrycode) {
    this.number = number;
    this.citycode = citycode;
    this.countrycode = countrycode;
  }

  public String getNumber() {
    return number;
  }

  public String getCitycode() {
    return citycode;
  }

  public String getCountrycode() {
    return countrycode;
  }
}
