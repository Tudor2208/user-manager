package org.sdi.usermanager.services;

import org.springframework.stereotype.Component;

@Component
public interface FriendshipService {

    void createFriendship(Long userId1, Long userId2);
    void deleteFriendship(Long userId1, Long userId2);
}
