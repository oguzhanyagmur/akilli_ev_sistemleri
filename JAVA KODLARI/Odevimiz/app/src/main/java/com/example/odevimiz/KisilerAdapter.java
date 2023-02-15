package com.example.odevimiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class KisilerAdapter extends RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu> {

    private Context mContext;
    private List <Kisiler> kisilerListe;

    public KisilerAdapter(Context mContext, List<Kisiler> kisilerListe) {
        this.mContext = mContext;
        this.kisilerListe = kisilerListe;
    }



    public  class CardTasarimTutucu extends RecyclerView.ViewHolder{

        private TextView textViewKisiBilgi;
        private ImageView ımageViewNokta;

        public  CardTasarimTutucu(View itemView){
            super(itemView);

            textViewKisiBilgi=itemView.findViewById(R.id.textViewKisiBilgi);
            ımageViewNokta=itemView.findViewById(R.id.imageViewNokta);

        }
    }
    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.kisi_card_tasarim,parent,false);
        return  new CardTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Kisiler kisi=kisilerListe.get(position);

        holder.textViewKisiBilgi.setText(kisi.getKisi_ad()+"**"+kisi.getKisi_tel());
        holder.ımageViewNokta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu=new PopupMenu(mContext,holder.ımageViewNokta);
                popupMenu.getMenuInflater().inflate(R.menu.pop_up_menu,popupMenu.getMenu());


                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        switch (menuItem.getItemId()){

                            case R.id.action_sil:

                                Snackbar.make(holder.ımageViewNokta,"Sil Tıklandı",Snackbar.LENGTH_SHORT).show();
                                return  true;
                            case R.id.action_guncelle:
                                Snackbar.make(holder.ımageViewNokta,"Güncelleye Tıklandı",Snackbar.LENGTH_SHORT).show();
                                return  true;
                            default:
                                return  false;


                        }

                    }
                });
                popupMenu.show();





            }
        });

    }

    @Override
    public int getItemCount() {
        return kisilerListe.size();
    }




}
