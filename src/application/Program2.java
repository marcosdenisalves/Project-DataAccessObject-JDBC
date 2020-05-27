package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("==== TEST 1 ====\n[department findById]");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);
		
		System.out.println("\n==== TEST 2 =====\n[department findAll]");
		List<Department> list = departmentDao.findAll();
		list.forEach(System.out::println);
		
		System.out.println("\n==== TEST 3 =====\n[department insert]");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! new Id = " + newDepartment.getId());

		System.out.println("\n==== TEST 4 =====\n[department update]");
		Department newDep = departmentDao.findById(6);
		newDep.setName("Food");
		departmentDao.update(newDep);
		System.out.println("Update complete!");
		
		System.out.println("\n==== TEST 5 =====\n[department delete]");
		System.out.print("Enter the id to delete a department: ");
		departmentDao.deleteById(sc.nextInt());
		System.out.println("successfully delete!");
		
		sc.close();
	}

}
