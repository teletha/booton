/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.ui.validator;

/**
 * @version 2013/04/12 16:25:12
 */
public class IntegerValidator implements Validator {

    /**
     * {@inheritDoc}
     */
    @Override
    public void validate(Object model) throws Invalid {
        try {
            System.out.println(Integer.parseInt(model.toString()));
        } catch (Throwable e) {
            throw new Invalid("Require number. " + model);
        }
    }
}
