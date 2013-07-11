/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.model.validator;

/**
 * @version 2013/04/09 16:52:36
 */
public interface Validator<M> {

    /**
     * <p>
     * Validate the given model.
     * </p>
     * 
     * @param model A target model to validate.
     * @throws Invalid If the model is invalid.
     */
    void validate(M model) throws Invalid;
}
