package com.psychicTyrion

class Profile {
//        Defines the relationship to the user class
    static belongsTo = User
//    store as a blob
    byte[] photo

    String fullName
    String bio
    String homepage
    String email
    String timezone
    String country
    String jabberAddress

    static constraints = {
        fullName nullable: true
        bio nullable: true, maxSize: 1000
        homepage nullable: true, url: true
        email nullable: true, email: true
        photo nullable: true
        country nullable: true
        timezone nullable: true
        jabberAddress email: true, nullable: true
    }
    @Override
    String toString() {
        "Profile for ${fullName} (${id})"
    }
}
