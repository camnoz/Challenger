package cl.ittalent.challenger.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class ResponseRegister {
  @JsonProperty("id")
  private String id;

  @JsonProperty("created")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
  private Date created;

  @JsonProperty("modified")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
  private Date modified;

  @JsonProperty("last_login")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
  private Date lastLogin;

  @JsonProperty("token")
  private String token;

  @JsonProperty("isactive")
  private String isactive;

  public ResponseRegister(
      final String id,
      final Date created,
      final Date modified,
      final Date lastLogin,
      final String token,
      final String isactive) {
    this.id = id;
    this.created = created;
    this.modified = modified;
    this.lastLogin = lastLogin;
    this.token = token;
    this.isactive = isactive;
  }

  public String getId() {
    return id;
  }

  public Date getCreated() {
    return created;
  }

  public Date getModified() {
    return modified;
  }

  public Date getLastLogin() {
    return lastLogin;
  }

  public String getToken() {
    return token;
  }

  public String getIsactive() {
    return isactive;
  }
}
