package org.sdi.usermanager.services.impl;

import org.sdi.usermanager.entities.User;
import org.sdi.usermanager.exceptions.NotFoundException;
import org.sdi.usermanager.repositories.UserRepository;
import org.sdi.usermanager.services.FriendshipService;
import org.springframework.stereotype.Service;

@Service
public class FriendshipServiceImpl implements FriendshipService {

    private final UserRepository userRepository;

    public FriendshipServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createFriendship(Long userId1, Long userId2) {
        User user1 = userRepository.findById(userId1)
                .orElseThrow(() -> new NotFoundException(String.format("User with id %d not found", userId1)));
        User user2 = userRepository.findById(userId2)
                .orElseThrow(() -> new NotFoundException(String.format("User with id %d not found", userId2)));

        user1.getFriends().add(user2);
        userRepository.save(user1);
    }

    @Override
    public void deleteFriendship(Long userId1, Long userId2) {
        User user1 = userRepository.findById(userId1)
                .orElseThrow(() -> new NotFoundException(String.format("User with id %d not found", userId1)));
        User user2 = userRepository.findById(userId2)
                .orElseThrow(() -> new NotFoundException(String.format("User with id %d not found", userId2)));

        user1.getFriends().remove(user2);
        user2.getFriends().remove(user1);
        userRepository.save(user1);
    }
}
