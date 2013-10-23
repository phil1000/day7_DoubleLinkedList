public class Patient {
	private String name;
	private int age;
	private String illness;
	private Patient priorPatient;
	private Patient nextPatient;
	
	public Patient (String name, int age, String illness) {
		this.name=name;
		this.age=age;
		this.illness=illness;
		this.priorPatient = null;
		this.nextPatient = null;
	}
	
	public void printPatient() {
		System.out.println("Name:" + this.name + " Age:" + this.age + " Illness:" + this.illness);
	}
	
	public void addPatient(Patient newPatient) {
		if (this.nextPatient == null) {
			// this is the last patient in the list
			this.nextPatient = newPatient;
			newPatient.priorPatient=this;
		} else {
			this.nextPatient.addPatient(newPatient); // 
		}
	}
	
	public boolean deletePatient(Patient patient) {
		Patient tempPatient=null;
		if (this.nextPatient == null) {
			// patient to remove was not found
			return false;
		} else if (this.nextPatient.name.equals(patient.name)) {
			// we found it and it's the next one
			// link this patient to the one after the next
			// the next object is not specifically deleted, just removed from the list
			// ultimately the garbage collector will remove it
			this.nextPatient = nextPatient.nextPatient;
			tempPatient=nextPatient.nextPatient;
			tempPatient.priorPatient=this;
			return true;
		} else {
			return this.nextPatient.deletePatient(patient); // recursive program 
		}
	}
	
	public boolean printPatientlist() {
		if (this.nextPatient == null) {
			// came to end of list so can finish printing
			return false;
		} else {
			this.printPatient();
			return this.nextPatient.printPatientlist(); // recursive program 
		}
	}
	
	public int getListSize() {
		int listSize=0;
		Patient listNavigator=this; // I am setting navigator to the current object instance I am in, which is the start of the list
		while (listNavigator.nextPatient != null) {
			listNavigator=listNavigator.nextPatient;
			listSize++;
		}
		return listSize;
	}
	
	public Patient findPatient(String patientName) {
	
		// I used a loop rather than recursive program as I find it easier
		Patient patientToReturn = null;
		Patient listNavigator = null;
		
		if (this.name.equals(patientName)) {
			// cannot delete first item in the list 
			System.out.println("Cannot delete first item in list so bye");
		}
		else {
			if (this.nextPatient==null) {
				// only one item in the list 
				System.out.println("Only one item in list and cannot delete it");
			}
			else {
				listNavigator=this.nextPatient;
				do {
					//System.out.println("Name" + listNavigator.name + "incoming patient=" + patientName);
					if (listNavigator.name.equals(patientName)) {
						patientToReturn=listNavigator;
						break;
					} else {
						listNavigator=listNavigator.nextPatient;
					}
				}
				while (listNavigator.nextPatient != null);
			}
		}
		
		return patientToReturn; // will either be null or a pointer to correct patient object
	}
}