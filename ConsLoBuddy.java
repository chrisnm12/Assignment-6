// represents a list of Person's buddies
class ConsLoBuddy implements ILoBuddy {

    Person first;
    ILoBuddy rest;

    ConsLoBuddy(Person first, ILoBuddy rest) {
        this.first = first;
        this.rest = rest;
    }
    public boolean contains(Person t) {
        if (this.first.equals(t)) {
            return true;
        } else {
            return this.rest.contains(t);
        }
    }
    public int length() {
        return 1 + this.rest.length();
    }
    public int countCommonBuddiesHelper(ILoBuddy lob, int n) {
        if (lob.contains(this.first)) {
            n = n + 1;
        }
        return this.rest.countCommonBuddiesHelper(lob, n);
    }
    public boolean hasExtendedBuddyHelper(Person that, ILoBuddy visited) {
        if (this.contains(that)) {
            return true;
        } else if (visited.contains(this.first)) {
            return this.rest.hasExtendedBuddyHelper(that, visited);
        } else {
            visited = new ConsLoBuddy(this.first, visited);
            return this.first.buddies.hasExtendedBuddyHelper(that, visited);
        }
    }
    public double maxLikelihoodHelper(Person a, Person that, ILoBuddy visited, double maxVal) {
        if (this.contains(that)) {
            if ((this.first.dictionScore * that.hearingScore) > maxVal) {
                maxVal = this.first.dictionScore * that.hearingScore;
            } else {
                return
            }

        } else if (visited.contains(this.first)) {
            return this.rest.maxLikelihoodHelper(a, that, visited, maxVal)
        }
    }
}
