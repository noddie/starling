package com.psychicTyrion

import org.junit.After
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.*

class UserIntegrationSpoc {

    @Test
    /**
     * Create a new instance of a User. Test that it is created and recursive.
     */ def "Create a user with a recursive join to simulate following"() {
        when:
        def newUser1 = new User(userId: theUserName, password: thePassword).save()
        def newUser2 = new User(userId: theUserName, password: thePassword).save()
        def newUser3 = new User(userId: theUserName, password: thePassword).save()

        then:
        newUser1.addToFollowing(newUser2).validate() == !isValid
        newUser1.addToFollowing(newUser3).validate() == !isValid

        where:

        theUserName | thePassword     | isValid
        'steve'     | 'welcome1'      | true
        'dave'      | 'welcome2'      | true
        'john'      | 'Bust The Size' | false

    }

}
