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
 * @version 2013/12/10 11:42:10
 */
public interface SubscribableInterface {

    public default void subscribe(PublishableInterface publishable) {
        Publisher publisher = Publisher.manager.get(publishable);

        if (publisher == null) {
            publisher = new Publisher();
            publisher.register(this);

            Publisher.manager.put(publishable, publisher);
        }
    }

    public default void unsubscribe(PublishableInterface publishable) {
        Publisher publisher = Publisher.manager.get(publishable);

        if (publisher != null) {
            publisher.register(this);
        }
    }
}
