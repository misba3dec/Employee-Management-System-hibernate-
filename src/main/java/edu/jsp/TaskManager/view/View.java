package edu.jsp.TaskManager.view;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import edu.jsp.TaskManager.controller.Controller;
import edu.jsp.TaskManager.model.Employee;
import edu.jsp.TaskManager.model.Task;



public class View {
	Scanner scanner = new Scanner(System.in);
	Controller controller = new Controller();
	boolean loop = true;

	public static void main(String[] args) {

		View view = new View();

		while (view.loop) {
			view.mainview();
		}
	}

	public void mainview() {
		System.out.print("-----------WELCOME------------\n" + "Select Operation to Perform \n" + "1.Save Employee \n"
				+ "2.Search Employee \n" + "3.Get All Employee \n" + "4.Remove Employee \n" + "5.Save Task\n"
				+ "6.Search Task  \n" + "7.Get All Task\n" + "8.Remove Task \n" + "9.Assign Task \n"
				+ "10.Update Employee \n" + "11.Update Task \n" + "12.Exit \n");

		int choice = scanner.nextInt();

		switch (choice) {
		case 1: {
			saveEmployee();
			break;
		}

		case 2: {
			searchEmployee();
			break;
		}

		case 3: {
			getAllEmployee();
			break;
		}

		case 4: {
			removeEmployee();
			break;
		}

		case 5: {
			saveTask();
			break;
		}

		case 6: {
			searchTask();
			break;
		}

		case 7: {
			getAllTasks();
			break;
		}

		case 8: {
			removeTask();
			break;
		}

		case 9: {
			assignTask();
			break;
		}

		case 10: {
			updateEmployee();
			break;
		}

		case 11: {
			updateTaskName();
			break;
		}

		case 12: {
			this.loop = false;
			System.out.println("THANK YOU");
			break;
		}

		default:
			System.out.print("invalid choice");
			break;

		}
	}

	public void saveEmployee() {

		System.out.println("Enter Employee Name:");
		String Name = scanner.next();
		scanner.nextLine();

		System.out.println("Enter Employee Age:");
		int Age = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter Employee Salary:");
		double Salary = scanner.nextDouble();
		scanner.nextLine();

		Employee employee = new Employee();
		employee.setName(Name);
		employee.setAge(Age);
		employee.setSalary(Salary);

		if (controller.saveEmp(employee) != false) {
			System.out.println("Emplyoee Saved ");

		} else {
			System.out.println("Something went Wrong");
		}
	}

	public void removeEmployee() {
		System.out.println("Enter Employee ID to Remove:");
		int id = scanner.nextInt();
		scanner.nextLine();

		if (controller.removeEmp(id) != false) {

			System.out.println("Employee removed \n");

		} else {
			System.out.println("Something went Wrong");
		}

	}

	public void searchEmployee() {
		System.out.println("Enter Employee ID to Search:");
		int id = scanner.nextInt();

		Employee emp = controller.searchEmp(id);
		if (emp != null) {

			System.out.println("---------------------------");
			System.out.println("Employee Name:" + emp.getName());
			System.out.println("Employee Age:" + emp.getAge());
			System.out.println("Employee Salary:" + emp.getSalary());
			System.out.println("Employee Task:" + emp.getTasks());

			System.out.println("---------------------------");

		} else {
			System.out.println("Something went Wrong");

		}

	}

	public void getAllEmployee() {
		List<Employee> employees = controller.getAllEmployee();
		if (employees != null) {
			for (Employee employee : employees) {

				System.out.println("---------------------------");
				System.out.println("Employee name: " + employee.getName());
				System.out.println("Employee Age:" + employee.getAge());
				System.out.println("Employee Salary:" + employee.getSalary());
				System.out.println("Employee Task:" + employee.getTasks());

				System.out.println("---------------------------");

			}
		} else {
			System.out.println("Employees not exist");
		}
	}

