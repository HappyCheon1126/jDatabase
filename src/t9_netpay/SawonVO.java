package t9_netpay;

public class SawonVO {
  private int sabun;
  private String name;
  private String jikkub;
  private int night;

  
  
  private int bonbong;
  private int tax;
  private int salary;
  
  
  
  
  int getBonbong() {
      return bonbong;
  }
  void setBonbong(int bonbong) {
      this.bonbong = bonbong;
  }
  int getSabun() {
      return sabun;
  }
  void setSabun(int sabun) {
      this.sabun = sabun;
  }
  String getName() {
      return name;
  }
  void setName(String name) {
      this.name = name;
  }
  String getJikkub() {
      return jikkub;
  }
  void setJikkub(String jikkub) {
      this.jikkub = jikkub;
  }
  int getNight() {
      return night;
  }
  void setNight(int night) {
      this.night = night;
  }
  int getTax() {
      return tax;
  }
  void setTax(int tax) {
      this.tax = tax;
  }
  int getSalary() {
      return salary;
  }
  void setSalary(int salary) {
      this.salary = salary;
  }
  @Override
  public String toString() {
      return "SawonVO [sabun=" + sabun + ", name=" + name + ", jikkub=" + jikkub + ", night=" + night + ", bonbong="
              + bonbong + ", tax=" + tax + ", salary=" + salary + "]";
  }
  
  
}