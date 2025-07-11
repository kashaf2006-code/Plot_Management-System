package module;

public class Client {
private String firstName;
private  String lastname;
private  int plotnumber;//this will be aloted to every client
private int totalmount;//total amount of the plot
private String cnic;
private double areaplot; // Area of the plot if added in system

//consstrcutor
//creating only specific thing in constructor so that form could be easily submited further things can be added latter on as a method
public Client(String f_name, String l_name, int plotnumber, int totalamount) {
	this.firstName=f_name;
	this.lastname=l_name;
	this.plotnumber=plotnumber;
	this.totalmount=totalamount;
	
}
public String getFirstName() {
    return firstName;
}

public void setFirstName(String firstName) {
    this.firstName = firstName;
}

public String getLastname() {
    return lastname;
}

public void setLastname(String lastname) {
    this.lastname = lastname;
}

public int getPlotnumber() {
    return plotnumber;
}

public void setPlotnumber(int plotnumber) {
    this.plotnumber = plotnumber;
}

public int getTotalmount() {
    return totalmount;
}

public void setTotalmount(int totalmount) {
    this.totalmount = totalmount;
}

public String getCnic() {
    return cnic;
}

public void setCnic(String cnic) {
    this.cnic = cnic;
}

public double getAreaplot() {
    return areaplot;
}

public void setAreaplot(double areaplot) {
    this.areaplot = areaplot;
}
// some improtant methods
// method to add CNIC or other Additional information for future
public void addAdditionalInfo(String cnic, double areaplot) {
this.cnic = cnic;
this.areaplot=areaplot;
System.out.println("The cnic is added successfully");
}
//display Info
@Override
public String toString() {
    return "Client: " + firstName + " " + lastname +
           "\n:Total value of plot " + totalmount +
           "\nPlotNumber: " + plotnumber +
           "\nCNIC: " + cnic+
           "\nPlot area:"+areaplot;
}


}
