package fr.eql.ai108.groupeRMR.model;

public class Intern {
	
	private String lastName;
	private String firstName;
	private String department;
	private String promotion;
	private int year;
	
	public Intern() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Intern(String lastName, String firstName, String department, String promotion, int year) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.department = department;
		this.promotion = promotion;
		this.year = year;
	}
	
	public String justifyLine {
		
		String space1 = "";
		String space2 = "";
		String space3 = "";
		String space4 = "";
		String space5 = "";
		
		for (int i = 0 ; i < 100 - lastName.length() ; i++) {
			space1 = space1 + " ";
		}
		
		for (int i = 0 ; i < 100 - firstName.length() ; i++) {
			space2 = space2 + " ";
		}
		
		for (int i = 0 ; i < 5 - department.length() ; i++) {
			space3 = space3 + " ";
		}
		
		for (int i = 0 ; i < 40 - promotion.length() ; i++) {
			space4 = space4 + " ";
		}
		
		for (int i = 0 ; i < 40 - .length() ; i++) {
			
		}
		
	}
	
	

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((promotion == null) ? 0 : promotion.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Intern other = (Intern) obj;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (promotion == null) {
			if (other.promotion != null)
				return false;
		} else if (!promotion.equals(other.promotion))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Intern [lastName=" + lastName + ", firstName=" + firstName + ", department=" + department
				+ ", promotion=" + promotion + ", year=" + year + "]";
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPromotion() {
		return promotion;
	}

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	
	
}
