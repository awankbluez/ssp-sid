/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.sspsid.managedBean;

import java.io.Serializable;
import java.text.DecimalFormat;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import org.omnifaces.util.Messages;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Wirawan Adi
 */
public class AbstractManagedBean implements Serializable {

    private static final int BUFFER_SIZE = 6124;

    /**
     * Function to display number in currency pattern, to show in JSF UI
     *
     * @author Wirawan Adi
     * @param currencySymbol String Currency Symbol
     * @param money Double Amount of Money
     * @return money pattern compkete with currency
     */
    protected static String moneyPattern(String currencySymbol, Double money) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###.##");
        return currencySymbol + decimalFormat.format(money);
    }

    public AbstractManagedBean() {
        super();
    }

    protected void displayErrorMessageToUser(String message) {
        Messages.addGlobalError(message);
    }

    protected void displayInfoMessageToUser(String message) {
        Messages.addGlobalInfo(message);
    }

    protected void displayWarnMessageToUser(String message) {
        Messages.addGlobalWarn(message);
    }

    protected RequestContext getRequestContext() {
        return RequestContext.getCurrentInstance();
    }

    protected void throwNewValidatorException(FacesContext context, UIComponent component, Object value, String messages) throws ValidatorException {
        Messages.addError(component.getClientId(context), messages);
    }

    protected void throwNewValidatorException(String message) {
        throwNewValidatorException(FacesContext.getCurrentInstance(), UIComponent.getCurrentComponent(FacesContext.getCurrentInstance()), null, message);
    }
}
