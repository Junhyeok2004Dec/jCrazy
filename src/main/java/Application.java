import com.sun.tools.javac.Main;
import util.GamePanel;
import util.MainPanel;

import javax.swing.*;
import java.awt.*;

public class Application {

    JPanel titlePanel;
    public Container container;
    //JFrame jframe;

    public static void main(String[] args) {

        new Application();

    }

    public Application() {
/*
		jframe = new JFrame();
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jframe.setResizable(false);

		jframe.setTitle("MainCraft");

			jframe.pack();

		jframe.setLocationRelativeTo(null);

		jframe.setVisible(true);
*/
        new MainPanel();
        //jframe.getContentPane().add(mp);


    }
}

