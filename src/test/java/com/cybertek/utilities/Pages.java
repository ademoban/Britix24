package com.cybertek.utilities;

import com.cybertek.login_navigation.LoginPage;
import com.cybertek.pages.activityStream.ActivityStreamManagment;
import com.cybertek.pages.activityStream.ActivityStreamPage;

public class Pages {


  private ActivityStreamManagment activityStreamManagment;
    private LoginPage loginPage;
    private ActivityStreamPage activityStreamPage;

  public ActivityStreamPage activityStreamPage(){
      if(activityStreamPage==null)
          activityStreamPage=new ActivityStreamPage();
      return activityStreamPage;
  }
  public LoginPage loginPage(){
      if(loginPage==null)
          loginPage=new LoginPage();
      return loginPage;
  }
  public ActivityStreamManagment activityStreamManagment(){
      if(activityStreamManagment==null)
         activityStreamManagment=new ActivityStreamManagment();
      return activityStreamManagment;
  }
}
