package com.psychicTyrion

class Tag {

    String name
    User user
    static constraints = {
        name(blank: false)
    }
    static hasMany = [posts: Post]
    static belongsTo = [User, Post]
}

