package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Iva1nov", new Asset("home", 929_999.99), new Asset("car", 2999.99));
//            Human ivanov = new Human(null, null);
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

//        public void save(OutputStream outputStream) throws Exception {
//            OutputStreamWriter writer = new OutputStreamWriter(outputStream);
//            if(this.name!=null)
//            writer.write(this.name+"\n");
//            for (Asset a:this.assets) {
//                writer.write(a.getName()+" "+a.getPrice()+"\n");
//            }
//            writer.flush();
//        }

//        public void load(InputStream inputStream) throws Exception {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//            if(reader.ready())
//            this.name = reader.readLine();
//            while (reader.ready()){
//                String str =reader.readLine();
//                Pattern p = Pattern.compile("([\\s\\S]+?)\\s([0-9]+\\.?[0-9]*)");
//                Matcher m = p.matcher(str);
//                if(m.find()){
//                    this.assets.add(new Asset(m.group(1),Double.parseDouble(m.group(2))));
//                }
//            }
//
//        }

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);
            if(assets.size() == 0){
                writer.print(name);
                writer.flush();
            } else {
                writer.println(name);
                writer.flush();
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i <= assets.size()-1; i++){
                    if(i <= assets.size()-2){
                        sb.append(assets.get(i).getName() + " " + assets.get(i).getPrice() + ";");
                    } else {
                        sb.append(assets.get(i).getName() + " " + assets.get(i).getPrice());
                    }
                }
                writer.print(sb.toString());
                writer.flush();
            }
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String name = br.readLine();
            this.name = name;
            if(br.ready()){
                String[] loadAssets = br.readLine().split("\\;");
                for(String asset : loadAssets){
                    String[] as = asset.split(" ");
                    String assetName = as[0];
                    double assetValue = Double.parseDouble(as[1]);
                    assets.add(new Asset(assetName, assetValue));
                }
            }
            br.close();
        }

    }
}
