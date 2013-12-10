/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx;

/**
 * @version 2013/10/09 15:53:49
 */
public interface PublishableInterface {

    /**
     * <p>
     * Publish the specified event.
     * </p>
     * 
     * @param event
     */
    public default void publish(Object event) {
        Publisher publisher = Publisher.manager.get(this);

        if (publisher != null) {
            publisher.publish(event);
        }
    }
}
