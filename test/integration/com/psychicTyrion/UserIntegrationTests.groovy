package com.psychicTyrion

import static org.junit.Assert.*
import org.junit.*

class UserIntegrationTests {
    String testUserName = 'Steve Holder'
    String testPassword = '1234678'
    String testHomePage = 'http://www.testmebaby.com'

    @Before
    void setUp() {
        // Setup logic here
    }

    @After
    void tearDown() {
        // Tear down logic here
    }

    @Test
    /**
     * Create a new instance of a User. Test that it is created.
     */
    void testCreateUser() {
        def user = new User(userId: testUserName, password: testPassword, homepage: testHomePage)
        assertNotNull user.save()
        assertNotNull(user.id)

        def foundUser = User.get(user.id)
        assertEquals testUserName, foundUser.userId
    }

    @Test
    void testSaveAndUpdate() {
        def user = new User(userId: testUserName, password: testPassword, homepage: testHomePage)
        assertNotNull user.save()

        def newPassword = '12374586'

        def foundUser = User.get(user.id)
        foundUser.password = newPassword
        foundUser.save()

        def editedUser = User.get(user.id)
        assertEquals(newPassword, editedUser.password)
        assertNotSame(testPassword, editedUser.password)
    }

    @Test
    void testSaveThenDelete() {
        def user = new User(userId: testUserName, password: testPassword, homepage: testHomePage)
        assertNotNull user.save()

        def foundUser = User.get(user.id)
        foundUser.delete()
        assertFalse User.exists(foundUser.id)
    }

    @Test
    /**
     * This should fail the validation as the URL in invalid
     */
    void testASaveThatShouldFail() {
        testUserName = 'Chuck_Norris'
        testPassword = 'Tiny'
        testHomePage = 'knackered.'
        def user = new User(userId: testUserName, password: testPassword, homepage: testHomePage)

        assertFalse user.validate()
        assertTrue user.hasErrors()

        def errorsFromCreateUser = user.errors

        assertEquals "size.toosmall", errorsFromCreateUser.getFieldError("password").code
        assertEquals testPassword, errorsFromCreateUser.getFieldError("password").rejectedValue

        assertEquals "url.invalid", errorsFromCreateUser.getFieldError("homepage").code
        assertEquals testHomePage, errorsFromCreateUser.getFieldError("homepage").rejectedValue

        assertNull errorsFromCreateUser.getFieldError("userId")
    }

    @Test
    /**
     * The user will not be persisted as the constrains are not met
     * An error will be thrown and corrected.
     */
    void testSaveThatWillFailAndRecover() {
        testUserName = 'Chuck_Norris'
        String testPasswordNotMeetingConstraints = 'Tiny'
        String testHomePageNotMeetingConstrains = 'knackered.'

        String compliantPassword  = 'DonkeyBo'
        String compliantHomePage =   'https://www.lookatme.com'

        def user = new User(userId: testUserName, password: testPasswordNotMeetingConstraints,
                homepage: testHomePageNotMeetingConstrains)

        assertFalse(user.validate())
        assertTrue(user.hasErrors())
        assertNull user.save()

        user.password = compliantPassword
        user.homepage = compliantHomePage
        assertTrue(user.validate())
        assertFalse(user.hasErrors())
        assertNotNull user.save()
    }
    @Test
    void testPasswordNotSameAsUsername(){

        def user = new User(userId:testPassword, password: testPassword )
        assertFalse user.validate()
        assertEquals 'validator.invalid', user.errors.getFieldError("password").code

    }
    @Test
    void testFollowingAnotherUser() {
        def glen = new User(userId: 'glen', password:'password').save()
        def peter = new User(userId: 'peter', password:'password').save()
        def sven = new User(userId: 'sven', password:'password').save()
        glen.addToFollowing(peter)
        glen.addToFollowing(sven)
        assertEquals 2, glen.following.size()
        sven.addToFollowing(peter)
        assertEquals 1, sven.following.size()
    }
}
