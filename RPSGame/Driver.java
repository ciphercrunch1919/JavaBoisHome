/*
The main purpose of the driver is to initialize the game's MVC pattern and add action listeners to each of the object screens in the game. model and view are also being added to controller
 */

public class Driver
{
    public static void main(String []args)
    {
        RPSView view = new RPSView();
        RPSModel model = new RPSModel();
        RPSController controller = new RPSController();

        controller.addModel(model);
        controller.addView(view);
        view.addListeners(controller);

    }
}
