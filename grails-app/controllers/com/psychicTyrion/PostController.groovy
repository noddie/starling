package com.psychicTyrion

class PostController {

    def PostService
    def scaffold = true

    def defaultAction = 'timeline'

    def timeline = {

//        take the id from the url and use it to find the user.
        def user = User.findByUserId(params.id)
//        pass the matched user to the view
        [user: user]
    }

    def addPost = {

        try {
            def newPost = postService.createPost(params.id, params.content)
            flash.message = "Added new post : ${newPost.content}"
        } catch (PostException pe) {
            flash.message = pe.message
        }
        redirect(action: 'timeline', id: params.id)
    }
}
