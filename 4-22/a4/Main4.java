package a4;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main4 {

    public static void main(String[] args) {

        try {
            // JSONファイルを読み込む
            String json = Files.readString(
                Path.of("a4/exercise.json")
            );

            // Gsonオブジェクトを作成
            Gson gson = new Gson();

            // JSONをEmployeeオブジェクトに変換
            Employee employee = gson.fromJson(json, Employee.class);

            // Employeeオブジェクトの情報を表示
            System.out.println("Name: " + employee.getName());
            System.out.println("Age: " + employee.getAge());
            System.out.println("Salary: " + (int) employee.getSalary());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}