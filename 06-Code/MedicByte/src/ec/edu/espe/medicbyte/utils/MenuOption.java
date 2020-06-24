package ec.edu.espe.medicbyte.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * @author Andres Jonathan J.
 */
public class MenuOption {
    private final String label;
    private boolean await = true;
    private Runnable callback;
    private Consumer<MenuOption> callback2;
    private final List<Object> arguments = new ArrayList<>();
    
    public MenuOption(String label) {
        this.label = label;
        this.callback = () -> {};
    }
    
    public MenuOption(String label, Runnable callback) {
        this.label = label;
        this.callback = callback;
    }
    
    public MenuOption(String label, Consumer<MenuOption> callback) {
        this.label = label;
        this.callback2 = callback;
    }

    public void run() {
        if (callback2 != null) {
            callback2.accept(this);
        } else {
            callback.run();
        }
    }
    
    public String getLabel() {
        return label;
    }
    
    public void setAwait(boolean await) {
        this.await = await;
    }
    
    public boolean shouldAwait() {
        return await;
    }

    public void addArgument(Object argument) {
        arguments.add(argument);
    }

    public List<Object> getArguments() {
        return arguments;
    }
    
    public Object getArgument(int index) {
        return arguments.get(index);
    }
}
