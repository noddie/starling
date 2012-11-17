package com.psychicTyrion

import static org.junit.Assert.*
import org.junit.*

/**
 * Created with IntelliJ IDEA.
 * User: AmysDelight
 * Date: 17/11/12
 * Time: 19:06
 * To change this template use File | Settings | File Templates.
 */
class PostIntegration {

    @Test
    void testCreateUserAndPost() {
        def user = new User(userId: 'joe',
                password: 'secret').save()

        //By adding to the user, persists the data
//        simulate a number of posts
        def post1 = new Post(content: "First post... W00t!")
        user.addToPost(post1)

        def post2 = new Post(content: "Second post...")
        user.addToPost(post2)

        def post3 = new Post(content: "Third post...")
        user.addToPost(post3)
        assertEquals 3, User.get(user.id).post.size()
    }
}
