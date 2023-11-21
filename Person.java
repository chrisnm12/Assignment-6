
// represents a Person with a user name and a list of buddies
class Person {

    String username;
    ILoBuddy buddies;
    double dictionScore;
    double hearingScore;

    Person(String username, double dictionScore, double hearingScore) {
        if (dictionScore < 0.0 || dictionScore > 1.0 || hearingScore < 0.0 || hearingScore > 1.0) {
            throw new IllegalArgumentException("Diction score and hearing score must be between 0 and 1.");
        }
        this.dictionScore = dictionScore;
        this.hearingScore = hearingScore;
        this.username = username;
        this.buddies = new MTLoBuddy();
    }
    Person(String username) {
        this(username, 0.0, 0.0);
    }

    // EFFECT:
    // Change this person's buddy list so that it includes the given person
    void addBuddy(Person buddy) {
        this.buddies = new ConsLoBuddy(buddy, this.buddies);
    }

    // returns true if this Person has that as a direct buddy
    boolean hasDirectBuddy(Person that) {
        return this.buddies.contains(that);
    }

    // returns the number of people who will show up at the party 
    // given by this person
    int partyCount() {
        return 0;
    }

    // returns the number of people that are direct buddies 
    // of both this and that person
    int countCommonBuddies(Person that) {
        return this.buddies.countCommonBuddiesHelper(that.buddies, 0);
    }

    // will the given person be invited to a party 
    // organized by this person?
    boolean hasExtendedBuddy(Person that) {
        return this.buddies.hasExtendedBuddyHelper(that, new MTLoBuddy());
    }

    double maxLikelihood(Person that) {
        if (this.hasExtendedBuddy(that)) {
            return this.buddies.maxLikelihoodHelper(this, that, new MTLoBuddy(), 0);
        } else {
            return 0;
        }
    }

}
