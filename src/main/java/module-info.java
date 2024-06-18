module genevent {
    requires commons.validator;
    requires javafx.controls;
    requires javafx.fxml;

    opens fr.uga.iut2.genevent.vue to javafx.fxml;
    exports fr.uga.iut2.genevent.vue;

}
