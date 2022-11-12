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
public class Pegar_Comando extends Comando {

    public Pegar_Comando(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        if (editor.clipboard == null || editor.clipboard.isEmpty())
            return false;
        
        backup();
        editor.texto.insert(editor.clipboard, editor.texto.getCaretPosition());
        return true;
    }
    
}
