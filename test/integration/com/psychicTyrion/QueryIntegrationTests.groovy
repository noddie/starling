package com.psychicTyrion

import org.junit.After
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertTrue

class QueryIntegrationTests {

    @Before
    void setUp() {
        // Setup logic here
    }

    @After
    void tearDown() {
        // Tear down logic here
    }

    @Test
    void testBasicDynamicFinders() {
        new User(userId: 'joe', password: 'secret', profile: new Profile(email: 'joe@aol.com')).save()
        new User(userId: 'bob', password: 'nTelling', profile: new Profile(homepage: 'http://www.aol.com')).save()


        def user = User.findByPassword('nTelling')
        assertEquals('bob', user.userId)

        user = User.findByUserIdAndPassword('joe', 'secret')
        assertEquals('joe', user.userId)

        def now = new Date()

        user = User.findAllByDateCreatedBetween(now - 1, now)
        assertEquals(2, user.size())

        def profile = Profile.findAllByEmailIsNotNull()
        assertEquals(1, profile.size())
    }

    @Test
    void testQueryByExample() {
        new User(userId: 'glen', password: 'password').save()
        new User(userId: 'peter', password: 'password').save()
        new User(userId: 'cynthia', password: 'sesame').save()

        def userToFind = new User(userId: 'glen')
        def u1 = User.find(userToFind)
        assertEquals('password', u1.password)

        userToFind = new User(userId: 'cynthia')
        def u2 = User.find(userToFind)
        assertEquals('cynthia', u2.userId)

        userToFind = new User(password: 'password')
        def u3 = User.findAll(userToFind)
        assertEquals(['glen', 'peter'], u3*.userId)


    }
}
