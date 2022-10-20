module com.example.laboratoriofinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;


    exports com.example.laboratoriofinal;
    opens com.example.laboratoriofinal to javafx.fxml;
    exports com.example.laboratoriofinal.Controller;
    opens com.example.laboratoriofinal.Controller to javafx.fxml;
    exports com.example.laboratoriofinal.Model to javafx.fxml;
    opens com.example.laboratoriofinal.Model;


}