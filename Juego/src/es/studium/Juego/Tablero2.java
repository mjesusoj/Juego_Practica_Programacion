package es.studium.Juego;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tablero2 extends WindowAdapter implements ActionListener{

	JFrame NuevaPartida2 = new JFrame("Tablero");

	// Componentes para la Ventana
	JLabel lblSeleccionar = new JLabel("Seleccione la traducci�n correcta");
	JLabel lblFrase = new JLabel("This morning not I have eat breakfast");

	// Botones
	JButton btn1 = new JButton("Esta ma�ana no he desayunado");
	JButton btn2 = new JButton("Hoy no he desayunado");
	JButton btnCalificar = new JButton("Calificar");

	// Panel Seleccionar
	JPanel pnlSeleccionar = new JPanel();

	// Panel Frase
	JPanel pnlFrase = new JPanel();

	// Panel para la primera frase
	JPanel pnlBoton = new JPanel();

	// Panel para la segunda frase
	JPanel pnlBoton1 = new JPanel();

	// Panel para el bot�n CALIFICAR
	JPanel pnlCalificar = new JPanel();

	// Di�logo Pregunta Correcta
	JDialog DialogoCorrecto = new JDialog(NuevaPartida2, false);

	// Di�logo Pregunta Incorrecta
	JDialog DialogoIncorrecto = new JDialog(NuevaPartida2, false);

	// Componentes Di�logo Correcto
	JLabel lblPuntos = new JLabel("Has obtenido 50 puntos");
	JButton btnVolver = new JButton("Volver");
	JButton btnNuevaPartida = new JButton("Nueva Partida");

	// Componentes Di�logo Incorrecto
	JLabel lblError = new JLabel("Has fallado, int�ntelo de nuevo");
	JButton btnVolver1 = new JButton("Volver");
	JButton btnNuevaPartida1 = new JButton("Nueva Partida");

	Tablero2()
	{
		// Almacenamos en mipantalla el sistema nativo de pantallas, el tama�o por defecto de la pantalla
		Toolkit mipantalla = Toolkit.getDefaultToolkit();

		// Aplicar Layout
		NuevaPartida2.setLayout(new GridLayout(5,2));

		// A�adir al Panel frase la frase
		pnlFrase.add(lblSeleccionar);
		pnlFrase.add(lblFrase);

		// Tama�o al Panel Botones 
		//pnlBoton.setLayout(new GridLayout(0,1,1,0));
		//pnlBoton1.setLayout(new FlowLayout());

		// A�adir la primera frase y la segunda a los paneles boton y boton2
		pnlBoton.add(btn1);
		pnlBoton1.add(btn2);

		// A�adir al panel BotonC
		pnlCalificar.add(btnCalificar);

		// Ubicaci�n de los paneles
		NuevaPartida2.add(pnlFrase, BorderLayout.NORTH);
		NuevaPartida2.add(pnlBoton, BorderLayout.CENTER);
		NuevaPartida2.add(pnlBoton1, BorderLayout.CENTER);
		NuevaPartida2.add(pnlCalificar, BorderLayout.SOUTH);

		// Di�logo Correcto
		DialogoCorrecto.setTitle("Pregunta Correcta");
		DialogoCorrecto.setLayout(new FlowLayout());
		DialogoCorrecto.add(lblPuntos);
		DialogoCorrecto.add(btnVolver);
		DialogoCorrecto.add(btnNuevaPartida);
		DialogoCorrecto.setSize(210,100);
		DialogoCorrecto.setLocationRelativeTo(null);
		DialogoCorrecto.setResizable(false);
		DialogoCorrecto.setVisible(false);

		// Di�logo Incorrecto
		DialogoIncorrecto.setTitle("Pregunta Incorrecta");
		DialogoIncorrecto.setLayout(new FlowLayout());
		DialogoIncorrecto.add(lblError);
		DialogoIncorrecto.add(btnVolver1);
		DialogoIncorrecto.add(btnNuevaPartida1);
		DialogoIncorrecto.setSize(210,100);
		DialogoIncorrecto.setLocationRelativeTo(null);
		DialogoIncorrecto.setResizable(false);
		DialogoIncorrecto.setVisible(false);

		// A�adir los listeners 
		NuevaPartida2.addWindowListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btnCalificar.addActionListener(this);

		// Listeners del Di�logo Correcto
		btnVolver.addActionListener(this);
		btnNuevaPartida.addActionListener(this);
		DialogoCorrecto.addWindowListener(this);

		// Listeners del Di�logo Pregunta Incorrecta
		btnVolver1.addActionListener(this);
		btnNuevaPartida1.addActionListener(this);
		DialogoIncorrecto.addWindowListener(this);

		// Establecer un icono a la aplicaci�n
		Image miIcono = mipantalla.getImage("src//duo.png");

		// Colocar icono
		NuevaPartida2.setIconImage(miIcono);

		NuevaPartida2.setSize(400,250);
		NuevaPartida2.setLocationRelativeTo(null);
		NuevaPartida2.setResizable(false);
		NuevaPartida2.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		if ((btn1.equals(ae.getSource())))
		{

		}

		if ((btn2.equals(ae.getSource()))) 
		{

		}

		if (btnCalificar.equals(ae.getSource())) {
			DialogoIncorrecto.setVisible(true);
		}

		if (btnVolver.equals(ae.getSource())) {
			DialogoCorrecto.setVisible(false);
			NuevaPartida2.setVisible(true);
		}

		if (btnVolver1.equals(ae.getSource())) {
			DialogoIncorrecto.setVisible(false);
			NuevaPartida2.setVisible(true);
		}
	}

	@Override
	public void windowClosing(WindowEvent arg0) {	
		if (DialogoCorrecto.isActive()) {
			DialogoCorrecto.setVisible(false);
			new Tablero2();
		}
		// Cuando se cierre el frame principal se abra el juego de nuevo
		else if(NuevaPartida2.isActive()){
			NuevaPartida2.setVisible(false);
			new Duolingo();
		}else if(DialogoIncorrecto.isActive()){
			NuevaPartida2.setVisible(true);
		}
	}
}