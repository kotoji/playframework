/*
 * Copyright (C) 2009-2018 Lightbend Inc. <https://www.lightbend.com>
 */

package play.data;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.ValidatorFactory;
import play.i18n.MessagesApi;
import play.data.format.Formatters;

/**
 * Helper to create HTML forms.
 */
@Singleton
public class FormFactory {

    private final MessagesApi messagesApi;

    private final Formatters formatters;

    private final ValidatorFactory validatorFactory;

    @Inject
    public FormFactory(MessagesApi messagesApi, Formatters formatters, ValidatorFactory validatorFactory) {
        this.messagesApi = messagesApi;
        this.formatters = formatters;
        this.validatorFactory = validatorFactory;
    }
    
    /**
     * @return a dynamic form.
     */
    public DynamicForm form() {
        return new DynamicForm(messagesApi, formatters, validatorFactory);
    }
    
    /**
     * @param clazz    the class to map to a form.
     * @param <T>   the type of value in the form.
     * @return a new form that wraps the specified class.
     */
    public <T> Form<T> form(Class<T> clazz) {
        return new Form<>(clazz, messagesApi, formatters, validatorFactory);
    }
    
    /**
     * @param <T>   the type of value in the form.
     * @param name the form's name.
     * @param clazz the class to map to a form.
     * @return a new form that wraps the specified class.
     */
    public <T> Form<T> form(String name, Class<T> clazz) {
        return new Form<>(name, clazz, messagesApi, formatters, validatorFactory);
    }
    
    /**
     * @param <T>   the type of value in the form.
     * @param name the form's name
     * @param clazz the class to map to a form.
     * @param groups the classes of groups.
     * @return a new form that wraps the specified class.
     */
    public <T> Form<T> form(String name, Class<T> clazz, Class<?>... groups) {
        return new Form<>(name, clazz, groups, messagesApi, formatters, validatorFactory);
    }

    /**
     * @param <T>   the type of value in the form.
     * @param clazz the class to map to a form.
     * @param groups the classes of groups.
     * @return a new form that wraps the specified class.
     */
    public <T> Form<T> form(Class<T> clazz, Class<?>... groups) {
        return new Form<>(null, clazz, groups, messagesApi, formatters, validatorFactory);
    }

}
