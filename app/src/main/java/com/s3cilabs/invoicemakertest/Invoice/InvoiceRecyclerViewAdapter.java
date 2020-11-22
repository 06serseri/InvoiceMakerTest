package com.s3cilabs.invoicemakertest.Invoice;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.s3cilabs.invoicemakertest.R;

import java.util.List;

public class InvoiceRecyclerViewAdapter extends RecyclerView.Adapter<InvoiceRecyclerViewAdapter.InvoiceViewHolder> {
    List<Invoice> invoiceList;
    Context context;

    public InvoiceRecyclerViewAdapter(List<Invoice> invoiceList, Context context) {
        this.invoiceList = invoiceList;
        this.context = context;
    }

    @NonNull
    @Override
    public InvoiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.invoice_item, parent, false);
        InvoiceViewHolder holder = new InvoiceViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull InvoiceViewHolder holder, int position) {
        holder.textViewInvoiceId.setText(String.valueOf(invoiceList.get(position).getInvoiceId()));
        holder.textViewInvoiceNumber.setText(invoiceList.get(position).getInvoiceNumber());
        holder.textViewInvoiceDate.setText(invoiceList.get(position).getInvoiceDate());
        holder.textViewInvoiceTerms.setText(invoiceList.get(position).getInvoiceTerms());
        holder.textViewInvoiceSubTotalAmount.setText(String.valueOf(invoiceList.get(position).getInvoiceSubTotalAmount()));
        holder.textViewInvoiceTaxAmount.setText(String.valueOf(invoiceList.get(position).getInvoiceTaxAmount()));
        holder.textViewInvoiceTotalAmount.setText(String.valueOf(invoiceList.get(position).getInvoiceTotalAmount()));

        //Invoice item click listener
        holder.invoiceItemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //send the control to the AddEditInvoiceActivity
                Intent intent = new Intent(context, EditInvoiceActivity.class);
                intent.putExtra("invoiceId", invoiceList.get(position).getInvoiceId());
                intent.putExtra("invoiceNumber", invoiceList.get(position).getInvoiceNumber());
                intent.putExtra("invoiceDate", invoiceList.get(position).getInvoiceDate());
                intent.putExtra("invoiceTerms", invoiceList.get(position).getInvoiceTerms());
                intent.putExtra("invoiceSubTotalAmount", invoiceList.get(position).getInvoiceSubTotalAmount());
                intent.putExtra("invoiceTaxAmount", invoiceList.get(position).getInvoiceTaxAmount());
                intent.putExtra("invoiceTotalAmount", invoiceList.get(position).getInvoiceTotalAmount());

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return invoiceList.size();
    }

    public class InvoiceViewHolder extends RecyclerView.ViewHolder{
        TextView textViewInvoiceId, textViewInvoiceNumber, textViewInvoiceDate, textViewInvoiceTerms,
                textViewInvoiceSubTotalAmount, textViewInvoiceTaxAmount, textViewInvoiceTotalAmount;
        RelativeLayout invoiceItemLayout;

        public InvoiceViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewInvoiceId = itemView.findViewById(R.id.textViewInvoiceId);
            textViewInvoiceNumber = itemView.findViewById(R.id.textViewInvoiceNumber);
            textViewInvoiceDate = itemView.findViewById(R.id.textViewInvoiceDate);
            textViewInvoiceTerms = itemView.findViewById(R.id.textViewInvoiceTerms);
            textViewInvoiceSubTotalAmount = itemView.findViewById(R.id.textViewInvoiceSubTotalAmount);
            textViewInvoiceTaxAmount = itemView.findViewById(R.id.textViewInvoiceTaxAmount);
            textViewInvoiceTotalAmount = itemView.findViewById(R.id.textViewInvoiceTotalAmount);
            invoiceItemLayout = itemView.findViewById(R.id.invoiceItemLayout);
        }
    }
}
