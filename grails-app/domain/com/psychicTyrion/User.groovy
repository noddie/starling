package com.psychicTyrion

class User {

    String userId
    String password
    String homepage
//    Grails will add sysdate as default because it sees dateCreated
    Date dateCreated

    static constraints = {

        userId size: 3..20, unique: true
        password size: 6..8
        homepage url: true, nullable: true
    }
}
