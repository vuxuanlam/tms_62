package tms62.action.homepage;

import com.opensymphony.xwork2.ActionSupport;

public class HomepageAction extends ActionSupport {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public String homePage() {

    System.out.println("Homepage page");
    return SUCCESS;
  }

}
