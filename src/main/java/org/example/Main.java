package org.example;

import java.util.*;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.time.*;
import java.util.concurrent.atomic.*;
import java.util.regex.Pattern;

// Sample enum for testing
enum Status {
    ACTIVE, INACTIVE, PENDING
}

// Generic class
class Container<T> {
    private T value;
    private List<T> history;

    public Container(T value) {
        this.value = value;
        this.history = new ArrayList<>();
        history.add(value);
    }
}

// Record type (Java 16+)
record Point(int x, int y) {}

// Complex object for testing
class Department {
    private String name;
    private List<Student> students;
    private Status status;

    public Department(String name, List<Student> students, Status status) {
        this.name = name;
        this.students = students;
        this.status = status;
    }
}

// Additional complex class
class Course {
    private String courseId;
    private Map<Student, List<Double>> studentGrades;
    private Set<String> prerequisites;
    
    public Course(String courseId) {
        this.courseId = courseId;
        this.studentGrades = new HashMap<>();
        this.prerequisites = new HashSet<>();
    }
}

// Additional nested classes for testing
class Address {
    private String street;
    private String city;
    private String country;
    
    public Address(String street, String city, String country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }
}

class PersonInfo {
    private String email;
    private Address address;
    private List<String> phoneNumbers;
    
    public PersonInfo(String email, Address address, List<String> phoneNumbers) {
        this.email = email;
        this.address = address;
        this.phoneNumbers = phoneNumbers;
    }
}

class StudentDetail extends Student {
    public PersonInfo personInfo;
    public Map<String, List<Double>> subjectScores;
    public List<Course> enrolledCourses;
    
    public StudentDetail(String name, int age, PersonInfo personInfo) {
        super(name, age);
        this.personInfo = personInfo;
        this.subjectScores = new HashMap<>();
        this.enrolledCourses = new ArrayList<>();
    }
}

public class Main {
    public static void main(String[] args) {
        // Basic data types
        int number = 42;
        double price = 99.99;
        boolean isActive = true;
        String text = "Hello JSON";
        
        // Advanced number types
        BigDecimal preciseNumber = new BigDecimal("123456.789012345");
        Long bigNumber = Long.MAX_VALUE;
        Float floatNumber = 3.14159f;
        
        // Date and Timestamp
        Date currentDate = new Date();
        long timestamp = System.currentTimeMillis();
        LocalDateTime localDateTime = LocalDateTime.now();
        
        // Arrays
        int[] numbers = {1, 2, 3, 4, 5};
        String[] words = {"apple", "banana", "orange"};
        Boolean[][] booleanMatrix = {{true, false}, {false, true}};
        
        // List of students
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("minh", 1));
        studentList.add(new Student("khang", 3));
        studentList.add(new Student("khanh", 6));
        studentList.add(new Student("quynh", 4));
        studentList.add(new Student("tuan", 2));
        studentList.add(new Student("nam", 5));
        studentList.add(new Student("hai", 7));
        studentList.add(new Student("long", 8));
        studentList.add(new Student("hung", 9));
        studentList.add(new Student("hoa", 10));
        
        // Complex nested objects list
        List<StudentDetail> detailedStudents = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Address address = new Address(
                "Street " + i,
                "City " + (i % 3 + 1),
                "Country " + (i % 2 + 1)
            );
            
            List<String> phones = Arrays.asList(
                "+84" + (900000000 + i),
                "+84" + (910000000 + i)
            );
            
            PersonInfo personInfo = new PersonInfo(
                "student" + i + "@example.com",
                address,
                phones
            );
            
            StudentDetail student = new StudentDetail("Student" + i, 20 + i, personInfo);
            
            // Add subject scores
            student.subjectScores.put("Math", Arrays.asList(8.5, 9.0, 8.7));
            student.subjectScores.put("Physics", Arrays.asList(7.5, 8.0, 8.2));
            student.subjectScores.put("Chemistry", Arrays.asList(9.0, 8.5, 9.2));
            
