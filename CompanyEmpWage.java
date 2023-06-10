package com.bridgelabz.assignment;

import java.util.Random;

public class CompanyEmpWage
{
    private String companyName;
    private int wagePerHour;
    private int fullDayHours;
    private int partTimeHours;
    private int workingDaysPerMonth;

    public CompanyEmpWage(String companyName, int wagePerHour, int fullDayHours, int partTimeHours, int workingDaysPerMonth) {
        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.fullDayHours = fullDayHours;
        this.partTimeHours = partTimeHours;
        this.workingDaysPerMonth = workingDaysPerMonth;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getWagePerHour() {
        return wagePerHour;
    }

    public int getFullDayHours() {
        return fullDayHours;
    }

    public int getPartTimeHours() {
        return partTimeHours;
    }

    public int getWorkingDaysPerMonth() {
        return workingDaysPerMonth;
    }
}

class EmpWageBuilder {
    private CompanyEmpWage[] companies;
    private int numOfCompanies;

    public EmpWageBuilder() {
        companies = new CompanyEmpWage[5]; // Assuming maximum 5 companies
        numOfCompanies = 0;
    }

    public void addCompanyEmpWage(String companyName, int wagePerHour, int fullDayHours, int partTimeHours, int workingDaysPerMonth) {
        CompanyEmpWage companyEmpWage = new CompanyEmpWage(companyName, wagePerHour, fullDayHours, partTimeHours, workingDaysPerMonth);
        companies[numOfCompanies] = companyEmpWage;
        numOfCompanies++;
    }

    public void computeEmpWage() {
        for (int i = 0; i < numOfCompanies; i++) {
            CompanyEmpWage company = companies[i];
            int totalWage = 0;
            int totalHours = 0;

            for (int day = 1; day <= company.getWorkingDaysPerMonth(); day++) {
                int employeeAttendance = getRandomAttendance(); // 0 - Absent, 1 - Present, 2 - Part-time

                int dailyWage = 0;
                int workingHours = 0;

                switch (employeeAttendance) {
                    case 0:
                        System.out.println("Day " + day + ": " + company.getCompanyName() + " Employee is Absent");
                        break;
                    case 1:
                        System.out.println("Day " + day + ": " + company.getCompanyName() + " Employee is Present");
                        workingHours = company.getFullDayHours();
                        break;
                    case 2:
                        System.out.println("Day " + day + ": " + company.getCompanyName() + " Employee is Part-time");
                        workingHours = company.getPartTimeHours();
                        break;
                    default:
                        System.out.println("Invalid attendance");
                        break;
                }

                dailyWage = workingHours * company.getWagePerHour();
                totalWage += dailyWage;
                totalHours += workingHours;
            }

            System.out.println("Total working hours for " + company.getCompanyName() + ": " + totalHours);
            System.out.println("Total wage for " + company.getCompanyName() + ": " + totalWage);
        }
    }

    public static int getRandomAttendance() {
        Random random = new Random();
        return random.nextInt(3); 
    }
}

public class EmployeesWageComputation {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");

        EmpWageBuilder empWageBuilder = new EmpWageBuilder();
        empWageBuilder.addCompanyEmpWage("ABC Company", 20, 8, 4, 20); // Example company details
        empWageBuilder.addCompanyEmpWage("XYZ Company", 22, 9, 5, 22); // Example company details

        empWageBuilder.computeEmpWage();
    }
}

