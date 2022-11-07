
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.*;
import java.time.temporal.ChronoField; 

class CreateAlarm{
	
	private static final int MAXIMUM_VALUE=100000;
	static String[] alarmArray = new String[MAXIMUM_VALUE];
	public static int numberOfAlarms=0;

	private long hours;
	private long minutes;
	private String day;
	private String time;

	public void setHours(long hours){
		this.hours = hours;
	}
	public void setMinutes(long minutes){
		this.minutes = minutes;
	}
	public void setDay(String day){
		this.day=day;
	}
	public String getDay(){
		return day;
	}
	public long getHours(){
		return hours;
	}
	public long getMinutes(){
		return minutes;
	}
	public void updateAlarmArray(int totalNumberOfAlarm){
		String time = Long.toString(hours)+":"+Long.toString(minutes);
		//System.out.println("time = "+time+" totalNumberOfAlarm = "+totalNumberOfAlarm);
		alarmArray[totalNumberOfAlarm] = time;
		numberOfAlarms++;
		
	}
	public void displayAlarmArray(int totalNumberOfAlarms){
		if(totalNumberOfAlarms>0){
			for(int i=0;i<totalNumberOfAlarms;i++){				
				System.out.print(alarmArray[i]+" ");
			}
			System.out.print("\n");
		}
		else{
			System.out.println("Empty");
		}
	}
	public void deleteAlarmValue(int deleteAlarmIndex){

		if(deleteAlarmIndex >= 0 && deleteAlarmIndex < numberOfAlarms){
			for(int i=deleteAlarmIndex;i<numberOfAlarms;i++){				
				alarmArray[i] = alarmArray[i+1];
			}
			numberOfAlarms--;
		}
	}
	
}

class DisplayTime{
	private long actualHour;
	private long actualMinute;
	private long actualIndicator;
	
	private long actualDate;
	private long actualMonth;
	private long actualYear;


	public long getActualDate(){
		return actualDate;
	}
	public long getActualMonth(){
		return actualMonth;
	}
	public long getActualYear(){
		return actualYear;
	}
	void display(){
   		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ss");
   		LocalDateTime time = LocalDateTime.now();
		actualHour = time.get(ChronoField.HOUR_OF_DAY);
		actualMinute = (time.get(ChronoField.MINUTE_OF_DAY) - actualHour*60);
		actualIndicator = time.get(ChronoField.AMPM_OF_DAY);
		//System.out.println("hour = "+actualHour);
		//System.out.println("minute = "+actualMinute);
		//System.out.println("indicator = "+actualIndicator);
		if(actualIndicator==0){
			System.out.println("Time = "+actualHour+":"+actualMinute+" AM");
		}
		else{
			System.out.println("Time = "+actualHour+":"+actualMinute+" PM");
		}
		
		actualDate = time.get(ChronoField.DAY_OF_MONTH);
		actualMonth = time.get(ChronoField.MONTH_OF_YEAR);
		actualYear = time.get(ChronoField.YEAR);
		System.out.println("Date = "+actualDate+"/"+actualMonth+"/"+actualYear);

		//System.out.println();
		//System.out.println();
		//System.out.println();
   		//System.out.println(dtf.format(time));
	}
} 
class UserInputForDateAndTime{
	
	long hrs,mins;
	char ch='y';
	int indicator,date,month,year,response;
	void userInputForTime(){
		Scanner sc = new Scanner(System.in);
		// User input for time
		System.out.println("Enter hours");
		hrs = sc.nextLong();
		System.out.println("Enter minutes");
		mins = sc.nextLong();
		System.out.println("Enter 0 for AM and 1 for PM");
		indicator=sc.nextInt();
	}
	void userInputForDate(){
		date=0;
		month=0;
		year=0;

		Scanner sc = new Scanner(System.in);
		//user input for year

		while(ch=='y'){
			System.out.println("Enter year (format XXXX)");
			year = sc.nextInt();
			if(year>=2022){break;}
		}
		//user input for month
		while(ch=='y'){
			System.out.println("Enter month,in case of july it will be 7");
			month = sc.nextInt();
			if(month>0 && month<=12){
				break;
			}
		}
		//user input for date
		while(ch=='y'){
			System.out.println("Enter date");
			date = sc.nextInt();
			if(year%4 !=0){
				if(month ==2){
					if(date>=1 && date<=28){
						break;
					}
					else{
						System.out.println("Wrong date");
					}
				}
				if(month==1 || month==3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
					if(date>=1 && date<=31){
						break;
					}
					else{
						System.out.println("Wrong date");
					}
				}
				else{
					if(date>=1 && date<=30){
						break;
					}
					else{
						System.out.println("Wrong date");
					}
				}
			}
			else{
				if(month ==2){
					if(date>=1 && date<=29){
						break;
					}
					else{
						System.out.println("Wrong date");
					}
				}
				if(month==1 || month==3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
					if(date>=1 && date<=31){
						break;
					}
					else{
						System.out.println("Wrong date");
					}
				}
				else{
					if(date>=1 && date<=30){
						break;
					}
					else{
						System.out.println("Wrong date");
					}
				}
			}
		}
	
		//System.out.println("date = "+date);
		//System.out.println("month = "+month);
		//System.out.println("year = "+year);
	}

}
class AlarmRing{
	
