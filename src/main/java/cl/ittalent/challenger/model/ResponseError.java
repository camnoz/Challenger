package cl.ittalent.challenger.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseError {
  @JsonProperty("message")
  private String message;

  public ResponseError(String message) {
    this.message = message;
  }
}
