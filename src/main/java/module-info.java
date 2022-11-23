module com.krolka {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires org.apache.pdfbox;

    opens com.krolka to javafx.fxml;
    exports com.krolka;
}