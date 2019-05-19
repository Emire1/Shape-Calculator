package shapesGUI;

//-------------------------------------------

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

//-------------------------------------------

/**
 *This is a JavaFX GUI program.
 *It calculates the area, perimeter, and volume of a rectangle,
 *cuboid, a circle, and a sphere.
 *It allows the user to input the dimensions and compute the results
 * 
 * @author T.M. Rao, Emmanuel Mireku, Tegan Stoddart 
 * @version March 1, 2019
 */


public class ShapesGUI extends Application 
{

// Declare GridPane variable
	GridPane pane;
	
// Declare Button variables
	Button exit, rectangle, circle, cuboid, sphere;
	
// Declare TextField variables
	TextField lengthTF, widthTF, heightTF, radiusTF, areaTF, perimeterTF, volumeTF;
	
//-------------------------------------------	
	
	/**
	 * This method launches the application
	 * @param args
	 */
	public static void main(String[] args) 
	{
        launch(args);
    }
	
//-------------------------------------------

/**
 * This method creates,
 * and combine the GUI components
 */
	public void createGUIComponents() 
	{
		
// Instantiate pane to initiate building of the GUI
		pane = new GridPane();
		
// Instantiate all TextField variables
    	lengthTF = new TextField();
    	widthTF = new TextField();
    	heightTF = new TextField();
    	radiusTF = new TextField();
    	areaTF = new TextField();
    	perimeterTF = new TextField();
    	volumeTF = new TextField();
    	
// Set area, perimeter, and volume values to immutable
    	areaTF.setEditable(false);
    	perimeterTF.setEditable(false);
    	volumeTF.setEditable(false);

/**
 * Set the vertical gaps to 10
 * Set the horizontal gaps to 10
 * Align GridPane to the center
 * Set Gridpane padding to 10    	
 */
    	pane.setHgap(10);
    	pane.setVgap(10);
    	pane.setAlignment(Pos.CENTER);
    	pane.setPadding(new Insets(10));
    
// add all objects to the pane    	
    	pane.add(new Label("Length"),0,0);
    	pane.add(lengthTF,0,1);
    	pane.add(new Label("Width"),1,0);
    	pane.add(widthTF,1,1);
    	pane.add(new Label("Height"),2,0);
    	pane.add(heightTF,2,1);
    	pane.add(new Label("Radius"), 3, 0);
    	pane.add(radiusTF,3,1);
    	rectangle = new Button("RECTANGLE");
    	pane.add(rectangle, 0, 2);
    	circle = new Button("CIRCLE");
    	pane.add(circle, 1, 2);
    	cuboid = new Button("CUBOID");
    	pane.add(cuboid, 2, 2);
    	sphere = new Button("SPHERE");
    	pane.add(sphere, 3, 2);
    	pane.add(new Label("Area"), 0, 3);
    	pane.add(areaTF, 0, 4);
    	pane.add(new Label("Perimeter"), 1, 3);
    	pane.add(perimeterTF, 1, 4);
    	pane.add(new Label("Volume"), 2, 3);
    	pane.add(volumeTF, 2, 4);
    	exit = new Button("EXIT");
    	pane.add(exit, 0, 5);
	}
	
//-------------------------------------------	
	
