package com.acme.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Name{
  private String first;
  private String last;

  public String getFirst(){
    return this.first;
  }
  public void setFirst(String first){
    this.first = first;
  }
  public String getLast(){
    return this.last;
  }
  public void setLast(String last){
    this.last = last;
  }
}