	public void saveTask() {

		System.out.println("Enter Task:");
		String Name = scanner.next();
		scanner.nextLine();
		
         System.out.println("enter DOJ(IN YYYY-MM-DD):");
         String deadline=scanner.next();
         scanner.nextLine();
         LocalDate dead=LocalDate.parse(deadline);
	
         Task task = new Task();
		task.setName(Name);
		task.setDeadLine(dead);

		if (controller.addTask(task) != false) {
			System.out.println("Task Saved \n");

		} else {
			System.out.println("Something went Wrong");
		}

	}

	public void removeTask() {
		System.out.println("Enter Task ID to Remove:");
		int id = scanner.nextInt();
		scanner.nextLine();

		if (controller.removeTask(id) != false) {
			System.out.println("Task removed \n");

		} else {
			System.out.println("Something went Wrong");
		}

	}

	public void searchTask() {
		System.out.println("Enter Task ID to Search:");
		int id = scanner.nextInt();

		Task task = controller.searchTask(id);
		if (task != null) {
			System.out.println("---------------------------");
			System.out.println("Task Name:" + task.getName());
			System.out.println("Employee Assign to this Task:" + task.getEmployees());

			System.out.println("---------------------------");

		} else {
			System.out.println("Something went Wrong");

		}

	}

	public void getAllTasks() {
		List<Task> tasks = controller.getAllTasks();
		if (tasks != null) {
			for (Task task : tasks) {
				System.out.println("---------------------------");
				System.out.println("Task Name:" + task.getName());
				System.out.println("Employee Assign to this Task:" + task.getEmployees());

				System.out.println("---------------------------");

			}
		} else {
			System.out.println("Tasks not exist");
		}
	}

	public void assignTask() {
		System.out.println("Enter task ID to assign: ");
		int tid = scanner.nextInt();
		System.out.println("Enter employee ID to assign task: ");
		int empid = scanner.nextInt();

		if (controller.assignTask(tid, empid) != false) {
			System.out.println("Task assigned successfully");
		} else {
			System.out.println("Something went wrong.");
		}
	}

	public void updateEmployee() {
		System.out.println("What to do Update \n" + "1.Name \n" + "2.Age \n" + "3.Salary \n" + "4.NO \n");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1: {
			updateEmployeeName();
			break;
		}

		case 2: {
			updateEmployeeAge();
			break;
		}

		case 3: {
			updateEmployeeSalary();
			break;
		}

		case 4: {
			return;
		}

		default:
			System.out.println("invalid choice");
			break;
		}
	}

	public void updateEmployeeAge() {
		System.out.println("Enter Employee ID to Update: ");
		int tid = scanner.nextInt();
		System.out.println("Enter Updated Age: ");
		int empage = scanner.nextInt();

		if (controller.updateAge(tid, empage) != false) {
			System.out.println("Employee Age Updated successfully");
		} else {
			System.out.println("Something went wrong.");
		}
	}

	public void updateEmployeeName() {
		System.out.println("Enter Employee ID to Update: ");
		int tid = scanner.nextInt();
		System.out.println("Enter Updated Name: ");
		String empName = scanner.next();

		if (controller.updateName(tid, empName) != false) {
			System.out.println("Employee Name Updated successfully");
		} else {
			System.out.println("Something went wrong.");
		}
	}

	public void updateEmployeeSalary() {
		System.out.println("Enter Employee ID to Update: ");
		int tid = scanner.nextInt();
		System.out.println("Enter Updated Salary: ");
		double empsal = scanner.nextInt();

		if (controller.updateSal(tid, empsal) != false) {
			System.out.println("Employee Salary Updated successfully");
		} else {
			System.out.println("Something went wrong.");
		}
	}

	public void updateTaskName() {
		System.out.println("Enter Task ID to Update: ");
		int tid = scanner.nextInt();
		System.out.println("Enter Updated Name: ");
		String Name = scanner.next();

		if (controller.updateTaskName(tid, Name) != false) {
			System.out.println("Task Name Updated successfully");
		} else {
			System.out.println("Something went wrong.");
		}
	}

}