	/**
	 * Attach event handlers to the the buttons
	 */
	public void attachHandlers()
    {
        /**
         * Attach EventHandler to rectangle button
         * When clicked it should call handle
         */
		rectangle.setOnAction(new EventHandler<ActionEvent>()
        {
			/**
			 * This method calls the Rectangle class
			 * and does all the calculations
			 * @param ActionEvent e
			 */
            public void handle(ActionEvent e)
            {
            	try {
					// Extract the input from the forms and convert it into double
					double w = Double.parseDouble(widthTF.getText());
					double l = Double.parseDouble(lengthTF.getText());
					
					// instantiate Rectangle and compute values
					Rectangle c = new Rectangle(l, w);
 
					/**
					 * display values in it's appropriate text field
					 * convert the value into Strings
					 * format the floating point to only two places
					 */
					areaTF.setText(String.format("%.2f", c.area()));
					perimeterTF.setText(String.format("%.2f", c.perimeter()));
					volumeTF.setText(String.format("%.2f", c.volume()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					areaTF.setText("");
					perimeterTF.setText("");
					volumeTF.setText("");
					widthTF.setText("Input invalid");
					lengthTF.setText("Input invalid");
					radiusTF.setText("");
				}
            }
            
        });
		
		
		/**
         * Attach EventHandler to cuboid button
         * When clicked it should call handle
         */
        cuboid.setOnAction(new EventHandler<ActionEvent>()
        {
        	/**
			 * This method calls the Cuboid class
			 * and does all the calculations
			 * @param ActionEvent e
			 */
            public void handle(ActionEvent e)
            {
            	try {
					double w = Double.parseDouble(widthTF.getText());
					double l = Double.parseDouble(lengthTF.getText());
					double h = Double.parseDouble(heightTF.getText());
					
					// instantiate Cuboid and compute values
					Cuboid c = new Cuboid(l, w, h);
 
					/**
					 * display values in it's appropriate text field
					 * convert the value into Strings
					 * format the floating point to only two places
					 */
					areaTF.setText(String.format("%.2f", c.area()));
					perimeterTF.setText(String.format("%.2f", c.perimeter()));
					volumeTF.setText(String.format("%.2f", c.volume()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					areaTF.setText("");
					perimeterTF.setText("");
					volumeTF.setText("");
					widthTF.setText("Input invalid");
					lengthTF.setText("Input invalid");
					heightTF.setText("Input invalid");
					radiusTF.setText("");
				}
            }
            
        });
        
        /**
         * Attach EventHandler to circle button
         * When clicked it should call handle
         */
        circle.setOnAction(new EventHandler<ActionEvent>()
        {
        	/**
			 * This method calls the Circle class
			 * and does all the calculations
			 * @param ActionEvent e
			 */
            public void handle(ActionEvent e)
            {
            	try {
					double r = Double.parseDouble(radiusTF.getText());
					
					// instantiate Circle and compute value
					Circle c = new Circle(r);
					
					/**
					 * display values in it's appropriate text field
					 * convert the value into Strings
					 * format the floating point to only two places
					 */
					areaTF.setText(String.format("%.2f", c.area()));
					perimeterTF.setText(String.format("%.2f", c.perimeter()));
					volumeTF.setText(String.format("%.2f", c.volume()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					areaTF.setText("");
					perimeterTF.setText("");
					volumeTF.setText("");
					radiusTF.setText("Input invalid");
					lengthTF.setText("");
					widthTF.setText("");
					heightTF.setText("");
				}
            }
            
        });
        
        
        /**
         * Attach EventHandler to sphere button
         * When clicked it should call handle
         */
        sphere.setOnAction(new EventHandler<ActionEvent>()
        {
        	/**
			 * This method calls the Sphere class
			 * and does all the calculations
			 * @param ActionEvent e
			 */
            public void handle(ActionEvent e)
            {
            	try {
					double r = Double.parseDouble(radiusTF.getText());
					
					// instantiate Sphere and compute value
					Sphere c = new Sphere(r);
 
					/**
					 * display values in it's appropriate text field
					 * convert the value into Strings
					 * format the floating point to only two places
					 */
            areaTF.setText(String.format("%.2f", c.area()));
            perimeterTF.setText(String.format("%.2f", c.perimeter()));
            volumeTF.setText(String.format("%.2f", c.volume()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					areaTF.setText("");
					perimeterTF.setText("");
					volumeTF.setText("");
					radiusTF.setText("Input invalid");
					lengthTF.setText("");
					widthTF.setText("");
					heightTF.setText("");
					
					
				}
            }
            
        });
        
        /**
         * Attach EventHandler to exit button
         * When clicked it should call handle and program should exit
         */
        exit.setOnAction(new EventHandler<ActionEvent>()
        {
        	/**
			 * This method calls the Platform class
			 * and closes the scene
			 * @param ActionEvent e
			 */
            public void handle(ActionEvent e)
            {
            	//Exit application
            	Platform.exit();
            }
            
        });
    }
	
//-------------------------------------------	
	
	/**
	 * Build and start the GUI application
	 * @param Stage
	 */
	public void start(Stage stage) 
	{
		// Create components
        createGUIComponents();
        
        // Attach handlers
        attachHandlers();

        // Instantiate a Scene
        Scene scene = new Scene(pane);
        
        // Set the scene
        stage.setScene(scene);
        
        // Set the name of the scene
        stage.setTitle("Shape Calculator");
        
       // Set the width and height of the scene
        stage.setWidth(600);
        stage.setHeight(250);
        
        // Show the scene
        stage.show();
    }
	
//-------------------------------------------
	
	/**
	 * End of Program
	*/
}

