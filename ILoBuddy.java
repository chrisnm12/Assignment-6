
// represents a list of Person's buddies
interface ILoBuddy {
  boolean contains(Person p);
  int length();
  int countCommonBuddiesHelper(ILoBuddy lob, int n);
  boolean hasExtendedBuddyHelper(Person that, ILoBuddy visited);
  double maxLikelihoodHelper(Person a, Person that, ILoBuddy visited, double maxVal);
}
