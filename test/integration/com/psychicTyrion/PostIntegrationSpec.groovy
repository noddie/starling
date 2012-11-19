package com.psychicTyrion

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class PostIntegrationSpec extends Specification {
//    http://code.google.com/p/grails-spock-examples/wiki/Overview#Testing_constraints
    def "Create a new user using spock whoop"() {
        when:

        def newUser = new User(userId: theUserID, password: thePassword)
        newUser.validate()

        then:
        newUser.hasErrors() == !valid

        where:
        theUserID           | thePassword      |  valid
        "More Than Allowed" | "TOO many Chars" |  false
        "Steve Holder"      | "Welcome1"       |  true
    }
}
