package com.davi.trooyiter;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class TrooyiterController {
  @Autowired
  private PostRepository postRepository;

  /**
   * Add a post to Trooyiter
   * This method runs imediattely and userID and Content must be provided
   * @param long userID
   * @param String content
   * 
   * It should not delete if mismatched userID
   * Return Success or Fail
   */
//@GetMapping("/add")
//public String addToTrooyiter(
//  @RequestParam(value="userID", defaultValue=-1) long userID,
//  @RequestParam(value="Content", defaultValue="") String content
//) {
//  return "Added";
//}

///**
// * Remove a post from Trooyiter
// * This method runs imediattely and userID and postID must be provided
// * @param long userID
// * @param long postID
// * 
// * It should not delete if mismatched userID
// * Return Success or Fail
// */
//@GetMapping("/rem")
//public String remFromTrooyiter(
//  @RequestParam(value="postID", defaultValue=-1) long postID,
//  @RequestParam(value="userID", defaultValue=-1) long userID
//  ) {
//   
//  return "Removed";
//}

  /**
   * Return all posts
   * returns JSON of Posts
   */
  @GetMapping("/all")
  public @ResponseBody Iterable<Post> getContent() {
    return postRepository.findAll();
  }
}