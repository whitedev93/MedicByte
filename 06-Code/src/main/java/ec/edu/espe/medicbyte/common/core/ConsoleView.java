package ec.edu.espe.medicbyte.common.core;

import com.google.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;

/**
 *
 * @author Andres Jonathan J.
 */
public abstract class ConsoleView implements View {
    @Inject private Console console;
    private final Map<String, String> templateVars = new HashMap<>();
    private Consumer<String> printer;
    
    @Override
    public void display() {
        console.echoln(render());
    }
    
    @Override
    public void set(String key, Object value) {
        templateVars.put(key, String.valueOf(value));
    }
    
    private String render() {
        String rendered = template();
        
        for (Entry<String, String> entry : templateVars.entrySet()) {
            rendered = rendered.replace("${" + entry.getKey() + "}", entry.getValue());
        }
        
        return rendered;
    }
    
    protected abstract String template();
}
