module fr.cookorama.dashboard {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens fr.cookorama.dashboard to javafx.fxml;
    exports fr.cookorama.dashboard;
}