package studentsystem;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cstuser
 */
public class StudentLoader {
    public static void testLoad(String pathStr) throws IOException {
        StudentLoader stLoader = new StudentLoader();
        final ArrayList<Student> students = stLoader.load(Paths.get(pathStr));
        for (final Student st : students) {
            String id = st.getId();
            String name = st.getName();
//                        if (id == null) {
//                            System.out.println("id null");
//                        }
//                        if (name == null) {
//                            System.out.println("name null");
//                        }
            System.out.println(st.getId() + " " + st.getName());
        }
    }
    
    public ArrayList<Student> load(Path path) throws IOException {
        final ArrayList<Student> result = new ArrayList<>();
        try (final Scanner fileReader = new Scanner(path)) {
            while (fileReader.hasNext()) {
                String stId = fileReader.next();
                String stName = fileReader.next();
//                System.out.println("stId:" + stId);
//                System.out.println("stName" + stName);
                result.add(new Student(stId, stName));

            }
 
        }
        return result;
    }
    
}
