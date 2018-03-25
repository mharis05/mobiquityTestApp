package employeeManagementTestSuite.utils;

import java.util.*;

public class DataGenerator {

    private static Random random = new Random();
    private static String firstName;
    private static int nameMax = 1000;
    private static int nameMin = 1;
    private static String namePostFix;

    private static void generatePostFixForName(){
        namePostFix = String.valueOf(random.nextInt((nameMax - nameMin) + 1) + nameMin);
    }

    private static String generateFirstName() {
        generatePostFixForName();
        firstName = "FirstName" + namePostFix;
        return firstName;
    }

    private static String generateEmail() {
        if (firstName == null) {
            generateFirstName();
        }
        return firstName + "@test.com";
    }

    private static String generateStartDate() {
        int maxDay = 28;
        int minDay = 1;
        int maxMonth = 12;
        int minMonth = 1;
        int minYear = 1900;             //Although it sounds a bit unrealistic to join in the past, lets just go with it :)
        int maxYear = 2099;
        String day = String.format("%02d",random.nextInt((maxDay - minDay) + 1) + minDay);
        String month = String.format("%02d",random.nextInt((maxMonth - minMonth) + 1) + minMonth);
        String year = String.format("%04d",random.nextInt((maxYear - minYear) + 1) + minYear);
        return year + "-" + month + "-" + day;
    }

    private static String generateLastName() {
        return "LastName" + namePostFix;
    }

    public static List<Map<String, String>> setActualValues(List<Map<String, String>> employeeDetailsMap) {

        Map<String, String> newEmployeeDetailTable = new HashMap<String, String>(employeeDetailsMap.get(0));
        List<Map<String, String>> newTable = new ArrayList<Map<String, String>>();

        if(newEmployeeDetailTable.containsKey("First Name")){
            newEmployeeDetailTable.put("First Name",DataGenerator.generateFirstName());
        }
        if(newEmployeeDetailTable.containsKey("Last Name")){
            newEmployeeDetailTable.put("Last Name",DataGenerator.generateLastName());
        }
        if(newEmployeeDetailTable.containsKey("Start Date")){
            newEmployeeDetailTable.put("Start Date",DataGenerator.generateStartDate());
        }
        if(newEmployeeDetailTable.containsKey("Invalid Start Date")){
            newEmployeeDetailTable.put("Start Date",DataGenerator.generateInvalidStartDate());
        }
        if(newEmployeeDetailTable.containsKey("Email")) {
            newEmployeeDetailTable.put("Email", DataGenerator.generateEmail());
        }
        if(newEmployeeDetailTable.containsKey("Invalid Email")) {
            newEmployeeDetailTable.put("Email", DataGenerator.generateInvalidEmail());
        }

        newTable.add(newEmployeeDetailTable);

        return newTable;
    }

    private static String generateInvalidEmail() {
        return "test@test@com";
    }

    private static String generateInvalidStartDate() {
        return "2018-13-32";
    }
}
