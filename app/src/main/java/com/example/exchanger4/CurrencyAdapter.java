//package com.example.exchanger4;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.List;
//
//public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder> {
//    private List<Currency> currencies;
//
//    public CurrencyAdapter(List<Currency> currencies) {
//        this.currencies = currencies;
//    }
//
//    @NonNull
//    @Override
//    public CurrencyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_currency, parent, false);
//        return new CurrencyViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull CurrencyViewHolder holder, int position) {
//        Currency currentCurrency = currencies.get(position);
//        holder.currencyName.setText(currentCurrency.getName());
//        holder.buyPrice.setText(String.valueOf(currentCurrency.getBuyPrice()));
//        holder.sellPrice.setText(String.valueOf(currentCurrency.getSellPrice()));
//    }
//
//    @Override
//    public int getItemCount() {
//        return currencies.size();
//    }
//
//    static class CurrencyViewHolder extends RecyclerView.ViewHolder {
//        TextView currencyName;
//        TextView buyPrice;
//        TextView sellPrice;
//
//        CurrencyViewHolder(@NonNull View itemView) {
//            super(itemView);
//            currencyName = itemView.findViewById(R.id.text_view_name);
//            buyPrice = itemView.findViewById(R.id.text_view_buy_price);
//            sellPrice = itemView.findViewById(R.id.text_view_sell_price);
//        }
//    }
//}
//
