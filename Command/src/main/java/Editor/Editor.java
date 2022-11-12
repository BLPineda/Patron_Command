/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Editor;
import Comandos.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Lenín
 */
public class Editor {

    public JTextArea texto;
    public String clipboard;
    private Historial historial = new Historial();
    
    public void inicio(){
        JFrame frame = new JFrame("Editor de texto (escribí o usá los botones, buena suerte)");
        JPanel contenido = new JPanel();
        frame.setContentPane(contenido);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        contenido.setLayout(new BoxLayout(contenido, BoxLayout.Y_AXIS));
        texto = new JTextArea();
        texto.setLineWrap(true);
        contenido.add(texto);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton ctrlC = new JButton("ctrlC");
        JButton ctrlX = new JButton("ctrlX");
        JButton ctrlV = new JButton("ctrlV");
        JButton ctrlZ = new JButton("ctrlZ");
        Editor editor = this;
        
        ctrlC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejecutarComando(new CopyCommand(editor));
            }
        });
         ctrlX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejecutarComando(new Cortar_Comando(editor));
            }
        });
        ctrlV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejecutarComando(new Pegar_Comando(editor));
            }
        });
        ctrlZ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrar();
            }
        });
        buttons.add(ctrlC);
        buttons.add(ctrlX);
        buttons.add(ctrlV);
        buttons.add(ctrlZ);
        contenido.add(buttons);
        frame.setSize(450, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
        
        private void ejecutarComando(Comando comando) {
        if (comando.execute()) {
            historial.push(comando);
        }
    }
        
        private void borrar() {
        if (historial.isEmpty()) return;

        Comando comando = historial.pop();
        if (comando != null) {
            comando.borrar();
        }
        }
}
