package com.psychicTyrion

class Post {

    String content
    Date dateCreated


    static constraints = {
        content blank: false
    }
//1:m relationship
    static belongsTo = [user: User]
    static hasMany = [ tags : Tag ]

    static mapping = {
        sort dateCreated:"desc"
    }

}
