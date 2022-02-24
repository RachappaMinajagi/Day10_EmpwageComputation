package empwage_10;

interface IEmployeeWageComputation {
	public void addCompany(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs);

	public void calculateTotalWage();
}

class CompanyEmpWage {

	final String COMPANY_NAME; // instance constants
	final int WAGE_PER_HR;
	final int MAX_WORKING_DAYS;
	final int MAX_WORKING_HRS;

	int totalEmpWage;

	CompanyEmpWage(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs) {
		COMPANY_NAME = companyName;
		WAGE_PER_HR = wagePerHr; // instance variable
		MAX_WORKING_DAYS = maxWorkingDays;
		MAX_WORKING_HRS = maxWorkingHrs;
		totalEmpWage = 0;
	}

	void setTotalEmployeeWage(int totalEmpWage) {
		this.totalEmpWage = totalEmpWage;
	}

	@Override
	public String toString() {
		System.out.println("Details of " + COMPANY_NAME + " Employee");
		System.out.println("..........................................");
		System.out.println("Wage per hour:" + WAGE_PER_HR);
		System.out.println("Maximum working days:" + MAX_WORKING_DAYS);
		System.out.println("Maximum working hours:" + MAX_WORKING_HRS);
		return "Total wage for a month of " + COMPANY_NAME + " employee is " + totalEmpWage + "\n";
	}
}

class EmpWage implements IEmployeeWageComputation {
	// class constants
	public static final int PART_TIME = 1;
	public static final int FULL_TIME = 2;
	// instance variables
	int noOfCompanies, index;
	CompanyEmpWage[] companies;

	public EmpWage(int noOfCompanies) {
		this.noOfCompanies = noOfCompanies;
		companies = new CompanyEmpWage[noOfCompanies];
		index = 0;
	}

	public void addCompany(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs) {
		companies[index++] = new CompanyEmpWage(companyName, wagePerHr, maxWorkingDays, maxWorkingHrs);
	}

	int generateEmployeeType() {
		return (int) (Math.random() * 100) % 3;
	}

	int getWorkingHrs(int empType) {
		switch (empType) {
		case FULL_TIME:
			return 8;
		case PART_TIME:
			return 4;
		default:
			return 0;
		}
	}

	public void calculateTotalWage() {
		for (CompanyEmpWage company : companies) {
			int totalWage = calculateTotalWage(company);
			company.setTotalEmployeeWage(totalWage);
			System.out.println(company);
		}
	}

	int calculateTotalWage(CompanyEmpWage companyEmpWage) {
		System.out.println("Computation of total wage of " + companyEmpWage.COMPANY_NAME + " employee");

		int workingHrs, totalWage = 0;
		for (int day = 1, totalWorkingHrs = 0; day <= companyEmpWage.MAX_WORKING_DAYS
				&& totalWorkingHrs <= companyEmpWage.MAX_WORKING_HRS; day++, totalWorkingHrs += workingHrs) {
			int empType = generateEmployeeType();
			workingHrs = getWorkingHrs(empType);
			int wage = workingHrs * companyEmpWage.WAGE_PER_HR;
			totalWage += wage;

		}
		return totalWage;
	}

	public static void main(String args[]) {
		EmpWage employeeWageComputation = new EmpWage(3);
		employeeWageComputation.addCompany("TCS", 3, 30, 50);
		employeeWageComputation.addCompany("D-mart", 8, 20, 120);
		employeeWageComputation.addCompany("Wipro", 8, 22, 50);
		employeeWageComputation.calculateTotalWage();
	}
}