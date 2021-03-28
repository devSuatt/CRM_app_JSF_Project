import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;


@ManagedBean
@RequestScoped
public class bean {
    
    private PieChartModel pie;
    private BarChartModel bar;

    public BarChartModel getBar() {
        return bar;
    }

    public void setBar(BarChartModel bar) {
        this.bar = bar;
    }
    
    public PieChartModel getPie() {
        return pie;
    }

    public void setPie(PieChartModel pie) {
        this.pie = pie;
    }
    
    
    public bean() {}
    
    @PostConstruct
    public void init() {
        createPie();
        createBar();
    }
    
    public void createPie() {
        pie = new PieChartModel();
        
        pie.set("New Order", 100);
        pie.set("Delivered", 70);
        pie.set("Returned", 10);
        
        pie.setTitle("Sales Report");
        pie.setLegendPosition("q");
        
    }
    
    public void createBar() {
        bar = new BarChartModel();
        
        ChartSeries newOrder = new ChartSeries("New Order");
        newOrder.set("2014", 100);
        newOrder.set("2015", 70);
        newOrder.set("2016", 150);
        
        ChartSeries delivered = new ChartSeries("Delivered");
        delivered.set("2014", 90);
        delivered.set("2015", 60);
        delivered.set("2016", 130);
        
        ChartSeries returned = new ChartSeries("Returned");
        returned.set("2014", 10);
        returned.set("2015", 20);
        returned.set("2016", 5);
        
        bar.addSeries(newOrder);
        bar.addSeries(delivered);
        bar.addSeries(returned);
        
        bar.setTitle("Yearly Report Summary");
        bar.setLegendPosition("ne");
        
        bar.getAxis(AxisType.X).setLabel("Year");
        bar.getAxis(AxisType.Y).setLabel("Sales");
        bar.getAxis(AxisType.Y).setMin(0);
        bar.getAxis(AxisType.Y).setMax(250);
        
    }
    
}