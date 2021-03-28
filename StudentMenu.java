import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentMenu {
	private Scanner consoleScanner = new Scanner(System.in);
	private ArrayList<Student> StudentsList = new ArrayList<Student>();
	
	protected void DisplayMenu()
	{
		try 
		{
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} 
		catch (InterruptedException | IOException e) 
		{
			System.out.println("Consola nu poate fi curatata " + e.getMessage());
		}
        
		System.out.println("***** GESTIONARE STUDENTI ******\n");
		System.out.println("0. Iesire");
		System.out.println("1. Adaugare");
		System.out.println("2. Modificare");
		System.out.println("3. Stergere");
		System.out.println("4. Vizualizare");
		System.out.println("\nIntorduceti optiunea dvs.: ");
		
	}
	
	public void Run()
	{
		String option = "0";
		
		do
		{
			DisplayMenu();
			option = consoleScanner.next();
			switch (option)
			{
				case "1":
					uiAddStudent();
					System.out.println("Press Any Key To Continue...");
			          consoleScanner.nextLine();
			          consoleScanner.nextLine();
					break;
				case "2":
					uiModifyStudent();
					System.out.println("Press Any Key To Continue...");
			          consoleScanner.nextLine();
			          consoleScanner.nextLine();
					break;
				case "3":
					uiDeleteStudent();
					System.out.println("Press Any Key To Continue...");
			          consoleScanner.nextLine();
			          consoleScanner.nextLine();
					break;
				case "4":
					uiViewStudents();
					System.out.println("Press Any Key To Continue...");
			          consoleScanner.nextLine();
			          consoleScanner.nextLine();
					break;
					
				default:
					System.out.println("\nAlegeti o optiune valida");
					System.out.println("Press Any Key To Continue...");
			          consoleScanner.nextLine();
			          consoleScanner.nextLine();
			}
			
		}while (option != "0");	
		
		System.out.println("Aplicatia se inchide ...");
	}

	private void listStudent(Student Student)
	{
		System.out.println(Student.getNume() + "\t" + Student.getPrenume() + "\t" +  Student.getMedie() );
	}
	private void uiViewStudents() {
		
		System.out.println("Nume\tPrenume\tMedie");
		
		for(Student currentStudent: StudentsList)
		{
			listStudent(currentStudent);			
		}
	}

	private void uiDeleteStudent() {
		System.out.println("Sterge STUDENT dupa nume.\nNumele studentilor sunt:");
		for(Student stud:StudentsList) {
			System.out.print(" " + stud.getNume());
		}
		System.out.println("Alegeti numele studentului");
		String StudentEliminat=consoleScanner.next();
		int indice=0;
		for(int i=0; i<StudentsList.size(); i++) {
			if(StudentsList.get(i).getNume()==StudentEliminat)
			{
				indice=i;
				break;
			}
		}
		StudentsList.remove(indice);
		System.out.println("Studentul a fost eliminat cu succes");
	}

	private void uiModifyStudent() {
		System.out.println("Alegeti indicele studentului pe care doriti sa il modificati");
		for(int i=0; i<StudentsList.size();i++) {
			System.out.println(i+". "+StudentsList.get(i).getNume()+" "+StudentsList.get(i).getPrenume());
		}
		int indice=consoleScanner.nextInt();
		System.out.println("Alegeti ce doriti sa modificati\n1.Nume\n2.Prenume\n3.Medie");
		int optiune=consoleScanner.nextInt();
		switch(optiune)
		{
		case 1:
			System.out.println("Introduceti noul nume:");
			StudentsList.get(indice).setNume(consoleScanner.next());
			break;
		case 2:
			System.out.println("Introduceti noul prenume:");
			StudentsList.get(indice).setPrenume(consoleScanner.next());
			break;
		case 3:
			System.out.println("Introduceti noua medie:");
			StudentsList.get(indice).setMedie(consoleScanner.nextDouble());
			break;
		default:
			System.out.println("Nu se modifica nimic.");
			break;
		}
	}

	private void uiAddStudent() {
		System.out.println("Adauga STUDENT: Nume, Prenume, Medie");
		String nume,prenume;
		double medie;
		nume=consoleScanner.next();
		prenume=consoleScanner.next();	
		medie=consoleScanner.nextDouble();
		StudentsList.add(new Student(nume,prenume,medie));
	}
	

}
