import tester.*;


// runs tests for the buddies problem
public class ExamplesBuddies{
Person Ann;
Person Bob;
Person Cole;
Person Dan;
Person Ed;
Person Fay;
Person Gabi;
Person Hank;
Person Jan;
Person Kim;
Person Len;

void initBuddies() {
  Ann = new Person("Ann", 0.95, 0.90);
  Bob = new Person("Bob", 0.80, 0.90);
  Cole = new Person("Cole", 0.55, 0.60);
  Dan = new Person("Dan", 0.95, 0.55);
  Ed = new Person("Ed", 1, 1);
  Fay = new Person("Fay", 0.35, 0.75);
  Gabi = new Person("Gabi", 0.1, 0.1);
  Hank = new Person("Hank", 0, 1);
  Jan = new Person("Jan", 0.45, 0.95);
  Kim = new Person("Kim", 0.80, 0.65);
  Len = new Person("Len", 1, 0);
}
void addedBuddies() {
  this.Ann.addBuddy(Bob);
  this.Ann.addBuddy(Cole);
  this.Bob.addBuddy(Ann);
  this.Bob.addBuddy(Ed);
  this.Bob.addBuddy(Hank);
  this.Cole.addBuddy(Dan);
  this.Dan.addBuddy(Cole);
  this.Ed.addBuddy(Fay);
  this.Fay.addBuddy(Ed);
  this.Fay.addBuddy(Gabi);
  this.Gabi.addBuddy(Ed);
  this.Gabi.addBuddy(Fay);
  this.Jan.addBuddy(Kim);
  this.Jan.addBuddy(Len);
  this.Kim.addBuddy(Jan);
  this.Kim.addBuddy(Len);
  this.Len.addBuddy(Jan);
  this.Len.addBuddy(Kim);
}

boolean testHasDirectBuddy(Tester t) {
  this.initBuddies();
  this.addedBuddies();
  return t.checkExpect(this.Ann.hasDirectBuddy(Cole),true);
}
boolean testCountCommonBuddies(Tester t) {
  this.initBuddies();
  this.addedBuddies();
  return t.checkExpect(this.Ed.countCommonBuddies(this.Gabi), 1);
}

boolean testHasExtendedBuddy(Tester t) {
  this.initBuddies();
  this.addedBuddies();
  return t.checkExpect(this.Ed.hasExtendedBuddy(this.Gabi), true);
}
/*
boolean testPartyCount(Tester t) {
  this.initBuddies();
  this.addedBuddies();
  return t.checkExpect(this.Ed.partyCount(), 4);
}
 */

boolean testMaxLikelihood(Tester t) {
  this.initBuddies();
  this.addedBuddies();
  return t.checkInexact(this.Ed.maxLikelihood(this.Gabi), 0.02625, 0.01);
}
}