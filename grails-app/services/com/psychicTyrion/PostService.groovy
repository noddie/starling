package com.psychicTyrion

class PostService {

    Boolean transactional = true

    def createPost(String userId, String content) {
//        Gotya the below will compile but as a list :-(
//        def user = User.findAllByUserId(userId)
        def user = User.findByUserId(userId)

        if (user) {
            def post = new Post(content: content)
            user.addToPosts(post)
            if (user.save()) {
                return post
            } else {
                throw new PostException(
                        message: "Invalid or Empty post", post: post
                )
            }
        }
        throw new PostException(message: "Invalid User Id")
    }
}

//Forces transactions to rollback if exceptions occur
class PostException extends RuntimeException {
    String message
    Post post
}