# 🎓 Student Dropout Risk Analysis System

A Java-based desktop application that predicts a student's dropout risk based on **attendance, academic performance, and financial conditions**. The project provides a simple graphical user interface (GUI) using Java Swing and recommends preventive measures based on the calculated risk level. The system uses object-oriented programming concepts such as abstraction, inheritance, polymorphism, and encapsulation.

---

## 📌 Features

- Student information input through Java Swing GUI
- Attendance risk evaluation
- Academic marks risk evaluation
- Financial risk evaluation
- Overall dropout risk prediction
- Risk classification:
  - 🟢 Low Risk
  - 🟡 Medium Risk
  - 🔴 High Risk
- Personalized prevention recommendations
- Input validation with error handling

---

## 🛠 Technologies Used

- Java
- Java Swing (GUI)
- Object-Oriented Programming (OOP)

---

## 📂 Project Structure

```
Student-Dropout-Risk-Analysis/
│
├── MainGUI.java
├── AttendanceRisk.class
├── MarksRisk.class
├── FinancialRisk.class
├── RiskFactor.class
├── Student.class
└── README.md
```

---

## 🧩 OOP Concepts Implemented

### Abstraction
- `RiskFactor` is an abstract class that defines the common behavior for different risk factors.

### Inheritance
- `AttendanceRisk`
- `MarksRisk`
- `FinancialRisk`

extend the `RiskFactor` class.

### Polymorphism
Different risk objects override the `evaluateRisk()` method to calculate their own risk scores.

### Encapsulation
The `Student` class stores student details and performs risk analysis internally.

---

## 🚀 How It Works

1. Enter:
   - Student Name
   - Attendance Percentage
   - Average Marks
   - Financial Problem (Yes/No)

2. Click **Analyze Risk**.

3. The system:
   - Calculates attendance risk
   - Calculates academic risk
   - Calculates financial risk
   - Computes the overall risk score
   - Displays the student's risk level
   - Suggests preventive measures

---

## 📊 Risk Evaluation Criteria

### Attendance

| Attendance | Risk Score |
|------------|-----------:|
| < 60% | 80 |
| 60–74% | 50 |
| ≥ 75% | 20 |

### Marks

| Average Marks | Risk Score |
|--------------|-----------:|
| < 40 | 85 |
| 40–59 | 55 |
| ≥ 60 | 25 |

### Financial Status

| Financial Problem | Risk Score |
|------------------|-----------:|
| Yes | 75 |
| No | 20 |

### Final Risk Level

| Average Risk Score | Status |
|-------------------|--------|
| ≥ 70 | High Risk |
| 40–69 | Medium Risk |
| < 40 | Low Risk |

---

## 💡 Prevention Measures

Depending on the identified risk factors, the system recommends:

- Strict attendance monitoring
- Academic counseling
- Financial aid support
- No intervention required for low-risk students

---

## ▶️ Running the Project

### Compile

```bash
javac MainGUI.java
```

### Run

```bash
java MainGUI
```

---

## 📷 Application Interface

The GUI includes:

- Student Name field
- Attendance Percentage
- Average Marks
- Financial Problem checkbox
- Analyze Risk button
- Output area displaying:
  - Overall Risk Score
  - Risk Status
  - Prevention Recommendations

---

## 📈 Sample Output

```
----- DROPOUT RISK ANALYSIS -----

Student Name: Rahul

Overall Risk Score: 68

Final Status: MEDIUM RISK

----- PREVENTION MEASURES -----

• Strict attendance monitoring
• Academic counseling scheduled
```

---

## 🎯 Future Enhancements

- Database integration (MySQL/SQLite)
- Student login system
- Admin dashboard
- Machine Learning-based prediction
- PDF report generation
- Charts and analytics
- Email/SMS alerts for at-risk students
## 📜 License

This project is intended for educational and academic purposes.
