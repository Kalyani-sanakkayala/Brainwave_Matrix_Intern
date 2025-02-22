import java.util.*;

class HospitalManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static List<Patient> patients = new ArrayList<>();
    static List<Appointment> appointments = new ArrayList<>();
    static List<Billing> bills = new ArrayList<>();

    static class Patient {
        String id, name, age, disease;

        public Patient(String id, String name, String age, String disease) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.disease = disease;
        }

        public void displayPatient() {
            System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Disease: " + disease);
        }
    }

    class Hospital {
        public static void registerPatient() {
            System.out.print("Enter Patient ID: ");
            String id = sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Age: ");
            String age = sc.nextLine();
            System.out.print("Enter Disease: ");
            String disease = sc.nextLine();
            patients.add(new Patient(id, name, age, disease));
            System.out.println("Patient Registered Successfully!");
        }

        public static void scheduleAppointment() {
            System.out.print("Enter Appointment ID: ");
            String appointmentId = sc.nextLine();
            System.out.print("Enter Patient ID: ");
            String patientId = sc.nextLine();
            System.out.print("Enter Doctor Name: ");
            String doctorName = sc.nextLine();
            System.out.print("Enter Date (YYYY-MM-DD): ");
            String date = sc.nextLine();
            appointments.add(new Appointment(appointmentId, patientId, doctorName, date));
            System.out.println("Appointment Scheduled Successfully!");
        }

        public static void generateBill() {
            System.out.print("Enter Bill ID: ");
            String billId = sc.nextLine();
            System.out.print("Enter Patient ID: ");
            String patientId = sc.nextLine();
            System.out.print("Enter Amount: ");
            double amount = sc.nextDouble();
            sc.nextLine();
            bills.add(new Billing(billId, patientId, amount));
            System.out.println("Bill Generated Successfully!");
        }

        public static void viewPatients() {
            System.out.println("\nRegistered Patients:");
            for (Patient p : patients)
                p.displayPatient();
        }

        public static void viewAppointments() {
            System.out.println("\nScheduled Appointments:");
            for (Appointment a : appointments)
                a.displayAppointment();
        }

        public static void viewBills() {
            System.out.println("\nGenerated Bills:");
            for (Billing b : bills)
                b.displayBill();
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println(
                    "\n1. Register Patient\n2. Schedule Appointment\n3. Generate Bill\n4. View Patients\n5. View Appointments\n6. View Bills\n7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    Hospital.registerPatient();
                    break;
                case 2:
                    Hospital.scheduleAppointment();
                    break;
                case 3:
                    Hospital.generateBill();
                    break;
                case 4:
                    Hospital.viewPatients();
                    break;
                case 5:
                    Hospital.viewAppointments();
                    break;
                case 6:
                    Hospital.viewBills();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static class Appointment {
        String appointmentId, patientId, doctorName, date;

        public Appointment(String appointmentId, String patientId, String doctorName, String date) {
            this.appointmentId = appointmentId;
            this.patientId = patientId;
            this.doctorName = doctorName;
            this.date = date;
        }

        public void displayAppointment() {
            System.out.println("Appointment ID: " + appointmentId + ", Patient ID: " + patientId + ", Doctor: "
                    + doctorName + ", Date: " + date);
        }
    }

    static class Billing {
        String billId, patientId;
        double amount;

        public Billing(String billId, String patientId, double amount) {
            this.billId = billId;
            this.patientId = patientId;
            this.amount = amount;
        }

        public void displayBill() {
            System.out.println("Bill ID: " + billId + ", Patient ID: " + patientId + ", Amount: " + amount);
        }
    }
}