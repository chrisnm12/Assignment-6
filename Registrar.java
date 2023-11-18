import tester.Tester;

class Course {
  String name;
  Instructor prof;
  IList<Student> students;
  Course(String name) {
    this.name = name;
    this.students = new MtList<>();
  }
  void enrollCourse(Student student) {
    this.students = new ConsList<>(student, this.students);
  }
  void addInstructor(Instructor instructor) {
    this.prof = instructor;
  }
}

class Instructor {
  String name;
  IList<Course> courses;

  Instructor(String name) {
    this.name = name;
    this.courses = new MtList<>();
  }

  void addCourse(Course course) {
    this.courses = new ConsList<>(course, this.courses);
    course.addInstructor(this);
  }

  boolean dejavu(Student s) {
    return s.dejavuHelper1(this.courses, 0);
  }
}

class Student {
  String name;
  int IDnum;
  IList<Course> courses;

  Student(String name, int IDnum) {
    this.name = name;
    this.IDnum = IDnum;
    this.courses = new MtList<>();
  }

  void enrollStudent(Course c) {
    this.courses = new ConsList<>(c, this.courses);
    c.enrollCourse(this);
  }

  boolean classmates(Student c) {
    return this.courses.classmatesHelper(c.courses);
  }

  boolean dejavuHelper1(IList<Course> courses, int count) {
    if (count >= 2) {
      return true;
    } else if (!courses.isEmpty() && courses.getFirst().students.contains(this)) {
      return dejavuHelper1(courses.getRest(), count + 1);
    } else if (courses.isEmpty()) {
      return false;
    } else {
      return dejavuHelper1(courses.getRest(), count);
    }
  }
}

class ExamplesRegistrar {
  Course Course1;
  Course Course2;
  Course Course3;
  Course Course4;
  Instructor MrMiyagi;
  Instructor OogwaySensei;
  Student Chris;
  Student Kevin;
  Student Mary;
  Student Steve;
  Student Akane;
  // Effect: Initialize Data
  void initData() {
    Course1 = new Course("Course1");
    Course2 = new Course("Course2");
    Course3 = new Course("Course3");
    Course4 = new Course("Course4");
    MrMiyagi = new Instructor("Miyagi");
    OogwaySensei = new Instructor("Oogway");
    Chris = new Student("Chris Bernal", 10232003);
    Kevin = new Student("Kevin Bernal", 12172007);
    Mary = new Student("Mary Asztalos", 7071971);
    Steve = new Student("Steve Minecraft", 01010101);
    Akane = new Student("Akane Tachibana", 2231960);
  }
  boolean testEnroll(Tester t) {
    this.initData();
    this.Chris.enrollStudent(Course1);
    return t.checkExpect(this.Course1.students.contains(Chris), true);
  }
  boolean testClassmates(Tester t) {
    this.initData();
    this.Chris.enrollStudent(Course1);
    this.Kevin.enrollStudent(Course1);
    return t.checkExpect(this.Chris.classmates(Kevin), true);
  }
  boolean testDejavu(Tester t) {
    this.initData();
    this.MrMiyagi.addCourse(Course1);
    this.MrMiyagi.addCourse(Course3);
    this.Akane.enrollStudent(Course1);
    this.Akane.enrollStudent(Course3);
    this.Akane.enrollStudent(Course4);
    return t.checkExpect(this.MrMiyagi.dejavu(Akane), true);
  }
}
