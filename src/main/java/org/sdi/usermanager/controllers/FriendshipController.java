package org.sdi.usermanager.controllers;

import org.sdi.usermanager.services.FriendshipService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/friendships")
@CrossOrigin
public class FriendshipController {

    private final FriendshipService friendshipService;

    public FriendshipController(FriendshipService friendshipService) {
        this.friendshipService = friendshipService;
    }

    @PostMapping("/{userId1}/{userId2}")
    public ResponseEntity<Void> createFriendship(@PathVariable Long userId1, @PathVariable Long userId2) {
        friendshipService.createFriendship(userId1, userId2);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{userId1}/{userId2}")
    public ResponseEntity<Void> deleteFriendship(@PathVariable Long userId1, @PathVariable Long userId2) {
        friendshipService.deleteFriendship(userId1, userId2);
        return ResponseEntity.noContent().build();
    }
}
