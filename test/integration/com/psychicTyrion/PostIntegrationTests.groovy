package com.psychicTyrion

import static org.junit.Assert.*
import org.junit.*

class PostIntegrationTests {

    @Before
    void setUp() {
        // Setup logic here
    }

    @After
    void tearDown() {
        // Tear down logic here
    }

    @Test
    void testFirstPostUser() {
        def user = new User(userId: 'joe', password: 'secret').save()

//        By adding to the user, persists the data simulate a number of posts
        def post1 = new Post(content: "First post... W00t!")
        user.addToPosts(post1)

        def post2 = new Post(content: "Second post...")
        user.addToPosts(post2)

        def post3 = new Post(content: "Third post...")
        user.addToPosts(post3)
        assertEquals 3, User.get(user.id).posts.size()
    }

    @Test
    void testAccessingPosts() {
        def user = new User(userId: 'joe', password: 'secret').save()

        user.addToPosts(new Post(content: "First"))
        user.addToPosts(new Post(content: "Second"))
        user.addToPosts(new Post(content: "Third"))

        def foundUser = User.get(user.id)
//Now that we have a user and some posts, check that the posts have been persisted.
        def postNames = foundUser.posts.collect { it.content }
//Need to use sort as the data comes from a indeterminable set.
        assertEquals(['First', 'Second', 'Third'], postNames.sort())
    }

    @Test
    void testPostsWithTags() {
//        Create the new user
        def user = new User(userId: 'joe', password: 'secret').save()
//        Create some tags
        def tagGroovy = new Tag(name: 'groovy')
        def tagGrails = new Tag(name: 'grails')
//        Add the tags to the user
        user.addToTags(tagGroovy)
        user.addToTags(tagGrails)
//        Check that we have the tags persisted
        def tagNames = user.tags*.name
        assertEquals(['grails', 'groovy'], tagNames.sort())

//        create a new post
        def groovyPost = new Post(content: "A groovy post")
//        Add the post to the user
        user.addToPosts(groovyPost)
//        now add the tag to the post
        groovyPost.addToTags(tagGroovy)
        assertEquals 1, groovyPost.tags.size()

        def bothPost = new Post(content: "A groovy and grails post")
        user.addToPosts(bothPost)

        bothPost.addToTags(tagGroovy)
        bothPost.addToTags(tagGrails)
        assertEquals 2, bothPost.tags.size()
    }
}
