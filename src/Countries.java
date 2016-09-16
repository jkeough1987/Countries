import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Countries {
    public static HashMap<String, ArrayList<Country>> allCountries = new HashMap<>();
    public static ArrayList<Country> countries = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static String Country_File = "_countries.json";
    public static String Countrytxt = "_countries.txt";


    public static void main(String[] args) throws IOException {
        buildMap();
        buildUserList();

    }

    public static void buildUserList() throws IOException {
        System.out.println("Please input the letter the countries start with.");

        boolean a = true;
        while (a) {
            String userLetter = scanner.nextLine();
            if (!(userLetter.isEmpty() || userLetter.length() >= 2)) {

                List newFile = allCountries.get(userLetter);
                writeTxtFile(userLetter + Countrytxt, newFile.toString());
                writeJsonFile(userLetter + Country_File, newFile.toString());
                System.out.println("Your file has been created!!");
                a = false;
            } else {
                System.out.println("Invalid letter");
            }
        }


    }

    static void writeTxtFile(String fileName, String fileContent) throws IOException {
        File f = new File(fileName);
        FileWriter fw = new FileWriter(f);
        fw.write(String.valueOf(fileContent)); // overwrites file
        fw.close();
    }

    static void writeJsonFile(String fileName, String fileContent) throws IOException {
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.serialize(fileContent);
        File Countries_File = new File(fileName);
        FileWriter fw = new FileWriter(Countries_File);
        fw.write(json);
        fw.close();
    }

    static void buildMap() throws FileNotFoundException {
        File f = new File("countries.txt");
        Scanner fileScanner = new Scanner(f);
        Country country;

        while (fileScanner.hasNext()) {
            String key;
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\|");
            country = new Country(columns[0], columns[1]);
            key = country.getName().substring(0, 1);
            if (country.getName().startsWith(key)) {
                if (allCountries.containsKey(key)) {
                    countries = allCountries.get(key);
                    countries.add(country);
                } else {
                    countries = new ArrayList<>();
                    countries.add(country);
                    allCountries.put(key, countries);

                }
            }


        }
    }


}
