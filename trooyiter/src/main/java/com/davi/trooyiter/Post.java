package com.davi.trooyiter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Post {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private long postID;

  private String body;

  private long posterID;

  public Post() {
    this.body = "";
    this.posterID = 0;
  }

  public Post(String body, long posterID) {
    this.body = body;
    this.posterID = posterID;
  }

  public long getPostID() {
    return postID;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public long getPosterID() {
    return posterID;
  }
}