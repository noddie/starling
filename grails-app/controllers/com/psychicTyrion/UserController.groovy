package com.psychicTyrion
class UserController {

    def scaffold = true

    def search = {}
    def advSearch = {}

    def results = {
        def users = User.findAllByUserIdLike(params.userId)
        return [users: users, term: params.userId]
    }

    def advResults = {
        def profileProps =
            Profile.metaClass.properties*.name
        def profiles = Profile.withCriteria {
            "${params.queryType}" {
                params.each { field, value ->
                    if (profileProps.grep(field)
                            && value) {
                        ilike(field, '%' + value + '%')
                    }
                }
            }
        }
        [profiles: profiles]
    }
    //get the data from the session container and reattach the new instance
    def update = {
        def user = session.users.attach()
        user.properties = params
        if (user.validate()) {
            flash.message = "Updated User"
        } else {
            user.discard()
        }
        [users: user]
    }
//    only allow updates of the following, any other entity that has been updated is thrwon away
//    user.profile.properties['email', 'fullName'] = params

    def register = {
        def user = new User(params)
        if (user.validate()) {
            user.save()
            flash.message = "Created User ${user.userId}"
            redirect(uri: '/')
        } else {
            flash.message = "Error registering user"
            return [user: user]
        }
    }
}
