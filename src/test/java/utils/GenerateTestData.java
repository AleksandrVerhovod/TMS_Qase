package utils;

import com.github.javafaker.Faker;
import constants.dropdownoptions.Milestones;
import constants.dropdownoptions.Severity;

import java.util.List;
import java.util.Random;

public class GenerateTestData {

    public static Faker faker;

    public static int getRandomIndex(int listSize) {
        Random random = new Random();
        return random.nextInt(listSize);
    }

    public static String getMilestone () {
        List<String> milestones = Milestones.getMelistones();
                return milestones.get(getRandomIndex(milestones.size()));
    }

    public static String getSeverity () {
        List<String> severity = Severity.getSeverity();
        return severity.get(getRandomIndex(severity.size()));
    }


    public static String generateEmail() {
        faker = new Faker();
        return faker.internet().emailAddress();
    }

    public static String generatePassword() {
        faker = new Faker();
        return faker.letterify("????????@1");
    }

    public static String generateFullName() {
        faker = new Faker();
        return faker.name().fullName();
    }
    public static String generateJob() {
        faker = new Faker();
        return faker.job().title();
    }

    public static String generateCompanyName() {
        faker = new Faker();
        return faker.company().name();
    }

    public static String generateWorkEmail() {
        faker = new Faker();
        return faker.internet().emailAddress();
    }
    public static String generateProjectName() {
        faker = new Faker();
        return faker.funnyName().name();
    }
    public static String generateProjectCode() {
        faker = new Faker();
        return faker.letterify("?????");
    }

    public static String generateDescriptionProject() {
        faker = new Faker();
        return faker.chuckNorris().fact();
    }

    public static String generateDefectTitle() {
        faker = new Faker();
        return faker.gameOfThrones().house();
    }

    public static String generateActualResultDefect() {
        faker = new Faker();
        return faker.chuckNorris().fact();
    }

    public static String generateTagsDefect() {
        faker = new Faker();
        return faker.letterify("#????????");
    }





}
