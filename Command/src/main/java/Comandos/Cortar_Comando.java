/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import Editor.Editor;

/**
 *
 * @author Lenín
 */
public class Cortar_Comando extends Comando {

    public Cortar_Comando(Editor editor) {
        super(editor);
    }

    private String cutString(String buscar){
        String inicio = buscar.substring(0, editor.texto.getSelectionStart());
        String end = buscar.substring(editor.texto.getSelectionEnd());
        return inicio + end;
    }
    
    @Override
    public boolean execute() {
        if (editor.texto.getSelectedText().isEmpty())
            return false;
        
        backup();
        String buscar = editor.texto.getText();
        editor.clipboard = editor.texto.getSelectedText();
        editor.texto.setText(cutString(buscar));
        return true;
    }
    
}
