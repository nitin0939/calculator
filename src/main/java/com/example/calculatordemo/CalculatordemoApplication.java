package com.example.calculatordemo;

import com.example.calculatordemo.bean.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Scanner;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
public class CalculatordemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculatordemoApplication.class, args);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Numbers to add");
		String numbers = scanner.nextLine();
		System.out.println("Sum is: "+Calculator.add(numbers));
	}

}