            detailedStudents.add(student);
        }
        
        // Different types of Lists with more elements
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Vector<String> vector = new Vector<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j"));
        Stack<Double> stack = new Stack<>();
        for (double i = 1.0; i <= 10.0; i++) {
            stack.push(i);
        }
        
        // Different types of Maps with more entries
        Map<String, Object> extendedDataMap = new HashMap<>();
        for (int i = 1; i <= 10; i++) {
            extendedDataMap.put("key" + i, "value" + i);
            extendedDataMap.put("number" + i, i * 100);
            extendedDataMap.put("list" + i, Arrays.asList(i, i*2, i*3));
        }
        
        TreeMap<String, Integer> extendedSortedMap = new TreeMap<>();
        for (char c = 'A'; c <= 'J'; c++) {
            extendedSortedMap.put(String.valueOf(c), (int)c);
        }
        
        // Different types of Sets with more elements
        Set<String> extendedUniqueNames = new HashSet<>(Arrays.asList(
            "John", "Jane", "Alice", "Bob", "Charlie",
            "David", "Eve", "Frank", "Grace", "Henry"
        ));
        
        TreeSet<Integer> extendedSortedSet = new TreeSet<>();
        for (int i = 1; i <= 10; i++) {
            extendedSortedSet.add(i * 5);
        }
        
        // Thread-safe collections with more elements
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(20);
        for (int i = 1; i <= 10; i++) {
            blockingQueue.offer("Item " + i);
        }
        
        CopyOnWriteArrayList<String> copyOnWriteList = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= 10; i++) {
            copyOnWriteList.add("CopyOnWrite " + i);
        }
        
        // Complex nested collections
        List<Map<String, Set<StudentDetail>>> complexNestedList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Map<String, Set<StudentDetail>> gradeMap = new HashMap<>();
            Set<StudentDetail> gradeAStudents = new HashSet<>();
            Set<StudentDetail> gradeBStudents = new HashSet<>();
            
            // Chia danh sách thành 2 nhóm, mỗi nhóm 5 sinh viên
            gradeAStudents.addAll(detailedStudents.subList(0, 5));
            gradeBStudents.addAll(detailedStudents.subList(5, 10));
            
            gradeMap.put("A", gradeAStudents);
            gradeMap.put("B", gradeBStudents);
            
            complexNestedList.add(gradeMap);
        }
        
        // Nested Map structure with more elements
        Map<Department, Map<Course, List<StudentDetail>>> departmentCourseStudents = new HashMap<>();
        Department[] departments = {
            new Department("Computer Science", studentList, Status.ACTIVE),
            new Department("Mathematics", studentList, Status.ACTIVE),
            new Department("Physics", studentList, Status.ACTIVE)
        };
        
        for (Department dept : departments) {
            Map<Course, List<StudentDetail>> courseMap = new HashMap<>();
            for (int i = 1; i <= 3; i++) {
                Course course = new Course("Course" + i);
                // Đảm bảo index không vượt quá kích thước của list
                int startIdx = (i-1) * 3;
                int endIdx = Math.min(i * 3, detailedStudents.size());
                courseMap.put(course, detailedStudents.subList(startIdx, endIdx));
            }
            departmentCourseStudents.put(dept, courseMap);
        }
        
        // Different types of Maps
        Map<String, Object> dataMap = new HashMap<>();
        for (int i = 1; i <= 10; i++) {
            dataMap.put("id" + i, i);
            dataMap.put("name" + i, "Test Map " + i);
            dataMap.put("scores" + i, Arrays.asList(95 - i, 87 - i, 91 - i));
        }
        
        TreeMap<String, Integer> sortedMap = new TreeMap<>();
        for (int i = 1; i <= 10; i++) {
            sortedMap.put("Key" + i, i * 100);
        }
        
        LinkedHashMap<Integer, String> orderedMap = new LinkedHashMap<>();
        for (int i = 1; i <= 10; i++) {
            orderedMap.put(i, "Item " + i);
        }
        
        ConcurrentHashMap<String, List<Integer>> threadSafeMap = new ConcurrentHashMap<>();
        for (int i = 1; i <= 10; i++) {
            threadSafeMap.put("thread" + i, Arrays.asList(i, i * 2, i * 3, i * 4));
        }
        
        // Nested Collections
        Map<String, Map<String, List<Integer>>> nestedMap = new HashMap<>();
        for (int i = 1; i <= 5; i++) {
            Map<String, List<Integer>> innerMap = new HashMap<>();
            for (int j = 1; j <= 3; j++) {
                innerMap.put("subject" + j, Arrays.asList(90 + i, 85 + i, 88 + i));
            }
            nestedMap.put("student" + i, innerMap);
        }
        
        // Different types of Sets
        Set<String> uniqueNames = new HashSet<>();
        for (int i = 1; i <= 10; i++) {
            uniqueNames.add("Student" + i);
            uniqueNames.add("Teacher" + i);
        }
        
        TreeSet<Integer> sortedSet = new TreeSet<>();
        for (int i = 1; i <= 15; i++) {
            sortedSet.add(i * 7);
        }
        
        LinkedHashSet<String> orderedSet = new LinkedHashSet<>();
        for (int i = 1; i <= 10; i++) {
            orderedSet.add("Ordered" + i);
        }
        
        // Queue implementations
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 20; i >= 1; i--) {
            priorityQueue.offer(i);
        }
        
        Deque<String> deque = new ArrayDeque<>();
        for (int i = 1; i <= 5; i++) {
            deque.addFirst("First" + i);
            deque.addLast("Last" + i);
        }
        
        // Complex nested structure
        Course javaCourse = new Course("CS101");
        Course pythonCourse = new Course("CS102");
        Course webCourse = new Course("CS103");
        
        Department computerScience = new Department("Computer Science", studentList, Status.ACTIVE);
        Map<Department, List<Course>> departmentCourses = new HashMap<>();
        departmentCourses.put(computerScience, Arrays.asList(javaCourse, pythonCourse, webCourse));
        
        // EnumMap
        EnumMap<Status, List<Student>> statusMap = new EnumMap<>(Status.class);
        List<Student> activeStudents = new ArrayList<>(studentList.subList(0, 4));
        List<Student> inactiveStudents = new ArrayList<>(studentList.subList(4, 7));
        List<Student> pendingStudents = new ArrayList<>(studentList.subList(7, 10));
        statusMap.put(Status.ACTIVE, activeStudents);
        statusMap.put(Status.INACTIVE, inactiveStudents);
        statusMap.put(Status.PENDING, pendingStudents);
        
        // Bit Set with more bits
        BitSet bitSet = new BitSet(32);
        for (int i = 0; i < 32; i += 2) {
            bitSet.set(i);
        }
        
        // Weak collections with more data
        WeakHashMap<String, Object> weakMap = new WeakHashMap<>();
        for (int i = 1; i <= 10; i++) {
            weakMap.put("weak" + i, new BigInteger(String.valueOf(i * 1000000)));
            weakMap.put("ref" + i, new Student("WeakRef" + i, i));
        }
        
        // Stream and Collectors with more data
        Stream<Integer> numberStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> collectedList = numberStream.collect(Collectors.toList());
        
        List<Integer> numberSequence = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            numberSequence.add(i);
        }
        Map<Boolean, List<Integer>> partitionedNumbers = numberSequence.stream()
            .collect(Collectors.partitioningBy(n -> n % 2 == 0));
            
        // Generic container usage with more data
        Container<String> stringContainer = new Container<>("test");
        Container<List<Integer>> listContainer = new Container<>(
            Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        );
        
        // More complex nested structures
        Map<String, Map<LocalDate, Set<Student>>> attendanceRecord = new HashMap<>();
        LocalDate today = LocalDate.now();
        for (int i = 0; i < 5; i++) {
            Map<LocalDate, Set<Student>> dateRecords = new HashMap<>();
            // Đảm bảo index không vượt quá kích thước của list
            int startIdx = i * 2;
            int endIdx = Math.min(startIdx + 5, studentList.size());
            Set<Student> presentStudents = new HashSet<>(studentList.subList(startIdx, endIdx));
            dateRecords.put(today.plusDays(i), presentStudents);
            attendanceRecord.put("Class" + (i + 1), dateRecords);
        }
        
        NavigableMap<Integer, List<String>> navigableMap = new TreeMap<>();
        for (int i = 1; i <= 10; i++) {
            navigableMap.put(i * 100, Arrays.asList(
                "Value" + i + "A",
                "Value" + i + "B",
                "Value" + i + "C"
            ));
        }
        
        // Immutable collections with initial data
        List<String> immutableList = Collections.unmodifiableList(
            Arrays.asList("Immutable1", "Immutable2", "Immutable3", "Immutable4", "Immutable5")
        );
        
        Set<Integer> immutableSet = Collections.unmodifiableSet(
            new HashSet<>(Arrays.asList(100, 200, 300, 400, 500))
        );
        
        Map<String, Integer> tempMap = new HashMap<>();
        for (int i = 1; i <= 5; i++) {
            tempMap.put("ImmutableKey" + i, i * 1000);
        }
        Map<String, Integer> immutableMap = Collections.unmodifiableMap(tempMap);
        
        // Synchronized collections with data
        List<String> syncList = Collections.synchronizedList(
            new ArrayList<>(Arrays.asList("Sync1", "Sync2", "Sync3", "Sync4", "Sync5"))
        );
        
        Set<Integer> syncSet = Collections.synchronizedSet(
            new HashSet<>(Arrays.asList(11, 22, 33, 44, 55, 66, 77, 88, 99, 100))
        );
        
        Map<String, Object> tempSyncMap = new HashMap<>();
        for (int i = 1; i <= 10; i++) {
            tempSyncMap.put("SyncKey" + i, "SyncValue" + i);
        }
        Map<String, Object> syncMap = Collections.synchronizedMap(tempSyncMap);
    }
}