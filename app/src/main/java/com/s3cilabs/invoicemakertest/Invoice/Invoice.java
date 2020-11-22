package com.s3cilabs.invoicemakertest.Invoice;

public class Invoice {

    private int invoiceId;
    private String invoiceNumber;
    private String invoiceDate;
    private String invoiceTerms;
    private double invoiceSubTotalAmount;
    private double invoiceTaxAmount;
    private double invoiceTotalAmount;

    //Constructor
    public Invoice(int invoiceId, String invoiceNumber, String invoiceDate, String invoiceTerms,
                   double invoiceSubTotalAmount, double invoiceTaxAmount, double invoiceTotalAmount) {
        this.invoiceId = invoiceId;
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.invoiceTerms = invoiceTerms;
        this.invoiceSubTotalAmount = invoiceSubTotalAmount;
        this.invoiceTaxAmount = invoiceTaxAmount;
        this.invoiceTotalAmount = invoiceTotalAmount;
    }

    //Empty constructor
    public Invoice() {
    }

    //toString
    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                ", invoiceDate='" + invoiceDate + '\'' +
                ", invoiceTerms='" + invoiceTerms + '\'' +
                ", invoiceSubTotalAmount=" + invoiceSubTotalAmount +
                ", invoiceTaxAmount=" + invoiceTaxAmount +
                ", invoiceTotalAmount=" + invoiceTotalAmount +
                '}';
    }

    //Getters and Setters

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getInvoiceTerms() {
        return invoiceTerms;
    }

    public void setInvoiceTerms(String invoiceTerms) {
        this.invoiceTerms = invoiceTerms;
    }

    public double getInvoiceSubTotalAmount() {
        return invoiceSubTotalAmount;
    }

    public void setInvoiceSubTotalAmount(double invoiceSubTotalAmount) {
        this.invoiceSubTotalAmount = invoiceSubTotalAmount;
    }

    public double getInvoiceTaxAmount() {
        return invoiceTaxAmount;
    }

    public void setInvoiceTaxAmount(double invoiceTaxAmount) {
        this.invoiceTaxAmount = invoiceTaxAmount;
    }

    public double getInvoiceTotalAmount() {
        return invoiceTotalAmount;
    }

    public void setInvoiceTotalAmount(double invoiceTotalAmount) {
        this.invoiceTotalAmount = invoiceTotalAmount;
    }
}
