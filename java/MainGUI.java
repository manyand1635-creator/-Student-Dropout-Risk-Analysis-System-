import javax.swing.*;
import java.awt.*;

/* =======================
   ABSTRACT RISK FACTOR
   ======================= */
abstract class RiskFactor {
    protected int riskScore;
    abstract int evaluateRisk();
}

/* =======================
   ATTENDANCE RISK
   ======================= */
class AttendanceRisk extends RiskFactor {
    private int attendancePercentage;

    public AttendanceRisk(int attendancePercentage) {
        this.attendancePercentage = attendancePercentage;
    }

    int evaluateRisk() {
        if (attendancePercentage < 60)
            riskScore = 80;
        else if (attendancePercentage < 75)
            riskScore = 50;
        else
            riskScore = 20;

        return riskScore;
    }
}

/* =======================
   MARKS RISK
   ======================= */
class MarksRisk extends RiskFactor {
    private int averageMarks;

    public MarksRisk(int averageMarks) {
        this.averageMarks = averageMarks;
    }

    int evaluateRisk() {
        if (averageMarks < 40)
            riskScore = 85;
        else if (averageMarks < 60)
            riskScore = 55;
        else
            riskScore = 25;

        return riskScore;
    }
}

/* =======================
   FINANCIAL RISK
   ======================= */
class FinancialRisk extends RiskFactor {
    private boolean financialProblem;

    public FinancialRisk(boolean financialProblem) {
        this.financialProblem = financialProblem;
    }

    int evaluateRisk() {
        riskScore = financialProblem ? 75 : 20;
        return riskScore;
    }
}

/* =======================
   STUDENT CLASS
   ======================= */
class Student {
    private String name;
    private RiskFactor[] risks;
    private boolean attendanceIssue = false;
    private boolean marksIssue = false;
    private boolean financialProblem;

    public Student(String name, RiskFactor[] risks, boolean financialProblem) {
        this.name = name;
        this.risks = risks;
        this.financialProblem = financialProblem;
    }

    public String analyzeAndPrevent() {
        int totalRisk = 0;

        for (RiskFactor risk : risks) {
            int score = risk.evaluateRisk();
            totalRisk += score;

            if (risk instanceof AttendanceRisk && score >= 50)
                attendanceIssue = true;

            if (risk instanceof MarksRisk && score >= 50)
                marksIssue = true;
        }

        int avgRisk = totalRisk / risks.length;
        StringBuilder result = new StringBuilder();

        result.append("----- DROPOUT RISK ANALYSIS -----\n");
        result.append("Student Name: ").append(name).append("\n");
        result.append("Overall Risk Score: ").append(avgRisk).append("\n");

        if (avgRisk >= 70)
            result.append("Final Status: HIGH RISK\n");
        else if (avgRisk >= 40)
            result.append("Final Status: MEDIUM RISK\n");
        else
            result.append("Final Status: LOW RISK\n");

        result.append("\n----- PREVENTION MEASURES -----\n");

        if (attendanceIssue)
            result.append("• Strict attendance monitoring\n");

        if (marksIssue)
            result.append("• Academic counseling scheduled\n");

        if (financialProblem)
            result.append("• Financial aid support recommended\n");

        if (!attendanceIssue && !marksIssue && !financialProblem && avgRisk < 40)
            result.append("• Student performing well, no intervention required\n");

        return result.toString();
    }
}

/* =======================
   GUI MAIN CLASS
   ======================= */
public class MainGUI extends JFrame {

    JTextField nameField, attendanceField, marksField;
    JCheckBox financeCheck;
    JTextArea outputArea;

    public MainGUI() {
        setTitle("Student Dropout Risk Analysis System");
        setSize(500, 500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));

        inputPanel.add(new JLabel("Student Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Attendance Percentage:"));
        attendanceField = new JTextField();
        inputPanel.add(attendanceField);

        inputPanel.add(new JLabel("Average Marks:"));
        marksField = new JTextField();
        inputPanel.add(marksField);

        inputPanel.add(new JLabel("Financial Problem:"));
        financeCheck = new JCheckBox("Yes");
        inputPanel.add(financeCheck);

        JButton analyzeBtn = new JButton("Analyze Risk");
        inputPanel.add(analyzeBtn);

        add(inputPanel, BorderLayout.NORTH);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        analyzeBtn.addActionListener(e -> analyze());

        setVisible(true);
    }

    private void analyze() {
        try {
            String name = nameField.getText();
            int attendance = Integer.parseInt(attendanceField.getText());
            int marks = Integer.parseInt(marksField.getText());
            boolean finance = financeCheck.isSelected();

            RiskFactor[] risks = {
                new AttendanceRisk(attendance),
                new MarksRisk(marks),
                new FinancialRisk(finance)
            };

            Student student = new Student(name, risks, finance);
            outputArea.setText(student.analyzeAndPrevent());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid inputs!");
        }
    }

    public static void main(String[] args) {
        new MainGUI();
    }
}