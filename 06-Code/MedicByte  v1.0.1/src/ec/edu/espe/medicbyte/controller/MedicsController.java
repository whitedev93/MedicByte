package ec.edu.espe.medicbyte.controller;

import ec.edu.espe.medicbyte.model.Medic;
import ec.edu.espe.medicbyte.utils.MenuOption;
import ec.edu.espe.medicbyte.model.Speciality;
import ec.edu.espe.medicbyte.service.MedicService;
import ec.edu.espe.medicbyte.service.MedicServiceImpl;
import ec.edu.espe.medicbyte.utils.Console;
import ec.edu.espe.medicbyte.utils.ConsoleMenu;
import java.util.List;

/**
 *
 * @author Andres Jonathan J.
 */
public class MedicsController {
    private final Console console;
    private final MedicService medicService;
    
    public MedicsController() {
        this.console = Console.getInstance();
        this.medicService = new MedicServiceImpl();
    }
    
    public void createMedic() {
        ConsoleMenu specialityMenu = new ConsoleMenu();
        Medic medic = new Medic();

        medic.setName(console.read("Enter medic full name: "));
        
        for (Speciality speciality : Speciality.values()) {
            specialityMenu
                .addOption(speciality.getLabel())
                .addArgument(speciality);
        }
        
        console.newLine();
        specialityMenu.setPrompt("Choose an speciality: ");
        
        MenuOption lastOption = specialityMenu.readOption();
        Speciality speciality = (Speciality) lastOption.getArguments().get(0);
        medic.setSpeciality(speciality);

        
        int count = medicService.getTotalMedics();
        medic.setId(count + 1);
        medicService.saveMedic(medic);
    }
    
    public void showMedics() {
        List<Medic> medics = medicService.getAllMedics();
        
        if (medics.isEmpty()) {
           console.echoln("No medics found");
           return;
        }
        
        for (Medic medic : medics) {
            console.echofmt(
                    "nombre: %s\nspeciality: %s", 
                    medic.getName(), medic.getSpeciality().getLabel());
        }
        
        console.pause();
    }
}
