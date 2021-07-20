package com.davi.trooyiter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Post {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private long postID;

  private String body;

  @Id
  private long posterID;

  public Post(String body, long posterID) {
    this.body = body;
    this.posterID = userID;
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