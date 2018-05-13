
import java.util.Date;
import java.util.Random;

public class Bar {

    private String barName;
    private int barAge;
    private Date barDate = new Date();

    {
        Random r = new Random();
        barName = "sss_"+String.valueOf(r.nextFloat());
        barAge = r.nextInt();
    }



    public String getBarName() {
        return barName;
    }

    public void setBarName(String barName) {
        this.barName = barName;
    }

    public int getBarAge() {
        return barAge;
    }

    public void setBarAge(int barAge) {
        this.barAge = barAge;
    }

    public Date getBarDate() {
        return barDate;
    }

    public void setBarDate(Date barDate) {
        this.barDate = barDate;
    }

    @Override
    public String toString() {
        return "Bar{" +
                "barName='" + barName + '\'' +
                ", barAge=" + barAge +
                ", barDate=" + barDate +
                '}';
    }
}

