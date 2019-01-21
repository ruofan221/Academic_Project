/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.Date;

/**
 *
 * @author too
 */
public class OrderReminderRequest extends WorkRequest{
    private int OrderId;
    private Date reminderCreated;
    private Date dateCreated;
    private String customerName;
    private Date requestCreated;
    private String deleteStatus;
    private String deleteMessage;
    

    public OrderReminderRequest() {
        
        this.reminderCreated = new Date();
        this.requestCreated = new Date();
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int OrderId) {
        this.OrderId = OrderId;
    }

    

    public Date getReminderCreated() {
        return reminderCreated;
    }

    public void setReminderCreated(Date reminderCreated) {
        this.reminderCreated = reminderCreated;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getRequestCreated() {
        return requestCreated;
    }

    public void setRequestCreated(Date requestCreated) {
        this.requestCreated = requestCreated;
    }

    public String getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(String deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public String getDeleteMessage() {
        return deleteMessage;
    }

    public void setDeleteMessage(String deleteMessage) {
        this.deleteMessage = deleteMessage;
    }
    
    
    
        
    
    @Override
    public String toString() {
        return Integer.toString(OrderId);
    }
    
}
