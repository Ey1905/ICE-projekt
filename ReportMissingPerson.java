public class ReportMissingPerson {
    private static int reportCounter = 1;
    private int reportId;
    private MissingPerson missingPerson;
    private User user;
    private String reportLocation;
    private String reportDate;
    private String additionalInfo;

    // Constructor
    public ReportMissingPerson(MissingPerson missingPerson, User user, String reportLocation, String reportDate, String additionalInfo) {
        this. reportId = reportCounter++;
        this.missingPerson = missingPerson;
        this.user = user;
        this.reportLocation = reportLocation;
        this.reportDate = reportDate;
        this.additionalInfo = additionalInfo;
    }

    // Getter
    public int getReportId() {
        return reportId;
    }

    public MissingPerson getMissingPerson() {
        return missingPerson;
    }

    public User getUser() {
        return user;
    }

    public String getReportLocation() {
        return reportLocation;
    }

    public String getReportDate() {
        return reportDate;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    // toString
    @Override
    public String toString() {
        return "Report [Report ID: " + reportId + ", Missing Person: " + missingPerson.getFirstName() + " " + missingPerson.getLastName()
                + ", Reported by: " + user.getUsername() + ", Location: " + reportLocation
                + ", Date: " + reportDate + ", Additional Info: " + additionalInfo + "]";
    }
}