package shared;

import java.beans.PropertyChangeListener;

/**
 * The interface Property change subject for observer pattern.
 */
public interface PropertyChangeSubject {
    /**
     * Add listener.
     *
     * @param listener the listener
     * @param name     the name
     */
    void addListener(PropertyChangeListener listener, String name);
}
