public class HospitalManager {
	private String name;
	private Patient patientListStart = null;
	private Patient patientListEnd = null;
	
	public HospitalManager (String name) {
		this.name=name;
	}
	
	public void launch() {
	// all the logic to go in here
		System.out.println("Hospital name is " + this.name);
		String name="A";
		int age=50;
		String illness="IllnessId:";
		
		Patient firstPatient = new Patient(name,age,illness);
		//firstPatient.printPatient();
		patientListStart = firstPatient; // this creates the start of my list
		
		for (int i=0; i<10; i++) {
			name=name+"1";
			age=age+1;
			illness=illness+i;
			Patient nextPatient = new Patient(name,age,illness);
			//nextPatient.printPatient();
			patientListStart.addPatient(nextPatient); //add this patient to the end of the existing list
			patientListEnd=nextPatient;
		}
		System.out.print("The last patient is ");
		patientListEnd.printPatient();
		
		// now print the entire list, starting from head node and also print it's size
		patientListStart.printPatientlist();
		System.out.println("The patient list size is " + patientListStart.getListSize());
				
		// now print the entire list, starting from tail node
		patientListEnd.reversePrintPatientlist();
		
		// Let's find a patient where name = "A11"
		Patient patientToFind = null;
		patientToFind = patientListStart.findPatient("A11");
		System.out.print("The patient to be found is ");
		patientToFind.printPatient();
		
		// now let's just delete this patient
		patientListStart.deletePatient(patientToFind);
		// now print the remaining list 
		patientListStart.printPatientlist();
		System.out.println("The patient list size is " + patientListStart.getListSize());
		// now print the entire list, starting from tail node
		patientListEnd.reversePrintPatientlist();
	} 
	
	public static void main(String[] args) {
		String userHospital= args[0];
		HospitalManager myHospMgr = new HospitalManager(userHospital);
		myHospMgr.launch();
	}
	
}