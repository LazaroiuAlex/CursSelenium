package curs13;

import org.testng.annotations.Test;

// dependinta intre metode - rularea se ia in ordine alfabetica one, three, two - putem adauga parametri pentru a stabili rularea
// daca avem doua prioritati cu acelasi numar se ia alfabetic

public class TestPriority {
	@Test(priority = 0)
	public void one() {
		
		System.out.println("First");
		
	}
	@Test(priority = 1)
	public void two() {
		
		System.out.println("Second");
		
	}
	@Test(priority = 2)
	public void third() {
		
		System.out.println("Third");
		
	}
	@Test
	public void four () {
		System.out.println("Fourth");
	}
	@Test
	public void five () {
		System.out.println("Fifth");
	}

}
