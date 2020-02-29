package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.users.add(new User());
            javaRush.users.get(0).setMale(false);
            javaRush.users.get(0).setLastName("asd");
            javaRush.users.get(0).setFirstName("Asddsa");
            javaRush.users.get(0).setBirthDate(new Date(123123));
            javaRush.users.get(0).setCountry(User.Country.RUSSIA);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the codeGym object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintStream printStream = new PrintStream(outputStream);
            if (users == null) {
                printStream.println("@null");
                return;
            }else printStream.println("@notNull");
            for (User u : users) {

                 if (u.getFirstName()==null)
                     printStream.println("@null");
                 else printStream.println(u.getFirstName());

                 if (u.getLastName()==null)
                     printStream.println("@null");
                 else printStream.println(u.getLastName());

                 if (u.getBirthDate()==null)
                     printStream.println("@null");
                 else printStream.println(u.getBirthDate().getTime());

                 printStream.println(u.isMale());

                if (u.getCountry()==null)
                    printStream.println("@null");
                else printStream.println(u.getCountry());
            }
            printStream.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader =new BufferedReader(new InputStreamReader(inputStream));
            String str = reader.readLine();
            if (str.equals("@null")){
                users = null;
                return;
            }
            while (reader.ready()){
                User u = new User();
                str = reader.readLine();
                u.setFirstName(str.equals("@null") ? null : str);
                str = reader.readLine();
                u.setLastName(str.equals("@null") ? null : str);
                str = reader.readLine();
                u.setBirthDate(str.equals("@null") ? null : new Date(Long.parseLong(str)));
                str = reader.readLine();
                u.setMale(str.equals("true") ? true : false);
                str = reader.readLine();
                u.setCountry(str.equals("@null") ? null : User.Country.valueOf(str));
                users.add(u);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
