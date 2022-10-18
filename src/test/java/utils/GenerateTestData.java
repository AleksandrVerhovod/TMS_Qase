package utils;

import com.github.javafaker.Faker;
import constants.dropdownoptions.*;

import java.util.List;
import java.util.Random;

public class GenerateTestData {

    public static Faker faker;

    public static int getRandomIndex(int listSize) {
        Random random = new Random();
        return random.nextInt(listSize);
    }

    public static String getMilestoneQase() {
        List<String> milestones = MilestonesQase.getMelistonesQase();
        return milestones.get(getRandomIndex(milestones.size()));
    }

    public static String getSeverity() {
        List<String> severity = Severity.getSeverity();
        return severity.get(getRandomIndex(severity.size()));
    }


    public static String getRoleUser() {
        List<String> roleUser = Role.getRole();
        return roleUser.get(getRandomIndex(roleUser.size()));
    }

    public static String getStatusTestCase() {
        List<String> status = StatusTestCase.getStatus();
        return status.get(getRandomIndex(status.size()));
    }

    public static String getSuiteTestCase() {
        List<String> suite = SuiteForTestCase.getSuite();
        return suite.get(getRandomIndex(suite.size()));
    }

    public static String getPriorityTestCase() {
        List<String> priority = Priority.getPriority();
        return priority.get(getRandomIndex(priority.size()));
    }

    public static String getTypeTestCase() {
        List<String> type = Type.getType();
        return type.get(getRandomIndex(type.size()));
    }

    public static String getLayerTestCase() {
        List<String> layer = Layer.getLayer();
        return layer.get(getRandomIndex(layer.size()));
    }

    public static String getIsMilestoneDemo() {
        List<String> milestone = MilestonesDemo.getMelistonesDemo();
        return milestone.get(getRandomIndex(milestone.size()));
    }

    public static String getIsFlakyTestCase() {
        List<String> flaky = IsFlaky.getIsFlaky();
        return flaky.get(getRandomIndex(flaky.size()));
    }

    public static String getBehaviorTestCase() {
        List<String> behavior = Behavior.getBehavior();
        return behavior.get(getRandomIndex(behavior.size()));
    }

    public static String getAutomationStatusTestCase() {
        List<String> autoStatus = AutomationStatus.getAutomationStatus();
        return autoStatus.get(getRandomIndex(autoStatus.size()));
    }

    public static String getParent() {
        List<String> parent = ParentRequirements.getParent();
        return parent.get(getRandomIndex(parent.size()));
    }

    public static String getPlan() {
        List<String> plan = PlanTestRun.getPlan();
        return plan.get(getRandomIndex(plan.size()));
    }

    public static String getEnvironment() {
        List<String> environment = EnvironmentTestRun.getEnvironment();
        return environment.get(getRandomIndex(environment.size()));
    }

    public static String getDefaultAssignee() {
        List<String> assignee = DefaultAssignee.getAssignee();
        return assignee.get(getRandomIndex(assignee.size()));
    }

    public static String getStatusReq() {
        List<String> status = StatusRequirements.getStatusReq();
        return status.get(getRandomIndex(status.size()));
    }

    public static String getTypeReq() {
        List<String> type = TypeRequirement.getTypeReq();
        return type.get(getRandomIndex(type.size()));
    }

    public static String getEmail() {
        List<String> email = Emails.getEmail();
        return email.get(getRandomIndex(email.size()));
    }

    public static String generateEmail() {
        faker = new Faker();
        return faker.letterify("???????????@gmail.com");
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

    public static String generateRoleTitle() {
        faker = new Faker();
        return faker.job().position();
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

    public static String generateTitle() {
        faker = new Faker();
        return faker.gameOfThrones().house();
    }

    public static String generateDescription() {
        faker = new Faker();
        return faker.chuckNorris().fact();
    }

    public static String generatePreConditions() {
        faker = new Faker();
        return faker.pokemon().location();
    }

    public static String generatePostConditions() {
        faker = new Faker();
        return faker.harryPotter().character();
    }

    public static String generateActionStepTestCase() {
        faker = new Faker();
        return faker.funnyName().name();
    }

    public static String generateDataStepTestCase() {
        faker = new Faker();
        return String.valueOf(faker.date().birthday());
    }

    public static String generateExpectedResultTestCase() {
        faker = new Faker();
        return faker.chuckNorris().fact();
    }


    public static String generateAPItitle() {
        faker = new Faker();
        return faker.funnyName().name();
    }

    public static String generateAPIcode() {
        faker = new Faker();
        return faker.code().asin();
    }

    public static String generateAPIDescription() {
        faker = new Faker();
        return faker.chuckNorris().fact();
    }
}
