import com.psychicTyrion.Profile
import com.psychicTyrion.User

class BootStrap {

    def init = { servletContext ->

        new User(userId: "noddie", password: "welcome1", profile:
                (new Profile(fullName: "Steve Holder", email: "nojunk.steveh@yahoo.co.uk"))).save()
        new User(userId: "bingo", password: "donkey", profile:
                (new Profile(fullName: "Amy Holder", email: "amy.holder@yahoo.co.uk"))).save()
    }
    def destroy = {
    }
}