	public void ring(){
		Scanner sc = new Scanner(System.in);
		char ch='y';
		int response,snoozeCount=3;
		CreateAlarm createAlarm = new CreateAlarm();
		String time=CreateAlarm.alarmArray[0];
				int flag = 0;
				int tempMinutes =0,tempHours=0,finalVar;

				for(int i=0;i<time.length();i++){
					if(time.charAt(i) != ':' && flag ==0){
						finalVar = (int) (time.charAt(i) - '0');
						tempHours = tempHours*10 + finalVar;
								
					}
					else if(flag == 1){
						finalVar = (int) (time.charAt(i) -'0');
						tempMinutes = tempMinutes*10 + finalVar;								
					}
					else{
						flag = 1;
					}
				} 
		int finalMinutes = tempMinutes;
		int finalHours = tempHours;
		while(ch=='y'){
			if(CreateAlarm.numberOfAlarms > 0){			
				System.out.println("ringing.........");
	
				System.out.println("1.Snooze");
				System.out.println("2.Exit");
				response = sc.nextInt();
				if(response == 1){
					if(snoozeCount>0){
						//UserInputForDateAndTime uiDT = new UserInputForDateAndTime();
					

								//System.out.println(tempHours+":"+tempMinutes);
						if(finalMinutes + 5 < 60){
							finalMinutes += 5;
							System.out.println("Alarm will ring at "+finalHours+":"+finalMinutes);
						}
						else{
							finalHours += 1;
							finalMinutes = (finalMinutes + 5) - 60;
							System.out.println("Alarm will ring at "+finalHours+":"+finalMinutes);

						}
						snoozeCount--;
					}
					else{
						
					}
				
				}
				else{
					break;
				}
			}
		}
		
	}

}
public class ShowTime{  
	
	

	public static void userInputToUI(){

		char ch='y';
		int userInput,deleteAlarmIndex;
		while(ch=='y'){
			System.out.println("1. Create Alarm");
			System.out.println("2. Display Total Alarms");
			System.out.println("3. Show Time");
			System.out.println("4. Check Alarm Status");
			System.out.println("5. Delete Alarm");
			System.out.println("6. Exit");

			Scanner sc = new Scanner(System.in);
			userInput = sc.nextInt();

			if(userInput == 1){

				UserInputForDateAndTime currentTime = new UserInputForDateAndTime();
				currentTime.userInputForTime();
				currentTime.userInputForDate();
			
				CreateAlarm createAlarm = new CreateAlarm();
				createAlarm.setHours(currentTime.hrs);
				createAlarm.setMinutes(currentTime.mins);
				createAlarm.updateAlarmArray(CreateAlarm.numberOfAlarms);
				System.out.println("\nAlarm has been set successfully");		
			}
			else if(userInput == 2){
				CreateAlarm createAlarm = new CreateAlarm();
				createAlarm.displayAlarmArray(CreateAlarm.numberOfAlarms);
			}
			else if(userInput == 3){
				DisplayTime displayTime= new DisplayTime();
				displayTime.display();
			}
			else if(userInput == 4){
				AlarmRing alarmRing= new AlarmRing();
				alarmRing.ring();
			}
			else if(userInput == 5){
				CreateAlarm createAlarm = new CreateAlarm();
				createAlarm.displayAlarmArray(CreateAlarm.numberOfAlarms);
				
				System.out.println("Which alarm has to be deleted (index starting from 1)");
				deleteAlarmIndex = sc.nextInt();
				createAlarm.deleteAlarmValue(--deleteAlarmIndex);
			
			}
			else{
				break;
			}
		}
	}

	public static void main(String[] args) {  
		userInputToUI();
	}  
}  



























/*import java.time.Clock;
 
public class ShowTime{
     
    // main method
    public static void main(String[] args) {
         
        // creating a Clock instance using
        // systemUTC() method of Clock class
	long millis,seconds,minutes,hours;
        Clock clock = Clock.systemUTC();
         
        // getting the current instant defined by clock
	millis= clock.millis();
	seconds = millis / 1000;
	minutes = seconds/60;
	hours = minutes/60;
	
        System.out.println("UTC time = " + hours + " "+ minutes+" "+seconds);
    }
}*/