module fr.cookorama.dashboard {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires java.curl;


    opens fr.cookorama.dashboard to javafx.fxml;
    exports fr.cookorama.dashboard;
}