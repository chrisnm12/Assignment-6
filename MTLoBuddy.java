
// represents an empty list of Person's buddies
class MTLoBuddy implements ILoBuddy {
    public boolean contains(Person p) {
        return false;
    }
    public int length() {
        return 0;
    }
    public int countCommonBuddiesHelper(ILoBuddy lob, int n) {
        return n;
    }

    public boolean hasExtendedBuddyHelper(Person that, ILoBuddy visited) {
        return false;
    }
    public double maxLikelihoodHelper(Person a, Person that, ILoBuddy visited, double currVal, double maxVal) {
        return maxVal;
    }
}
