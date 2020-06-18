package ec.edu.espe.medicbyte;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import ec.edu.espe.medicbyte.common.core.Console;
import ec.edu.espe.medicbyte.common.service.AuthService;

/**
 *
 * @author Andres Jonathan J.
 */
public class MainModule extends AbstractModule {
    public void setApplication(Application application) {
        bind(Application.class).toInstance(application);
    }
    
    @Override
    protected void configure() {
        this.bind(Console.class).in(Singleton.class);
        this.bind(AuthService.class).in(Singleton.class);
    }
}
