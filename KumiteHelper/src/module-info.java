/**
 * 
 */
/**
 * 
 */
/*module KumiteHelper {
	requires javafx.graphics;
	requires javafx.controls;
}*/

module KumiteHelper {

requires javafx.controls;

requires javafx.media;

requires javafx.graphics;
requires java.desktop;
requires javafx.base;

opens KumiteHelper to javafx.graphics;

}
