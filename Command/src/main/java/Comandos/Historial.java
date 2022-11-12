/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;
import java.util.Stack;
/**
 *
 * @author Lenín
 */
public class Historial {
    private Stack<Comando> historial = new Stack<>();
    
    public void push (Comando c){
        historial.push(c);
    }
    
    public Comando pop(){
        return historial.pop();
    }
    
    public boolean isEmpty(){
        return historial.isEmpty();
    }
    
}
