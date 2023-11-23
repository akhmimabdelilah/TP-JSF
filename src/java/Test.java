
import entities.Service;
import services.ServiceService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LACHGAR
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServiceService ss = new ServiceService();
        //création des Services
        ss.create(new Service("A", "Info"));
        ss.create(new Service("B", "Data"));

        //La liste des Services
        for (Service s : ss.getAll()) {
            System.out.println("" + s.getCode());
        }
    }
}
