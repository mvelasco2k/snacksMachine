/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import domain.Snack;
import java.util.List;
/**
 *
 * @author Mateo Velasco
 */
public interface IServiceSnacks {
    void addSnack(Snack snack);
    void showSnacks();
    List<Snack> getSnacks();
}
