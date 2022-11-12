/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;
import Editor.*;
/**
 *
 * @author Lenín
 */
public abstract class Comando /** Command */ {
    
    public Editor editor;
    private String backup;

    public Comando(Editor editor) {
        this.editor = editor;
    }
    
    void backup(){
        backup = editor.texto.getText();
    }
    
    public void borrar(){
        editor.texto.setText(backup);
    }
    
    public abstract boolean execute();
    
}
