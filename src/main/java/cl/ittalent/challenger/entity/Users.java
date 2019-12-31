package cl.ittalent.challenger.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "users")
public class Users implements Serializable {

  private static final long serialVersionUID = 7984742860381881890L;

  @Id private String id;

  @Column(name = "email")
  private String email;

  @Column(name = "name")
  private String name;

  @Column(name = "password")
  private String password;

  @Column(name = "created")
  private Date created;

  @Column(name = "modified")
  private Date modified;

  @Column(name = "lastLogin")
  private Date lastLogin;

  @Column(name = "token")
  private String token;

  @Column(name = "number")
  private String number;

  @Column(name = "citycode")
  private String citycode;

  @Column(name = "countrycode")
  private String countrycode;

  @Column(name = "isactive")
  private String isactive;

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  @PrePersist
  private void onCreated() {
    lastLogin = modified = created = new Date();
  }

  @PreUpdate
  private void onLastLogin() {
    lastLogin = new Date();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public Date getModified() {
    return modified;
  }

  public void setModified(Date modified) {
    this.modified = modified;
  }

  public Date getLastLogin() {
    return lastLogin;
  }

  public void setLastLogin(Date lastLogin) {
    this.lastLogin = lastLogin;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getCitycode() {
    return citycode;
  }

  public void setCitycode(String citycode) {
    this.citycode = citycode;
  }

  public String getCountrycode() {
    return countrycode;
  }

  public void setCountrycode(String countrycode) {
    this.countrycode = countrycode;
  }

  public String getIsactive() {
    return isactive;
  }

  public void setIsactive(String isactive) {
    this.isactive = isactive;
  }
}
