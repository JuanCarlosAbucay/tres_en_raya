package com.example.tresenraya.adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tresenraya.R;
import com.example.tresenraya.roomdatabse.Jugador;

import java.util.List;

public class AdaptadorRanking extends RecyclerView.Adapter<AdaptadorRanking.ViewHolder>{
    private final List<Jugador> jugadorList;

    public AdaptadorRanking(List<Jugador> jugadorList) {
        this.jugadorList = jugadorList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView nickname;
            TextView points;
        public ViewHolder(@NonNull View itemView) {
                super(itemView);
                nickname = (TextView)itemView.findViewById(R.id.rankingNickname);
                points = (TextView)itemView.findViewById(R.id.rankingPoints);
        }
        public TextView getLblNickame() {return nickname;}
        public TextView getLblPoints() {return points;}
    }



    @NonNull
    @Override
    public AdaptadorRanking.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.ranking_dades, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRanking.ViewHolder holder, int position) {
        String nick = position + 1 + ". " + jugadorList.get(position).getNombre();
        int puntos = jugadorList.get(position).getPoints();
        holder.getLblNickame().setText(nick);
        holder.getLblPoints().setText(String.valueOf(puntos));
    }

    @Override
    public int getItemCount() {
        return jugadorList.size();
    }
}
