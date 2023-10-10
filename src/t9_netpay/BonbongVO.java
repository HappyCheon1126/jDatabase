package t9_netpay;

public class BonbongVO {
  private String jikkub;
  private int bonbong;
  
  
  String getJikkub() {
      return jikkub;
  }
  void setJikkub(String jikkub) {
      this.jikkub = jikkub;
  }
  int getBonbong() {
      return bonbong;
  }
  void setBonbong(int bonbong) {
      this.bonbong = bonbong;
  }
  @Override
  public String toString() {
      return "bonbongVO [jikkub=" + jikkub + ", bonbong=" + bonbong + "]";
  }

  
  
}