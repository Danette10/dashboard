module com.fxml {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jfree.jfreechart;
    requires org.jfree.chart.fx;
    requires java.curl;
    requires org.json;
    requires fontawesomefx;
    requires java.desktop;

    opens fr.cookorama.dashboard to javafx.fxml;
    exports fr.cookorama.dashboard;
}