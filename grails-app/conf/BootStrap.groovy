import com.psychicTyrion.Profile
import com.psychicTyrion.User
import grails.util.Environment

class BootStrap {

    def init = { servletContext ->
        switch (Environment.current) {
            case Environment.DEVELOPMENT:
                createAdminUserIfRequired()
                createTestUserIfRequired()
                break
            case Environment.PRODUCTION:
                println("nowt special to do here!")
        }


    }
    def destroy = {
    }

    void createAdminUserIfRequired() {
        if (!User.findByUserId("admin")) {
            println "Fresh Database. Creating ADMIN user."
            def adminProfile = new Profile(fullName: "Admin", email: "admin@yourhost.com")
            new User(userId: "admin",
                    password: "secret", profile: adminProfile).save()
        } else {
            println "Existing admin user, skipping creation"
        }
    }

    void createTestUserIfRequired() {
        if (!User.findByUserId("noddie") || !User.findByUserId("bingo")) {
            println "Fresh Database. Creating Test users."
            new User(userId: "noddie", password: "welcome1", profile:
                    (new Profile(fullName: "Steve Holder", email: "nojunk.steveh@yahoo.co.uk"))).save()

            new User(userId: "bingo", password: "donkey", profile:
                    (new Profile(fullName: "Amy Holder", email: "amy.holder@yahoo.co.uk"))).save()
        } else {
            println "Existing test user, skipping creation"
        }
    }
}
