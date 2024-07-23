
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

class Student implements Comparable<Student> {
    private final String name;
    private final int korean_point;
    private final int english_point;
    private final int math_point;

    public Student(String name, int korean_point, int english_point, int math_point) {
        this.name = name;
        this.korean_point = korean_point;
        this.english_point = english_point;
        this.math_point = math_point;
    }

    public String getName() {
        return this.name;
    }

    public int getKoreanPoint() {
        return korean_point;
    }

    public int getEnglishPoint() {
        return english_point;
    }

    public int getMathPoint() {
        return math_point;
    }

    @Override
    public int compareTo(Student o) {
        // 국어점수 내림차순, 영어점수 오름차순, 수학점수 내림차순, 이름 오름차순
        if (this.korean_point != o.korean_point) {
            return o.korean_point - this.korean_point;
        } else if (this.english_point != o.english_point) {
            return this.english_point - o.english_point;
        } else if (this.math_point != o.math_point) {
            return o.math_point - this.math_point;
        } else {
            return this.name.compareTo(o.name);
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(reader.readLine());

        Student[] students = new Student[cnt];

        for (int i = 0; i < cnt; i++) {
            String[] s = reader.readLine().split(" ");
            students[i] = new Student(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]), Integer.parseInt(s[3]));
        }

        Arrays.sort(students);

        for (Student student : students) {
            System.out.println(student.getName());
        }
    }
}
