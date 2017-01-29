package com.example.petar.inteligentnisistemi.models;


public class User {


  private long id;

  private String email;

  private String name;

  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  
  public User() { }

  public User(long id) { 
    this.id = id;
  }
  
  public User(String email, String name) {
    this.email = email;
    this.name = name;
  }

  // Getter and setter methods

  public long getId() {
    return id;
  }

  public void setId(long value) {
    this.id = value;
  }

  public String getEmail() {
    return email;
  }
  
  public void setEmail(String value) {
    this.email = value;
  }
  
  public String getName() {
    return name;
  }

  public void setName(String value) {
    this.name = value;
  }
  
} // class User
