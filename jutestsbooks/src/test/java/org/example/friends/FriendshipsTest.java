package org.example.friends;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

public class FriendshipsTest {


    @InjectMocks
    FriendshipsMongo friendships;
    @Mock
    FriendsCollection friends;

    @Test
    public void joeHas5Friends() {
        List<String> expected = Arrays.asList("Audrey", "Peter", "Michael", "Britney", "Paul");
        Person joe = spy(new Person("Joe"));

        doReturn(joe).when(friends).findByName("Joe");
        doReturn(expected).when(joe).getFriends();

        assertThat(friendships.getFriendsList("Joe"))
                .hasSize(5)
                .containsOnly("Audrey", "Peter", "Michael", "Britney", "Paul");
    }

}
