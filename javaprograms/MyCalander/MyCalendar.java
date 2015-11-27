import java.util.ArrayList;
import java.util.Date;
import java.text.*;
class MyCalendar {
	private String name;
	ArrayList<Appointment> aal = new ArrayList<Appointment>();
	ArrayList<Appointment> bal = new ArrayList<Appointment>();
	public MyCalendar(String name) {
		this.name = name;
	}
	public boolean createAppointmentSlot(Appointment a) {
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
		try {
			dt = sdf.parse(a.getDatee());
		}catch(ParseException e){
		}
		if(aal.size() == 0) {
			aal.add(a);
			return true;
		}
		for(int i = 0; i < aal.size() ; i++) {
			Date dt1 = new Date();
			try {
				dt1 = sdf.parse(aal.get(i).getDatee());
			}catch(ParseException e){
			}
			if(dt1.getYear() <= dt.getYear()) {
				if(dt1.getMonth() <= dt.getMonth()) {
					if(dt1.getDate() <= dt.getDate()) {
						if(dt1.getHours() == dt.getHours()) {
							if((dt1.getMinutes() + aal.get(i).getDuration()) < dt.getMinutes() ) {
								aal.add(a);
								return true;
							}
						}
						else if(dt1.getHours() < dt.getHours()) {
							aal.add(a);
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	public boolean bookAppointment(String name,String date,int duration,String venue) {
		Date dt = new Date();
		Appointment a = new Appointment(name,date,duration,venue);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
		try {
			dt = sdf.parse(date);
		}catch(ParseException e){
		}
		for(int i = 0; i < aal.size(); i++) {
			Date dt1 = new Date();
			try {
				dt1 = sdf.parse(aal.get(i).getDatee());
			}catch(ParseException e){
			}
			if(dt.equals(dt1)) {
				if(bal.size() == 0) {
					bal.add(a);
						return true;
				}
				for(int j = 0; j < bal.size(); j++) {
					Date dt2 = new Date();
					try {
					dt2 = sdf.parse(aal.get(j).getDatee());
					}catch(ParseException e){
					}
					if(dt2.equals(dt)) {
						return false;
					}
					else {
						bal.add(a);
						return true;
					}
				}
			}
		}
		return false;
	}
	public boolean cancelAppointment(String date) {
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
		try {
			dt = sdf.parse(date);
		}catch(ParseException e){
		}
		for(int j = 0; j < bal.size(); j++) {
					Date dt2 = new Date();
					try {
					dt2 = sdf.parse(aal.get(j).getDatee());
					}catch(ParseException e){
					}
					if(dt2.equals(dt)) {
						bal.remove(bal.get(j));
						return true;
					}
				}
		return false;
	}
}