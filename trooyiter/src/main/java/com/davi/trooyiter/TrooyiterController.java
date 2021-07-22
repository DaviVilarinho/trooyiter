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
import javax.transaction.Transactional;

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
  @GetMapping("/add")
  @Transactional
  public String addToTrooyiter(
    @RequestParam long userID,
    @RequestParam String content
  ) {
    Post newPost = new Post(content, userID);
    postRepository.save(newPost);
    return "Added";
  }

  /**
   * Remove a post from Trooyiter
   * This method runs imediattely and userID and postID must be provided
   * @param long userID
   * @param long postID
   * 
   * It should not delete if mismatched userID from postID
   * Return Success or Fail
   */
  @GetMapping("/rem")
  @Transactional
  public @ResponseBody String remFromTrooyiter(
    @RequestParam long postID,
    @RequestParam long userID
    ) {
    // missing any params, bad request by spring

    // query the postID
    Iterable<Post> postsMatchedById = postRepository.findBypostID(postID);
    for (Post post : postsMatchedById) {
      // if matched, delete
      if (post.getPostID() == postID && post.getPosterID() == userID) {
        postRepository.deleteBypostID(postID);
        return "{\"Status\": 1, \"description\": \"deleted succesfully\"}";
      }
      return "{\"Status\": 0, \"description\": \"mismatched user and postID\"}";
    }
    
    return "{\"Status\": 0, \"description\": \"missing posts\"}";
  }

  /**
   * Return all posts
   * returns JSON of Posts
   */
  @GetMapping("/all")
  public @ResponseBody Iterable<Post> getContent() {
    return postRepository.findAll();
  }
}