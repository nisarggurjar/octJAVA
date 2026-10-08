interface Printable {
    void print(); // implicitly public abstract
}

interface Exportable {
    void exportToPdf(String destinationPath);
}

// A single class implementing multiple interfaces
class FinancialReport implements Printable, Exportable {
    private String reportId;

    public FinancialReport(String reportId) {
        this.reportId = reportId;
    }

    @Override
    public void print() {
        System.out.println("Printing physical paper copy of report: " + reportId);
    }

    @Override
    public void exportToPdf(String destinationPath) {
        System.out.println("Exported report " + reportId + " to PDF at: " + destinationPath);
    }
}

public class MultipleInterfacesDemo {
    public static void main(String[] args) {
        FinancialReport report = new FinancialReport("Q3-FIN-2026");

        // Can be referenced via either interface type
        Printable p = report;
        p.print();

        Exportable e = report;
        e.exportToPdf("/var/reports/q3.pdf");
    }
}