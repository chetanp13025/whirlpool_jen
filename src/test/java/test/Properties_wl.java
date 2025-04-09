package test;

import java.util.ResourceBundle;

//import org.openqa.selenium.WebElement;

public class Properties_wl {
	public static String QA_URL;
	public static String usernamefiledW;
	public static String passfieldW;
	public static String usernameW;
	public static String passwordW;
	public static String signinw;
	public static String UploadT;
	public static String Upload;
	public static String Side;
	public static String Return;
	public static String Select_file;
	public static String Confirm;
	public static String File_status;
	public static String Profile;
	public static String Logout;
	public static String Log_man_un;
	public static String Log_man_pass;
	public static String Log_request;
	public static String Check_box;
	public static String Update_confirmation;
	public static String Confirmation;
	public static String Date_pick;
	public static String Suggest_Pick;
	public static String Update_asign;
	public static String Log_par;
	public static String Log_field;
	public static String Par;
	public static String Log_ex;
	public static String Exe;
	public static String Create_Trips;
	public static String Search_CT;
	public static String Create_Trip;
	public static String Sequence;
	public static String Sequence_num;
	public static String Seq_number;
	public static String Submit;
	public static String Track_trip;
	public static String CRM_tk;
	public static String CRM_ticket;
	public static String Search_TP;
	public static String Update_exe;
	public static String Executive;
	public static String Asexe;
	public static String Vehical;
	public static String Sucessful;
	public static String Fta_Proceed;
	
	
	public static void pro() {
			ResourceBundle rb = ResourceBundle.getBundle("Whirlpool");
			QA_URL= rb.getString("url");
			usernamefiledW = rb.getString("unfieldweb");
			passfieldW =rb.getString("pwfieldweb");
			usernameW = rb.getString("usernameweb");
			passwordW =rb.getString("passwordweb");
			signinw = rb.getString("signinweb");
			Side=rb.getString("sidebar");
			UploadT = rb.getString("uploadT");
			Upload =rb.getString("upload");
			Return=rb.getString("return");
			Select_file=rb.getString("select");
			Confirm =rb.getString("confirm");
			File_status=rb.getString("status_file");
			Profile=rb.getString("profile");
			Logout=rb.getString("logout");
			Log_man_un=rb.getString("log_manun");
			Log_man_pass=rb.getString("log_manpass");
			Log_request=rb.getString("log_req");
			Check_box=rb.getString("check_box");
			Update_confirmation=rb.getString("u_confirm");
			Confirmation=rb.getString("confirmation");
			Suggest_Pick=rb.getString("suggest");
			Date_pick=rb.getString("date");
			Update_asign=rb.getString("update_as");
			Log_par=rb.getString("log_par");
			Log_field=rb.getString("log_field");
			Par=rb.getString("par");
			Log_ex=rb.getString("log_exe");
			Exe=rb.getString("exe");
			Create_Trips=rb.getString("create_trips");
			Search_CT=rb.getString("search_ct");
			Create_Trip=rb.getString("create_trip");
			Sequence=rb.getString("seq");
			Sequence_num=rb.getString("seq_nums");
			Submit=rb.getString("submit");
			Track_trip=rb.getString("track_tp");
			CRM_tk=rb.getString("crm");
			CRM_ticket=rb.getString("crm_ticket");
			Search_TP=rb.getString("search_tp");
			Update_exe=rb.getString("update");
			Executive=rb.getString("execu");
			Asexe=rb.getString("asexe");
			Vehical=rb.getString("vehical");
			Sucessful=rb.getString("sucess");
			Fta_Proceed=rb.getString("fta_proceed");
			
			
			
	}

}
