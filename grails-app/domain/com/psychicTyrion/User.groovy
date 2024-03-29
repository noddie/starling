package com.psychicTyrion
/**
 * The user class defines the user, the user can also follow a user through a recursive join
 */
class User {

    String userId
    String password
    String homepage
//    Grails will add sysdate as default because it sees dateCreated
    Date dateCreated
//   make sure that we have a 1:1 mapping, leave this out would create a 1:m
    Profile profile


    static constraints = {

        userId size: 3..20, unique: true
        password size: 6..8, validator: { passwd, user ->
            passwd != user.userId
        }
        homepage url: true, nullable: true
        dateCreated()
        profile nullable: true
    }
    static mapping = {
//        load profile with User
        profile lazy: false
//        only sort when accessing posts from the user
//        posts sort:'dateCreated'
    }
//    following created the recursive join
    static hasMany = [posts: Post, tags: Tag, following: User]
}
