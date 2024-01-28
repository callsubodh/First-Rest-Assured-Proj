package learnEnums;

public class CallEnumsWithSwitch {

	public static void main(String[] args) {
		
		DaysOfTheWeek dwobj = DaysOfTheWeek.FRIDAY;
		
		switch(dwobj) {
		
		case SUNDAY:			
			System.out.println("This is Sunday.");
			break;
			
		case MONDAY:
			System.out.println("This is Monday.");
			break;
			
		case TUESDAY:
			System.out.println("This is Tuesday.");
			break;
		
		case WEDNESDAY:
			System.out.println("This is Wednesday.");
			break;
			
		case THURSDAY:
			System.out.println("This is Thursday.");
			break;
			
		default:
			System.out.println("Last working day of the week.");
		
		}

	}

}
