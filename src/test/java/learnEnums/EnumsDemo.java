package learnEnums;

public class EnumsDemo {

	public static void main(String[] args) {
		
		DaysOfTheWeek dw = DaysOfTheWeek.SATURDAY;
		System.out.println(dw);
		
		System.out.println(DaysOfTheWeek.valueOf("WEDNESDAY"));
		
		DaysOfTheWeek[] dwarr= DaysOfTheWeek.values();
		
		for(DaysOfTheWeek dwar : dwarr) {
			System.out.println("Inside for loop: "+dwar);
		}
		

	}

}
